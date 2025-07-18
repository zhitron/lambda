package com.github.zhitron.lambda.primitive.function;

/**
 * 表示一个接收单个 char 参数并生成结果的函数。
 * 这是 Function 接口针对 char 类型的原始类型特化版本。
 *
 * <p>这是一个函数式接口，其函数式方法为 apply(char)。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface CharSingleFunctionToByte {
    /**
     * 在给定参数上生成结果。
     *
     * @param input 输入参数
     * @return 返回一个结果
     */
    char apply(char input);
}