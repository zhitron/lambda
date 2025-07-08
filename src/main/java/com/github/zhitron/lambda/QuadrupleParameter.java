package com.github.zhitron.lambda;

/**
 * TwiceParameter 是一个函数式接口，用于表示接受四个参数的函数。
 *
 * @author zhitron
 */
public interface QuadrupleParameter {

    /**
     * 接受四个任意类型参数并返回一个结果的函数式接口
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     * @param <R> 返回值类型
     */
    @FunctionalInterface
    interface ToAny<T, U, V, W, R> {
        /**
         * 执行操作并返回结果
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return 操作结果
         */
        R apply(T t, U u, V v, W w);
    }

    /**
     * 接受四个任意类型参数且无返回值的函数式接口
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     */
    @FunctionalInterface
    interface ToVoid<T, U, V, W> {
        /**
         * 执行操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         */
        void apply(T t, U u, V v, W w);
    }

    /**
     * 接受四个任意类型参数并返回布尔值的函数式接口
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     */
    @FunctionalInterface
    interface ToBoolean<T, U, V, W> {
        /**
         * 执行判断操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return 判断结果
         */
        boolean apply(T t, U u, V v, W w);
    }

    /**
     * 接受四个任意类型参数并返回char值的函数式接口
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     */
    @FunctionalInterface
    interface ToChar<T, U, V, W> {
        /**
         * 执行操作并返回char结果
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return char 类型结果
         */
        char apply(T t, U u, V v, W w);
    }

    /**
     * 接受四个任意类型参数并返回byte值的函数式接口
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     */
    @FunctionalInterface
    interface ToByte<T, U, V, W> {
        /**
         * 执行操作并返回byte结果
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return byte 类型结果
         */
        byte apply(T t, U u, V v, W w);
    }

    /**
     * 接受四个任意类型参数并返回short值的函数式接口
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     */
    @FunctionalInterface
    interface ToShort<T, U, V, W> {
        /**
         * 执行操作并返回short结果
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return short 类型结果
         */
        short apply(T t, U u, V v, W w);
    }

    /**
     * 接受四个任意类型参数并返回int值的函数式接口
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     */
    @FunctionalInterface
    interface ToInt<T, U, V, W> {
        /**
         * 执行操作并返回int结果
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return int 类型结果
         */
        int apply(T t, U u, V v, W w);
    }

    /**
     * 接受四个任意类型参数并返回long值的函数式接口
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     */
    @FunctionalInterface
    interface ToLong<T, U, V, W> {
        /**
         * 执行操作并返回long结果
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return long 类型结果
         */
        long apply(T t, U u, V v, W w);
    }

    /**
     * 接受四个任意类型参数并返回float值的函数式接口
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     */
    @FunctionalInterface
    interface ToFloat<T, U, V, W> {
        /**
         * 执行操作并返回float结果
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return float 类型结果
         */
        float apply(T t, U u, V v, W w);
    }

    /**
     * 接受四个任意类型参数并返回double值的函数式接口
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     */
    @FunctionalInterface
    interface ToDouble<T, U, V, W> {
        /**
         * 执行操作并返回double结果
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return double 类型结果
         */
        double apply(T t, U u, V v, W w);
    }
}