package com.github.zhitron.lambda.primitive.consumer;

/**
 * 表示一个接收单个 float 参数的消费器，该消费器可能抛出异常。
 * 这是 Consumer 接口针对 float 类型的原始类型特化版本，并支持在执行过程中抛出指定类型的异常。
 *
 * @param <E> 可能抛出的异常类型
 * @author zhitron
 */
@FunctionalInterface
public interface FloatSingleConsumerThrow<E extends Exception> extends FloatSingleConsumer {
    /**
     * 在给定参数上执行消费操作，可能抛出异常。
     *
     * @param input 输入参数
     * @throws E 如果评估过程中发生错误
     */
    void acceptThrow(float input) throws E;

    /**
     * 在给定参数上执行消费操作，不支持直接抛出检查型异常。
     * 默认实现将检查型异常封装为运行时异常后抛出。
     *
     * @param input 输入参数
     */
    @Override
    default void accept(float input) {
        try {
            acceptThrow(input);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'acceptThrow'", e);
        }
    }
}
