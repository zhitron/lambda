package com.github.zhitron.lambda;

import com.github.zhitron.BasicConstant;

/**
 * TripleParameter 是一个函数式接口，用于表示接受三个参数的函数。
 *
 * @author zhitron
 */
@SuppressWarnings("unchecked")
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
         * 一个始终返回 null 的空实现。
         */
        ToAny<?, ?, ?, ?> EMPTY = (t, u, v) -> null;

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToAny 实例
         */
        static <T, U, V, R> ToAny<T, U, V, R> empty() {
            return (ToAny<T, U, V, R>) EMPTY;
        }

        /**
         * 创建一个始终返回指定常量值的函数式接口。
         *
         * @param value 常量值
         * @return 返回指定常量值的函数式接口
         */
        static <T, U, V, R> ToAny<T, U, V, R> constant(R value) {
            return (t, u, v) -> value;
        }

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
         * 表示一个空操作的常量实例，不执行任何操作。
         */
        ToVoid<?, ?, ?> EMPTY = (t, u, v) -> {
        };

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToVoid 实例
         */
        static <T, U, V> ToVoid<T, U, V> empty() {
            return (ToVoid<T, U, V>) EMPTY;
        }

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
         * 始终返回 true 的常量实例。
         */
        ToBoolean<?, ?, ?> TRUE = (t, u, v) -> BasicConstant.BOOLEAN_TRUE;
        /**
         * 始终返回 false 的常量实例。
         */
        ToBoolean<?, ?, ?> FALSE = (t, u, v) -> BasicConstant.BOOLEAN_TRUE;

        /**
         * 创建一个返回指定布尔值的函数式接口。
         *
         * @param value 确定返回 true 还是 false 的布尔值
         * @return 根据给定布尔值确定的 ToBoolean 实例
         */
        static <T, U, V> ToBoolean<T, U, V> constant(boolean value) {
            return (ToBoolean<T, U, V>) (value ? TRUE : FALSE);
        }

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
         * 表示一个返回 '\0' 字符的常量实例。
         */
        ToChar<?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.CHAR_ZERO;

        /**
         * 获取一个返回 '\0' 字符的 ToChar 实例。
         *
         * @return 一个返回 '\0' 字符的 ToChar 实例
         */
        static <T, U, V> ToChar<T, U, V> empty() {
            return (ToChar<T, U, V>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字符的 ToChar 实例。
         *
         * @param value 要返回的固定字符
         * @return 一个总是返回给定字符的 ToChar 实例
         */
        static <T, U, V> ToChar<T, U, V> constant(char value) {
            return (t, u, v) -> value;
        }

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
         * 表示一个返回 0 字节值的常量实例。
         */
        ToByte<?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.BYTE_ZERO;

        /**
         * 获取一个返回 0 字节值的 ToByte 实例。
         *
         * @return 一个返回 0 字节值的 ToByte 实例
         */
        static <T, U, V> ToByte<T, U, V> empty() {
            return (ToByte<T, U, V>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字节值的 ToByte 实例。
         *
         * @param value 要返回的固定字节值
         * @return 一个总是返回给定字节值的 ToByte 实例
         */
        static <T, U, V> ToByte<T, U, V> constant(byte value) {
            return (t, u, v) -> value;
        }

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
         * 表示一个返回 0 短整数值的常量实例。
         */
        ToShort<?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.SHORT_ZERO;

        /**
         * 获取一个返回 0 短整数值的 ToShort 实例。
         *
         * @return 一个返回 0 短整数值的 ToShort 实例
         */
        static <T, U, V> ToShort<T, U, V> empty() {
            return (ToShort<T, U, V>) EMPTY;
        }

        /**
         * 创建一个总是返回给定短整数值的 ToShort 实例。
         *
         * @param value 要返回的固定短整数值
         * @return 一个总是返回给定短整数值的 ToShort 实例
         */
        static <T, U, V> ToShort<T, U, V> constant(short value) {
            return (t, u, v) -> value;
        }

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
         * 表示一个返回 0 整数值的常量实例。
         */
        ToInt<?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.INT_ZERO;

        /**
         * 获取一个返回 0 整数值的 ToInt 实例。
         *
         * @return 一个返回 0 整数值的 ToInt 实例
         */
        static <T, U, V> ToInt<T, U, V> empty() {
            return (ToInt<T, U, V>) EMPTY;
        }

        /**
         * 创建一个总是返回给定整数值的 ToInt 实例。
         *
         * @param value 要返回的固定整数值
         * @return 一个总是返回给定整数值的 ToInt 实例
         */
        static <T, U, V> ToInt<T, U, V> constant(int value) {
            return (t, u, v) -> value;
        }

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
         * 表示一个返回 0 长整数值的常量实例。
         */
        ToLong<?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.LONG_ZERO;

        /**
         * 获取一个返回 0 长整数值的 ToLong 实例。
         *
         * @return 一个返回 0 长整数值的 ToLong 实例
         */
        static <T, U, V> ToLong<T, U, V> empty() {
            return (ToLong<T, U, V>) EMPTY;
        }

        /**
         * 创建一个总是返回给定长整数值的 ToLong 实例。
         *
         * @param value 要返回的固定长整数值
         * @return 一个总是返回给定长整数值的 ToLong 实例
         */
        static <T, U, V> ToLong<T, U, V> constant(long value) {
            return (t, u, v) -> value;
        }

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
         * 表示一个返回 0.0f 浮点值的常量实例。
         */
        ToFloat<?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.FLOAT_ZERO;

        /**
         * 获取一个返回 0.0f 浮点值的 ToFloat 实例。
         *
         * @return 一个返回 0.0f 浮点值的 ToFloat 实例
         */
        static <T, U, V> ToFloat<T, U, V> empty() {
            return (ToFloat<T, U, V>) EMPTY;
        }

        /**
         * 创建一个总是返回给定浮点值的 ToFloat 实例。
         *
         * @param value 要返回的固定浮点值
         * @return 一个总是返回给定浮点值的 ToFloat 实例
         */
        static <T, U, V> ToFloat<T, U, V> constant(float value) {
            return (t, u, v) -> value;
        }

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
         * 表示一个返回 0.0d 双精度浮点值的常量实例。
         */
        ToDouble<?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.DOUBLE_ZERO;

        /**
         * 获取一个返回 0.0d 双精度浮点值的 ToDouble 实例。
         *
         * @return 一个返回 0.0d 双精度浮点值的 ToDouble 实例
         */
        static <T, U, V> ToDouble<T, U, V> empty() {
            return (ToDouble<T, U, V>) EMPTY;
        }

        /**
         * 创建一个总是返回给定双精度浮点值的 ToDouble 实例。
         *
         * @param value 要返回的固定双精度浮点值
         * @return 一个总是返回给定双精度浮点值的 ToDouble 实例
         */
        static <T, U, V> ToDouble<T, U, V> constant(double value) {
            return (t, u, v) -> value;
        }

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
