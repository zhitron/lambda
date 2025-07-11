package com.github.zhitron.lambda;

import com.github.zhitron.BasicConstant;

/**
 * TwiceParameterThrow 是 TwiceParameter 接口的扩展，用于定义可抛出异常的两个参数函数式接口。
 * 它为每种返回类型提供了带有异常处理的 applyThrow 方法，并默认将检查异常包装成运行时异常。
 *
 * @author zhitron
 */
@SuppressWarnings("unchecked")
public interface TwiceParameterThrow extends TwiceParameter {
    /**
     * ToAny 是一个函数式接口，用于表示接受两个参数并返回泛型结果的函数，同时允许抛出指定类型的异常。
     *
     * @param <T> 函数的第一个参数类型
     * @param <U> 函数的第二个参数类型
     * @param <R> 返回值类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToAny<T, U, R, E extends Exception> extends TwiceParameter.ToAny<T, U, R> {
        /**
         * 一个始终返回 null 的空实现。
         */
        ToAny<?, ?, ?, ?> EMPTY = (t, u) -> null;

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToAny 实例
         */
        static <T, U, R, E extends Exception> ToAny<T, U, R, E> empty() {
            return (ToAny<T, U, R, E>) EMPTY;
        }

        /**
         * 创建一个始终返回指定常量值的函数式接口。
         *
         * @param value 常量值
         * @return 返回指定常量值的函数式接口
         */
        static <T, U, R, E extends Exception> ToAny<T, U, R, E> constant(R value) {
            return (t, u) -> value;
        }

        /**
         * 应用函数操作，并可能抛出异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 函数运算结果
         * @throws E 指定的异常类型
         */
        R applyThrow(T t, U u) throws E;

        /**
         * 默认实现，将 applyThrow 方法包装为不抛出受检异常的方法。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 函数运算结果
         */
        @Override
        default R apply(T t, U u) {
            try {
                return applyThrow(t, u);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToVoid 是一个函数式接口，用于表示接受两个参数且不返回结果的函数，同时允许抛出指定类型的异常。
     *
     * @param <T> 函数的第一个参数类型
     * @param <U> 函数的第二个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToVoid<T, U, E extends Exception> extends TwiceParameter.ToVoid<T, U> {
        /**
         * 表示一个空操作的常量实例，不执行任何操作。
         */
        ToVoid<?, ?, ?> EMPTY = (t, u) -> {
        };

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToVoid 实例
         */
        static <T, U, E extends Exception> ToVoid<T, U, E> empty() {
            return (ToVoid<T, U, E>) EMPTY;
        }

        /**
         * 应用函数操作，并可能抛出异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @throws E 指定的异常类型
         */
        void applyThrow(T t, U u) throws E;

        /**
         * 默认实现，将 applyThrow 方法包装为不抛出受检异常的方法。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         */
        @Override
        default void apply(T t, U u) {
            try {
                applyThrow(t, u);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToBoolean 是一个函数式接口，用于表示接受两个参数并返回布尔类型结果的函数，同时允许抛出指定类型的异常。
     *
     * @param <T> 函数的第一个参数类型
     * @param <U> 函数的第二个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToBoolean<T, U, E extends Exception> extends TwiceParameter.ToBoolean<T, U> {
        /**
         * 始终返回 true 的常量实例。
         */
        ToBoolean<?, ?, ?> TRUE = (t, u) -> BasicConstant.BOOLEAN_TRUE;
        /**
         * 始终返回 false 的常量实例。
         */
        ToBoolean<?, ?, ?> FALSE = (t, u) -> BasicConstant.BOOLEAN_TRUE;

        /**
         * 创建一个返回指定布尔值的函数式接口。
         *
         * @param value 确定返回 true 还是 false 的布尔值
         * @return 根据给定布尔值确定的 ToBoolean 实例
         */
        static <T, U, E extends Exception> ToBoolean<T, U, E> constant(boolean value) {
            return (ToBoolean<T, U, E>) (value ? TRUE : FALSE);
        }

        /**
         * 应用函数操作，并可能抛出异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 布尔类型的运算结果
         * @throws E 指定的异常类型
         */
        boolean applyThrow(T t, U u) throws E;

        /**
         * 默认实现，将 applyThrow 方法包装为不抛出受检异常的方法。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 布尔类型的运算结果
         */
        @Override
        default boolean apply(T t, U u) {
            try {
                return applyThrow(t, u);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToChar 是一个函数式接口，用于表示接受两个参数并返回字符类型结果的函数，同时允许抛出指定类型的异常。
     *
     * @param <T> 函数的第一个参数类型
     * @param <U> 函数的第二个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToChar<T, U, E extends Exception> extends TwiceParameter.ToChar<T, U> {
        /**
         * 表示一个返回 '\0' 字符的常量实例。
         */
        ToChar<?, ?, ?> EMPTY = (t, u) -> BasicConstant.CHAR_ZERO;

        /**
         * 获取一个返回 '\0' 字符的 ToChar 实例。
         *
         * @return 一个返回 '\0' 字符的 ToChar 实例
         */
        static <T, U, E extends Exception> ToChar<T, U, E> empty() {
            return (ToChar<T, U, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字符的 ToChar 实例。
         *
         * @param value 要返回的固定字符
         * @return 一个总是返回给定字符的 ToChar 实例
         */
        static <T, U, E extends Exception> ToChar<T, U, E> constant(char value) {
            return (t, u) -> value;
        }

        /**
         * 应用函数操作，并可能抛出异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 字符类型的运算结果
         * @throws E 指定的异常类型
         */
        char applyThrow(T t, U u) throws E;

        /**
         * 默认实现，将 applyThrow 方法包装为不抛出受检异常的方法。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 字符类型的运算结果
         */
        @Override
        default char apply(T t, U u) {
            try {
                return applyThrow(t, u);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToByte 是一个函数式接口，用于表示接受两个参数并返回字节类型结果的函数，同时允许抛出指定类型的异常。
     *
     * @param <T> 函数的第一个参数类型
     * @param <U> 函数的第二个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToByte<T, U, E extends Exception> extends TwiceParameter.ToByte<T, U> {
        /**
         * 表示一个返回 0 字节值的常量实例。
         */
        ToByte<?, ?, ?> EMPTY = (t, u) -> BasicConstant.BYTE_ZERO;

        /**
         * 获取一个返回 0 字节值的 ToByte 实例。
         *
         * @return 一个返回 0 字节值的 ToByte 实例
         */
        static <T, U, E extends Exception> ToByte<T, U, E> empty() {
            return (ToByte<T, U, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字节值的 ToByte 实例。
         *
         * @param value 要返回的固定字节值
         * @return 一个总是返回给定字节值的 ToByte 实例
         */
        static <T, U, E extends Exception> ToByte<T, U, E> constant(byte value) {
            return (t, u) -> value;
        }

        /**
         * 应用函数操作，并可能抛出异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 字节类型的运算结果
         * @throws E 指定的异常类型
         */
        byte applyThrow(T t, U u) throws E;

        /**
         * 默认实现，将 applyThrow 方法包装为不抛出受检异常的方法。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 字节类型的运算结果
         */
        @Override
        default byte apply(T t, U u) {
            try {
                return applyThrow(t, u);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToShort 是一个函数式接口，用于表示接受两个参数并返回短整型结果的函数，同时允许抛出指定类型的异常。
     *
     * @param <T> 函数的第一个参数类型
     * @param <U> 函数的第二个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToShort<T, U, E extends Exception> extends TwiceParameter.ToShort<T, U> {
        /**
         * 表示一个返回 0 短整数值的常量实例。
         */
        ToShort<?, ?, ?> EMPTY = (t, u) -> BasicConstant.SHORT_ZERO;

        /**
         * 获取一个返回 0 短整数值的 ToShort 实例。
         *
         * @return 一个返回 0 短整数值的 ToShort 实例
         */
        static <T, U, E extends Exception> ToShort<T, U, E> empty() {
            return (ToShort<T, U, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定短整数值的 ToShort 实例。
         *
         * @param value 要返回的固定短整数值
         * @return 一个总是返回给定短整数值的 ToShort 实例
         */
        static <T, U, E extends Exception> ToShort<T, U, E> constant(short value) {
            return (t, u) -> value;
        }

        /**
         * 应用函数操作，并可能抛出异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 短整型的运算结果
         * @throws E 指定的异常类型
         */
        short applyThrow(T t, U u) throws E;

        /**
         * 默认实现，将 applyThrow 方法包装为不抛出受检异常的方法。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 短整型的运算结果
         */
        @Override
        default short apply(T t, U u) {
            try {
                return applyThrow(t, u);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToInt 是一个函数式接口，用于表示接受两个参数并返回整型结果的函数，同时允许抛出指定类型的异常。
     *
     * @param <T> 函数的第一个参数类型
     * @param <U> 函数的第二个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToInt<T, U, E extends Exception> extends TwiceParameter.ToInt<T, U> {
        /**
         * 表示一个返回 0 整数值的常量实例。
         */
        ToInt<?, ?, ?> EMPTY = (t, u) -> BasicConstant.INT_ZERO;

        /**
         * 获取一个返回 0 整数值的 ToInt 实例。
         *
         * @return 一个返回 0 整数值的 ToInt 实例
         */
        static <T, U, E extends Exception> ToInt<T, U, E> empty() {
            return (ToInt<T, U, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定整数值的 ToInt 实例。
         *
         * @param value 要返回的固定整数值
         * @return 一个总是返回给定整数值的 ToInt 实例
         */
        static <T, U, E extends Exception> ToInt<T, U, E> constant(int value) {
            return (t, u) -> value;
        }

        /**
         * 应用函数操作，并可能抛出异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 整型的运算结果
         * @throws E 指定的异常类型
         */
        int applyThrow(T t, U u) throws E;

        /**
         * 默认实现，将 applyThrow 方法包装为不抛出受检异常的方法。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 整型的运算结果
         */
        @Override
        default int apply(T t, U u) {
            try {
                return applyThrow(t, u);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToLong 是一个函数式接口，用于表示接受两个参数并返回长整型结果的函数，同时允许抛出指定类型的异常。
     *
     * @param <T> 函数的第一个参数类型
     * @param <U> 函数的第二个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToLong<T, U, E extends Exception> extends TwiceParameter.ToLong<T, U> {
        /**
         * 表示一个返回 0 长整数值的常量实例。
         */
        ToLong<?, ?, ?> EMPTY = (t, u) -> BasicConstant.LONG_ZERO;

        /**
         * 获取一个返回 0 长整数值的 ToLong 实例。
         *
         * @return 一个返回 0 长整数值的 ToLong 实例
         */
        static <T, U, E extends Exception> ToLong<T, U, E> empty() {
            return (ToLong<T, U, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定长整数值的 ToLong 实例。
         *
         * @param value 要返回的固定长整数值
         * @return 一个总是返回给定长整数值的 ToLong 实例
         */
        static <T, U, E extends Exception> ToLong<T, U, E> constant(long value) {
            return (t, u) -> value;
        }

        /**
         * 应用函数操作，并可能抛出异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 长整型的运算结果
         * @throws E 指定的异常类型
         */
        long applyThrow(T t, U u) throws E;

        /**
         * 默认实现，将 applyThrow 方法包装为不抛出受检异常的方法。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 长整型的运算结果
         */
        @Override
        default long apply(T t, U u) {
            try {
                return applyThrow(t, u);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToFloat 是一个函数式接口，用于表示接受两个参数并返回浮点型结果的函数，同时允许抛出指定类型的异常。
     *
     * @param <T> 函数的第一个参数类型
     * @param <U> 函数的第二个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToFloat<T, U, E extends Exception> extends TwiceParameter.ToFloat<T, U> {
        /**
         * 表示一个返回 0.0f 浮点值的常量实例。
         */
        ToFloat<?, ?, ?> EMPTY = (t, u) -> BasicConstant.FLOAT_ZERO;

        /**
         * 获取一个返回 0.0f 浮点值的 ToFloat 实例。
         *
         * @return 一个返回 0.0f 浮点值的 ToFloat 实例
         */
        static <T, U, E extends Exception> ToFloat<T, U, E> empty() {
            return (ToFloat<T, U, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定浮点值的 ToFloat 实例。
         *
         * @param value 要返回的固定浮点值
         * @return 一个总是返回给定浮点值的 ToFloat 实例
         */
        static <T, U, E extends Exception> ToFloat<T, U, E> constant(float value) {
            return (t, u) -> value;
        }

        /**
         * 应用函数操作，并可能抛出异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 浮点型的运算结果
         * @throws E 指定的异常类型
         */
        float applyThrow(T t, U u) throws E;

        /**
         * 默认实现，将 applyThrow 方法包装为不抛出受检异常的方法。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 浮点型的运算结果
         */
        @Override
        default float apply(T t, U u) {
            try {
                return applyThrow(t, u);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToDouble 是一个函数式接口，用于表示接受两个参数并返回双精度浮点型结果的函数，同时允许抛出指定类型的异常。
     *
     * @param <T> 函数的第一个参数类型
     * @param <U> 函数的第二个参数类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToDouble<T, U, E extends Exception> extends TwiceParameter.ToDouble<T, U> {
        /**
         * 表示一个返回 0.0d 双精度浮点值的常量实例。
         */
        ToDouble<?, ?, ?> EMPTY = (t, u) -> BasicConstant.DOUBLE_ZERO;

        /**
         * 获取一个返回 0.0d 双精度浮点值的 ToDouble 实例。
         *
         * @return 一个返回 0.0d 双精度浮点值的 ToDouble 实例
         */
        static <T, U, E extends Exception> ToDouble<T, U, E> empty() {
            return (ToDouble<T, U, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定双精度浮点值的 ToDouble 实例。
         *
         * @param value 要返回的固定双精度浮点值
         * @return 一个总是返回给定双精度浮点值的 ToDouble 实例
         */
        static <T, U, E extends Exception> ToDouble<T, U, E> constant(double value) {
            return (t, u) -> value;
        }

        /**
         * 应用函数操作，并可能抛出异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 双精度浮点型的运算结果
         * @throws E 指定的异常类型
         */
        double applyThrow(T t, U u) throws E;

        /**
         * 默认实现，将 applyThrow 方法包装为不抛出受检异常的方法。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @return 双精度浮点型的运算结果
         */
        @Override
        default double apply(T t, U u) {
            try {
                return applyThrow(t, u);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }
}
