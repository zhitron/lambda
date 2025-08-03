package com.github.zhitron.lambda.operator;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数接口，用于对 1 个 float 类型参数进行操作。。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface FloatSingleOperator {

    /**
     * 一个空实现的实例，它总是返回 BasicConstant.FLOAT_ZERO 值。
     */
    FloatSingleOperator EMPTY = (v1) -> BasicConstant.FLOAT_ZERO;

    /**
     * 返回一个空实现的实例，它总是返回 {@link BasicConstant#FLOAT_ZERO} 值。
     *
     * @return 获取一个空的函数式接口实例。
     */
    static FloatSingleOperator empty() {
        return EMPTY;
    }

    /**
     * 创建一个始终返回指定常量值的函数式接口。
     *
     * @param value 常量值。
     * @return 返回指定常量值的函数式接口。
     */
    static FloatSingleOperator constant(float value) {
        return (v1) -> value;
    }

    /**
     * 对给定的 1 个 FLOAT 参数执行某种操作并返回结果。
     *
     * @param v1 类型为 float 的第 1 个参数。
     * @return 操作后的 float 结果。
     */
    float apply(float v1);
}
