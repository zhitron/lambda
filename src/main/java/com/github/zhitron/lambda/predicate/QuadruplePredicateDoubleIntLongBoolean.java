package com.github.zhitron.lambda.predicate;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数类，输入 4 个参数的操作，并返回一个布尔值。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface QuadruplePredicateDoubleIntLongBoolean {

    /**
     * 默认返回 true 的 QuadruplePredicateDoubleIntLongBoolean 实例。
     */
    QuadruplePredicateDoubleIntLongBoolean DEFAULT_TRUE = (v1, v2, v3, v4) -> BasicConstant.BOOLEAN_TRUE;

    /**
     * 默认返回 false 的 QuadruplePredicateDoubleIntLongBoolean 实例。
     */
    QuadruplePredicateDoubleIntLongBoolean DEFAULT_FALSE = (v1, v2, v3, v4) -> BasicConstant.BOOLEAN_FALSE;

    /**
     * 根据给定的布尔值返回对应的默认 QuadruplePredicateDoubleIntLongBoolean 实例。
     *
     * @param value 给定的布尔值。
     * @return 如果 value 为 true，返回 DEFAULT_TRUE；否则返回 DEFAULT_FALSE。
     */
    static QuadruplePredicateDoubleIntLongBoolean constant(boolean value) {
        return (value ? DEFAULT_TRUE : DEFAULT_FALSE);
    }

    /**
     * 对给定的 4 个参数进行操作，并返回一个布尔值。
     *
     * @param v1 类型为 double 的第 1 个参数。
     * @param v2 类型为 int 的第 2 个参数。
     * @param v3 类型为 long 的第 3 个参数。
     * @param v4 类型为 boolean 的第 4 个参数。
     * @return 该方法返回一个布尔值，表示操作是否成功。
     */
    boolean test(double v1, int v2, long v3, boolean v4);
}
