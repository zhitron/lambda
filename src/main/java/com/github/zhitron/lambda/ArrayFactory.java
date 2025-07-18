package com.github.zhitron.lambda;

/**
 * ArrayFactory 是一个函数式接口，用于根据指定长度创建数组。
 *
 * @param <A> 数组的类型
 * @author zhitron
 */
@SuppressWarnings("unchecked")
@FunctionalInterface
public interface ArrayFactory<A> {

    /**
     * 一个不支持操作的默认实现，当调用 apply 方法时会抛出 UnsupportedOperationException。
     */
    ArrayFactory<?> NOT_SUPPORT = length -> {
        throw new UnsupportedOperationException();
    };

    /**
     * 返回一个不支持操作的 ArrayFactory 实例，该实例在调用 apply 方法时会抛出 UnsupportedOperationException。
     *
     * @param <A> 数组的类型
     * @return 一个不支持操作的 ArrayFactory 实例
     */
    static <A> ArrayFactory<A> notSupport() {
        return (ArrayFactory<A>) NOT_SUPPORT;
    }

    /**
     * 根据给定的长度创建数组。
     *
     * @param length 数组的长度
     * @return 创建的数组
     */
    A apply(int length);
}
