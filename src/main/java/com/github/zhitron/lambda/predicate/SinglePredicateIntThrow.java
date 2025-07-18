package com.github.zhitron.lambda.predicate;

/**
 * 这是一个通用的 lambda 函数类，输入 1 个参的操作，并返回一个布尔值。支持抛出异常。
 * 该接口扩展自 {@link SinglePredicateInt}，增加了异常处理能力。
 *
 * @param <E> 异常类型，必须是 {@link Exception} 的子类
 * @author zhitron
 */
@FunctionalInterface
public interface SinglePredicateIntThrow<E extends Exception> extends SinglePredicateInt {

    /**
     * 对给定的 1 个参数进行操作，并返回一个布尔值。
     *
     * @param v1 类型为 int 的第 1 个参数。
     * @return 该方法返回一个布尔值，表示操作是否成功。
     * @throws E 抛出执行过程中的异常
     */
    boolean testThrow(int v1) throws E;

    /**
     * 默认方法实现，用于应用某些操作或逻辑
     * 该方法旨在封装对 {@link #testThrow} 方法的调用，并处理可能抛出的异常
     *
     * @param v1 类型为 int 的第 1 个参数。
     * @return 该方法返回一个布尔值，表示操作是否成功。
     */
    @Override
    default boolean test(int v1) {
        try {
            return this.testThrow(v1);
        } catch (Exception e) {
            throw new RuntimeException("Exception for 'testThrow'", e);
        }
    }
}
