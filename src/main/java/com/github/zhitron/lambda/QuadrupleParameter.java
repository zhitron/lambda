package com.github.zhitron.lambda;

import com.github.zhitron.BasicConstant;

/**
 * QuadrupleParameter 是一个函数式接口，用于表示接受四个参数的函数。
 *
 * @author zhitron
 */
@SuppressWarnings("unchecked")
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
         * 一个始终返回 null 的空实现。
         */
        ToAny<?, ?, ?, ?, ?> EMPTY = (t, u, v, w) -> null;

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToAny 实例
         */
        static <T, U, V, W, R> ToAny<T, U, V, W, R> empty() {
            return (ToAny<T, U, V, W, R>) EMPTY;
        }

        /**
         * 创建一个始终返回指定常量值的函数式接口。
         *
         * @param value 常量值
         * @return 返回指定常量值的函数式接口
         */
        static <T, U, V, W, R> ToAny<T, U, V, W, R> constant(R value) {
            return (t, u, v, w) -> value;
        }

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
         * 表示一个空操作的常量实例，不执行任何操作。
         */
        ToVoid<?, ?, ?, ?> EMPTY = (t, u, v, w) -> {
        };

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToVoid 实例
         */
        static <T, U, V, W> ToVoid<T, U, V, W> empty() {
            return (ToVoid<T, U, V, W>) EMPTY;
        }

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
         * 始终返回 true 的常量实例。
         */
        ToBoolean<?, ?, ?, ?> TRUE = (t, u, v, w) -> BasicConstant.BOOLEAN_TRUE;
        /**
         * 始终返回 false 的常量实例。
         */
        ToBoolean<?, ?, ?, ?> FALSE = (t, u, v, w) -> BasicConstant.BOOLEAN_TRUE;

        /**
         * 创建一个返回指定布尔值的函数式接口。
         *
         * @param value 确定返回 true 还是 false 的布尔值
         * @return 根据给定布尔值确定的 ToBoolean 实例
         */
        static <T, U, V, W> ToBoolean<T, U, V, W> constant(boolean value) {
            return (ToBoolean<T, U, V, W>) (value ? TRUE : FALSE);
        }

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
         * 表示一个返回 '\0' 字符的常量实例。
         */
        ToChar<?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.CHAR_ZERO;

        /**
         * 获取一个返回 '\0' 字符的 ToChar 实例。
         *
         * @return 一个返回 '\0' 字符的 ToChar 实例
         */
        static <T, U, V, W> ToChar<T, U, V, W> empty() {
            return (ToChar<T, U, V, W>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字符的 ToChar 实例。
         *
         * @param value 要返回的固定字符
         * @return 一个总是返回给定字符的 ToChar 实例
         */
        static <T, U, V, W> ToChar<T, U, V, W> constant(char value) {
            return (t, u, v, w) -> value;
        }

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
         * 表示一个返回 0 字节值的常量实例。
         */
        ToByte<?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.BYTE_ZERO;

        /**
         * 获取一个返回 0 字节值的 ToByte 实例。
         *
         * @return 一个返回 0 字节值的 ToByte 实例
         */
        static <T, U, V, W> ToByte<T, U, V, W> empty() {
            return (ToByte<T, U, V, W>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字节值的 ToByte 实例。
         *
         * @param value 要返回的固定字节值
         * @return 一个总是返回给定字节值的 ToByte 实例
         */
        static <T, U, V, W> ToByte<T, U, V, W> constant(byte value) {
            return (t, u, v, w) -> value;
        }

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
         * 表示一个返回 0 短整数值的常量实例。
         */
        ToShort<?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.SHORT_ZERO;

        /**
         * 获取一个返回 0 短整数值的 ToShort 实例。
         *
         * @return 一个返回 0 短整数值的 ToShort 实例
         */
        static <T, U, V, W> ToShort<T, U, V, W> empty() {
            return (ToShort<T, U, V, W>) EMPTY;
        }

        /**
         * 创建一个总是返回给定短整数值的 ToShort 实例。
         *
         * @param value 要返回的固定短整数值
         * @return 一个总是返回给定短整数值的 ToShort 实例
         */
        static <T, U, V, W> ToShort<T, U, V, W> constant(short value) {
            return (t, u, v, w) -> value;
        }

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
         * 表示一个返回 0 整数值的常量实例。
         */
        ToInt<?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.INT_ZERO;

        /**
         * 获取一个返回 0 整数值的 ToInt 实例。
         *
         * @return 一个返回 0 整数值的 ToInt 实例
         */
        static <T, U, V, W> ToInt<T, U, V, W> empty() {
            return (ToInt<T, U, V, W>) EMPTY;
        }

        /**
         * 创建一个总是返回给定整数值的 ToInt 实例。
         *
         * @param value 要返回的固定整数值
         * @return 一个总是返回给定整数值的 ToInt 实例
         */
        static <T, U, V, W> ToInt<T, U, V, W> constant(int value) {
            return (t, u, v, w) -> value;
        }

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
         * 表示一个返回 0 长整数值的常量实例。
         */
        ToLong<?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.LONG_ZERO;

        /**
         * 获取一个返回 0 长整数值的 ToLong 实例。
         *
         * @return 一个返回 0 长整数值的 ToLong 实例
         */
        static <T, U, V, W> ToLong<T, U, V, W> empty() {
            return (ToLong<T, U, V, W>) EMPTY;
        }

        /**
         * 创建一个总是返回给定长整数值的 ToLong 实例。
         *
         * @param value 要返回的固定长整数值
         * @return 一个总是返回给定长整数值的 ToLong 实例
         */
        static <T, U, V, W> ToLong<T, U, V, W> constant(long value) {
            return (t, u, v, w) -> value;
        }

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
         * 表示一个返回 0.0f 浮点值的常量实例。
         */
        ToFloat<?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.FLOAT_ZERO;

        /**
         * 获取一个返回 0.0f 浮点值的 ToFloat 实例。
         *
         * @return 一个返回 0.0f 浮点值的 ToFloat 实例
         */
        static <T, U, V, W> ToFloat<T, U, V, W> empty() {
            return (ToFloat<T, U, V, W>) EMPTY;
        }

        /**
         * 创建一个总是返回给定浮点值的 ToFloat 实例。
         *
         * @param value 要返回的固定浮点值
         * @return 一个总是返回给定浮点值的 ToFloat 实例
         */
        static <T, U, V, W> ToFloat<T, U, V, W> constant(float value) {
            return (t, u, v, w) -> value;
        }

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
         * 表示一个返回 0.0d 双精度浮点值的常量实例。
         */
        ToDouble<?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.DOUBLE_ZERO;

        /**
         * 获取一个返回 0.0d 双精度浮点值的 ToDouble 实例。
         *
         * @return 一个返回 0.0d 双精度浮点值的 ToDouble 实例
         */
        static <T, U, V, W> ToDouble<T, U, V, W> empty() {
            return (ToDouble<T, U, V, W>) EMPTY;
        }

        /**
         * 创建一个总是返回给定双精度浮点值的 ToDouble 实例。
         *
         * @param value 要返回的固定双精度浮点值
         * @return 一个总是返回给定双精度浮点值的 ToDouble 实例
         */
        static <T, U, V, W> ToDouble<T, U, V, W> constant(double value) {
            return (t, u, v, w) -> value;
        }

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