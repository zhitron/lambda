package com.github.zhitron.lambda.operator;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数接口，用于对 1 个 char 类型参数进行操作。。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface CharSingleOperator {

    /**
     * 一个空实现的实例，它总是返回 BasicConstant.CHAR_ZERO 值。
     */
    CharSingleOperator EMPTY = (v1) -> BasicConstant.CHAR_ZERO;

    /**
     * 返回一个空实现的实例，它总是返回 {@link BasicConstant#CHAR_ZERO} 值。
     *
     * @return 获取一个空的函数式接口实例。
     */
    static CharSingleOperator empty() {
        return EMPTY;
    }

    /**
     * 创建一个始终返回指定常量值的函数式接口。
     *
     * @param value 常量值。
     * @return 返回指定常量值的函数式接口。
     */
    static CharSingleOperator constant(char value) {
        return (v1) -> value;
    }

    /**
     * 对给定的 1 个 CHAR 参数执行某种操作并返回结果。
     *
     * @param v1 类型为 char 的第 1 个参数。
     * @return 操作后的 char 结果。
     */
    char apply(char v1);
}
