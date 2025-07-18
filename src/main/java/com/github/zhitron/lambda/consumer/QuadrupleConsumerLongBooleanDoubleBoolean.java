package com.github.zhitron.lambda.consumer;

/**
 * 这是一个通用的 lambda 函数类，输入 4 个参的操作。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface QuadrupleConsumerLongBooleanDoubleBoolean {

    /**
     * 对给定的 4 个参数进行操作。
     *
     * @param v1 类型为 long 的第 1 个参数。
     * @param v2 类型为 boolean 的第 2 个参数。
     * @param v3 类型为 double 的第 3 个参数。
     * @param v4 类型为 boolean 的第 4 个参数。
     */
    void accept(long v1, boolean v2, double v3, boolean v4);
}
