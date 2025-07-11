package com.github.zhitron.lambda;

import com.github.zhitron.BasicConstant;

/**
 * TwiceParameter 是一个函数式接口，用于表示接受二个参数的函数。
 *
 * @author zhitron
 */
@SuppressWarnings("unchecked")
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
         * 一个始终返回 null 的空实现。
         */
        ToAny<?, ?, ?> EMPTY = (t, u) -> null;

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToAny 实例
         */
        static <T, U, R> ToAny<T, U, R> empty() {
            return (ToAny<T, U, R>) EMPTY;
        }

        /**
         * 创建一个始终返回指定常量值的函数式接口。
         *
         * @param value 常量值
         * @return 返回指定常量值的函数式接口
         */
        static <T, U, R> ToAny<T, U, R> constant(R value) {
            return (t, u) -> value;
        }

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
         * 表示一个空操作的常量实例，不执行任何操作。
         */
        ToVoid<?, ?> EMPTY = (t, u) -> {
        };

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToVoid 实例
         */
        static <T, U> ToVoid<T, U> empty() {
            return (ToVoid<T, U>) EMPTY;
        }

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
         * 始终返回 true 的常量实例。
         */
        ToBoolean<?, ?> TRUE = (t, u) -> BasicConstant.BOOLEAN_TRUE;
        /**
         * 始终返回 false 的常量实例。
         */
        ToBoolean<?, ?> FALSE = (t, u) -> BasicConstant.BOOLEAN_TRUE;

        /**
         * 创建一个返回指定布尔值的函数式接口。
         *
         * @param value 确定返回 true 还是 false 的布尔值
         * @return 根据给定布尔值确定的 ToBoolean 实例
         */
        static <T, U> ToBoolean<T, U> constant(boolean value) {
            return (ToBoolean<T, U>) (value ? TRUE : FALSE);
        }

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
         * 表示一个返回 '\0' 字符的常量实例。
         */
        ToChar<?, ?> EMPTY = (t, u) -> BasicConstant.CHAR_ZERO;

        /**
         * 获取一个返回 '\0' 字符的 ToChar 实例。
         *
         * @return 一个返回 '\0' 字符的 ToChar 实例
         */
        static <T, U> ToChar<T, U> empty() {
            return (ToChar<T, U>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字符的 ToChar 实例。
         *
         * @param value 要返回的固定字符
         * @return 一个总是返回给定字符的 ToChar 实例
         */
        static <T, U> ToChar<T, U> constant(char value) {
            return (t, u) -> value;
        }

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
         * 表示一个返回 0 字节值的常量实例。
         */
        ToByte<?, ?> EMPTY = (t, u) -> BasicConstant.BYTE_ZERO;

        /**
         * 获取一个返回 0 字节值的 ToByte 实例。
         *
         * @return 一个返回 0 字节值的 ToByte 实例
         */
        static <T, U> ToByte<T, U> empty() {
            return (ToByte<T, U>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字节值的 ToByte 实例。
         *
         * @param value 要返回的固定字节值
         * @return 一个总是返回给定字节值的 ToByte 实例
         */
        static <T, U> ToByte<T, U> constant(byte value) {
            return (t, u) -> value;
        }

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
         * 表示一个返回 0 短整数值的常量实例。
         */
        ToShort<?, ?> EMPTY = (t, u) -> BasicConstant.SHORT_ZERO;

        /**
         * 获取一个返回 0 短整数值的 ToShort 实例。
         *
         * @return 一个返回 0 短整数值的 ToShort 实例
         */
        static <T, U> ToShort<T, U> empty() {
            return (ToShort<T, U>) EMPTY;
        }

        /**
         * 创建一个总是返回给定短整数值的 ToShort 实例。
         *
         * @param value 要返回的固定短整数值
         * @return 一个总是返回给定短整数值的 ToShort 实例
         */
        static <T, U> ToShort<T, U> constant(short value) {
            return (t, u) -> value;
        }

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
         * 表示一个返回 0 整数值的常量实例。
         */
        ToInt<?, ?> EMPTY = (t, u) -> BasicConstant.INT_ZERO;

        /**
         * 获取一个返回 0 整数值的 ToInt 实例。
         *
         * @return 一个返回 0 整数值的 ToInt 实例
         */
        static <T, U> ToInt<T, U> empty() {
            return (ToInt<T, U>) EMPTY;
        }

        /**
         * 创建一个总是返回给定整数值的 ToInt 实例。
         *
         * @param value 要返回的固定整数值
         * @return 一个总是返回给定整数值的 ToInt 实例
         */
        static <T, U> ToInt<T, U> constant(int value) {
            return (t, u) -> value;
        }

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
         * 表示一个返回 0 长整数值的常量实例。
         */
        ToLong<?, ?> EMPTY = (t, u) -> BasicConstant.LONG_ZERO;

        /**
         * 获取一个返回 0 长整数值的 ToLong 实例。
         *
         * @return 一个返回 0 长整数值的 ToLong 实例
         */
        static <T, U> ToLong<T, U> empty() {
            return (ToLong<T, U>) EMPTY;
        }

        /**
         * 创建一个总是返回给定长整数值的 ToLong 实例。
         *
         * @param value 要返回的固定长整数值
         * @return 一个总是返回给定长整数值的 ToLong 实例
         */
        static <T, U> ToLong<T, U> constant(long value) {
            return (t, u) -> value;
        }

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
         * 表示一个返回 0.0f 浮点值的常量实例。
         */
        ToFloat<?, ?> EMPTY = (t, u) -> BasicConstant.FLOAT_ZERO;

        /**
         * 获取一个返回 0.0f 浮点值的 ToFloat 实例。
         *
         * @return 一个返回 0.0f 浮点值的 ToFloat 实例
         */
        static <T, U> ToFloat<T, U> empty() {
            return (ToFloat<T, U>) EMPTY;
        }

        /**
         * 创建一个总是返回给定浮点值的 ToFloat 实例。
         *
         * @param value 要返回的固定浮点值
         * @return 一个总是返回给定浮点值的 ToFloat 实例
         */
        static <T, U> ToFloat<T, U> constant(float value) {
            return (t, u) -> value;
        }

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
         * 表示一个返回 0.0d 双精度浮点值的常量实例。
         */
        ToDouble<?, ?> EMPTY = (t, u) -> BasicConstant.DOUBLE_ZERO;

        /**
         * 获取一个返回 0.0d 双精度浮点值的 ToDouble 实例。
         *
         * @return 一个返回 0.0d 双精度浮点值的 ToDouble 实例
         */
        static <T, U> ToDouble<T, U> empty() {
            return (ToDouble<T, U>) EMPTY;
        }

        /**
         * 创建一个总是返回给定双精度浮点值的 ToDouble 实例。
         *
         * @param value 要返回的固定双精度浮点值
         * @return 一个总是返回给定双精度浮点值的 ToDouble 实例
         */
        static <T, U> ToDouble<T, U> constant(double value) {
            return (t, u) -> value;
        }

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
