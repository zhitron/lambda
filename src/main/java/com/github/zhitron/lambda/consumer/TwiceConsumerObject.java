package com.github.zhitron.lambda.consumer;

/**
 * 这是一个通用的 lambda 函数类，输入 2 个参数的操作。
 *
 * @param <T> 第 1 个参数类型。
 * @param <U> 第 2 个参数类型。
 * @author zhitron
 */
@FunctionalInterface
public interface TwiceConsumerObject<T, U> {

    /**
     * 一个空实现的实例，它总是返回 。
     */
    TwiceConsumerObject<?, ?> EMPTY = (v1, v2) -> {
    };

    /**
     * 返回一个空实现的实例，它总是返回 。
     *
     * @return 获取一个空的函数式接口实例。
     */
    @SuppressWarnings("unchecked")
    static <T, U> TwiceConsumerObject<T, U> empty() {
        return (TwiceConsumerObject<T, U>) EMPTY;
    }

    /**
     * 对给定的 2 个参数进行操作。
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 U 的第 2 个参数。
     */
    void accept(T v1, U v2);
}
