package com.github.zhitron.lambda;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

import static com.github.zhitron.lambda.LambdaType.BOOLEAN;

/**
 * TemplateInfo 是一个抽象类，用于生成 Lambda 表达式相关的模板代码。
 * 它包含了方法名、返回类型、参数类型等信息，并提供了生成类名、泛型声明等功能。
 *
 * @author zhitron
 */
abstract class TemplateInformation {
    /**
     * 方法名称
     */
    protected final String methodName;

    /**
     * 返回类型
     */
    protected final LambdaType returnType;

    /**
     * 参数类型数组
     */
    protected final LambdaType[] paramTypes;

    /**
     * 泛型参数的数量
     */
    protected final int genericCount;

    /**
     * 缓存的类名（支持抛出异常）
     */
    private String cachedClassNameThrowTrue;

    /**
     * 缓存的类名（不支持抛出异常）
     */
    private String cachedClassNameThrowFalse;

    /**
     * 缓存的泛型声明（支持抛出异常）
     */
    private String cachedGenericDeclarationThrowTrue;

    /**
     * 缓存的泛型声明（不支持抛出异常）
     */
    private String cachedGenericDeclarationThrowFalse;

    /**
     * 缓存的泛型定义（支持抛出异常）
     */
    private String cachedGenericDefinitionThrowTrue;

    /**
     * 缓存的泛型定义（不支持抛出异常）
     */
    private String cachedGenericDefinitionThrowFalse;

    /**
     * 缓存的未知泛型（支持抛出异常）
     */
    private String cachedGenericUnknownThrowTrue;

    /**
     * 缓存的未知泛型（不支持抛出异常）
     */
    private String cachedGenericUnknownThrowFalse;

    /**
     * 缓存的参数声明字符串，用于避免重复生成。
     * 格式为 "类型1 参数名1, 类型2 参数名2, ..."
     */
    private String cachedParamDeclaration;

    /**
     * 缓存的参数调用字符串，用于避免重复生成。
     * 格式为 "参数名1, 参数名2, ..."
     */
    private String cachedParamInvocation;

    /**
     * 构造函数，用于创建具有相同参数类型的TemplateInfo实例。
     *
     * @param methodName 方法名称
     * @param returnType 返回类型，如果为null则表示Consumer类型
     * @param paramType  参数类型
     * @param paramCount 参数个数，必须在1到4之间
     * @throws IllegalArgumentException 如果参数个数不正确
     */
    public TemplateInformation(String methodName, LambdaType returnType, LambdaType paramType, int paramCount) {
        if (paramCount < 1 || paramCount > 4) {
            throw new IllegalArgumentException("The number of parameters is incorrect");
        }
        this.methodName = methodName;
        this.returnType = returnType;

        this.paramTypes = new LambdaType[paramCount];
        Arrays.fill(this.paramTypes, paramType);

        this.genericCount = paramType.isGeneric() ? paramCount : 0;
    }

    /**
     * 构造函数，用于创建具有不同参数类型的TemplateInfo实例。
     *
     * @param methodName 方法名称
     * @param returnType 返回类型，如果为null则表示Consumer类型
     * @param paramTypes 参数类型数组，长度必须在1到4之间
     * @throws IllegalArgumentException 如果参数个数不正确
     */
    public TemplateInformation(String methodName, LambdaType returnType, LambdaType... paramTypes) {
        if (paramTypes.length < 1 || paramTypes.length > 4) {
            throw new IllegalArgumentException("The number of parameters is incorrect");
        }
        this.methodName = methodName;
        this.returnType = returnType;

        // 过滤掉null值参数
        this.paramTypes = Arrays.stream(paramTypes).filter(Objects::nonNull).toArray(LambdaType[]::new);

        int count = 0;
        for (LambdaType paramType : this.paramTypes) {
            if (paramType.isGeneric()) count++;
        }
        this.genericCount = count;
    }

    /**
     * 检查是否存在泛型类型
     *
     * @param isThrowException 是否抛出异常的标志位
     * @return 如果存在泛型类型则返回true，否则返回false
     */
    public boolean hasGeneric(boolean isThrowException) {
        // 判断是否存在泛型：genericCount大于0，或者返回类型不为空且为泛型类型，或者需要抛出异常
        return genericCount > 0 || (returnType != null && returnType.isGeneric()) || isThrowException;
    }

    /**
     * 生成Java代码
     *
     * @param isThrowException 是否支持抛出异常
     * @return 生成的Java代码字符串
     */
    public abstract String generate(boolean isThrowException);

    /**
     * 将生成的代码写入文件
     *
     * @param directory 目标目录
     * @param charset   字符集
     * @throws IOException 如果写入过程中发生错误
     */
    public void writeToDirectory(Path directory, Charset charset) throws IOException {
        Path path = directory.resolve(getClassName(false) + ".java");
        Files.write(path, generate(false).getBytes(charset));
        path = directory.resolve(getClassName(true) + ".java");
        Files.write(path, generate(true).getBytes(charset));
    }

    /**
     * 获取生成的类名
     *
     * @param isThrowException 是否支持抛出异常
     * @return 生成的类名
     */
    protected final String getClassName(boolean isThrowException) {
        if (isThrowException) {
            if (cachedClassNameThrowTrue == null) {
                cachedClassNameThrowTrue = doGetClassName(true);
            }
            return cachedClassNameThrowTrue;
        } else {
            if (cachedClassNameThrowFalse == null) {
                cachedClassNameThrowFalse = doGetClassName(false);
            }
            return cachedClassNameThrowFalse;
        }
    }

    /**
     * 实际获取类名的方法
     *
     * @param isThrowException 是否支持抛出异常
     * @return 生成的类名字符串
     */
    protected String doGetClassName(boolean isThrowException) {
        StringBuilder sb = new StringBuilder();

        // 根据参数个数添加前缀
        switch (paramTypes.length) {
            case 1:
                sb.append("Single");
                break;
            case 2:
                sb.append("Twice");
                break;
            case 3:
                sb.append("Triple");
                break;
            case 4:
                sb.append("Quadruple");
                break;
        }

        // 根据返回类型添加后缀
        if (returnType == null) {
            sb.append("Consumer");
        } else {
            if (returnType == BOOLEAN) {
                sb.append("Predicate");
            } else {
                sb.append("Function");
            }
        }

        // 检查所有参数类型是否相同
        boolean isSame = true;
        LambdaType last = paramTypes[0];
        for (int i = 1; i < paramTypes.length; i++) {
            if (last != paramTypes[i]) {
                isSame = false;
                break;
            }
        }

        // 如果所有参数类型相同，直接添加类型名称
        if (isSame) {
            sb.append(last.getCapitalizedName());
        } else {
            // 否则按连续相同类型分组添加名称
            int count = 1;
            for (int i = 1; i <= paramTypes.length; i++) {
                assert last != null;
                if (i == paramTypes.length || last != paramTypes[i]) {
                    switch (count) {
                        case 1:
                            sb.append(last.getCapitalizedName());
                            break;
                        case 2:
                            sb.append("Tw").append(last.getCapitalizedName());
                            break;
                        case 3:
                            sb.append("Tri").append(last.getCapitalizedName());
                            break;
                        case 4:
                            sb.append("Quad").append(last.getCapitalizedName());
                            break;
                    }
                    count = 1;
                    last = i == paramTypes.length ? null : paramTypes[i];
                } else {
                    count++;
                }
            }
        }

        // 如果是Function类型，添加返回类型
        if (returnType != null && returnType != BOOLEAN) {
            sb.append("To").append(returnType.getCapitalizedName());
        }

        // 如果支持抛出异常，添加Throw后缀
        if (isThrowException) {
            sb.append("Throw");
        }

        return sb.toString();
    }

    /**
     * 获取泛型声明
     *
     * @param isThrowException 是否支持抛出异常
     * @return 泛型声明字符串
     */
    protected final String getGenericDeclaration(boolean isThrowException) {
        if (isThrowException) {
            if (cachedGenericDeclarationThrowTrue == null) {
                cachedGenericDeclarationThrowTrue = doGetGenericDeclaration(true);
            }
            return cachedGenericDeclarationThrowTrue;
        } else {
            if (cachedGenericDeclarationThrowFalse == null) {
                cachedGenericDeclarationThrowFalse = doGetGenericDeclaration(false);
            }
            return cachedGenericDeclarationThrowFalse;
        }
    }

    /**
     * 实际获取泛型声明的方法
     *
     * @param isThrowException 是否支持抛出异常
     * @return 泛型声明字符串
     */
    protected String doGetGenericDeclaration(boolean isThrowException) {
        StringBuilder sb = new StringBuilder();
        // 泛型声明
        if (hasGeneric(isThrowException)) {
            sb.append("<");
            if (genericCount > 0) {
                for (int i = 0; i < paramTypes.length; i++) {
                    if (paramTypes[i].isGeneric()) {
                        sb.append(paramTypes[i].getParamType(i)).append(", ");
                    }
                }
            }
            if (returnType != null && returnType.isGeneric()) {
                sb.append(returnType.getReturnType()).append(", ");
            }
            if (isThrowException) {
                sb.append("E extends Exception");
            } else {
                sb.setLength(sb.length() - 2);
            }
            sb.append(">");
        }
        return sb.toString();
    }

    /**
     * 获取泛型定义
     *
     * @param isThrowException 是否支持抛出异常
     * @return 泛型定义字符串
     */
    protected final String getGenericDefinition(boolean isThrowException) {
        if (isThrowException) {
            if (cachedGenericDefinitionThrowTrue == null) {
                cachedGenericDefinitionThrowTrue = doGetGenericDefinition(true);
            }
            return cachedGenericDefinitionThrowTrue;
        } else {
            if (cachedGenericDefinitionThrowFalse == null) {
                cachedGenericDefinitionThrowFalse = doGetGenericDefinition(false);
            }
            return cachedGenericDefinitionThrowFalse;
        }
    }

    /**
     * 实际获取泛型定义的方法
     *
     * @param isThrowException 是否支持抛出异常
     * @return 泛型定义字符串
     */
    protected String doGetGenericDefinition(boolean isThrowException) {
        StringBuilder sb = new StringBuilder();
        // 泛型声明
        if (hasGeneric(isThrowException)) {
            sb.append("<");
            if (genericCount > 0) {
                for (int i = 0; i < paramTypes.length; i++) {
                    if (paramTypes[i].isGeneric()) {
                        sb.append(paramTypes[i].getParamType(i)).append(", ");
                    }
                }
            }
            if (returnType != null && returnType.isGeneric()) {
                sb.append(returnType.getReturnType()).append(", ");
            }
            if (isThrowException) {
                sb.append("E");
            } else {
                sb.setLength(sb.length() - 2);
            }
            sb.append(">");
        }
        return sb.toString();
    }

    /**
     * 获取未知泛型
     *
     * @param isThrowException 是否支持抛出异常
     * @return 未知泛型字符串
     */
    protected final String getGenericUnknown(boolean isThrowException) {
        if (isThrowException) {
            if (cachedGenericUnknownThrowTrue == null) {
                cachedGenericUnknownThrowTrue = doGetGenericUnknown(true);
            }
            return cachedGenericUnknownThrowTrue;
        } else {
            if (cachedGenericUnknownThrowFalse == null) {
                cachedGenericUnknownThrowFalse = doGetGenericUnknown(false);
            }
            return cachedGenericUnknownThrowFalse;
        }
    }

    /**
     * 实际获取未知泛型的方法
     *
     * @param isThrowException 是否支持抛出异常
     * @return 未知泛型字符串
     */
    protected String doGetGenericUnknown(boolean isThrowException) {
        StringBuilder sb = new StringBuilder();
        // 泛型声明
        if (hasGeneric(isThrowException)) {
            sb.append("<");
            if (genericCount > 0) {
                for (LambdaType paramType : paramTypes) {
                    if (paramType.isGeneric()) {
                        sb.append("?, ");
                    }
                }
            }
            if (returnType != null && returnType.isGeneric()) {
                sb.append("?, ");
            }
            if (isThrowException) {
                sb.append("?");
            } else {
                sb.setLength(sb.length() - 2);
            }
            sb.append(">");
        }
        return sb.toString();
    }

    /**
     * 获取参数声明字符串，包含参数类型和参数名。
     * 该方法使用缓存机制避免重复计算。
     *
     * @return 参数声明字符串，例如 "T v1, U v2"
     */
    protected final String getParamDeclaration() {
        if (cachedParamDeclaration == null) {
            cachedParamDeclaration = doGetParamDeclaration();
        }
        return cachedParamDeclaration;
    }

    /**
     * 实际生成参数声明字符串的方法。
     *
     * @return 参数声明字符串
     */
    protected final String doGetParamDeclaration() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paramTypes.length; i++) {
            sb.append(paramTypes[i].getParamType(i)).append(" ").append(paramTypes[i].getParamName(i)).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    /**
     * 获取参数调用字符串，仅包含参数名。
     * 该方法使用缓存机制避免重复计算。
     *
     * @return 参数调用字符串，例如 "v1, v2"
     */
    protected final String getParamInvocation() {
        if (cachedParamInvocation == null) {
            cachedParamInvocation = doGetParamInvocation();
        }
        return cachedParamInvocation;
    }

    /**
     * 实际生成参数调用字符串的方法。
     *
     * @return 参数调用字符串
     */
    protected String doGetParamInvocation() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paramTypes.length; i++) {
            sb.append(paramTypes[i].getParamName(i)).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}
