package com.github.zhitron.lambda.primitive.consumer;

/**
 * 表示一个接收三个 float 参数的消费器。
 * 这是 TriConsumer 接口针对 float 类型的原始类型特化版本。
 *
 * <p>这是一个函数式接口，其函数式方法为 accept(float, float, float)。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface FloatTripleConsumer {
    /**
     * 在给定参数上执行消费操作。
     *
     * @param input 输入参数
     * @param value 另一个输入参数
     * @param other 第三个输入参数
     */
    void accept(float input, float value, float other);
}