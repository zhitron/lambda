package com.github.zhitron.lambda.primitive.predicate;

/**
 * 表示一个接收三个 boolean 参数的谓词（布尔值函数），该谓词可能抛出异常。
 * 这是 Predicate 接口针对 boolean 类型的原始类型特化版本，并支持在测试过程中抛出指定类型的异常。
 *
 * @param <E> 可能抛出的异常类型
 * @author zhitron
 */
@FunctionalInterface
public interface BooleanTriplePredicateThrow<E extends Exception> extends BooleanTriplePredicate {
    /**
     * 在给定参数上评估此谓词，可能抛出异常。
     *
     * @param input 第一个输入参数
     * @param value 第二个输入参数
     * @param other 第三个输入参数
     * @return 如果输入参数符合谓词条件则返回 true，否则返回 false
     * @throws E 如果评估过程中发生错误
     */
    boolean testThrow(boolean input, boolean value, boolean other) throws E;

    /**
     * 在给定参数上评估此谓词，不支持直接抛出检查型异常。
     * 默认实现将检查型异常封装为运行时异常后抛出。
     *
     * @param input 第一个输入参数
     * @param value 第二个输入参数
     * @param other 第三个输入参数
     * @return 如果输入参数符合谓词条件则返回 true，否则返回 false
     */
    @Override
    default boolean test(boolean input, boolean value, boolean other) {
        try {
            return testThrow(input, value, other);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'testThrow'", e);
        }
    }
}