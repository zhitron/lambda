package com.github.zhitron.lambda;

import com.github.zhitron.BasicConstant;

/**
 * 非参数函数式接口集合，提供多种返回类型的无参函数接口
 * 该接口作为一组函数式接口的容器，支持不同基本类型和通用类型的无参函数定义
 *
 * @author zhitron
 */
@SuppressWarnings("unchecked")
public interface NonParameter {
    /**
     * 通用函数式接口，表示一个无参数且有返回值的函数
     *
     * @param <R> 返回值的泛型类型
     */
    @FunctionalInterface
    interface ToAny<R> {
        /**
         * 一个始终返回 null 的空实现。
         */
        ToAny<?> EMPTY = () -> null;

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToAny 实例
         */
        static <R> ToAny<R> empty() {
            return (ToAny<R>) EMPTY;
        }

        /**
         * 创建一个始终返回指定常量值的函数式接口。
         *
         * @param value 常量值
         * @return 返回指定常量值的函数式接口
         */
        static <R> ToAny<R> constant(R value) {
            return () -> value;
        }

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
         * 表示一个空操作的常量实例，不执行任何操作。
         */
        ToVoid EMPTY = () -> {
        };

        /**
         * 获取一个空的函数式接口实例。
         *
         * @return 空的 ToVoid 实例
         */
        static ToVoid empty() {
            return EMPTY;
        }

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
         * 始终返回 true 的常量实例。
         */
        ToBoolean TRUE = () -> BasicConstant.BOOLEAN_TRUE;
        /**
         * 始终返回 false 的常量实例。
         */
        ToBoolean FALSE = () -> BasicConstant.BOOLEAN_TRUE;

        /**
         * 创建一个返回指定布尔值的函数式接口。
         *
         * @param value 确定返回 true 还是 false 的布尔值
         * @return 根据给定布尔值确定的 ToBoolean 实例
         */
        static ToBoolean constant(boolean value) {
            return value ? TRUE : FALSE;
        }

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
         * 表示一个返回 '\0' 字符的常量实例。
         */
        ToChar EMPTY = () -> BasicConstant.CHAR_ZERO;

        /**
         * 获取一个返回 '\0' 字符的 ToChar 实例。
         *
         * @return 一个返回 '\0' 字符的 ToChar 实例
         */
        static ToChar empty() {
            return EMPTY;
        }

        /**
         * 创建一个总是返回给定字符的 ToChar 实例。
         *
         * @param value 要返回的固定字符
         * @return 一个总是返回给定字符的 ToChar 实例
         */
        static ToChar constant(char value) {
            return () -> value;
        }

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
         * 表示一个返回 0 字节值的常量实例。
         */
        ToByte EMPTY = () -> BasicConstant.BYTE_ZERO;

        /**
         * 获取一个返回 0 字节值的 ToByte 实例。
         *
         * @return 一个返回 0 字节值的 ToByte 实例
         */
        static ToByte empty() {
            return EMPTY;
        }

        /**
         * 创建一个总是返回给定字节值的 ToByte 实例。
         *
         * @param value 要返回的固定字节值
         * @return 一个总是返回给定字节值的 ToByte 实例
         */
        static ToByte constant(byte value) {
            return () -> value;
        }

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
         * 表示一个返回 0 短整数值的常量实例。
         */
        ToShort EMPTY = () -> BasicConstant.SHORT_ZERO;

        /**
         * 获取一个返回 0 短整数值的 ToShort 实例。
         *
         * @return 一个返回 0 短整数值的 ToShort 实例
         */
        static ToShort empty() {
            return EMPTY;
        }

        /**
         * 创建一个总是返回给定短整数值的 ToShort 实例。
         *
         * @param value 要返回的固定短整数值
         * @return 一个总是返回给定短整数值的 ToShort 实例
         */
        static ToShort constant(short value) {
            return () -> value;
        }

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
         * 表示一个返回 0 整数值的常量实例。
         */
        ToInt EMPTY = () -> BasicConstant.INT_ZERO;

        /**
         * 获取一个返回 0 整数值的 ToInt 实例。
         *
         * @return 一个返回 0 整数值的 ToInt 实例
         */
        static ToInt empty() {
            return EMPTY;
        }

        /**
         * 创建一个总是返回给定整数值的 ToInt 实例。
         *
         * @param value 要返回的固定整数值
         * @return 一个总是返回给定整数值的 ToInt 实例
         */
        static ToInt constant(int value) {
            return () -> value;
        }

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
         * 表示一个返回 0 长整数值的常量实例。
         */
        ToLong EMPTY = () -> BasicConstant.LONG_ZERO;

        /**
         * 获取一个返回 0 长整数值的 ToLong 实例。
         *
         * @return 一个返回 0 长整数值的 ToLong 实例
         */
        static ToLong empty() {
            return EMPTY;
        }

        /**
         * 创建一个总是返回给定长整数值的 ToLong 实例。
         *
         * @param value 要返回的固定长整数值
         * @return 一个总是返回给定长整数值的 ToLong 实例
         */
        static ToLong constant(long value) {
            return () -> value;
        }

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
         * 表示一个返回 0.0f 浮点值的常量实例。
         */
        ToFloat EMPTY = () -> BasicConstant.FLOAT_ZERO;

        /**
         * 获取一个返回 0.0f 浮点值的 ToFloat 实例。
         *
         * @return 一个返回 0.0f 浮点值的 ToFloat 实例
         */
        static ToFloat empty() {
            return EMPTY;
        }

        /**
         * 创建一个总是返回给定浮点值的 ToFloat 实例。
         *
         * @param value 要返回的固定浮点值
         * @return 一个总是返回给定浮点值的 ToFloat 实例
         */
        static ToFloat constant(float value) {
            return () -> value;
        }

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
         * 表示一个返回 0.0d 双精度浮点值的常量实例。
         */
        ToDouble EMPTY = () -> BasicConstant.DOUBLE_ZERO;

        /**
         * 获取一个返回 0.0d 双精度浮点值的 ToDouble 实例。
         *
         * @return 一个返回 0.0d 双精度浮点值的 ToDouble 实例
         */
        static ToDouble empty() {
            return EMPTY;
        }

        /**
         * 创建一个总是返回给定双精度浮点值的 ToDouble 实例。
         *
         * @param value 要返回的固定双精度浮点值
         * @return 一个总是返回给定双精度浮点值的 ToDouble 实例
         */
        static ToDouble constant(double value) {
            return () -> value;
        }

        /**
         * 执行函数逻辑
         *
         * @return double 类型的返回结果
         */
        double apply();
    }
}
