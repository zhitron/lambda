package com.github.zhitron.lambda.primitive.consumer;

/**
 * 表示一个接收两个 byte 参数的消费器。
 * 这是 BiConsumer 接口针对 byte 类型的原始类型特化版本。
 *
 * <p>这是一个函数式接口，其函数式方法为 accept(byte, byte)。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface ByteTwiceConsumer {
    /**
     * 在给定参数上执行消费操作。
     *
     * @param input 输入参数
     * @param value 另一个输入参数
     */
    void accept(byte input, byte value);
}