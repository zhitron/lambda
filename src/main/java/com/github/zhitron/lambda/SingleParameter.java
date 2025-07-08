package com.github.zhitron.lambda;

/**
 * TwiceParameter 是一个函数式接口，用于表示接受一个参数的函数。
 *
 * @author zhitron
 */
public interface SingleParameter {

    /**
     * 通用的函数式接口，表示接受一个泛型参数并返回一个结果。
     *
     * @param <T> 输入参数类型
     * @param <R> 返回值类型
     */
    @FunctionalInterface
    interface ToAny<T, R> {
        /**
         * 对给定的输入执行操作并返回结果。
         *
         * @param t 输入参数
         * @return 操作结果
         */
        R apply(T t);
    }

    /**
     * 函数式接口，表示接受一个泛型参数且不返回结果。
     *
     * @param <T> 输入参数类型
     */
    @FunctionalInterface
    interface ToVoid<T> {
        /**
         * 对给定的输入执行操作，无返回值。
         *
         * @param t 输入参数
         */
        void apply(T t);
    }

    /**
     * 函数式接口，表示接受一个泛型参数并返回布尔值。
     *
     * @param <T> 输入参数类型
     */
    @FunctionalInterface
    interface ToBoolean<T> {
        /**
         * 对给定的输入执行判断操作并返回布尔值。
         *
         * @param t 输入参数
         * @return 布尔值结果
         */
        boolean apply(T t);
    }

    /**
     * 函数式接口，表示接受一个泛型参数并返回字符值。
     *
     * @param <T> 输入参数类型
     */
    @FunctionalInterface
    interface ToChar<T> {
        /**
         * 对给定的输入执行操作并返回字符值。
         *
         * @param t 输入参数
         * @return 字符值结果
         */
        char apply(T t);
    }

    /**
     * 函数式接口，表示接受一个泛型参数并返回字节值。
     *
     * @param <T> 输入参数类型
     */
    @FunctionalInterface
    interface ToByte<T> {
        /**
         * 对给定的输入执行操作并返回字节值。
         *
         * @param t 输入参数
         * @return 字节值结果
         */
        byte apply(T t);
    }

    /**
     * 函数式接口，表示接受一个泛型参数并返回短整型值。
     *
     * @param <T> 输入参数类型
     */
    @FunctionalInterface
    interface ToShort<T> {
        /**
         * 对给定的输入执行操作并返回短整型值。
         *
         * @param t 输入参数
         * @return 短整型值结果
         */
        short apply(T t);
    }

    /**
     * 函数式接口，表示接受一个泛型参数并返回整型值。
     *
     * @param <T> 输入参数类型
     */
    @FunctionalInterface
    interface ToInt<T> {
        /**
         * 对给定的输入执行操作并返回整型值。
         *
         * @param t 输入参数
         * @return 整型值结果
         */
        int apply(T t);
    }

    /**
     * 函数式接口，表示接受一个泛型参数并返回长整型值。
     *
     * @param <T> 输入参数类型
     */
    @FunctionalInterface
    interface ToLong<T> {
        /**
         * 对给定的输入执行操作并返回长整型值。
         *
         * @param t 输入参数
         * @return 长整型值结果
         */
        long apply(T t);
    }

    /**
     * 函数式接口，表示接受一个泛型参数并返回浮点型值。
     *
     * @param <T> 输入参数类型
     */
    @FunctionalInterface
    interface ToFloat<T> {
        /**
         * 对给定的输入执行操作并返回浮点型值。
         *
         * @param t 输入参数
         * @return 浮点型值结果
         */
        float apply(T t);
    }

    /**
     * 函数式接口，表示接受一个泛型参数并返回双精度浮点型值。
     *
     * @param <T> 输入参数类型
     */
    @FunctionalInterface
    interface ToDouble<T> {
        /**
         * 对给定的输入执行操作并返回双精度浮点型值。
         *
         * @param t 输入参数
         * @return 双精度浮点型值结果
         */
        double apply(T t);
    }
}
