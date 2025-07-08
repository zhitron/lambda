package com.github.zhitron.lambda;

/**
 * TwiceParameterThrow 是 TwiceParameter 接口的扩展，用于定义可抛出异常的两个参数函数式接口。
 * 它为每种返回类型提供了带有异常处理的 applyThrow 方法，并默认将检查异常包装成运行时异常。
 *
 * @author zhitron
 */
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
