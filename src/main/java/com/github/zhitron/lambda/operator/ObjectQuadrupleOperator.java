package com.github.zhitron.lambda.operator;

/**
 * 这是一个通用的 lambda 函数接口，用于对 4 个 R 类型参数进行操作。。
 *
 * @param <T> 第 1 个参数类型。
 * @param <U> 第 2 个参数类型。
 * @param <V> 第 3 个参数类型。
 * @param <O> 第 4 个参数类型。
 * @author zhitron
 */
@FunctionalInterface
public interface ObjectQuadrupleOperator<T, U, V, O, R> {

    /**
     * 一个空实现的实例，它总是返回 null 值。
     */
    ObjectQuadrupleOperator<?, ?, ?, ?, ?> EMPTY = (v1, v2, v3, v4) -> null;

    /**
     * 返回一个空实现的实例，它总是返回 null 值。
     *
     * @return 获取一个空的函数式接口实例。
     */
    @SuppressWarnings("unchecked")
    static <T, U, V, O, R> ObjectQuadrupleOperator<T, U, V, O, R> empty() {
        return (ObjectQuadrupleOperator<T, U, V, O, R>) EMPTY;
    }

    /**
     * 创建一个始终返回指定常量值的函数式接口。
     *
     * @param value 常量值。
     * @return 返回指定常量值的函数式接口。
     */
    static <T, U, V, O, R> ObjectQuadrupleOperator<T, U, V, O, R> constant(R value) {
        return (v1, v2, v3, v4) -> value;
    }

    /**
     * 对给定的 4 个 OBJECT 参数执行某种操作并返回结果。
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 U 的第 2 个参数。
     * @param v3 类型为 V 的第 3 个参数。
     * @param v4 类型为 O 的第 4 个参数。
     * @return 操作后的 R 结果。
     */
    R apply(T v1, U v2, V v3, O v4);
}
