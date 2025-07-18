package com.github.zhitron.lambda;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author zhitron
 */
class LambdaTemplate {
    private final String methodName;
    private final LambdaType returnType;
    private final LambdaType[] paramTypes;
    private final int genericCount;

    /**
     * 构造函数
     *
     * @param returnType 返回类型，如果为null表示Consumer，如果为LambdaType.TEST表示Predicate，否则表示Function
     * @param paramTypes 参数类型数组
     */
    public LambdaTemplate(LambdaType returnType, LambdaType... paramTypes) {
        // 如果没有返回类型，则默认为"accept"方法
        // 如果返回类型是TEST，则使用"test"方法
        // 否则使用"apply"方法
        this.methodName = returnType == null ? "accept" : (returnType == LambdaType.TEST ? "test" : "apply");
        this.returnType = returnType;

        // 过滤掉null值参数
        this.paramTypes = Arrays.stream(paramTypes).filter(Objects::nonNull).toArray(LambdaType[]::new);

        // 统计泛型参数的数量
        this.genericCount = (int) Arrays.stream(this.paramTypes).filter(LambdaType::isGeneric).count();
    }

    /**
     * 获取生成的类名
     *
     * @param isThrowException 是否支持抛出异常
     * @return 生成的类名
     */
    public String getClassName(boolean isThrowException) {
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
            default:
                throw new IllegalArgumentException("参数个数错误");
        }

        // 根据返回类型添加后缀
        if (returnType == null) {
            sb.append("Consumer");
        } else {
            if (returnType == LambdaType.TEST) {
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
                        default:
                            throw new IllegalArgumentException("参数个数错误");
                    }
                    count = 1;
                    last = i == paramTypes.length ? null : paramTypes[i];
                } else {
                    count++;
                }
            }
        }

        // 如果是Function类型，添加返回类型
        if (returnType != null && returnType != LambdaType.TEST) {
            sb.append("To").append(returnType.getCapitalizedName());
        }

        // 如果支持抛出异常，添加Throw后缀
        if (isThrowException) {
            sb.append("Throw");
        }

        return sb.toString();
    }

    /**
     * 生成Java代码
     *
     * @param isThrowException 是否支持抛出异常
     * @return 生成的Java代码字符串
     */
    public String getResult(boolean isThrowException) {
        StringBuilder sb = new StringBuilder();

        // 包声明
        sb.append("package com.github.zhitron.lambda");
        if (returnType == null) {
            sb.append(".consumer");
        } else if (returnType == LambdaType.TEST) {
            sb.append(".predicate");
        } else {
            sb.append(".function");
        }
        sb.append(";").append("\n");
        sb.append("\n");

        // 类注释
        sb.append("/**").append("\n");
        sb.append(" * 这是一个通用的 lambda 函数类，输入 ").append(paramTypes.length).append(" 个参的操作");
        if (returnType != null) {
            if (returnType == LambdaType.TEST) {
                sb.append("，并返回一个布尔值。");
            } else {
                sb.append("，并返回一个结果。");
            }
        } else {
            sb.append("。");
        }
        if (isThrowException) {
            sb.append("支持抛出异常。");
        }
        sb.append("\n");

        // 继承信息
        if (isThrowException) {
            sb.append(" * 该接口扩展自 {@link ").append(getClassName(false)).append("}，增加了异常处理能力。").append("\n");
        }
        sb.append(" *").append("\n");

        // 泛型参数说明
        for (int i = 0; i < paramTypes.length; i++) {
            if (paramTypes[i].isGeneric()) {
                sb.append(" * @param <").append(paramTypes[i].getParamType(i)).append("> 第 ").append(i + 1).append(" 个参数类型。").append("\n");
            }
        }

        // 异常类型说明
        if (isThrowException) {
            sb.append(" * @param <E> 异常类型，必须是 {@link Exception} 的子类").append("\n");
        }

        // 其他注释信息
        sb.append(" * @author zhitron").append("\n");
        sb.append(" */").append("\n");
        sb.append("@FunctionalInterface").append("\n");
        sb.append("public interface ").append(getClassName(isThrowException));

        // 泛型声明
        if (genericCount > 0 || (returnType != null && returnType.isGeneric()) || isThrowException) {
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

        // 继承声明
        if (isThrowException) {
            sb.append(" extends ").append(getClassName(false));

            if (genericCount > 0 || (returnType != null && returnType.isGeneric())) {
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
                sb.setLength(sb.length() - 2);
                sb.append(">");
            }
        }
        sb.append(" {").append("\n");
        sb.append("\n");

        // 方法注释
        sb.append("    /**").append("\n");
        sb.append("     * 对给定的 ").append(paramTypes.length).append(" 个参数进行操作");
        if (returnType != null) {
            if (returnType == LambdaType.TEST) {
                sb.append("，并返回一个布尔值。");
            } else {
                sb.append("，并返回一个结果。");
            }
        } else {
            sb.append("。");
        }
        sb.append("\n");
        sb.append("     *").append("\n");

        // 参数说明
        for (int i = 0; i < paramTypes.length; i++) {
            sb.append("     * @param ").append(paramTypes[i].getParamName(i)).append(" 类型为 ").append(paramTypes[i].getParamType(i)).append(" 的第 ").append(i + 1).append(" 个参数。").append("\n");
        }

        // 返回值说明
        if (returnType != null) {
            if (returnType == LambdaType.TEST) {
                sb.append("     * @return 该方法返回一个布尔值，表示操作是否成功。");
            } else {
                sb.append("     * @return 该方法返回一个结果，表示操作的结果。");
            }
            sb.append("\n");
        }

        // 异常说明
        if (isThrowException) {
            sb.append("     * @throws E 抛出执行过程中的异常").append("\n");
        }
        sb.append("     */").append("\n");

        // 方法声明
        sb.append("    ");
        if (returnType != null) {
            sb.append(returnType.getReturnType());
        } else {
            sb.append("void");
        }
        sb.append(" ").append(methodName);
        if (isThrowException) {
            sb.append("Throw");
        }
        sb.append("(");
        for (int i = 0; i < paramTypes.length; i++) {
            sb.append(paramTypes[i].getParamType(i)).append(" ").append(paramTypes[i].getParamName(i)).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(")");
        if (isThrowException) {
            sb.append(" throws E");
        }
        sb.append(";").append("\n");

        // 默认实现
        if (isThrowException) {
            sb.append("\n");
            sb.append("    /**").append("\n");
            sb.append("     * 默认方法实现，用于应用某些操作或逻辑").append("\n");
            sb.append("     * 该方法旨在封装对 {@link #").append(methodName).append("Throw").append("} 方法的调用，并处理可能抛出的异常").append("\n");
            sb.append("     *").append("\n");

            // 参数说明
            for (int i = 0; i < paramTypes.length; i++) {
                sb.append("     * @param ").append(paramTypes[i].getParamName(i)).append(" 类型为 ").append(paramTypes[i].getParamType(i)).append(" 的第 ").append(i + 1).append(" 个参数。").append("\n");
            }

            // 返回值说明
            if (returnType != null) {
                if (returnType == LambdaType.TEST) {
                    sb.append("     * @return 该方法返回一个布尔值，表示操作是否成功。");
                } else {
                    sb.append("     * @return 该方法返回一个结果，表示操作的结果。");
                }
                sb.append("\n");
            }
            sb.append("     */").append("\n");
            sb.append("    @Override").append("\n");
            sb.append("    default ");
            if (returnType != null) {
                sb.append(returnType.getReturnType());
            } else {
                sb.append("void");
            }
            sb.append(" ").append(methodName).append("(");

            // 参数声明
            for (int i = 0; i < paramTypes.length; i++) {
                sb.append(paramTypes[i].getParamType(i)).append(" ").append(paramTypes[i].getParamName(i)).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(") {").append("\n");

            // 实现逻辑
            sb.append("        try {").append("\n");
            sb.append("            ").append(returnType != null ? "return " : "").append("this.").append(methodName).append("Throw").append("(");
            for (int i = 0; i < paramTypes.length; i++) {
                sb.append(paramTypes[i].getParamName(i)).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(");").append("\n");
            sb.append("        } catch (Exception e) {").append("\n");
            sb.append("            throw new RuntimeException(\"Exception for '").append(methodName).append("Throw").append("'\", e);").append("\n");
            sb.append("        }").append("\n");
            sb.append("    }").append("\n");
        }
        sb.append("}").append("\n");

        return sb.toString();
    }

    /**
     * 将生成的代码写入文件
     *
     * @param directory 目标目录
     * @param charset   字符集
     * @throws IOException 如果写入过程中发生错误
     */
    public void writeToDirectory(Path directory, Charset charset) throws IOException {
        Path path = directory.resolve(getClassName(false) + ".java");
        Files.write(path, getResult(false).getBytes(charset));
        path = directory.resolve(getClassName(true) + ".java");
        Files.write(path, getResult(true).getBytes(charset));
    }
}
