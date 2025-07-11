package com.github.zhitron.lambda;

import com.github.zhitron.BasicConstant;

/**
 * TwiceParameter 是一个函数式接口，用于表示接受一个参数的函数。
 *
 * @author zhitron
 */
@SuppressWarnings("unchecked")
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
         * 一个始终返回 null 的空实现。
         */
        ToAny<?, ?> EMPTY = (t) -> null;

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToAny 实例
         */
        static <T, R> ToAny<T, R> empty() {
            return (ToAny<T, R>) EMPTY;
        }

        /**
         * 创建一个始终返回指定常量值的函数式接口。
         *
         * @param value 常量值
         * @return 返回指定常量值的函数式接口
         */
        static <T, R> ToAny<T, R> constant(R value) {
            return (t) -> value;
        }

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
         * 表示一个空操作的常量实例，不执行任何操作。
         */
        ToVoid<?> EMPTY = (t) -> {
        };

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToVoid 实例
         */
        static <T> ToVoid<T> empty() {
            return (ToVoid<T>) EMPTY;
        }

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
         * 始终返回 true 的常量实例。
         */
        ToBoolean<?> TRUE = (t) -> BasicConstant.BOOLEAN_TRUE;
        /**
         * 始终返回 false 的常量实例。
         */
        ToBoolean<?> FALSE = (t) -> BasicConstant.BOOLEAN_TRUE;

        /**
         * 创建一个返回指定布尔值的函数式接口。
         *
         * @param value 确定返回 true 还是 false 的布尔值
         * @return 根据给定布尔值确定的 ToBoolean 实例
         */
        static <T> ToBoolean<T> constant(boolean value) {
            return (ToBoolean<T>) (value ? TRUE : FALSE);
        }

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
         * 表示一个返回 '\0' 字符的常量实例。
         */
        ToChar<?> EMPTY = (t) -> BasicConstant.CHAR_ZERO;

        /**
         * 获取一个返回 '\0' 字符的 ToChar 实例。
         *
         * @return 一个返回 '\0' 字符的 ToChar 实例
         */
        static <T> ToChar<T> empty() {
            return (ToChar<T>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字符的 ToChar 实例。
         *
         * @param value 要返回的固定字符
         * @return 一个总是返回给定字符的 ToChar 实例
         */
        static <T> ToChar<T> constant(char value) {
            return (t) -> value;
        }

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
         * 表示一个返回 0 字节值的常量实例。
         */
        ToByte<?> EMPTY = (t) -> BasicConstant.BYTE_ZERO;

        /**
         * 获取一个返回 0 字节值的 ToByte 实例。
         *
         * @return 一个返回 0 字节值的 ToByte 实例
         */
        static <T> ToByte<T> empty() {
            return (ToByte<T>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字节值的 ToByte 实例。
         *
         * @param value 要返回的固定字节值
         * @return 一个总是返回给定字节值的 ToByte 实例
         */
        static <T> ToByte<T> constant(byte value) {
            return (t) -> value;
        }

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
         * 表示一个返回 0 短整数值的常量实例。
         */
        ToShort<?> EMPTY = (t) -> BasicConstant.SHORT_ZERO;

        /**
         * 获取一个返回 0 短整数值的 ToShort 实例。
         *
         * @return 一个返回 0 短整数值的 ToShort 实例
         */
        static <T> ToShort<T> empty() {
            return (ToShort<T>) EMPTY;
        }

        /**
         * 创建一个总是返回给定短整数值的 ToShort 实例。
         *
         * @param value 要返回的固定短整数值
         * @return 一个总是返回给定短整数值的 ToShort 实例
         */
        static <T> ToShort<T> constant(short value) {
            return (t) -> value;
        }

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
         * 表示一个返回 0 整数值的常量实例。
         */
        ToInt<?> EMPTY = (t) -> BasicConstant.INT_ZERO;

        /**
         * 获取一个返回 0 整数值的 ToInt 实例。
         *
         * @return 一个返回 0 整数值的 ToInt 实例
         */
        static <T> ToInt<T> empty() {
            return (ToInt<T>) EMPTY;
        }

        /**
         * 创建一个总是返回给定整数值的 ToInt 实例。
         *
         * @param value 要返回的固定整数值
         * @return 一个总是返回给定整数值的 ToInt 实例
         */
        static <T> ToInt<T> constant(int value) {
            return (t) -> value;
        }

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
         * 表示一个返回 0 长整数值的常量实例。
         */
        ToLong<?> EMPTY = (t) -> BasicConstant.LONG_ZERO;

        /**
         * 获取一个返回 0 长整数值的 ToLong 实例。
         *
         * @return 一个返回 0 长整数值的 ToLong 实例
         */
        static <T> ToLong<T> empty() {
            return (ToLong<T>) EMPTY;
        }

        /**
         * 创建一个总是返回给定长整数值的 ToLong 实例。
         *
         * @param value 要返回的固定长整数值
         * @return 一个总是返回给定长整数值的 ToLong 实例
         */
        static <T> ToLong<T> constant(long value) {
            return (t) -> value;
        }

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
         * 表示一个返回 0.0f 浮点值的常量实例。
         */
        ToFloat<?> EMPTY = (t) -> BasicConstant.FLOAT_ZERO;

        /**
         * 获取一个返回 0.0f 浮点值的 ToFloat 实例。
         *
         * @return 一个返回 0.0f 浮点值的 ToFloat 实例
         */
        static <T> ToFloat<T> empty() {
            return (ToFloat<T>) EMPTY;
        }

        /**
         * 创建一个总是返回给定浮点值的 ToFloat 实例。
         *
         * @param value 要返回的固定浮点值
         * @return 一个总是返回给定浮点值的 ToFloat 实例
         */
        static <T> ToFloat<T> constant(float value) {
            return (t) -> value;
        }

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
         * 表示一个返回 0.0d 双精度浮点值的常量实例。
         */
        ToDouble<?> EMPTY = (t) -> BasicConstant.DOUBLE_ZERO;

        /**
         * 获取一个返回 0.0d 双精度浮点值的 ToDouble 实例。
         *
         * @return 一个返回 0.0d 双精度浮点值的 ToDouble 实例
         */
        static <T> ToDouble<T> empty() {
            return (ToDouble<T>) EMPTY;
        }

        /**
         * 创建一个总是返回给定双精度浮点值的 ToDouble 实例。
         *
         * @param value 要返回的固定双精度浮点值
         * @return 一个总是返回给定双精度浮点值的 ToDouble 实例
         */
        static <T> ToDouble<T> constant(double value) {
            return (t) -> value;
        }

        /**
         * 对给定的输入执行操作并返回双精度浮点型值。
         *
         * @param t 输入参数
         * @return 双精度浮点型值结果
         */
        double apply(T t);
    }
}
