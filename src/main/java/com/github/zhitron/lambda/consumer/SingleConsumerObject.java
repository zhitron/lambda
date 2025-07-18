package com.github.zhitron.lambda.consumer;

/**
 * 这是一个通用的 lambda 函数类，输入 1 个参的操作。
 *
 * @param <T> 第 1 个参数类型。
 * @author zhitron
 */
@FunctionalInterface
public interface SingleConsumerObject<T> {

    /**
     * 对给定的 1 个参数进行操作。
     *
     * @param v1 类型为 T 的第 1 个参数。
     */
    void accept(T v1);
}
