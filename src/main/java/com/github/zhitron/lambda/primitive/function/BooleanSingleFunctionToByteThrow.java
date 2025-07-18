package com.github.zhitron.lambda.primitive.function;

/**
 * 表示一个接收单个 boolean 参数并生成结果的函数，该谓词可能抛出异常。
 * 这是 Function 接口针对 boolean 类型的原始类型特化版本，并支持在测试过程中抛出指定类型的异常。
 *
 * @param <E> 可能抛出的异常类型
 * @author zhitron
 */
@FunctionalInterface
public interface BooleanSingleFunctionToByteThrow<E extends Exception> extends BooleanSingleFunctionToByte {
    /**
     * 在给定参数上生成结果，可能抛出异常。
     *
     * @param input 输入参数
     * @return 返回一个结果
     * @throws E 如果评估过程中发生错误
     */
    char applyThrow(boolean input) throws E;

    /**
     * 在给定参数上生成结果，不支持直接抛出检查型异常。
     * 默认实现将检查型异常封装为运行时异常后抛出。
     *
     * @param input 输入参数
     * @return 返回一个结果
     */
    @Override
    default char apply(boolean input) {
        try {
            return applyThrow(input);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'applyThrow'", e);
        }
    }
}
