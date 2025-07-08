package com.github.zhitron.lambda;

/**
 * SingleParameterThrow 是 SingleParameter 接口的扩展，用于定义可抛出异常的一个参数函数式接口。
 * 它为每种返回类型提供了带有异常处理的 applyThrow 方法，并默认将检查异常包装成运行时异常。
 *
 * @author zhitron
 */
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
