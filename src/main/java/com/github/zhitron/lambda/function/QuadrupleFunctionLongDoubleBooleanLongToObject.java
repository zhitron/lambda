package com.github.zhitron.lambda.function;

/**
 * 这是一个通用的 lambda 函数类，输入 4 个参的操作，并返回一个结果。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface QuadrupleFunctionLongDoubleBooleanLongToObject<R> {

    /**
     * 对给定的 4 个参数进行操作，并返回一个结果。
     *
     * @param v1 类型为 long 的第 1 个参数。
     * @param v2 类型为 double 的第 2 个参数。
     * @param v3 类型为 boolean 的第 3 个参数。
     * @param v4 类型为 long 的第 4 个参数。
     * @return 该方法返回一个结果，表示操作的结果。
     */
    R apply(long v1, double v2, boolean v3, long v4);
}
