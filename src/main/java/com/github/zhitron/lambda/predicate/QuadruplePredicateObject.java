package com.github.zhitron.lambda.predicate;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数类，输入 4 个参数的操作，并返回一个布尔值。
 *
 * @param <T> 第 1 个参数类型。
 * @param <U> 第 2 个参数类型。
 * @param <V> 第 3 个参数类型。
 * @param <O> 第 4 个参数类型。
 * @author zhitron
 */
@FunctionalInterface
public interface QuadruplePredicateObject<T, U, V, O> {

    /**
     * 默认返回 true 的 QuadruplePredicateObject 实例。
     */
    QuadruplePredicateObject<?, ?, ?, ?> DEFAULT_TRUE = (v1, v2, v3, v4) -> BasicConstant.BOOLEAN_TRUE;

    /**
     * 默认返回 false 的 QuadruplePredicateObject 实例。
     */
    QuadruplePredicateObject<?, ?, ?, ?> DEFAULT_FALSE = (v1, v2, v3, v4) -> BasicConstant.BOOLEAN_FALSE;

    /**
     * 根据给定的布尔值返回对应的默认 QuadruplePredicateObject 实例。
     *
     * @param value 给定的布尔值。
     * @return 如果 value 为 true，返回 DEFAULT_TRUE；否则返回 DEFAULT_FALSE。
     */
    @SuppressWarnings("unchecked")
    static <T, U, V, O> QuadruplePredicateObject<T, U, V, O> constant(boolean value) {
        return (QuadruplePredicateObject<T, U, V, O>) (value ? DEFAULT_TRUE : DEFAULT_FALSE);
    }

    /**
     * 对给定的 4 个参数进行操作，并返回一个布尔值。
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 U 的第 2 个参数。
     * @param v3 类型为 V 的第 3 个参数。
     * @param v4 类型为 O 的第 4 个参数。
     * @return 该方法返回一个布尔值，表示操作是否成功。
     */
    boolean test(T v1, U v2, V v3, O v4);
}
