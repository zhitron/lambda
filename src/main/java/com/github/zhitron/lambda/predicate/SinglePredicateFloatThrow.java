package com.github.zhitron.lambda.predicate;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数类，输入 1 个参数的操作，并返回一个布尔值。支持抛出异常。
 * 该接口扩展自 {@link SinglePredicateFloat}，增加了异常处理能力。
 *
 * @param <E> 异常类型，必须是 {@link Exception} 的子类
 * @author zhitron
 */
@FunctionalInterface
public interface SinglePredicateFloatThrow<E extends Exception> extends SinglePredicateFloat {

    /**
     * 默认返回 true 的 SinglePredicateFloatThrow 实例。
     */
    SinglePredicateFloatThrow<?> DEFAULT_TRUE = (v1) -> BasicConstant.BOOLEAN_TRUE;

    /**
     * 默认返回 false 的 SinglePredicateFloatThrow 实例。
     */
    SinglePredicateFloatThrow<?> DEFAULT_FALSE = (v1) -> BasicConstant.BOOLEAN_FALSE;

    /**
     * 根据给定的布尔值返回对应的默认 SinglePredicateFloatThrow 实例。
     *
     * @param value 给定的布尔值。
     * @return 如果 value 为 true，返回 DEFAULT_TRUE；否则返回 DEFAULT_FALSE。
     */
    @SuppressWarnings("unchecked")
    static <E extends Exception> SinglePredicateFloatThrow<E> constant(boolean value) {
        return (SinglePredicateFloatThrow<E>) (value ? DEFAULT_TRUE : DEFAULT_FALSE);
    }

    /**
     * 对给定的 1 个参数进行操作，并返回一个布尔值。
     *
     * @param v1 类型为 float 的第 1 个参数。
     * @return 该方法返回一个布尔值，表示操作是否成功。
     * @throws E 抛出执行过程中的异常
     */
    boolean testThrow(float v1) throws E;

    /**
     * 默认方法实现，用于应用某些操作或逻辑
     * 该方法旨在封装对 {@link #testThrow} 方法的调用，并处理可能抛出的异常
     *
     * @param v1 类型为 float 的第 1 个参数。
     * @return 该方法返回一个布尔值，表示操作是否成功。
     */
    @Override
    default boolean test(float v1) {
        try {
            return this.testThrow(v1);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'testThrow'", e);
        }
    }
}
