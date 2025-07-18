package com.github.zhitron.lambda;

/**
 * 函数式接口，用于提供数组或类似结构的大小。
 *
 * @param <A> 数组或可获取长度的对象类型
 * @author zhitron
 */
@FunctionalInterface
public interface ArraySizeProvider<A> {

    /**
     * 返回给定数组或结构的大小。
     *
     * @param array 输入对象
     * @return 大小
     */
    int apply(A array);
}
