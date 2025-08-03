package com.github.zhitron.lambda.consumer;

/**
 * 这是一个通用的 lambda 函数类，输入 2 个参数的操作。支持抛出异常。
 * 该接口扩展自 {@link TwiceConsumerObjectLong}，增加了异常处理能力。
 *
 * @param <T> 第 1 个参数类型。
 * @param <E> 异常类型，必须是 {@link Exception} 的子类
 * @author zhitron
 */
@FunctionalInterface
public interface TwiceConsumerObjectLongThrow<T, E extends Exception> extends TwiceConsumerObjectLong<T> {

    /**
     * 一个空实现的实例，它总是返回 。
     */
    TwiceConsumerObjectLongThrow<?, ?> EMPTY = (v1, v2) -> {
    };

    /**
     * 返回一个空实现的实例，它总是返回 。
     *
     * @return 获取一个空的函数式接口实例。
     */
    @SuppressWarnings("unchecked")
    static <T, E extends Exception> TwiceConsumerObjectLongThrow<T, E> empty() {
        return (TwiceConsumerObjectLongThrow<T, E>) EMPTY;
    }

    /**
     * 对给定的 2 个参数进行操作。
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 long 的第 2 个参数。
     * @throws E 抛出执行过程中的异常
     */
    void acceptThrow(T v1, long v2) throws E;

    /**
     * 默认方法实现，用于应用某些操作或逻辑
     * 该方法旨在封装对 {@link #acceptThrow} 方法的调用，并处理可能抛出的异常
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 long 的第 2 个参数。
     */
    @Override
    default void accept(T v1, long v2) {
        try {
            this.acceptThrow(v1, v2);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'acceptThrow'", e);
        }
    }
}
