package com.github.zhitron.lambda;

/**
 * 非参数函数式接口集合，提供多种返回类型的无参函数接口
 * 该接口作为一组函数式接口的容器，支持不同基本类型和通用类型的无参函数定义
 *
 * @author zhitron
 */
public interface NonParameter {

    /**
     * 通用函数式接口，表示一个无参数且有返回值的函数
     *
     * @param <R> 返回值的泛型类型
     */
    @FunctionalInterface
    interface ToAny<R> {
        /**
         * 执行函数逻辑并返回结果
         *
         * @return 函数执行的返回结果
         */
        R apply();
    }

    /**
     * 表示一个无参数、无返回值的函数
     */
    @FunctionalInterface
    interface ToVoid {
        /**
         * 执行函数逻辑
         */
        void apply();
    }

    /**
     * 表示一个无参数、返回boolean值的函数
     */
    @FunctionalInterface
    interface ToBoolean {
        /**
         * 执行函数逻辑
         *
         * @return boolean 类型的返回结果
         */
        boolean apply();
    }

    /**
     * 表示一个无参数、返回char值的函数
     */
    @FunctionalInterface
    interface ToChar {
        /**
         * 执行函数逻辑
         *
         * @return char 类型的返回结果
         */
        char apply();
    }

    /**
     * 表示一个无参数、返回byte值的函数
     */
    @FunctionalInterface
    interface ToByte {
        /**
         * 执行函数逻辑
         *
         * @return byte 类型的返回结果
         */
        byte apply();
    }

    /**
     * 表示一个无参数、返回short值的函数
     */
    @FunctionalInterface
    interface ToShort {
        /**
         * 执行函数逻辑
         *
         * @return short 类型的返回结果
         */
        short apply();
    }

    /**
     * 表示一个无参数、返回int值的函数
     */
    @FunctionalInterface
    interface ToInt {
        /**
         * 执行函数逻辑
         *
         * @return int 类型的返回结果
         */
        int apply();
    }

    /**
     * 表示一个无参数、返回long值的函数
     */
    @FunctionalInterface
    interface ToLong {
        /**
         * 执行函数逻辑
         *
         * @return long 类型的返回结果
         */
        long apply();
    }

    /**
     * 表示一个无参数、返回float值的函数
     */
    @FunctionalInterface
    interface ToFloat {
        /**
         * 执行函数逻辑
         *
         * @return float 类型的返回结果
         */
        float apply();
    }

    /**
     * 表示一个无参数、返回double值的函数
     */
    @FunctionalInterface
    interface ToDouble {
        /**
         * 执行函数逻辑
         *
         * @return double 类型的返回结果
         */
        double apply();
    }
}
