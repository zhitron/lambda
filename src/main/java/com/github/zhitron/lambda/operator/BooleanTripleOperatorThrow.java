package com.github.zhitron.lambda.operator;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数接口，用于对 3 个 boolean 类型参数进行操作。。支持抛出异常。
 * 该接口扩展自 {@link BooleanTripleOperator}，增加了异常处理能力。
 *
 * @param <E> 异常类型，必须是 {@link Exception} 的子类
 * @author zhitron
 */
@FunctionalInterface
public interface BooleanTripleOperatorThrow<E extends Exception> extends BooleanTripleOperator {

    /**
     * 默认返回 true 的 BooleanTripleOperatorThrow 实例。
     */
    BooleanTripleOperatorThrow<?> DEFAULT_TRUE = (v1, v2, v3) -> BasicConstant.BOOLEAN_TRUE;

    /**
     * 默认返回 false 的 BooleanTripleOperatorThrow 实例。
     */
    BooleanTripleOperatorThrow<?> DEFAULT_FALSE = (v1, v2, v3) -> BasicConstant.BOOLEAN_FALSE;

    /**
     * 根据给定的布尔值返回对应的默认 BooleanTripleOperatorThrow 实例。
     *
     * @param value 给定的布尔值。
     * @return 如果 value 为 true，返回 DEFAULT_TRUE；否则返回 DEFAULT_FALSE。
     */
    @SuppressWarnings("unchecked")
    static <E extends Exception> BooleanTripleOperatorThrow<E> constant(boolean value) {
        return (BooleanTripleOperatorThrow<E>) (value ? DEFAULT_TRUE : DEFAULT_FALSE);
    }

    /**
     * 对给定的 3 个 BOOLEAN 参数执行某种操作并返回结果。
     *
     * @param v1 类型为 boolean 的第 1 个参数。
     * @param v2 类型为 boolean 的第 2 个参数。
     * @param v3 类型为 boolean 的第 3 个参数。
     * @return 操作后的 boolean 结果。
     * @throws E 抛出执行过程中的异常
     */
    boolean applyThrow(boolean v1, boolean v2, boolean v3) throws E;

    /**
     * 默认方法实现，用于应用某些操作或逻辑
     * 该方法旨在封装对 {@link #applyThrow} 方法的调用，并处理可能抛出的异常
     *
     * @param v1 类型为 boolean 的第 1 个参数。
     * @param v2 类型为 boolean 的第 2 个参数。
     * @param v3 类型为 boolean 的第 3 个参数。
     * @return 操作后的 boolean 结果。
     */
    @Override
    default boolean apply(boolean v1, boolean v2, boolean v3) {
        try {
            return this.applyThrow(v1, v2, v3);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'applyThrow'", e);
        }
    }
}
