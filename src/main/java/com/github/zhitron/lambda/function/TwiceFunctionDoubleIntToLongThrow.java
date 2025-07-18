package com.github.zhitron.lambda.function;

/**
 * 这是一个通用的 lambda 函数类，输入 2 个参的操作，并返回一个结果。支持抛出异常。
 * 该接口扩展自 {@link TwiceFunctionDoubleIntToLong}，增加了异常处理能力。
 *
 * @param <E> 异常类型，必须是 {@link Exception} 的子类
 * @author zhitron
 */
@FunctionalInterface
public interface TwiceFunctionDoubleIntToLongThrow<E extends Exception> extends TwiceFunctionDoubleIntToLong {

    /**
     * 对给定的 2 个参数进行操作，并返回一个结果。
     *
     * @param v1 类型为 double 的第 1 个参数。
     * @param v2 类型为 int 的第 2 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     * @throws E 抛出执行过程中的异常
     */
    long applyThrow(double v1, int v2) throws E;

    /**
     * 默认方法实现，用于应用某些操作或逻辑
     * 该方法旨在封装对 {@link #applyThrow} 方法的调用，并处理可能抛出的异常
     *
     * @param v1 类型为 double 的第 1 个参数。
     * @param v2 类型为 int 的第 2 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     */
    @Override
    default long apply(double v1, int v2) {
        try {
            return this.applyThrow(v1, v2);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'applyThrow'", e);
        }
    }
}
