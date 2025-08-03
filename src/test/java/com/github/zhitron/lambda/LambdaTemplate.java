package com.github.zhitron.lambda;

import static com.github.zhitron.lambda.LambdaType.BOOLEAN;
import static com.github.zhitron.lambda.LambdaType.OBJECT;

/**
 * LambdaTemplate 是一个用于生成 Lambda 表达式模板代码的类。
 * 它继承自 TemplateInfo，根据给定的返回类型和参数类型生成相应的函数式接口代码。
 *
 * @author zhitron
 */
class LambdaTemplate extends TemplateInformation {

    /**
     * 构造函数
     *
     * @param returnType 返回类型，如果为null表示Consumer，如果为TEST表示Predicate，否则表示Function
     * @param paramTypes 参数类型数组
     */
    public LambdaTemplate(LambdaType returnType, LambdaType... paramTypes) {
        super(returnType == null ? "accept" : (returnType == BOOLEAN ? "test" : "apply"), returnType, paramTypes);
    }

    /**
     * 生成Java代码
     *
     * @param isThrowException 是否支持抛出异常
     * @return 生成的Java代码字符串
     */
    public String generate(boolean isThrowException) {
        StringBuilder sb = new StringBuilder();

        // 包声明
        sb.append("package com.github.zhitron.lambda");
        if (returnType == null) {
            sb.append(".consumer");
        } else if (returnType == BOOLEAN) {
            sb.append(".predicate");
        } else {
            sb.append(".function");
        }
        sb.append(";").append("\n");
        sb.append("\n");
        if (returnType != null && returnType != OBJECT) {
            sb.append("import com.github.zhitron.BasicConstant;").append("\n");
            sb.append("\n");
        }

        // 类注释
        sb.append("/**").append("\n");
        sb.append(" * 这是一个通用的 lambda 函数类，输入 ").append(paramTypes.length).append(" 个参数的操作");
        if (returnType != null) {
            if (returnType == BOOLEAN) {
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
        sb.append(getGenericDeclaration(isThrowException));

        // 继承声明
        if (isThrowException) {
            sb.append(" extends ").append(getClassName(false));

            if (hasGeneric(true)) {
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

        // 方法声明
        if (returnType == BOOLEAN) {
            sb.append("    /**").append("\n");
            sb.append("     * 默认返回 true 的 ").append(getClassName(isThrowException)).append(" 实例。").append("\n");
            sb.append("     */").append("\n");
            sb.append("    ").append(getClassName(isThrowException)).append(getGenericUnknown(isThrowException)).append(" DEFAULT_TRUE = (").append(getParamInvocation()).append(") -> BasicConstant.BOOLEAN_TRUE;").append("\n");
            sb.append("\n");
            sb.append("    /**").append("\n");
            sb.append("     * 默认返回 false 的 ").append(getClassName(isThrowException)).append(" 实例。").append("\n");
            sb.append("     */").append("\n");
            sb.append("    ").append(getClassName(isThrowException)).append(getGenericUnknown(isThrowException)).append(" DEFAULT_FALSE = (").append(getParamInvocation()).append(") -> BasicConstant.BOOLEAN_FALSE;").append("\n");
            sb.append("\n");
            sb.append("    /**").append("\n");
            sb.append("     * 根据给定的布尔值返回对应的默认 ").append(getClassName(isThrowException)).append(" 实例。").append("\n");
            sb.append("     *").append("\n");
            sb.append("     * @param value 给定的布尔值。").append("\n");
            sb.append("     * @return 如果 value 为 true，返回 DEFAULT_TRUE；否则返回 DEFAULT_FALSE。").append("\n");
            sb.append("     */").append("\n");

            if (hasGeneric(isThrowException)) {
                sb.append("    @SuppressWarnings(\"unchecked\")").append("\n");
            }
            sb.append("    static ");
            String genericDeclaration = getGenericDeclaration(isThrowException);
            if (!genericDeclaration.isEmpty()) {
                sb.append(genericDeclaration).append(" ");
            }
            sb.append(getClassName(isThrowException)).append(getGenericDefinition(isThrowException));
            sb.append(" constant(boolean value) {").append("\n");
            sb.append("        return");
            if (hasGeneric(isThrowException)) {
                sb.append(" (").append(getClassName(isThrowException)).append(getGenericDefinition(isThrowException)).append(")");
            }
            sb.append(" (value ? DEFAULT_TRUE : DEFAULT_FALSE);").append("\n");
            sb.append("    }").append("\n");
            sb.append("\n");
        } else {
            sb.append("    /**").append("\n");
            sb.append("     * 一个空实现的实例，它总是返回 ");
            if (returnType != null) {
                if (returnType == OBJECT) {
                    sb.append("null 值。");
                } else {
                    sb.append("BasicConstant.").append(returnType).append("_ZERO 值。");
                }
            } else {
                sb.append("。");
            }
            sb.append("\n");
            sb.append("     */").append("\n");
            sb.append("    ").append(getClassName(isThrowException)).append(getGenericUnknown(isThrowException)).append(" EMPTY = (").append(getParamInvocation()).append(") -> ");
            if (returnType != null) {
                if (returnType == OBJECT) {
                    sb.append("null;");
                } else {
                    sb.append("BasicConstant.").append(returnType).append("_ZERO;");
                }
                sb.append("\n");
            } else {
                sb.append("{").append("\n");
                sb.append("    };").append("\n");
            }
            sb.append("\n");
            sb.append("    /**").append("\n");
            sb.append("     * 返回一个空实现的实例，它总是返回 ");
            if (returnType != null) {
                if (returnType == OBJECT) {
                    sb.append("null 值。");
                } else {
                    sb.append("{@link BasicConstant#").append(returnType).append("_ZERO} 值。");
                }
            } else {
                sb.append("。");
            }
            sb.append("\n");
            sb.append("     *").append("\n");
            sb.append("     * @return 获取一个空的函数式接口实例。").append("\n");
            sb.append("     */").append("\n");
            if (hasGeneric(isThrowException)) {
                sb.append("    @SuppressWarnings(\"unchecked\")").append("\n");
            }
            sb.append("    static ");
            String genericDeclaration = getGenericDeclaration(isThrowException);
            if (!genericDeclaration.isEmpty()) {
                sb.append(genericDeclaration).append(" ");
            }
            sb.append(getClassName(isThrowException)).append(getGenericDefinition(isThrowException));
            sb.append(" empty() {").append("\n");
            sb.append("        return");
            if (hasGeneric(isThrowException)) {
                sb.append(" (").append(getClassName(isThrowException)).append(getGenericDefinition(isThrowException)).append(")");
            }
            sb.append(" EMPTY;").append("\n");
            sb.append("    }").append("\n");
            sb.append("\n");
            if (returnType != null) {
                sb.append("    /**").append("\n");
                sb.append("     * 创建一个始终返回指定常量值的函数式接口。").append("\n");
                sb.append("     *").append("\n");
                sb.append("     * @param value 常量值。").append("\n");
                sb.append("     * @return 返回指定常量值的函数式接口。").append("\n");
                sb.append("     */").append("\n");
                sb.append("    static ");
                if (!genericDeclaration.isEmpty()) {
                    sb.append(genericDeclaration).append(" ");
                }
                sb.append(getClassName(isThrowException)).append(getGenericDefinition(isThrowException));
                sb.append(" constant(").append(returnType.getReturnType()).append(" value) {").append("\n");
                sb.append("        return (");
                for (int i = 0; i < paramTypes.length; i++) {
                    sb.append(paramTypes[i].getParamName(i)).append(", ");
                }
                sb.setLength(sb.length() - 2);
                sb.append(") -> value;").append("\n");
                sb.append("    }").append("\n");
                sb.append("\n");
            }
        }

        // 方法注释
        sb.append("    /**").append("\n");
        sb.append("     * 对给定的 ").append(paramTypes.length).append(" 个参数进行操作");
        if (returnType != null) {
            if (returnType == BOOLEAN) {
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
            if (returnType == BOOLEAN) {
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
        sb.append("(").append(getParamDeclaration()).append(")");
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
                if (returnType == BOOLEAN) {
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
            sb.append(" ").append(methodName).append("(").append(getParamDeclaration()).append(") {").append("\n");

            // 实现逻辑
            sb.append("        try {").append("\n");
            sb.append("            ").append(returnType != null ? "return " : "").append("this.").append(methodName).append("Throw").append("(").append(getParamInvocation()).append(");").append("\n");
            sb.append("        } catch (Exception e) {").append("\n");
            sb.append("            throw new RuntimeException(\"Exception for '").append(methodName).append("Throw").append("'\", e);").append("\n");
            sb.append("        }").append("\n");
            sb.append("    }").append("\n");
        }
        sb.append("}").append("\n");

        return sb.toString();
    }
}
