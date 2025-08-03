package com.github.zhitron.lambda.consumer;

/**
 * 这是一个通用的 lambda 函数类，输入 1 个参数的操作。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface SingleConsumerDouble {

    /**
     * 一个空实现的实例，它总是返回 。
     */
    SingleConsumerDouble EMPTY = (v1) -> {
    };

    /**
     * 返回一个空实现的实例，它总是返回 。
     *
     * @return 获取一个空的函数式接口实例。
     */
    static SingleConsumerDouble empty() {
        return EMPTY;
    }

    /**
     * 对给定的 1 个参数进行操作。
     *
     * @param v1 类型为 double 的第 1 个参数。
     */
    void accept(double v1);
}
