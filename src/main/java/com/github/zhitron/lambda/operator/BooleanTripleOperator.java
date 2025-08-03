package com.github.zhitron.lambda.operator;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数接口，用于对 3 个 boolean 类型参数进行操作。。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface BooleanTripleOperator {

    /**
     * 默认返回 true 的 BooleanTripleOperator 实例。
     */
    BooleanTripleOperator DEFAULT_TRUE = (v1, v2, v3) -> BasicConstant.BOOLEAN_TRUE;

    /**
     * 默认返回 false 的 BooleanTripleOperator 实例。
     */
    BooleanTripleOperator DEFAULT_FALSE = (v1, v2, v3) -> BasicConstant.BOOLEAN_FALSE;

    /**
     * 根据给定的布尔值返回对应的默认 BooleanTripleOperator 实例。
     *
     * @param value 给定的布尔值。
     * @return 如果 value 为 true，返回 DEFAULT_TRUE；否则返回 DEFAULT_FALSE。
     */
    static BooleanTripleOperator constant(boolean value) {
        return (value ? DEFAULT_TRUE : DEFAULT_FALSE);
    }

    /**
     * 对给定的 3 个 BOOLEAN 参数执行某种操作并返回结果。
     *
     * @param v1 类型为 boolean 的第 1 个参数。
     * @param v2 类型为 boolean 的第 2 个参数。
     * @param v3 类型为 boolean 的第 3 个参数。
     * @return 操作后的 boolean 结果。
     */
    boolean apply(boolean v1, boolean v2, boolean v3);
}
