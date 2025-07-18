package com.github.zhitron.lambda.primitive.predicate;

/**
 * 表示一个接收两个 float 参数的谓词（布尔值函数）。
 * 这是 BiPredicate 接口针对 float 类型的原始类型特化版本。
 *
 * <p>这是一个函数式接口，其函数式方法为 test(float, float)。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface FloatTwicePredicate {
    /**
     * 在给定参数上评估此谓词。
     *
     * @param input 输入参数
     * @param value 另一个输入参数
     * @return 如果输入参数符合谓词条件则返回 true，否则返回 false
     */
    boolean test(float input, float value);
}