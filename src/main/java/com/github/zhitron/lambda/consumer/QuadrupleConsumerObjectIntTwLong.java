package com.github.zhitron.lambda.consumer;

/**
 * 这是一个通用的 lambda 函数类，输入 4 个参的操作。
 *
 * @param <T> 第 1 个参数类型。
 * @author zhitron
 */
@FunctionalInterface
public interface QuadrupleConsumerObjectIntTwLong<T> {

    /**
     * 对给定的 4 个参数进行操作。
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 int 的第 2 个参数。
     * @param v3 类型为 long 的第 3 个参数。
     * @param v4 类型为 long 的第 4 个参数。
     */
    void accept(T v1, int v2, long v3, long v4);
}
