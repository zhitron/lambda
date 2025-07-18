package com.github.zhitron.lambda.primitive.function;

/**
 * 表示一个接收两个 double 参数并生成结果的函数。
 * 这是 BiFunction 接口针对 double 类型的原始类型特化版本。
 *
 * <p>这是一个函数式接口，其函数式方法为 apply(double, double)。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface DoubleTwiceFunctionToShort {
    /**
     * 在给定参数上生成结果。
     *
     * @param input 输入参数
     * @param value 另一个输入参数
     * @return 返回一个结果
     */
    char apply(double input, double value);
}