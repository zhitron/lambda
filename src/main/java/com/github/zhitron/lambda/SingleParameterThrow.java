package com.github.zhitron.lambda;

import com.github.zhitron.BasicConstant;

/**
 * SingleParameterThrow 是 SingleParameter 接口的扩展，用于定义可抛出异常的一个参数函数式接口。
 * 它为每种返回类型提供了带有异常处理的 applyThrow 方法，并默认将检查异常包装成运行时异常。
 *
 * @author zhitron
 */
@SuppressWarnings("unchecked")
public interface SingleParameterThrow extends SingleParameter {
    /**
     * ToAny 是一个函数式接口，接受一个泛型参数并返回一个结果，同时允许抛出异常。
     *
     * @param <T> 输入参数类型
     * @param <R> 返回值类型
     * @param <E> 异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToAny<T, R, E extends Exception> extends SingleParameter.ToAny<T, R> {
        /**
         * 一个始终返回 null 的空实现。
         */
        ToAny<?, ?, ?> EMPTY = (t) -> null;

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToAny 实例
         */
        static <T, R, E extends Exception> ToAny<T, R, E> empty() {
            return (ToAny<T, R, E>) EMPTY;
        }

        /**
         * 创建一个始终返回指定常量值的函数式接口。
         *
         * @param value 常量值
         * @return 返回指定常量值的函数式接口
         */
        static <T, R, E extends Exception> ToAny<T, R, E> constant(R value) {
            return (t) -> value;
        }

        /**
         * 对给定的输入执行操作并返回结果，可能抛出异常。
         *
         * @param t 输入参数
         * @return 操作结果
         * @throws E 指定类型的异常
         */
        R applyThrow(T t) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow，并捕获异常后包装为 RuntimeException 抛出。
         *
         * @param t 输入参数
         * @return 操作结果
         */
        @Override
        default R apply(T t) {
            try {
                return applyThrow(t);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToVoid 是一个函数式接口，接受一个泛型参数且不返回结果，同时允许抛出异常。
     *
     * @param <T> 输入参数类型
     * @param <E> 异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToVoid<T, E extends Exception> extends SingleParameter.ToVoid<T> {
        /**
         * 表示一个空操作的常量实例，不执行任何操作。
         */
        ToVoid<?, ?> EMPTY = (t) -> {
        };

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToVoid 实例
         */
        static <T, E extends Exception> ToVoid<T, E> empty() {
            return (ToVoid<T, E>) EMPTY;
        }

        /**
         * 对给定的输入执行操作，无返回值，可能抛出异常。
         *
         * @param t 输入参数
         * @throws E 指定类型的异常
         */
        void applyThrow(T t) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow，并捕获异常后包装为 RuntimeException 抛出。
         *
         * @param t 输入参数
         */
        @Override
        default void apply(T t) {
            try {
                applyThrow(t);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToBoolean 是一个函数式接口，接受一个泛型参数并返回布尔值，同时允许抛出异常。
     *
     * @param <T> 输入参数类型
     * @param <E> 异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToBoolean<T, E extends Exception> extends SingleParameter.ToBoolean<T> {
        /**
         * 始终返回 true 的常量实例。
         */
        ToBoolean<?, ?> TRUE = (t) -> BasicConstant.BOOLEAN_TRUE;
        /**
         * 始终返回 false 的常量实例。
         */
        ToBoolean<?, ?> FALSE = (t) -> BasicConstant.BOOLEAN_TRUE;

        /**
         * 创建一个返回指定布尔值的函数式接口。
         *
         * @param value 确定返回 true 还是 false 的布尔值
         * @return 根据给定布尔值确定的 ToBoolean 实例
         */
        static <T, E extends Exception> ToBoolean<T, E> constant(boolean value) {
            return (ToBoolean<T, E>) (value ? TRUE : FALSE);
        }

        /**
         * 对给定的输入执行判断操作并返回布尔值，可能抛出异常。
         *
         * @param t 输入参数
         * @return 布尔值结果
         * @throws E 指定类型的异常
         */
        boolean applyThrow(T t) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow，并捕获异常后包装为 RuntimeException 抛出。
         *
         * @param t 输入参数
         * @return 布尔值结果
         */
        @Override
        default boolean apply(T t) {
            try {
                return applyThrow(t);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToChar 是一个函数式接口，接受一个泛型参数并返回字符值，同时允许抛出异常。
     *
     * @param <T> 输入参数类型
     * @param <E> 异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToChar<T, E extends Exception> extends SingleParameter.ToChar<T> {
        /**
         * 表示一个返回 '\0' 字符的常量实例。
         */
        ToChar<?, ?> EMPTY = (t) -> BasicConstant.CHAR_ZERO;

        /**
         * 获取一个返回 '\0' 字符的 ToChar 实例。
         *
         * @return 一个返回 '\0' 字符的 ToChar 实例
         */
        static <T, E extends Exception> ToChar<T, E> empty() {
            return (ToChar<T, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字符的 ToChar 实例。
         *
         * @param value 要返回的固定字符
         * @return 一个总是返回给定字符的 ToChar 实例
         */
        static <T, E extends Exception> ToChar<T, E> constant(char value) {
            return (t) -> value;
        }

        /**
         * 对给定的输入执行操作并返回字符值，可能抛出异常。
         *
         * @param t 输入参数
         * @return 字符值结果
         * @throws E 指定类型的异常
         */
        char applyThrow(T t) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow，并捕获异常后包装为 RuntimeException 抛出。
         *
         * @param t 输入参数
         * @return 字符值结果
         */
        @Override
        default char apply(T t) {
            try {
                return applyThrow(t);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToByte 是一个函数式接口，接受一个泛型参数并返回字节值，同时允许抛出异常。
     *
     * @param <T> 输入参数类型
     * @param <E> 异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToByte<T, E extends Exception> extends SingleParameter.ToByte<T> {
        /**
         * 表示一个返回 0 字节值的常量实例。
         */
        ToByte<?, ?> EMPTY = (t) -> BasicConstant.BYTE_ZERO;

        /**
         * 获取一个返回 0 字节值的 ToByte 实例。
         *
         * @return 一个返回 0 字节值的 ToByte 实例
         */
        static <T, E extends Exception> ToByte<T, E> empty() {
            return (ToByte<T, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字节值的 ToByte 实例。
         *
         * @param value 要返回的固定字节值
         * @return 一个总是返回给定字节值的 ToByte 实例
         */
        static <T, E extends Exception> ToByte<T, E> constant(byte value) {
            return (t) -> value;
        }

        /**
         * 对给定的输入执行操作并返回字节值，可能抛出异常。
         *
         * @param t 输入参数
         * @return 字节值结果
         * @throws E 指定类型的异常
         */
        byte applyThrow(T t) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow，并捕获异常后包装为 RuntimeException 抛出。
         *
         * @param t 输入参数
         * @return 字节值结果
         */
        @Override
        default byte apply(T t) {
            try {
                return applyThrow(t);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToShort 是一个函数式接口，接受一个泛型参数并返回短整型值，同时允许抛出异常。
     *
     * @param <T> 输入参数类型
     * @param <E> 异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToShort<T, E extends Exception> extends SingleParameter.ToShort<T> {
        /**
         * 表示一个返回 0 短整数值的常量实例。
         */
        ToShort<?, ?> EMPTY = (t) -> BasicConstant.SHORT_ZERO;

        /**
         * 获取一个返回 0 短整数值的 ToShort 实例。
         *
         * @return 一个返回 0 短整数值的 ToShort 实例
         */
        static <T, E extends Exception> ToShort<T, E> empty() {
            return (ToShort<T, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定短整数值的 ToShort 实例。
         *
         * @param value 要返回的固定短整数值
         * @return 一个总是返回给定短整数值的 ToShort 实例
         */
        static <T, E extends Exception> ToShort<T, E> constant(short value) {
            return (t) -> value;
        }

        /**
         * 对给定的输入执行操作并返回短整型值，可能抛出异常。
         *
         * @param t 输入参数
         * @return 短整型值结果
         * @throws E 指定类型的异常
         */
        short applyThrow(T t) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow，并捕获异常后包装为 RuntimeException 抛出。
         *
         * @param t 输入参数
         * @return 短整型值结果
         */
        @Override
        default short apply(T t) {
            try {
                return applyThrow(t);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToInt 是一个函数式接口，接受一个泛型参数并返回整型值，同时允许抛出异常。
     *
     * @param <T> 输入参数类型
     * @param <E> 异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToInt<T, E extends Exception> extends SingleParameter.ToInt<T> {
        /**
         * 表示一个返回 0 整数值的常量实例。
         */
        ToInt<?, ?> EMPTY = (t) -> BasicConstant.INT_ZERO;

        /**
         * 获取一个返回 0 整数值的 ToInt 实例。
         *
         * @return 一个返回 0 整数值的 ToInt 实例
         */
        static <T, E extends Exception> ToInt<T, E> empty() {
            return (ToInt<T, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定整数值的 ToInt 实例。
         *
         * @param value 要返回的固定整数值
         * @return 一个总是返回给定整数值的 ToInt 实例
         */
        static <T, E extends Exception> ToInt<T, E> constant(int value) {
            return (t) -> value;
        }

        /**
         * 对给定的输入执行操作并返回整型值，可能抛出异常。
         *
         * @param t 输入参数
         * @return 整型值结果
         * @throws E 指定类型的异常
         */
        int applyThrow(T t) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow，并捕获异常后包装为 RuntimeException 抛出。
         *
         * @param t 输入参数
         * @return 整型值结果
         */
        @Override
        default int apply(T t) {
            try {
                return applyThrow(t);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToLong 是一个函数式接口，接受一个泛型参数并返回长整型值，同时允许抛出异常。
     *
     * @param <T> 输入参数类型
     * @param <E> 异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToLong<T, E extends Exception> extends SingleParameter.ToLong<T> {
        /**
         * 表示一个返回 0 长整数值的常量实例。
         */
        ToLong<?, ?> EMPTY = (t) -> BasicConstant.LONG_ZERO;

        /**
         * 获取一个返回 0 长整数值的 ToLong 实例。
         *
         * @return 一个返回 0 长整数值的 ToLong 实例
         */
        static <T, E extends Exception> ToLong<T, E> empty() {
            return (ToLong<T, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定长整数值的 ToLong 实例。
         *
         * @param value 要返回的固定长整数值
         * @return 一个总是返回给定长整数值的 ToLong 实例
         */
        static <T, E extends Exception> ToLong<T, E> constant(long value) {
            return (t) -> value;
        }

        /**
         * 对给定的输入执行操作并返回长整型值，可能抛出异常。
         *
         * @param t 输入参数
         * @return 长整型值结果
         * @throws E 指定类型的异常
         */
        long applyThrow(T t) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow，并捕获异常后包装为 RuntimeException 抛出。
         *
         * @param t 输入参数
         * @return 长整型值结果
         */
        @Override
        default long apply(T t) {
            try {
                return applyThrow(t);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToFloat 是一个函数式接口，接受一个泛型参数并返回浮点型值，同时允许抛出异常。
     *
     * @param <T> 输入参数类型
     * @param <E> 异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToFloat<T, E extends Exception> extends SingleParameter.ToFloat<T> {
        /**
         * 表示一个返回 0.0f 浮点值的常量实例。
         */
        ToFloat<?, ?> EMPTY = (t) -> BasicConstant.FLOAT_ZERO;

        /**
         * 获取一个返回 0.0f 浮点值的 ToFloat 实例。
         *
         * @return 一个返回 0.0f 浮点值的 ToFloat 实例
         */
        static <T, E extends Exception> ToFloat<T, E> empty() {
            return (ToFloat<T, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定浮点值的 ToFloat 实例。
         *
         * @param value 要返回的固定浮点值
         * @return 一个总是返回给定浮点值的 ToFloat 实例
         */
        static <T, E extends Exception> ToFloat<T, E> constant(float value) {
            return (t) -> value;
        }

        /**
         * 对给定的输入执行操作并返回浮点型值，可能抛出异常。
         *
         * @param t 输入参数
         * @return 浮点型值结果
         * @throws E 指定类型的异常
         */
        float applyThrow(T t) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow，并捕获异常后包装为 RuntimeException 抛出。
         *
         * @param t 输入参数
         * @return 浮点型值结果
         */
        @Override
        default float apply(T t) {
            try {
                return applyThrow(t);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * ToDouble 是一个函数式接口，接受一个泛型参数并返回双精度浮点型值，同时允许抛出异常。
     *
     * @param <T> 输入参数类型
     * @param <E> 异常类型，必须是 Exception 的子类
     */
    @FunctionalInterface
    interface ToDouble<T, E extends Exception> extends SingleParameter.ToDouble<T> {
        /**
         * 表示一个返回 0.0d 双精度浮点值的常量实例。
         */
        ToDouble<?, ?> EMPTY = (t) -> BasicConstant.DOUBLE_ZERO;

        /**
         * 获取一个返回 0.0d 双精度浮点值的 ToDouble 实例。
         *
         * @return 一个返回 0.0d 双精度浮点值的 ToDouble 实例
         */
        static <T, E extends Exception> ToDouble<T, E> empty() {
            return (ToDouble<T, E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定双精度浮点值的 ToDouble 实例。
         *
         * @param value 要返回的固定双精度浮点值
         * @return 一个总是返回给定双精度浮点值的 ToDouble 实例
         */
        static <T, E extends Exception> ToDouble<T, E> constant(double value) {
            return (t) -> value;
        }

        /**
         * 对给定的输入执行操作并返回双精度浮点型值，可能抛出异常。
         *
         * @param t 输入参数
         * @return 双精度浮点型值结果
         * @throws E 指定类型的异常
         */
        double applyThrow(T t) throws E;

        /**
         * 默认实现，将 apply 方法委托给 applyThrow，并捕获异常后包装为 RuntimeException 抛出。
         *
         * @param t 输入参数
         * @return 双精度浮点型值结果
         */
        @Override
        default double apply(T t) {
            try {
                return applyThrow(t);
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }
}
