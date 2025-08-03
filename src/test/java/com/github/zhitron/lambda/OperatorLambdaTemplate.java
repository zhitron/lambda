package com.github.zhitron.lambda;

import static com.github.zhitron.lambda.LambdaType.BOOLEAN;
import static com.github.zhitron.lambda.LambdaType.OBJECT;

/**
 * @author zhitron
 */
class OperatorLambdaTemplate extends TemplateInformation {
    /**
     * 构造函数
     *
     * @param returnType 返回类型，如果为null表示Consumer，如果为TEST表示Predicate，否则表示Function
     * @param paramCount 参数类型数组
     */
    public OperatorLambdaTemplate(LambdaType returnType, int paramCount) {
        super("apply", returnType, returnType, paramCount);
        if (returnType == null) {
            throw new IllegalArgumentException("The type of return type is incorrect");
        }
    }

    /**
     * 获取生成的类名
     *
     * @param isThrowException 是否支持抛出异常
     * @return 生成的类名
     */
    @Override
    public String doGetClassName(boolean isThrowException) {
        StringBuilder sb = new StringBuilder();

        // 如果所有参数类型相同，直接添加类型名称
        sb.append(returnType.getCapitalizedName());

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
        sb.append("Operator");

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
    public String generate(boolean isThrowException) {
        StringBuilder sb = new StringBuilder();

        // 包声明
        sb.append("package com.github.zhitron.lambda.operator").append(";").append("\n");
        sb.append("\n");
        if (returnType != OBJECT) {
            sb.append("import com.github.zhitron.BasicConstant;").append("\n");
            sb.append("\n");
        }

        // 类注释
        sb.append("/**").append("\n");
        sb.append(" * 这是一个通用的 lambda 函数接口，用于对 ").append(paramTypes.length).append(" 个 ").append(returnType.getReturnType()).append(" 类型参数进行操作。。");

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
        if (returnType.isGeneric()) {
            for (int i = 0; i < paramTypes.length; i++) {
                sb.append(" * @param <").append(returnType.getParamType(i)).append("> 第 ").append(i + 1).append(" 个参数类型。").append("\n");
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
        String genericDeclaration = getGenericDeclaration(isThrowException);
        if (!genericDeclaration.isEmpty()) {
            sb.append(genericDeclaration);
        }

        // 继承声明
        if (isThrowException) {
            sb.append(" extends ").append(getClassName(false));

            if (returnType.isGeneric()) {
                sb.append("<");
                if (returnType.isGeneric()) {
                    for (int i = 0; i < paramTypes.length; i++) {
                        if (returnType.isGeneric()) {
                            sb.append(returnType.getParamType(i)).append(", ");
                        }
                    }
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
            if (returnType == OBJECT) {
                sb.append("null 值。");
            } else {
                sb.append("BasicConstant.").append(returnType).append("_ZERO 值。");
            }
            sb.append("\n");
            sb.append("     */").append("\n");
            sb.append("    ").append(getClassName(isThrowException)).append(getGenericUnknown(isThrowException)).append(" EMPTY = (").append(getParamInvocation()).append(") -> ");
            if (returnType == OBJECT) {
                sb.append("null;");
            } else {
                sb.append("BasicConstant.").append(returnType).append("_ZERO;");
            }
            sb.append("\n");
            sb.append("\n");
            sb.append("    /**").append("\n");
            sb.append("     * 返回一个空实现的实例，它总是返回 ");
            if (returnType == OBJECT) {
                sb.append("null 值。");
            } else {
                sb.append("{@link BasicConstant#").append(returnType).append("_ZERO} 值。");
            }
            sb.append("\n");
            sb.append("     *").append("\n");
            sb.append("     * @return 获取一个空的函数式接口实例。").append("\n");
            sb.append("     */").append("\n");
            if (hasGeneric(isThrowException)) {
                sb.append("    @SuppressWarnings(\"unchecked\")").append("\n");
            }
            sb.append("    static ");
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
            sb.append("        return (").append(getParamInvocation()).append(") -> value;").append("\n");
            sb.append("    }").append("\n");
            sb.append("\n");
        }

        // 方法注释
        sb.append("    /**").append("\n");
        sb.append("     * 对给定的 ").append(paramTypes.length).append(" 个 ").append(returnType).append(" 参数执行某种操作并返回结果。").append("\n");
        sb.append("     *").append("\n");

        // 参数说明
        for (int i = 0; i < paramTypes.length; i++) {
            sb.append("     * @param ").append(returnType.getParamName(i)).append(" 类型为 ").append(returnType.getParamType(i)).append(" 的第 ").append(i + 1).append(" 个参数。").append("\n");
        }

        // 返回值说明
        sb.append("     * @return 操作后的 ").append(returnType.getReturnType()).append(" 结果。").append("\n");

        // 异常说明
        if (isThrowException) {
            sb.append("     * @throws E 抛出执行过程中的异常").append("\n");
        }
        sb.append("     */").append("\n");

        // 方法声明
        sb.append("    ").append(returnType.getReturnType()).append(" ").append(methodName);
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
                sb.append("     * @param ").append(returnType.getParamName(i)).append(" 类型为 ").append(returnType.getParamType(i)).append(" 的第 ").append(i + 1).append(" 个参数。").append("\n");
            }

            // 返回值说明
            sb.append("     * @return 操作后的 ").append(returnType.getReturnType()).append(" 结果。").append("\n");
            sb.append("     */").append("\n");
            sb.append("    @Override").append("\n");
            sb.append("    default ").append(returnType.getReturnType()).append(" ").append(methodName).append("(").append(getParamDeclaration()).append(") {").append("\n");

            // 实现逻辑
            sb.append("        try {").append("\n");
            sb.append("            ").append("return ").append("this.").append(methodName).append("Throw").append("(");
            for (int i = 0; i < paramTypes.length; i++) {
                sb.append(returnType.getParamName(i)).append(", ");
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
}
