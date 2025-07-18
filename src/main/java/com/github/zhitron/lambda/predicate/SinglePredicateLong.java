package com.github.zhitron.lambda.predicate;

/**
 * 这是一个通用的 lambda 函数类，输入 1 个参的操作，并返回一个布尔值。
 *
 * @author zhitron
 */
@FunctionalInterface
public interface SinglePredicateLong {

    /**
     * 对给定的 1 个参数进行操作，并返回一个布尔值。
     *
     * @param v1 类型为 long 的第 1 个参数。
     * @return 该方法返回一个布尔值，表示操作是否成功。
     */
    boolean test(long v1);
}
