package com.github.zhitron.lambda;

import com.github.zhitron.BasicConstant;

/**
 * TripleParameterThrow 是 TripleParameter 接口的扩展，用于定义可抛出异常的三个参数函数式接口。
 * 它为每种返回类型提供了带有异常处理的 applyThrow 方法，并默认将检查异常包装成运行时异常。
 *
 * @author zhitron
 */
@SuppressWarnings("unchecked")
public interface TripleParameterThrow extends TripleParameter {
    /**
     * ToAny 表示接受三个参数并返回泛型结果，同时允许抛出检查性异常的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <R> 返回值类型
     * @param <E> 抛出的异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToAny<T, U, V, R, E extends Exception> extends TripleParameter.ToAny<T, U, V, R> {
        /**
         * 一个始终返回 null 的空实现。
         */
        ToAny<?, ?, ?, ?, ?> EMPTY = (t, u, v) -> null;

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToAny 实例
         */
        static <T, U, V, R, E extends Exception> ToAny<T, U, V, R, E> empty() {
            return (ToAny<T, U, V, R, E>) EMPTY;
        }

        /**
         * 创建一个始终返回指定常量值的函数式接口。
         *
         * @param value 常量值
         * @return 返回指定常量值的函数式接口
         */
        static <T, U, V, R, E extends Exception> ToAny<T, U, V, R, E> constant(R value) {
            return (t, u, v) -> value;
        }

        /**
         * 应用操作，接受三个参数并返回一个结果，可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return 操作结果
         * @throws E 自定义异常
         */
        R applyThrow(T t, U u, V v) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow 方法，并捕获所有异常将其包装成 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return 操作结果
         */
        @Override
        default R apply(T t, U u, V v) {
            try {
                return applyThrow(t, u, v);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToVoid 表示接受三个参数且无返回值，同时允许抛出检查性异常的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <E> 抛出的异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToVoid<T, U, V, E extends Exception> extends TripleParameter.ToVoid<T, U, V> {
        /**
         * 表示一个空操作的常量实例，不执行任何操作。
         */
        ToVoid<?, ?, ?, ?> EMPTY = (t, u, v) -> {
        };

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToVoid 实例
         */
        static <T, U, V, E extends Exception> ToVoid<T, U, V, E> empty() {
            return (ToVoid<T, U, V, E>) EMPTY;
        }

        /**
         * 应用操作，接受三个参数且不返回任何结果，可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @throws E 自定义异常
         */
        void applyThrow(T t, U u, V v) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow 方法，并捕获所有异常将其包装成 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         */
        @Override
        default void apply(T t, U u, V v) {
            try {
                applyThrow(t, u, v);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToBoolean 表示接受三个参数并返回 boolean 结果，同时允许抛出检查性异常的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <E> 抛出的异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToBoolean<T, U, V, E extends Exception> extends TripleParameter.ToBoolean<T, U, V> {
        /**
         * 始终返回 true 的常量实例。
         */
        ToBoolean<?, ?, ?, ?> TRUE = (t, u, v) -> BasicConstant.BOOLEAN_TRUE;
        /**
         * 始终返回 false 的常量实例。
         */
        ToBoolean<?, ?, ?, ?> FALSE = (t, u, v) -> BasicConstant.BOOLEAN_TRUE;

        /**
         * 创建一个返回指定布尔值的函数式接口。
         *
         * @param value 确定返回 true 还是 false 的布尔值
         * @return 根据给定布尔值确定的 ToBoolean 实例
         */
        static <T, U, V, E extends Exception> ToBoolean<T, U, V, E> constant(boolean value) {
            return (ToBoolean<T, U, V, E>) (value ? TRUE : FALSE);
        }

        /**
         * 应用操作，接受三个参数并返回 boolean 类型结果，可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return boolean 类型结果
         * @throws E 自定义异常
         */
        boolean applyThrow(T t, U u, V v) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow 方法，并捕获所有异常将其包装成 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return boolean 类型结果
         */
        @Override
        default boolean apply(T t, U u, V v) {
            try {
                return applyThrow(t, u, v);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToChar 表示接受三个参数并返回 char 结果，同时允许抛出检查性异常的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <E> 抛出的异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToChar<T, U, V, E extends Exception> extends TripleParameter.ToChar<T, U, V> {
        /**
         * 表示一个返回 '\0' 字符的常量实例。
         */
        ToChar<?, ?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.CHAR_ZERO;

        /**
         * 获取一个返回 '\0' 字符的 ToChar 实例。
         *
         * @return 一个返回 '\0' 字符的 ToChar 实例
         */
        static <T, U, V, E extends Exception> ToChar<T, U, V, E> empty() {
            return (ToChar<T, U, V, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字符的 ToChar 实例。
         *
         * @param value 要返回的固定字符
         * @return 一个总是返回给定字符的 ToChar 实例
         */
        static <T, U, V, E extends Exception> ToChar<T, U, V, E> constant(char value) {
            return (t, u, v) -> value;
        }

        /**
         * 应用操作，接受三个参数并返回 char 类型结果，可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return char 类型结果
         * @throws E 自定义异常
         */
        char applyThrow(T t, U u, V v) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow 方法，并捕获所有异常将其包装成 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return char 类型结果
         */
        @Override
        default char apply(T t, U u, V v) {
            try {
                return applyThrow(t, u, v);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToByte 表示接受三个参数并返回 byte 结果，同时允许抛出检查性异常的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <E> 抛出的异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToByte<T, U, V, E extends Exception> extends TripleParameter.ToByte<T, U, V> {
        /**
         * 表示一个返回 0 字节值的常量实例。
         */
        ToByte<?, ?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.BYTE_ZERO;

        /**
         * 获取一个返回 0 字节值的 ToByte 实例。
         *
         * @return 一个返回 0 字节值的 ToByte 实例
         */
        static <T, U, V, E extends Exception> ToByte<T, U, V, E> empty() {
            return (ToByte<T, U, V, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字节值的 ToByte 实例。
         *
         * @param value 要返回的固定字节值
         * @return 一个总是返回给定字节值的 ToByte 实例
         */
        static <T, U, V, E extends Exception> ToByte<T, U, V, E> constant(byte value) {
            return (t, u, v) -> value;
        }

        /**
         * 应用操作，接受三个参数并返回 byte 类型结果，可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return byte 类型结果
         * @throws E 自定义异常
         */
        byte applyThrow(T t, U u, V v) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow 方法，并捕获所有异常将其包装成 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return byte 类型结果
         */
        @Override
        default byte apply(T t, U u, V v) {
            try {
                return applyThrow(t, u, v);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToShort 表示接受三个参数并返回 short 结果，同时允许抛出检查性异常的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <E> 抛出的异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToShort<T, U, V, E extends Exception> extends TripleParameter.ToShort<T, U, V> {
        /**
         * 表示一个返回 0 短整数值的常量实例。
         */
        ToShort<?, ?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.SHORT_ZERO;

        /**
         * 获取一个返回 0 短整数值的 ToShort 实例。
         *
         * @return 一个返回 0 短整数值的 ToShort 实例
         */
        static <T, U, V, E extends Exception> ToShort<T, U, V, E> empty() {
            return (ToShort<T, U, V, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定短整数值的 ToShort 实例。
         *
         * @param value 要返回的固定短整数值
         * @return 一个总是返回给定短整数值的 ToShort 实例
         */
        static <T, U, V, E extends Exception> ToShort<T, U, V, E> constant(short value) {
            return (t, u, v) -> value;
        }

        /**
         * 应用操作，接受三个参数并返回 short 类型结果，可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return short 类型结果
         * @throws E 自定义异常
         */
        short applyThrow(T t, U u, V v) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow 方法，并捕获所有异常将其包装成 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return short 类型结果
         */
        @Override
        default short apply(T t, U u, V v) {
            try {
                return applyThrow(t, u, v);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToInt 表示接受三个参数并返回 int 结果，同时允许抛出检查性异常的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <E> 抛出的异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToInt<T, U, V, E extends Exception> extends TripleParameter.ToInt<T, U, V> {
        /**
         * 表示一个返回 0 整数值的常量实例。
         */
        ToInt<?, ?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.INT_ZERO;

        /**
         * 获取一个返回 0 整数值的 ToInt 实例。
         *
         * @return 一个返回 0 整数值的 ToInt 实例
         */
        static <T, U, V, E extends Exception> ToInt<T, U, V, E> empty() {
            return (ToInt<T, U, V, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定整数值的 ToInt 实例。
         *
         * @param value 要返回的固定整数值
         * @return 一个总是返回给定整数值的 ToInt 实例
         */
        static <T, U, V, E extends Exception> ToInt<T, U, V, E> constant(int value) {
            return (t, u, v) -> value;
        }

        /**
         * 应用操作，接受三个参数并返回 int 类型结果，可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return int 类型结果
         * @throws E 自定义异常
         */
        int applyThrow(T t, U u, V v) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow 方法，并捕获所有异常将其包装成 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return int 类型结果
         */
        @Override
        default int apply(T t, U u, V v) {
            try {
                return applyThrow(t, u, v);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToLong 表示接受三个参数并返回 long 结果，同时允许抛出检查性异常的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <E> 抛出的异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToLong<T, U, V, E extends Exception> extends TripleParameter.ToLong<T, U, V> {
        /**
         * 表示一个返回 0 长整数值的常量实例。
         */
        ToLong<?, ?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.LONG_ZERO;

        /**
         * 获取一个返回 0 长整数值的 ToLong 实例。
         *
         * @return 一个返回 0 长整数值的 ToLong 实例
         */
        static <T, U, V, E extends Exception> ToLong<T, U, V, E> empty() {
            return (ToLong<T, U, V, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定长整数值的 ToLong 实例。
         *
         * @param value 要返回的固定长整数值
         * @return 一个总是返回给定长整数值的 ToLong 实例
         */
        static <T, U, V, E extends Exception> ToLong<T, U, V, E> constant(long value) {
            return (t, u, v) -> value;
        }

        /**
         * 应用操作，接受三个参数并返回 long 类型结果，可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return long 类型结果
         * @throws E 自定义异常
         */
        long applyThrow(T t, U u, V v) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow 方法，并捕获所有异常将其包装成 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return long 类型结果
         */
        @Override
        default long apply(T t, U u, V v) {
            try {
                return applyThrow(t, u, v);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToFloat 表示接受三个参数并返回 float 结果，同时允许抛出检查性异常的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <E> 抛出的异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToFloat<T, U, V, E extends Exception> extends TripleParameter.ToFloat<T, U, V> {
        /**
         * 表示一个返回 0.0f 浮点值的常量实例。
         */
        ToFloat<?, ?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.FLOAT_ZERO;

        /**
         * 获取一个返回 0.0f 浮点值的 ToFloat 实例。
         *
         * @return 一个返回 0.0f 浮点值的 ToFloat 实例
         */
        static <T, U, V, E extends Exception> ToFloat<T, U, V, E> empty() {
            return (ToFloat<T, U, V, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定浮点值的 ToFloat 实例。
         *
         * @param value 要返回的固定浮点值
         * @return 一个总是返回给定浮点值的 ToFloat 实例
         */
        static <T, U, V, E extends Exception> ToFloat<T, U, V, E> constant(float value) {
            return (t, u, v) -> value;
        }

        /**
         * 应用操作，接受三个参数并返回 float 类型结果，可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return float 类型结果
         * @throws E 自定义异常
         */
        float applyThrow(T t, U u, V v) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow 方法，并捕获所有异常将其包装成 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return float 类型结果
         */
        @Override
        default float apply(T t, U u, V v) {
            try {
                return applyThrow(t, u, v);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToDouble 表示接受三个参数并返回 double 结果，同时允许抛出检查性异常的函数式接口。
     *
     * @param <T> 第一个参数类型
     * @param <U> 第二个参数类型
     * @param <V> 第三个参数类型
     * @param <E> 抛出的异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToDouble<T, U, V, E extends Exception> extends TripleParameter.ToDouble<T, U, V> {
        /**
         * 表示一个返回 0.0d 双精度浮点值的常量实例。
         */
        ToDouble<?, ?, ?, ?> EMPTY = (t, u, v) -> BasicConstant.DOUBLE_ZERO;

        /**
         * 获取一个返回 0.0d 双精度浮点值的 ToDouble 实例。
         *
         * @return 一个返回 0.0d 双精度浮点值的 ToDouble 实例
         */
        static <T, U, V, E extends Exception> ToDouble<T, U, V, E> empty() {
            return (ToDouble<T, U, V, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定双精度浮点值的 ToDouble 实例。
         *
         * @param value 要返回的固定双精度浮点值
         * @return 一个总是返回给定双精度浮点值的 ToDouble 实例
         */
        static <T, U, V, E extends Exception> ToDouble<T, U, V, E> constant(double value) {
            return (t, u, v) -> value;
        }

        /**
         * 应用操作，接受三个参数并返回 double 类型结果，可能抛出指定类型的异常。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return double 类型结果
         * @throws E 自定义异常
         */
        double applyThrow(T t, U u, V v) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow 方法，并捕获所有异常将其包装成 RuntimeException。
         *
         * @param t 第一个参数
         * @param u 第二个参数
         * @param v 第三个参数
         * @return double 类型结果
         */
        @Override
        default double apply(T t, U u, V v) {
            try {
                return applyThrow(t, u, v);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }
}