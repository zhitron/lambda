package com.github.zhitron.lambda.supplier;

/**
 * 一个扩展自 {@link LongSupplier} 的函数式接口，允许在其方法中抛出指定类型的异常。
 * 此接口适用于需要延迟计算或按需提供 long 值，并且可能抛出受检异常的场景。
 *
 * @param <E> 接口方法可以抛出的异常类型，必须是 {@link Throwable} 的子类型
 * @author zhitron
 */
public interface LongSupplierThrow<E extends Exception> extends LongSupplier {

    /**
     * 获取一个 long 值，并可能抛出指定类型的异常。
     *
     * @return 提供的 long 值
     * @throws E 当操作失败时抛出的异常
     */
    long getAsLongThrow() throws E;

    /**
     * 默认实现，调用 {@link #getAsLongThrow()} 方法并捕获其中抛出的异常，将其包装为运行时异常后抛出。
     * 如果发生异常，将抛出一个新的 {@link RuntimeException}，其中包含原始异常的信息。
     *
     * @return 提供的 long 值
     * @throws RuntimeException 包装了 {@link #getAsLongThrow()} 方法中抛出的异常
     */
    @Override
    default long getAsLong() {
        try {
            return getAsLongThrow();
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'getAsLongThrow'", e);
        }
    }
}