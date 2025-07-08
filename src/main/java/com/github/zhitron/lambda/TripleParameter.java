package com.github.zhitron.lambda;

/**
 * TripleParameter 是一个函数式接口，用于表示接受三个参数的函数。
 *
 * @author zhitron
 */
public interface TripleParameter {

    /**
     * 接收三个参数并返回一个泛型结果的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <R> 返回值类型
     */
    @FunctionalInterface
    interface ToAny<T, U, V, R> {
        /**
         * 应用操作，接受三个参数并返回一个结果。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return 操作结果
         */
        R apply(T t, U u, V v);
    }

    /**
     * 接收三个参数且无返回值的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     */
    @FunctionalInterface
    interface ToVoid<T, U, V> {
        /**
         * 应用操作，接受三个参数且不返回任何结果。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         */
        void apply(T t, U u, V v);
    }

    /**
     * 接收三个参数并返回 boolean 类型结果的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     */
    @FunctionalInterface
    interface ToBoolean<T, U, V> {
        /**
         * 应用操作，接受三个参数并返回 boolean 结果。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return boolean 类型结果
         */
        boolean apply(T t, U u, V v);
    }

    /**
     * 接收三个参数并返回 char 类型结果的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     */
    @FunctionalInterface
    interface ToChar<T, U, V> {
        /**
         * 应用操作，接受三个参数并返回 char 结果。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return char 类型结果
         */
        char apply(T t, U u, V v);
    }

    /**
     * 接收三个参数并返回 byte 类型结果的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     */
    @FunctionalInterface
    interface ToByte<T, U, V> {
        /**
         * 应用操作，接受三个参数并返回 byte 结果。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return byte 类型结果
         */
        byte apply(T t, U u, V v);
    }

    /**
     * 接收三个参数并返回 short 类型结果的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     */
    @FunctionalInterface
    interface ToShort<T, U, V> {
        /**
         * 应用操作，接受三个参数并返回 short 结果。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return short 类型结果
         */
        short apply(T t, U u, V v);
    }

    /**
     * 接收三个参数并返回 int 类型结果的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     */
    @FunctionalInterface
    interface ToInt<T, U, V> {
        /**
         * 应用操作，接受三个参数并返回 int 结果。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return int 类型结果
         */
        int apply(T t, U u, V v);
    }

    /**
     * 接收三个参数并返回 long 类型结果的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     */
    @FunctionalInterface
    interface ToLong<T, U, V> {
        /**
         * 应用操作，接受三个参数并返回 long 结果。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return long 类型结果
         */
        long apply(T t, U u, V v);
    }

    /**
     * 接收三个参数并返回 float 类型结果的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     */
    @FunctionalInterface
    interface ToFloat<T, U, V> {
        /**
         * 应用操作，接受三个参数并返回 float 结果。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return float 类型结果
         */
        float apply(T t, U u, V v);
    }

    /**
     * 接收三个参数并返回 double 类型结果的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     */
    @FunctionalInterface
    interface ToDouble<T, U, V> {
        /**
         * 应用操作，接受三个参数并返回 double 结果。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return double 类型结果
         */
        double apply(T t, U u, V v);
    }
}
