package com.github.zhitron.lambda.function;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数类，输入 1 个参数的操作，并返回一个结果。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface SingleFunctionBooleanToLong {

    /**
     * 一个空实现的实例，它总是返回 BasicConstant.LONG_ZERO 值。
     */
    SingleFunctionBooleanToLong EMPTY = (v1) -> BasicConstant.LONG_ZERO;

    /**
     * 返回一个空实现的实例，它总是返回 {@link BasicConstant#LONG_ZERO} 值。
     *
     * @return 获取一个空的函数式接口实例。
     */
    static SingleFunctionBooleanToLong empty() {
        return EMPTY;
    }

    /**
     * 创建一个始终返回指定常量值的函数式接口。
     *
     * @param value 常量值。
     * @return 返回指定常量值的函数式接口。
     */
    static SingleFunctionBooleanToLong constant(long value) {
        return (v1) -> value;
    }

    /**
     * 对给定的 1 个参数进行操作，并返回一个结果。
     *
     * @param v1 类型为 boolean 的第 1 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     */
    long apply(boolean v1);
}
