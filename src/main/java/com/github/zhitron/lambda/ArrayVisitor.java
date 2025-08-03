package com.github.zhitron.lambda;

/**
 * 接口用于访问数组或类似结构中的元素
 *
 * @param <A> 数组类型
 * @param <E> 元素类型
 * @author zhitron
 */
@FunctionalInterface
public interface ArrayVisitor<A, E> {

    /**
     * 访问数组中的特定索引元素
     *
     * @param array   数组对象
     * @param element 数组元素
     * @param index   索引位置
     * @param length  数组长度
     */
    void visit(A array, E element, int index, int length);
}