package com.github.zhitron.lambda.function;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数类，输入 4 个参数的操作，并返回一个结果。支持抛出异常。
 * 该接口扩展自 {@link QuadrupleFunctionObjectBooleanLongIntToLong}，增加了异常处理能力。
 *
 * @param <T> 第 1 个参数类型。
 * @param <E> 异常类型，必须是 {@link Exception} 的子类
 * @author zhitron
 */
@FunctionalInterface
public interface QuadrupleFunctionObjectBooleanLongIntToLongThrow<T, E extends Exception> extends QuadrupleFunctionObjectBooleanLongIntToLong<T> {

    /**
     * 一个空实现的实例，它总是返回 BasicConstant.LONG_ZERO 值。
     */
    QuadrupleFunctionObjectBooleanLongIntToLongThrow<?, ?> EMPTY = (v1, v2, v3, v4) -> BasicConstant.LONG_ZERO;

    /**
     * 返回一个空实现的实例，它总是返回 {@link BasicConstant#LONG_ZERO} 值。
     *
     * @return 获取一个空的函数式接口实例。
     */
    @SuppressWarnings("unchecked")
    static <T, E extends Exception> QuadrupleFunctionObjectBooleanLongIntToLongThrow<T, E> empty() {
        return (QuadrupleFunctionObjectBooleanLongIntToLongThrow<T, E>) EMPTY;
    }

    /**
     * 创建一个始终返回指定常量值的函数式接口。
     *
     * @param value 常量值。
     * @return 返回指定常量值的函数式接口。
     */
    static <T, E extends Exception> QuadrupleFunctionObjectBooleanLongIntToLongThrow<T, E> constant(long value) {
        return (v1, v2, v3, v4) -> value;
    }

    /**
     * 对给定的 4 个参数进行操作，并返回一个结果。
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 boolean 的第 2 个参数。
     * @param v3 类型为 long 的第 3 个参数。
     * @param v4 类型为 int 的第 4 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     * @throws E 抛出执行过程中的异常
     */
    long applyThrow(T v1, boolean v2, long v3, int v4) throws E;

    /**
     * 默认方法实现，用于应用某些操作或逻辑
     * 该方法旨在封装对 {@link #applyThrow} 方法的调用，并处理可能抛出的异常
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 boolean 的第 2 个参数。
     * @param v3 类型为 long 的第 3 个参数。
     * @param v4 类型为 int 的第 4 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     */
    @Override
    default long apply(T v1, boolean v2, long v3, int v4) {
        try {
            return this.applyThrow(v1, v2, v3, v4);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'applyThrow'", e);
        }
    }
}
