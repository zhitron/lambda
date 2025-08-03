package com.github.zhitron.lambda.function;

/**
 * 这是一个通用的 lambda 函数类，输入 2 个参数的操作，并返回一个结果。
 *
 * @param <T> 第 1 个参数类型。
 * @author zhitron
 */
@FunctionalInterface
public interface TwiceFunctionObjectBooleanToObject<T, R> {

    /**
     * 一个空实现的实例，它总是返回 null 值。
     */
    TwiceFunctionObjectBooleanToObject<?, ?> EMPTY = (v1, v2) -> null;

    /**
     * 返回一个空实现的实例，它总是返回 null 值。
     *
     * @return 获取一个空的函数式接口实例。
     */
    @SuppressWarnings("unchecked")
    static <T, R> TwiceFunctionObjectBooleanToObject<T, R> empty() {
        return (TwiceFunctionObjectBooleanToObject<T, R>) EMPTY;
    }

    /**
     * 创建一个始终返回指定常量值的函数式接口。
     *
     * @param value 常量值。
     * @return 返回指定常量值的函数式接口。
     */
    static <T, R> TwiceFunctionObjectBooleanToObject<T, R> constant(R value) {
        return (v1, v2) -> value;
    }

    /**
     * 对给定的 2 个参数进行操作，并返回一个结果。
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 boolean 的第 2 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     */
    R apply(T v1, boolean v2);
}
