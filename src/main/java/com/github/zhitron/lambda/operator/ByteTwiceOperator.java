package com.github.zhitron.lambda.operator;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数接口，用于对 2 个 byte 类型参数进行操作。。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface ByteTwiceOperator {

    /**
     * 一个空实现的实例，它总是返回 BasicConstant.BYTE_ZERO 值。
     */
    ByteTwiceOperator EMPTY = (v1, v2) -> BasicConstant.BYTE_ZERO;

    /**
     * 返回一个空实现的实例，它总是返回 {@link BasicConstant#BYTE_ZERO} 值。
     *
     * @return 获取一个空的函数式接口实例。
     */
    static ByteTwiceOperator empty() {
        return EMPTY;
    }

    /**
     * 创建一个始终返回指定常量值的函数式接口。
     *
     * @param value 常量值。
     * @return 返回指定常量值的函数式接口。
     */
    static ByteTwiceOperator constant(byte value) {
        return (v1, v2) -> value;
    }

    /**
     * 对给定的 2 个 BYTE 参数执行某种操作并返回结果。
     *
     * @param v1 类型为 byte 的第 1 个参数。
     * @param v2 类型为 byte 的第 2 个参数。
     * @return 操作后的 byte 结果。
     */
    byte apply(byte v1, byte v2);
}
