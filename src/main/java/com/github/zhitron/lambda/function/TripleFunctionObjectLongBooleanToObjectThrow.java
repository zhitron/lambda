package com.github.zhitron.lambda.function;

/**
 * 这是一个通用的 lambda 函数类，输入 3 个参的操作，并返回一个结果。支持抛出异常。
 * 该接口扩展自 {@link TripleFunctionObjectLongBooleanToObject}，增加了异常处理能力。
 *
 * @param <T> 第 1 个参数类型。
 * @param <E> 异常类型，必须是 {@link Exception} 的子类
 * @author zhitron
 */
@FunctionalInterface
public interface TripleFunctionObjectLongBooleanToObjectThrow<T, R, E extends Exception> extends TripleFunctionObjectLongBooleanToObject<T, R> {

    /**
     * 对给定的 3 个参数进行操作，并返回一个结果。
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 long 的第 2 个参数。
     * @param v3 类型为 boolean 的第 3 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     * @throws E 抛出执行过程中的异常
     */
    R applyThrow(T v1, long v2, boolean v3) throws E;

    /**
     * 默认方法实现，用于应用某些操作或逻辑
     * 该方法旨在封装对 {@link #applyThrow} 方法的调用，并处理可能抛出的异常
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 long 的第 2 个参数。
     * @param v3 类型为 boolean 的第 3 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     */
    @Override
    default R apply(T v1, long v2, boolean v3) {
        try {
            return this.applyThrow(v1, v2, v3);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'applyThrow'", e);
        }
    }
}
