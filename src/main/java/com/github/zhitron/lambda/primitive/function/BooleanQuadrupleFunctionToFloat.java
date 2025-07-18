package com.github.zhitron.lambda.primitive.function;

/**
 * 表示一个接收四个 boolean 参数并生成结果的函数。
 * 这是 QuadFunction 接口针对 boolean 类型的原始类型特化版本。
 *
 * <p>这是一个函数式接口，其函数式方法为 apply(boolean, boolean, boolean, boolean)。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface BooleanQuadrupleFunctionToFloat {
    /**
     * 在给定参数上生成结果。
     *
     * @param input   输入参数
     * @param value   另一个输入参数
     * @param other   第三个输入参数
     * @param another 第四个输入参数
     * @return 返回一个结果
     */
    char apply(boolean input, boolean value, boolean other, boolean another);
}