package com.github.zhitron.lambda;

/**
 * NonParameterThrow 是 NonParameter 接口的扩展，用于定义可抛出异常的无参函函数式接口。
 * 它为每种返回类型提供了带有异常处理的 applyThrow 方法，并默认将检查异常包装成运行时异常。
 *
 * @author zhitron
 */
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
