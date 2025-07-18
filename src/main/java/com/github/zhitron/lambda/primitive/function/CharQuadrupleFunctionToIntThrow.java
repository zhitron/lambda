package com.github.zhitron.lambda.primitive.function;

/**
 * 表示一个接收四个 char 参数并生成结果的函数，该谓词可能抛出异常。
 * 这是 Function 接口针对 char 类型的原始类型特化版本，并支持在测试过程中抛出指定类型的异常。
 *
 * @param <E> 可能抛出的异常类型
 * @author zhitron
 */
@FunctionalInterface
public interface CharQuadrupleFunctionToIntThrow<E extends Exception> extends CharQuadrupleFunctionToInt {
    /**
     * 在给定参数上生成结果，可能抛出异常。
     *
     * @param input   第一个输入参数
     * @param value   第二个输入参数
     * @param other   第三个输入参数
     * @param another 第四个输入参数
     * @return 返回一个结果
     * @throws E 如果评估过程中发生错误
     */
    char applyThrow(char input, char value, char other, char another) throws E;

    /**
     * 在给定参数上生成结果，不支持直接抛出检查型异常。
     * 默认实现将检查型异常封装为运行时异常后抛出。
     *
     * @param input   第一个输入参数
     * @param value   第二个输入参数
     * @param other   第三个输入参数
     * @param another 第四个输入参数
     * @return 返回一个结果
     */
    @Override
    default char apply(char input, char value, char other, char another) {
        try {
            return applyThrow(input, value, other, another);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'applyThrow'", e);
        }
    }
}