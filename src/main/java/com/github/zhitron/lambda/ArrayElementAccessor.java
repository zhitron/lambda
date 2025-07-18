package com.github.zhitron.lambda;

/**
 * 接口用于访问数组或类似结构中的元素
 *
 * @param <A> 数组类型
 * @param <E> 元素类型
 * @author zhitron
 */
@FunctionalInterface
public interface ArrayElementAccessor<A, E> {

    /**
     * 访问数组中的特定索引元素
     *
     * @param array 数组对象
     * @param index 索引位置
     * @return 返回索引位置的元素
     */
    E apply(A array, int index);
}
