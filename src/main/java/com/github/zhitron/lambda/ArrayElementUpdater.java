package com.github.zhitron.lambda;

/**
 * 该接口定义了一个函数式接口，用于更新泛型数组中指定索引位置的元素值。
 *
 * @param <A> 数组的类型
 * @param <E> 要更新的元素类型
 * @author zhitron
 */
@FunctionalInterface
public interface ArrayElementUpdater<A, E> {

    /**
     * 更新数组中指定索引位置的元素值。
     *
     * @param array 数组对象
     * @param index 要更新的索引位置
     * @param value 要设置的新值
     */
    void apply(A array, int index, E value);
}
