package com.github.zhitron;

/**
 * 提供基础数据类型的默认值、空数组及对应Class对象的常量接口，用于统一基础类型常量管理，提高代码可读性和维护性。
 *
 * @author zhitron
 */
public interface BasicConstant {

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    boolean BOOLEAN_FALSE = false, BOOLEAN_TRUE = true;
    boolean[] BOOLEAN_EMPTY_ARRAY = {};
    Boolean[] BOOLEAN_OBJECT_EMPTY_ARRAY = {};
    Class<?> BOOLEAN_TYPE = boolean.class, BOOLEAN_ARRAY_TYPE = boolean[].class, BOOLEAN_OBJECT_TYPE = Boolean.class, BOOLEAN_OBJECT_ARRAY_TYPE = Boolean[].class;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    char CHAR_ZERO = '\0';
    char[] EMPTY_CHAR_ARRAY = {};
    Character[] EMPTY_CHARACTER_OBJECT_ARRAY = {};
    Class<?> CHAR_TYPE = char.class, CHAR_ARRAY_TYPE = char[].class, CHAR_OBJECT_TYPE = Character.class, CHAR_OBJECT_ARRAY_TYPE = Character[].class;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    byte BYTE_ZERO = 0;
    byte[] BYTE_EMPTY_ARRAY = {};
    Byte[] BYTE_OBJECT_EMPTY_ARRAY = {};
    Class<?> BYTE_TYPE = byte.class, BYTE_ARRAY_TYPE = byte[].class, BYTE_OBJECT_TYPE = Byte.class, BYTE_OBJECT_ARRAY_TYPE = Byte[].class;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    short SHORT_ZERO = 0;
    short[] SHORT_EMPTY_ARRAY = {};
    Short[] SHORT_OBJECT_EMPTY_ARRAY = {};
    Class<?> SHORT_TYPE = short.class, SHORT_ARRAY_TYPE = short[].class, SHORT_OBJECT_TYPE = Short.class, SHORT_OBJECT_ARRAY_TYPE = Short[].class;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    int INT_ZERO = 0;
    int[] INT_EMPTY_ARRAY = {};
    Integer[] INT_OBJECT_EMPTY_ARRAY = {};
    Class<?> INT_TYPE = int.class, INT_ARRAY_TYPE = int[].class, INT_OBJECT_TYPE = Integer.class, INT_OBJECT_ARRAY_TYPE = Integer[].class;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    long LONG_ZERO = 0L;
    long[] LONG_EMPTY_ARRAY = {};
    Long[] LONG_OBJECT_EMPTY_ARRAY = {};
    Class<?> LONG_TYPE = long.class, LONG_ARRAY_TYPE = long[].class, LONG_OBJECT_TYPE = Long.class, LONG_OBJECT_ARRAY_TYPE = Long[].class;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    float FLOAT_ZERO = 0.0f;
    float[] FLOAT_EMPTY_ARRAY = {};
    Float[] FLOAT_OBJECT_EMPTY_ARRAY = {};
    Class<?> FLOAT_TYPE = float.class, FLOAT_ARRAY_TYPE = float[].class, FLOAT_OBJECT_TYPE = Float.class, FLOAT_OBJECT_ARRAY_TYPE = Float[].class;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    double DOUBLE_ZERO = 0.0d;
    double[] DOUBLE_EMPTY_ARRAY = {};
    Double[] DOUBLE_OBJECT_EMPTY_ARRAY = {};
    Class<?> DOUBLE_TYPE = double.class, DOUBLE_ARRAY_TYPE = double[].class, DOUBLE_OBJECT_TYPE = Double.class, DOUBLE_OBJECT_ARRAY_TYPE = Double[].class;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    Object[] OBJECT_EMPTY_ARRAY = {};
    Class<?> OBJECT_TYPE = Object.class, OBJECT_ARRAY_TYPE = Object[].class;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    Class<?>[] CLASS_EMPTY_ARRAY = {};
    Class<?> CLASS_TYPE = Class.class, CLASS_ARRAY_TYPE = Class[].class;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    String[] STRING_EMPTY_ARRAY = {};
    Class<?> STRING_TYPE = String.class, STRING_ARRAY_TYPE = String[].class;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

}