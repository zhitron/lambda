package com.github.zhitron.lambda.predicate;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数类，输入 3 个参数的操作，并返回一个布尔值。支持抛出异常。
 * 该接口扩展自 {@link TriplePredicateLong}，增加了异常处理能力。
 *
 * @param <E> 异常类型，必须是 {@link Exception} 的子类
 * @author zhitron
 */
@FunctionalInterface
public interface TriplePredicateLongThrow<E extends Exception> extends TriplePredicateLong {

    /**
     * 默认返回 true 的 TriplePredicateLongThrow 实例。
     */
    TriplePredicateLongThrow<?> DEFAULT_TRUE = (v1, v2, v3) -> BasicConstant.BOOLEAN_TRUE;

    /**
     * 默认返回 false 的 TriplePredicateLongThrow 实例。
     */
    TriplePredicateLongThrow<?> DEFAULT_FALSE = (v1, v2, v3) -> BasicConstant.BOOLEAN_FALSE;

    /**
     * 根据给定的布尔值返回对应的默认 TriplePredicateLongThrow 实例。
     *
     * @param value 给定的布尔值。
     * @return 如果 value 为 true，返回 DEFAULT_TRUE；否则返回 DEFAULT_FALSE。
     */
    @SuppressWarnings("unchecked")
    static <E extends Exception> TriplePredicateLongThrow<E> constant(boolean value) {
        return (TriplePredicateLongThrow<E>) (value ? DEFAULT_TRUE : DEFAULT_FALSE);
    }

    /**
     * 对给定的 3 个参数进行操作，并返回一个布尔值。
     *
     * @param v1 类型为 long 的第 1 个参数。
     * @param v2 类型为 long 的第 2 个参数。
     * @param v3 类型为 long 的第 3 个参数。
     * @return 该方法返回一个布尔值，表示操作是否成功。
     * @throws E 抛出执行过程中的异常
     */
    boolean testThrow(long v1, long v2, long v3) throws E;

    /**
     * 默认方法实现，用于应用某些操作或逻辑
     * 该方法旨在封装对 {@link #testThrow} 方法的调用，并处理可能抛出的异常
     *
     * @param v1 类型为 long 的第 1 个参数。
     * @param v2 类型为 long 的第 2 个参数。
     * @param v3 类型为 long 的第 3 个参数。
     * @return 该方法返回一个布尔值，表示操作是否成功。
     */
    @Override
    default boolean test(long v1, long v2, long v3) {
        try {
            return this.testThrow(v1, v2, v3);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'testThrow'", e);
        }
    }
}
