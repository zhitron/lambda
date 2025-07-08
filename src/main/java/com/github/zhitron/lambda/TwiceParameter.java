package com.github.zhitron.lambda;

/**
 * TwiceParameter 是一个函数式接口，用于表示接受二个参数的函数。
 *
 * @author zhitron
 */
public interface TwiceParameter {
    /**
     * 通用的双参数函数式接口，用于返回任意类型的结果
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <R> 返回值类型
     */
    @FunctionalInterface
    interface ToAny<T, U, R> {
        /**
         * 应用函数操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 函数运算结果
         */
        R apply(T t, U u);
    }

    /**
     * 双参数函数式接口，不返回结果
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     */
    @FunctionalInterface
    interface ToVoid<T, U> {
        /**
         * 应用函数操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         */
        void apply(T t, U u);
    }

    /**
     * 双参数函数式接口，返回布尔类型结果
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     */
    @FunctionalInterface
    interface ToBoolean<T, U> {
        /**
         * 应用函数操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 布尔类型的运算结果
         */
        boolean apply(T t, U u);
    }

    /**
     * 双参数函数式接口，返回字符类型结果
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     */
    @FunctionalInterface
    interface ToChar<T, U> {
        /**
         * 应用函数操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 字符类型的运算结果
         */
        char apply(T t, U u);
    }

    /**
     * 双参数函数式接口，返回字节类型结果
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     */
    @FunctionalInterface
    interface ToByte<T, U> {
        /**
         * 应用函数操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 字节类型的运算结果
         */
        byte apply(T t, U u);
    }

    /**
     * 双参数函数式接口，返回短整型结果
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     */
    @FunctionalInterface
    interface ToShort<T, U> {
        /**
         * 应用函数操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 短整型的运算结果
         */
        short apply(T t, U u);
    }

    /**
     * 双参数函数式接口，返回整型结果
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     */
    @FunctionalInterface
    interface ToInt<T, U> {
        /**
         * 应用函数操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 整型的运算结果
         */
        int apply(T t, U u);
    }

    /**
     * 双参数函数式接口，返回长整型结果
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     */
    @FunctionalInterface
    interface ToLong<T, U> {
        /**
         * 应用函数操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 长整型的运算结果
         */
        long apply(T t, U u);
    }

    /**
     * 双参数函数式接口，返回浮点型结果
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     */
    @FunctionalInterface
    interface ToFloat<T, U> {
        /**
         * 应用函数操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 浮点型的运算结果
         */
        float apply(T t, U u);
    }

    /**
     * 双参数函数式接口，返回双精度浮点型结果
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     */
    @FunctionalInterface
    interface ToDouble<T, U> {
        /**
         * 应用函数操作
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 双精度浮点型的运算结果
         */
        double apply(T t, U u);
    }
}
