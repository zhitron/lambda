package com.github.zhitron.lambda.primitive.function;

/**
 * 表示一个接收两个 long 参数并生成结果的函数。
 * 这是 BiFunction 接口针对 long 类型的原始类型特化版本。
 *
 * <p>这是一个函数式接口，其函数式方法为 apply(long, long)。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface LongTwiceFunctionToDouble {
    /**
     * 在给定参数上生成结果。
     *
     * @param input 输入参数
     * @param value 另一个输入参数
     * @return 返回一个结果
     */
    char apply(long input, long value);
}