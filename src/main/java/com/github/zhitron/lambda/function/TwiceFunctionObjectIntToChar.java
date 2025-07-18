package com.github.zhitron.lambda.function;

/**
 * 这是一个通用的 lambda 函数类，输入 2 个参的操作，并返回一个结果。
 *
 * @param <T> 第 1 个参数类型。
 * @author zhitron
 */
@FunctionalInterface
public interface TwiceFunctionObjectIntToChar<T> {

    /**
     * 对给定的 2 个参数进行操作，并返回一个结果。
     *
     * @param v1 类型为 T 的第 1 个参数。
     * @param v2 类型为 int 的第 2 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     */
    char apply(T v1, int v2);
}
