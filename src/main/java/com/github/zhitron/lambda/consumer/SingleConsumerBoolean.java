package com.github.zhitron.lambda.consumer;

/**
 * 这是一个通用的 lambda 函数类，输入 1 个参的操作。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface SingleConsumerBoolean {

    /**
     * 对给定的 1 个参数进行操作。
     *
     * @param v1 类型为 boolean 的第 1 个参数。
     */
    void accept(boolean v1);
}
