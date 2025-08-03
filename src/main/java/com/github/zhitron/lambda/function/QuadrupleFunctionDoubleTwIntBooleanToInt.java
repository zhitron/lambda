package com.github.zhitron.lambda.function;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数类，输入 4 个参数的操作，并返回一个结果。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface QuadrupleFunctionDoubleTwIntBooleanToInt {

    /**
     * 一个空实现的实例，它总是返回 BasicConstant.INT_ZERO 值。
     */
    QuadrupleFunctionDoubleTwIntBooleanToInt EMPTY = (v1, v2, v3, v4) -> BasicConstant.INT_ZERO;

    /**
     * 返回一个空实现的实例，它总是返回 {@link BasicConstant#INT_ZERO} 值。
     *
     * @return 获取一个空的函数式接口实例。
     */
    static QuadrupleFunctionDoubleTwIntBooleanToInt empty() {
        return EMPTY;
    }

    /**
     * 创建一个始终返回指定常量值的函数式接口。
     *
     * @param value 常量值。
     * @return 返回指定常量值的函数式接口。
     */
    static QuadrupleFunctionDoubleTwIntBooleanToInt constant(int value) {
        return (v1, v2, v3, v4) -> value;
    }

    /**
     * 对给定的 4 个参数进行操作，并返回一个结果。
     *
     * @param v1 类型为 double 的第 1 个参数。
     * @param v2 类型为 int 的第 2 个参数。
     * @param v3 类型为 int 的第 3 个参数。
     * @param v4 类型为 boolean 的第 4 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     */
    int apply(double v1, int v2, int v3, boolean v4);
}
