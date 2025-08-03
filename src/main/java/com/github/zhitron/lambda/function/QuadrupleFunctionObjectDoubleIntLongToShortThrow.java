package com.github.zhitron.lambda.function;

import com.github.zhitron.BasicConstant;

/**
 * 这是一个通用的 lambda 函数类，输入 4 个参数的操作，并返回一个结果。支持抛出异常。
 * 该接口扩展自 {@link QuadrupleFunctionObjectDoubleIntLongToShort}，增加了异常处理能力。
 *
 * @param <T> 第 1 个参数类型。
 * @param <E> 异常类型，必须是 {@link Exception} 的子类
 * @author zhitron
 */
@FunctionalInterface
public interface QuadrupleFunctionObjectDoubleIntLongToShortThrow<T, E extends Exception> extends QuadrupleFunctionObjectDoubleIntLongToShort<T> {

    /**
     * 一个空实现的实例，它总是返回 BasicConstant.SHORT_ZERO 值。
     */
    QuadrupleFunctionObjectDoubleIntLongToShortThrow<?, ?> EMPTY = (v1, v2, v3, v4) -> BasicConstant.SHORT_ZERO;

    /**
     * 返回一个空实现的实例，它总是返回 {@link BasicConstant#SHORT_ZERO} 值。
     *
     * @return 获取一个空的函数式接口实例。
     */
    @SuppressWarnings("unchecked")
    static <T, E extends Exception> QuadrupleFunctionObjectDoubleIntLongToShortThrow<T, E> empty() {
        return (QuadrupleFunctionObjectDoubleIntLongToShortThrow<T, E>) EMPTY;
    }

    /**
     * 创建一个始终返回指定常量值的函数式接口。
     *
     * @param value 常量值。
     * @return 返回指定常量值的函数式接口。
     */
    static <T, E extends Exception> QuadrupleFunctionObjectDoubleIntLongToShortThrow<T, E> constant(short value) {
        return (v1, v2, v3, v4) -> value;
    }

    /**
     * 对给定的 4 个参数进行操作，并返回一个结果。
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 double 的第 2 个参数。
     * @param v3 类型为 int 的第 3 个参数。
     * @param v4 类型为 long 的第 4 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     * @throws E 抛出执行过程中的异常
     */
    short applyThrow(T v1, double v2, int v3, long v4) throws E;

    /**
     * 默认方法实现，用于应用某些操作或逻辑
     * 该方法旨在封装对 {@link #applyThrow} 方法的调用，并处理可能抛出的异常
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 double 的第 2 个参数。
     * @param v3 类型为 int 的第 3 个参数。
     * @param v4 类型为 long 的第 4 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     */
    @Override
    default short apply(T v1, double v2, int v3, long v4) {
        try {
            return this.applyThrow(v1, v2, v3, v4);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'applyThrow'", e);
        }
    }
}
