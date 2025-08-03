package com.github.zhitron.lambda.consumer;

/**
 * 这是一个通用的 lambda 函数类，输入 4 个参数的操作。支持抛出异常。
 * 该接口扩展自 {@link QuadrupleConsumerLongTwIntDouble}，增加了异常处理能力。
 *
 * @param <E> 异常类型，必须是 {@link Exception} 的子类
 * @author zhitron
 */
@FunctionalInterface
public interface QuadrupleConsumerLongTwIntDoubleThrow<E extends Exception> extends QuadrupleConsumerLongTwIntDouble {

    /**
     * 一个空实现的实例，它总是返回 。
     */
    QuadrupleConsumerLongTwIntDoubleThrow<?> EMPTY = (v1, v2, v3, v4) -> {
    };

    /**
     * 返回一个空实现的实例，它总是返回 。
     *
     * @return 获取一个空的函数式接口实例。
     */
    @SuppressWarnings("unchecked")
    static <E extends Exception> QuadrupleConsumerLongTwIntDoubleThrow<E> empty() {
        return (QuadrupleConsumerLongTwIntDoubleThrow<E>) EMPTY;
    }

    /**
     * 对给定的 4 个参数进行操作。
     *
     * @param v1 类型为 long 的第 1 个参数。
     * @param v2 类型为 int 的第 2 个参数。
     * @param v3 类型为 int 的第 3 个参数。
     * @param v4 类型为 double 的第 4 个参数。
     * @throws E 抛出执行过程中的异常
     */
    void acceptThrow(long v1, int v2, int v3, double v4) throws E;

    /**
     * 默认方法实现，用于应用某些操作或逻辑
     * 该方法旨在封装对 {@link #acceptThrow} 方法的调用，并处理可能抛出的异常
     *
     * @param v1 类型为 long 的第 1 个参数。
     * @param v2 类型为 int 的第 2 个参数。
     * @param v3 类型为 int 的第 3 个参数。
     * @param v4 类型为 double 的第 4 个参数。
     */
    @Override
    default void accept(long v1, int v2, int v3, double v4) {
        try {
            this.acceptThrow(v1, v2, v3, v4);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'acceptThrow'", e);
        }
    }
}
