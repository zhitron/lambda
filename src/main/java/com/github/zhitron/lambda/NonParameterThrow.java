package com.github.zhitron.lambda;

import com.github.zhitron.BasicConstant;

/**
 * NonParameterThrow 是 NonParameter 接口的扩展，用于定义可抛出异常的无参函函数式接口。
 * 它为每种返回类型提供了带有异常处理的 applyThrow 方法，并默认将检查异常包装成运行时异常。
 *
 * @author zhitron
 */
@SuppressWarnings("unchecked")
public interface NonParameterThrow extends NonParameter {
    /**
     * 通用函数式接口，表示一个无参数且有返回值的函数，支持泛型返回类型和异常抛出
     *
     * @param <R> 返回值的泛型类型
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToAny<R, E extends Exception> extends NonParameter.ToAny<R> {
        /**
         * 一个始终返回 null 的空实现。
         */
        ToAny<?, ?> EMPTY = () -> null;

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToAny 实例
         */
        static <R, E extends Exception> ToAny<R, E> empty() {
            return (ToAny<R, E>) EMPTY;
        }

        /**
         * 创建一个始终返回指定常量值的函数式接口。
         *
         * @param value 常量值
         * @return 返回指定常量值的函数式接口
         */
        static <R, E extends Exception> ToAny<R, E> constant(R value) {
            return () -> value;
        }

        /**
         * 执行函数逻辑并返回结果，可能抛出异常
         *
         * @return 函数执行的返回结果
         * @throws E 自定义的异常类型
         */
        R applyThrow() throws E;

        /**
         * 默认实现方法，包装异常为运行时异常
         *
         * @return 函数执行的返回结果
         */
        @Override
        default R apply() {
            try {
                return applyThrow();
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * 表示一个无参数、无返回值的函数，支持异常抛出
     *
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToVoid<E extends Exception> extends NonParameter.ToVoid {
        /**
         * 表示一个空操作的常量实例，不执行任何操作。
         */
        ToVoid<?> EMPTY = () -> {
        };

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToVoid 实例
         */
        static <E extends Exception> ToVoid<E> empty() {
            return (ToVoid<E>) EMPTY;
        }

        /**
         * 执行函数逻辑，可能抛出异常
         *
         * @throws E 自定义的异常类型
         */
        void applyThrow() throws E;

        /**
         * 默认实现方法，包装异常为运行时异常
         */
        @Override
        default void apply() {
            try {
                applyThrow();
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * 表示一个无参数、返回boolean值的函数，支持异常抛出
     *
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToBoolean<E extends Exception> extends NonParameter.ToBoolean {
        /**
         * 始终返回 true 的常量实例。
         */
        ToBoolean<?> TRUE = () -> BasicConstant.BOOLEAN_TRUE;
        /**
         * 始终返回 false 的常量实例。
         */
        ToBoolean<?> FALSE = () -> BasicConstant.BOOLEAN_TRUE;

        /**
         * 创建一个返回指定布尔值的函数式接口。
         *
         * @param value 确定返回 true 还是 false 的布尔值
         * @return 根据给定布尔值确定的 ToBoolean 实例
         */
        static <E extends Exception> ToBoolean<E> constant(boolean value) {
            return (ToBoolean<E>) (value ? TRUE : FALSE);
        }

        /**
         * 执行函数逻辑并返回布尔值，可能抛出异常
         *
         * @return boolean 类型的返回结果
         * @throws E 自定义的异常类型
         */
        boolean applyThrow() throws E;

        /**
         * 默认实现方法，包装异常为运行时异常
         *
         * @return boolean 类型的返回结果
         */
        @Override
        default boolean apply() {
            try {
                return applyThrow();
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * 表示一个无参数、返回char值的函数，支持异常抛出
     *
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToChar<E extends Exception> extends NonParameter.ToChar {
        /**
         * 表示一个返回 '\0' 字符的常量实例。
         */
        ToChar<?> EMPTY = () -> BasicConstant.CHAR_ZERO;

        /**
         * 获取一个返回 '\0' 字符的 ToChar 实例。
         *
         * @return 一个返回 '\0' 字符的 ToChar 实例
         */
        static <E extends Exception> ToChar<E> empty() {
            return (ToChar<E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字符的 ToChar 实例。
         *
         * @param value 要返回的固定字符
         * @return 一个总是返回给定字符的 ToChar 实例
         */
        static <E extends Exception> ToChar<E> constant(char value) {
            return () -> value;
        }

        /**
         * 执行函数逻辑并返回字符值，可能抛出异常
         *
         * @return char 类型的返回结果
         * @throws E 自定义的异常类型
         */
        char applyThrow() throws E;

        /**
         * 默认实现方法，包装异常为运行时异常
         *
         * @return char 类型的返回结果
         */
        @Override
        default char apply() {
            try {
                return applyThrow();
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * 表示一个无参数、返回byte值的函数，支持异常抛出
     *
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToByte<E extends Exception> extends NonParameter.ToByte {
        /**
         * 表示一个返回 0 字节值的常量实例。
         */
        ToByte<?> EMPTY = () -> BasicConstant.BYTE_ZERO;

        /**
         * 获取一个返回 0 字节值的 ToByte 实例。
         *
         * @return 一个返回 0 字节值的 ToByte 实例
         */
        static <E extends Exception> ToByte<E> empty() {
            return (ToByte<E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定字节值的 ToByte 实例。
         *
         * @param value 要返回的固定字节值
         * @return 一个总是返回给定字节值的 ToByte 实例
         */
        static <E extends Exception> ToByte<E> constant(byte value) {
            return () -> value;
        }

        /**
         * 执行函数逻辑并返回字节值，可能抛出异常
         *
         * @return byte 类型的返回结果
         * @throws E 自定义的异常类型
         */
        byte applyThrow() throws E;

        /**
         * 默认实现方法，包装异常为运行时异常
         *
         * @return byte 类型的返回结果
         */
        @Override
        default byte apply() {
            try {
                return applyThrow();
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * 表示一个无参数、返回short值的函数，支持异常抛出
     *
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToShort<E extends Exception> extends NonParameter.ToShort {
        /**
         * 表示一个返回 0 短整数值的常量实例。
         */
        ToShort<?> EMPTY = () -> BasicConstant.SHORT_ZERO;

        /**
         * 获取一个返回 0 短整数值的 ToShort 实例。
         *
         * @return 一个返回 0 短整数值的 ToShort 实例
         */
        static <E extends Exception> ToShort<E> empty() {
            return (ToShort<E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定短整数值的 ToShort 实例。
         *
         * @param value 要返回的固定短整数值
         * @return 一个总是返回给定短整数值的 ToShort 实例
         */
        static <E extends Exception> ToShort<E> constant(short value) {
            return () -> value;
        }

        /**
         * 执行函数逻辑并返回短整数值，可能抛出异常
         *
         * @return short 类型的返回结果
         * @throws E 自定义的异常类型
         */
        short applyThrow() throws E;

        /**
         * 默认实现方法，包装异常为运行时异常
         *
         * @return short 类型的返回结果
         */
        @Override
        default short apply() {
            try {
                return applyThrow();
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * 表示一个无参数、返回int值的函数，支持异常抛出
     *
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToInt<E extends Exception> extends NonParameter.ToInt {
        /**
         * 表示一个返回 0 整数值的常量实例。
         */
        ToInt<?> EMPTY = () -> BasicConstant.INT_ZERO;

        /**
         * 获取一个返回 0 整数值的 ToInt 实例。
         *
         * @return 一个返回 0 整数值的 ToInt 实例
         */
        static <E extends Exception> ToInt<E> empty() {
            return (ToInt<E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定整数值的 ToInt 实例。
         *
         * @param value 要返回的固定整数值
         * @return 一个总是返回给定整数值的 ToInt 实例
         */
        static <E extends Exception> ToInt<E> constant(int value) {
            return () -> value;
        }

        /**
         * 执行函数逻辑并返回整数值，可能抛出异常
         *
         * @return int 类型的返回结果
         * @throws E 自定义的异常类型
         */
        int applyThrow() throws E;

        /**
         * 默认实现方法，包装异常为运行时异常
         *
         * @return int 类型的返回结果
         */
        @Override
        default int apply() {
            try {
                return applyThrow();
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * 表示一个无参数、返回long值的函数，支持异常抛出
     *
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToLong<E extends Exception> extends NonParameter.ToLong {
        /**
         * 表示一个返回 0 长整数值的常量实例。
         */
        ToLong<?> EMPTY = () -> BasicConstant.LONG_ZERO;

        /**
         * 获取一个返回 0 长整数值的 ToLong 实例。
         *
         * @return 一个返回 0 长整数值的 ToLong 实例
         */
        static <E extends Exception> ToLong<E> empty() {
            return (ToLong<E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定长整数值的 ToLong 实例。
         *
         * @param value 要返回的固定长整数值
         * @return 一个总是返回给定长整数值的 ToLong 实例
         */
        static <E extends Exception> ToLong<E> constant(long value) {
            return () -> value;
        }

        /**
         * 执行函数逻辑并返回长整数值，可能抛出异常
         *
         * @return long 类型的返回结果
         * @throws E 自定义的异常类型
         */
        long applyThrow() throws E;

        /**
         * 默认实现方法，包装异常为运行时异常
         *
         * @return long 类型的返回结果
         */
        @Override
        default long apply() {
            try {
                return applyThrow();
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * 表示一个无参数、返回float值的函数，支持异常抛出
     *
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToFloat<E extends Exception> extends NonParameter.ToFloat {
        /**
         * 表示一个返回 0.0f 浮点值的常量实例。
         */
        ToFloat<?> EMPTY = () -> BasicConstant.FLOAT_ZERO;

        /**
         * 获取一个返回 0.0f 浮点值的 ToFloat 实例。
         *
         * @return 一个返回 0.0f 浮点值的 ToFloat 实例
         */
        static <E extends Exception> ToFloat<E> empty() {
            return (ToFloat<E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定浮点值的 ToFloat 实例。
         *
         * @param value 要返回的固定浮点值
         * @return 一个总是返回给定浮点值的 ToFloat 实例
         */
        static <E extends Exception> ToFloat<E> constant(float value) {
            return () -> value;
        }

        /**
         * 执行函数逻辑并返回浮点数值，可能抛出异常
         *
         * @return float 类型的返回结果
         * @throws E 自定义的异常类型
         */
        float applyThrow() throws E;

        /**
         * 默认实现方法，包装异常为运行时异常
         *
         * @return float 类型的返回结果
         */
        @Override
        default float apply() {
            try {
                return applyThrow();
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }

    /**
     * 表示一个无参数、返回double值的函数，支持异常抛出
     *
     * @param <E> 抛出的异常类型
     */
    @FunctionalInterface
    interface ToDouble<E extends Exception> extends NonParameter.ToDouble {
        /**
         * 表示一个返回 0.0d 双精度浮点值的常量实例。
         */
        ToDouble<?> EMPTY = () -> BasicConstant.DOUBLE_ZERO;

        /**
         * 获取一个返回 0.0d 双精度浮点值的 ToDouble 实例。
         *
         * @return 一个返回 0.0d 双精度浮点值的 ToDouble 实例
         */
        static <E extends Exception> ToDouble<E> empty() {
            return (ToDouble<E>) EMPTY;
        }

        /**
         * 创建一个总是返回给定双精度浮点值的 ToDouble 实例。
         *
         * @param value 要返回的固定双精度浮点值
         * @return 一个总是返回给定双精度浮点值的 ToDouble 实例
         */
        static <E extends Exception> ToDouble<E> constant(double value) {
            return () -> value;
        }

        /**
         * 执行函数逻辑并返回双精度浮点数值，可能抛出异常
         *
         * @return double 类型的返回结果
         * @throws E 自定义的异常类型
         */
        double applyThrow() throws E;

        /**
         * 默认实现方法，包装异常为运行时异常
         *
         * @return double 类型的返回结果
         */
        @Override
        default double apply() {
            try {
                return applyThrow();
            } catch (Exception e) {
                throw new RuntimeException("The lambda function execution appears exception", e);
            }
        }
    }
}
