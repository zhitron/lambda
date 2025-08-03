package com.github.zhitron.lambda.consumer;

/**
 * 这是一个通用的 lambda 函数类，输入 2 个参数的操作。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface TwiceConsumerIntDouble {

    /**
     * 一个空实现的实例，它总是返回 。
     */
    TwiceConsumerIntDouble EMPTY = (v1, v2) -> {
    };

    /**
     * 返回一个空实现的实例，它总是返回 。
     *
     * @return 获取一个空的函数式接口实例。
     */
    static TwiceConsumerIntDouble empty() {
        return EMPTY;
    }

    /**
     * 对给定的 2 个参数进行操作。
     *
     * @param v1 类型为 int 的第 1 个参数。
     * @param v2 类型为 double 的第 2 个参数。
     */
    void accept(int v1, double v2);
}
