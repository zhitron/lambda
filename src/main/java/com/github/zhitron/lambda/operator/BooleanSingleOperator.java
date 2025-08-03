package com.github.zhitron.lambda.operator;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数接口，用于对 1 个 boolean 类型参数进行操作。。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface BooleanSingleOperator {

    /**
     * 默认返回 true 的 BooleanSingleOperator 实例。
     */
    BooleanSingleOperator DEFAULT_TRUE = (v1) -> BasicConstant.BOOLEAN_TRUE;

    /**
     * 默认返回 false 的 BooleanSingleOperator 实例。
     */
    BooleanSingleOperator DEFAULT_FALSE = (v1) -> BasicConstant.BOOLEAN_FALSE;

    /**
     * 根据给定的布尔值返回对应的默认 BooleanSingleOperator 实例。
     *
     * @param value 给定的布尔值。
     * @return 如果 value 为 true，返回 DEFAULT_TRUE；否则返回 DEFAULT_FALSE。
     */
    static BooleanSingleOperator constant(boolean value) {
        return (value ? DEFAULT_TRUE : DEFAULT_FALSE);
    }

    /**
     * 对给定的 1 个 BOOLEAN 参数执行某种操作并返回结果。
     *
     * @param v1 类型为 boolean 的第 1 个参数。
     * @return 操作后的 boolean 结果。
     */
    boolean apply(boolean v1);
}
