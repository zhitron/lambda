package com.github.zhitron.lambda.primitive.predicate;

/**
 * 表示一个接收四个 long 参数的谓词（布尔值函数）。
 * 这是 QuadPredicate 接口针对 long 类型的原始类型特化版本。
 *
 * <p>这是一个函数式接口，其函数式方法为 test(long, long, long, long)。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface LongQuadruplePredicate {
    /**
     * 在给定参数上评估此谓词。
     *
     * @param input   输入参数
     * @param value   另一个输入参数
     * @param other   第三个输入参数
     * @param another 第四个输入参数
     * @return 如果输入参数符合谓词条件则返回 true，否则返回 false
     */
    boolean test(long input, long value, long other, long another);
}