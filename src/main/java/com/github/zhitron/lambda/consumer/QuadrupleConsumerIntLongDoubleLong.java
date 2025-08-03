package com.github.zhitron.lambda.consumer;

/**
 * 这是一个通用的 lambda 函数类，输入 4 个参数的操作。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface QuadrupleConsumerIntLongDoubleLong {

    /**
     * 一个空实现的实例，它总是返回 。
     */
    QuadrupleConsumerIntLongDoubleLong EMPTY = (v1, v2, v3, v4) -> {
    };

    /**
     * 返回一个空实现的实例，它总是返回 。
     *
     * @return 获取一个空的函数式接口实例。
     */
    static QuadrupleConsumerIntLongDoubleLong empty() {
        return EMPTY;
    }

    /**
     * 对给定的 4 个参数进行操作。
     *
     * @param v1 类型为 int 的第 1 个参数。
     * @param v2 类型为 long 的第 2 个参数。
     * @param v3 类型为 double 的第 3 个参数。
     * @param v4 类型为 long 的第 4 个参数。
     */
    void accept(int v1, long v2, double v3, long v4);
}
