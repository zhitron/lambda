package com.github.zhitron.lambda;

import com.github.zhitron.BasicConstant;

/**
 * QuadrupleParameterThrow 是 QuadrupleParameter 接口的扩展，用于定义可抛出异常的四个参数函数式接口。
 * 它为每种返回类型提供了带有异常处理的 applyThrow 方法，并默认将检查异常包装成运行时异常。
 *
 * @author zhitron
 */
@SuppressWarnings("unchecked")
public interface QuadrupleParameterThrow extends QuadrupleParameter {
    /**
     * ToAny 是一个函数式接口，表示接受四个参数并返回一个结果且可能抛出异常的函数。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     * @param <R> 返回值类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToAny<T, U, V, W, R, E extends Exception> extends QuadrupleParameter.ToAny<T, U, V, W, R> {
        /**
         * 一个始终返回 null 的空实现。
         */
        ToAny<?, ?, ?, ?, ?, ?> EMPTY = (t, u, v, w) -> null;

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToAny 实例
         */
        static <T, U, V, W, R, E extends Exception> ToAny<T, U, V, W, R, E> empty() {
            return (ToAny<T, U, V, W, R, E>) EMPTY;
        }

        /**
         * 创建一个始终返回指定常量值的函数式接口。
         *
         * @param value 常量值
         * @return 返回指定常量值的函数式接口
         */
        static <T, U, V, W, R, E extends Exception> ToAny<T, U, V, W, R, E> constant(R value) {
            return (t, u, v, w) -> value;
        }

        /**
         * 执行操作并返回结果，但可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return 操作结果
         * @throws E 自定义异常类型
         */
        R applyThrow(T t, U u, V v, W w) throws E;

        /**
         * 默认实现，将受检异常封装为 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return 操作结果
         */
        @Override
        default R apply(T t, U u, V v, W w) {
            try {
                return applyThrow(t, u, v, w);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToVoid 是一个函数式接口，表示接受四个参数且无返回值、可能抛出异常的函数。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToVoid<T, U, V, W, E extends Exception> extends QuadrupleParameter.ToVoid<T, U, V, W> {
        /**
         * 表示一个空操作的常量实例，不执行任何操作。
         */
        ToVoid<?, ?, ?, ?, ?> EMPTY = (t, u, v, w) -> {
        };

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToVoid 实例
         */
        static <T, U, V, W, E extends Exception> ToVoid<T, U, V, W, E> empty() {
            return (ToVoid<T, U, V, W, E>) EMPTY;
        }

        /**
         * 执行操作，但可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @throws E 自定义异常类型
         */
        void applyThrow(T t, U u, V v, W w) throws E;

        /**
         * 默认实现，将受检异常封装为 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         */
        @Override
        default void apply(T t, U u, V v, W w) {
            try {
                applyThrow(t, u, v, w);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToBoolean 是一个函数式接口，表示接受四个参数并返回布尔值、可能抛出异常的函数。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToBoolean<T, U, V, W, E extends Exception> extends QuadrupleParameter.ToBoolean<T, U, V, W> {
        /**
         * 始终返回 true 的常量实例。
         */
        ToBoolean<?, ?, ?, ?, ?> TRUE = (t, u, v, w) -> BasicConstant.BOOLEAN_TRUE;
        /**
         * 始终返回 false 的常量实例。
         */
        ToBoolean<?, ?, ?, ?, ?> FALSE = (t, u, v, w) -> BasicConstant.BOOLEAN_TRUE;

        /**
         * 创建一个返回指定布尔值的函数式接口。
         *
         * @param value 确定返回 true 还是 false 的布尔值
         * @return 根据给定布尔值确定的 ToBoolean 实例
         */
        static <T, U, V, W, E extends Exception> ToBoolean<T, U, V, W, E> constant(boolean value) {
            return (ToBoolean<T, U, V, W, E>) (value ? TRUE : FALSE);
        }

        /**
         * 执行判断操作并返回布尔值，但可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return 判断结果
         * @throws E 自定义异常类型
         */
        boolean applyThrow(T t, U u, V v, W w) throws E;

        /**
         * 默认实现，将受检异常封装为 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return 判断结果
         */
        @Override
        default boolean apply(T t, U u, V v, W w) {
            try {
                return applyThrow(t, u, v, w);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToChar 是一个函数式接口，表示接受四个参数并返回 char 值、可能抛出异常的函数。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToChar<T, U, V, W, E extends Exception> extends QuadrupleParameter.ToChar<T, U, V, W> {
        /**
         * 表示一个返回 '\0' 字符的常量实例。
         */
        ToChar<?, ?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.CHAR_ZERO;

        /**
         * 获取一个返回 '\0' 字符的 ToChar 实例。
         *
         * @return 一个返回 '\0' 字符的 ToChar 实例
         */
        static <T, U, V, W, E extends Exception> ToChar<T, U, V, W, E> empty() {
            return (ToChar<T, U, V, W, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字符的 ToChar 实例。
         *
         * @param value 要返回的固定字符
         * @return 一个总是返回给定字符的 ToChar 实例
         */
        static <T, U, V, W, E extends Exception> ToChar<T, U, V, W, E> constant(char value) {
            return (t, u, v, w) -> value;
        }

        /**
         * 执行操作并返回 char 类型的结果，但可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return char 类型结果
         * @throws E 自定义异常类型
         */
        char applyThrow(T t, U u, V v, W w) throws E;

        /**
         * 默认实现，将受检异常封装为 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return char 类型结果
         */
        @Override
        default char apply(T t, U u, V v, W w) {
            try {
                return applyThrow(t, u, v, w);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToByte 是一个函数式接口，表示接受四个参数并返回 byte 值、可能抛出异常的函数。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToByte<T, U, V, W, E extends Exception> extends QuadrupleParameter.ToByte<T, U, V, W> {
        /**
         * 表示一个返回 0 字节值的常量实例。
         */
        ToByte<?, ?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.BYTE_ZERO;

        /**
         * 获取一个返回 0 字节值的 ToByte 实例。
         *
         * @return 一个返回 0 字节值的 ToByte 实例
         */
        static <T, U, V, W, E extends Exception> ToByte<T, U, V, W, E> empty() {
            return (ToByte<T, U, V, W, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字节值的 ToByte 实例。
         *
         * @param value 要返回的固定字节值
         * @return 一个总是返回给定字节值的 ToByte 实例
         */
        static <T, U, V, W, E extends Exception> ToByte<T, U, V, W, E> constant(byte value) {
            return (t, u, v, w) -> value;
        }

        /**
         * 执行操作并返回 byte 类型的结果，但可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return byte 类型结果
         * @throws E 自定义异常类型
         */
        byte applyThrow(T t, U u, V v, W w) throws E;

        /**
         * 默认实现，将受检异常封装为 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return byte 类型结果
         */
        @Override
        default byte apply(T t, U u, V v, W w) {
            try {
                return applyThrow(t, u, v, w);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToShort 是一个函数式接口，表示接受四个参数并返回 short 值、可能抛出异常的函数。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToShort<T, U, V, W, E extends Exception> extends QuadrupleParameter.ToShort<T, U, V, W> {
        /**
         * 表示一个返回 0 短整数值的常量实例。
         */
        ToShort<?, ?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.SHORT_ZERO;

        /**
         * 获取一个返回 0 短整数值的 ToShort 实例。
         *
         * @return 一个返回 0 短整数值的 ToShort 实例
         */
        static <T, U, V, W, E extends Exception> ToShort<T, U, V, W, E> empty() {
            return (ToShort<T, U, V, W, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定短整数值的 ToShort 实例。
         *
         * @param value 要返回的固定短整数值
         * @return 一个总是返回给定短整数值的 ToShort 实例
         */
        static <T, U, V, W, E extends Exception> ToShort<T, U, V, W, E> constant(short value) {
            return (t, u, v, w) -> value;
        }

        /**
         * 执行操作并返回 short 类型的结果，但可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return short 类型结果
         * @throws E 自定义异常类型
         */
        short applyThrow(T t, U u, V v, W w) throws E;

        /**
         * 默认实现，将受检异常封装为 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return short 类型结果
         */
        @Override
        default short apply(T t, U u, V v, W w) {
            try {
                return applyThrow(t, u, v, w);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToInt 是一个函数式接口，表示接受四个参数并返回 int 值、可能抛出异常的函数。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToInt<T, U, V, W, E extends Exception> extends QuadrupleParameter.ToInt<T, U, V, W> {
        /**
         * 表示一个返回 0 整数值的常量实例。
         */
        ToInt<?, ?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.INT_ZERO;

        /**
         * 获取一个返回 0 整数值的 ToInt 实例。
         *
         * @return 一个返回 0 整数值的 ToInt 实例
         */
        static <T, U, V, W, E extends Exception> ToInt<T, U, V, W, E> empty() {
            return (ToInt<T, U, V, W, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定整数值的 ToInt 实例。
         *
         * @param value 要返回的固定整数值
         * @return 一个总是返回给定整数值的 ToInt 实例
         */
        static <T, U, V, W, E extends Exception> ToInt<T, U, V, W, E> constant(int value) {
            return (t, u, v, w) -> value;
        }

        /**
         * 执行操作并返回 int 类型的结果，但可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return int 类型结果
         * @throws E 自定义异常类型
         */
        int applyThrow(T t, U u, V v, W w) throws E;

        /**
         * 默认实现，将受检异常封装为 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return int 类型结果
         */
        @Override
        default int apply(T t, U u, V v, W w) {
            try {
                return applyThrow(t, u, v, w);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToLong 是一个函数式接口，表示接受四个参数并返回 long 值、可能抛出异常的函数。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToLong<T, U, V, W, E extends Exception> extends QuadrupleParameter.ToLong<T, U, V, W> {
        /**
         * 表示一个返回 0 长整数值的常量实例。
         */
        ToLong<?, ?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.LONG_ZERO;

        /**
         * 获取一个返回 0 长整数值的 ToLong 实例。
         *
         * @return 一个返回 0 长整数值的 ToLong 实例
         */
        static <T, U, V, W, E extends Exception> ToLong<T, U, V, W, E> empty() {
            return (ToLong<T, U, V, W, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定长整数值的 ToLong 实例。
         *
         * @param value 要返回的固定长整数值
         * @return 一个总是返回给定长整数值的 ToLong 实例
         */
        static <T, U, V, W, E extends Exception> ToLong<T, U, V, W, E> constant(long value) {
            return (t, u, v, w) -> value;
        }

        /**
         * 执行操作并返回 long 类型的结果，但可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return long 类型结果
         * @throws E 自定义异常类型
         */
        long applyThrow(T t, U u, V v, W w) throws E;

        /**
         * 默认实现，将受检异常封装为 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return long 类型结果
         */
        @Override
        default long apply(T t, U u, V v, W w) {
            try {
                return applyThrow(t, u, v, w);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToFloat 是一个函数式接口，表示接受四个参数并返回 float 值、可能抛出异常的函数。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToFloat<T, U, V, W, E extends Exception> extends QuadrupleParameter.ToFloat<T, U, V, W> {
        /**
         * 表示一个返回 0.0f 浮点值的常量实例。
         */
        ToFloat<?, ?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.FLOAT_ZERO;

        /**
         * 获取一个返回 0.0f 浮点值的 ToFloat 实例。
         *
         * @return 一个返回 0.0f 浮点值的 ToFloat 实例
         */
        static <T, U, V, W, E extends Exception> ToFloat<T, U, V, W, E> empty() {
            return (ToFloat<T, U, V, W, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定浮点值的 ToFloat 实例。
         *
         * @param value 要返回的固定浮点值
         * @return 一个总是返回给定浮点值的 ToFloat 实例
         */
        static <T, U, V, W, E extends Exception> ToFloat<T, U, V, W, E> constant(float value) {
            return (t, u, v, w) -> value;
        }

        /**
         * 执行操作并返回 float 类型的结果，但可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return float 类型结果
         * @throws E 自定义异常类型
         */
        float applyThrow(T t, U u, V v, W w) throws E;

        /**
         * 默认实现，将受检异常封装为 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return float 类型结果
         */
        @Override
        default float apply(T t, U u, V v, W w) {
            try {
                return applyThrow(t, u, v, w);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToDouble 是一个函数式接口，表示接受四个参数并返回 double 值、可能抛出异常的函数。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <W> 第四个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToDouble<T, U, V, W, E extends Exception> extends QuadrupleParameter.ToDouble<T, U, V, W> {
        /**
         * 表示一个返回 0.0d 双精度浮点值的常量实例。
         */
        ToDouble<?, ?, ?, ?, ?> EMPTY = (t, u, v, w) -> BasicConstant.DOUBLE_ZERO;

        /**
         * 获取一个返回 0.0d 双精度浮点值的 ToDouble 实例。
         *
         * @return 一个返回 0.0d 双精度浮点值的 ToDouble 实例
         */
        static <T, U, V, W, E extends Exception> ToDouble<T, U, V, W, E> empty() {
            return (ToDouble<T, U, V, W, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定双精度浮点值的 ToDouble 实例。
         *
         * @param value 要返回的固定双精度浮点值
         * @return 一个总是返回给定双精度浮点值的 ToDouble 实例
         */
        static <T, U, V, W, E extends Exception> ToDouble<T, U, V, W, E> constant(double value) {
            return (t, u, v, w) -> value;
        }

        /**
         * 执行操作并返回 double 类型的结果，但可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return double 类型结果
         * @throws E 自定义异常类型
         */
        double applyThrow(T t, U u, V v, W w) throws E;

        /**
         * 默认实现，将受检异常封装为 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @param w 第四个参数
         * @return double 类型结果
         */
        @Override
        default double apply(T t, U u, V v, W w) {
            try {
                return applyThrow(t, u, v, w);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }
}