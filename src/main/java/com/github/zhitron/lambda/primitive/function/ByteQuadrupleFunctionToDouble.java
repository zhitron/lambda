package com.github.zhitron.lambda.primitive.function;

/**
 * 表示一个接收四个 byte 参数并生成结果的函数。
 * 这是 QuadFunction 接口针对 byte 类型的原始类型特化版本。
 *
 * <p>这是一个函数式接口，其函数式方法为 apply(byte, byte, byte, byte)。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface ByteQuadrupleFunctionToDouble {
    /**
     * 在给定参数上生成结果。
     *
     * @param input   输入参数
     * @param value   另一个输入参数
     * @param other   第三个输入参数
     * @param another 第四个输入参数
     * @return 返回一个结果
     */
    char apply(byte input, byte value, byte other, byte another);
}