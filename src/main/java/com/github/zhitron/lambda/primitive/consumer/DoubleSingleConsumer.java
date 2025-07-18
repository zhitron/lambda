package com.github.zhitron.lambda.primitive.consumer;

/**
 * 表示一个接收单个 double 参数的消费器。
 * 这是 Consumer 接口针对 double 类型的原始类型特化版本。
 *
 * <p>这是一个函数式接口，其函数式方法为 accept(double)。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface DoubleSingleConsumer {
    /**
     * 在给定参数上执行消费操作。
     *
     * @param input 输入参数
     */
    void accept(double input);
}