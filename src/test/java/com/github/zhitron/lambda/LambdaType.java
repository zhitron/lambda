package com.github.zhitron.lambda;

/**
 * LambdaType 枚举定义了不同类型的 Lambda 表达式元信息，包括基本数据类型和对象类型。
 * 每个枚举值都包含类型名称、大写形式、返回类型泛型、参数泛型类型以及参数名称。
 *
 * @author zhitron
 */
enum LambdaType {
    /**
     * 测试类型，用于内部测试用途。
     */
    TEST("boolean", "Boolean", null, null, null),

    /**
     * 布尔类型 Lambda 元信息。
     */
    BOOLEAN("boolean", "Boolean", null, null, new String[]{"v1", "v2", "v3", "v4"}),

    /**
     * 字符类型 Lambda 元信息。
     */
    CHAR("char", "Char", null, null, new String[]{"v1", "v2", "v3", "v4"}),

    /**
     * 字节类型 Lambda 元信息。
     */
    BYTE("byte", "Byte", null, null, new String[]{"v1", "v2", "v3", "v4"}),

    /**
     * 短整型 Lambda 元信息。
     */
    SHORT("short", "Short", null, null, new String[]{"v1", "v2", "v3", "v4"}),

    /**
     * 整型 Lambda 元信息。
     */
    INT("int", "Int", null, null, new String[]{"v1", "v2", "v3", "v4"}),

    /**
     * 长整型 Lambda 元信息。
     */
    LONG("long", "Long", null, null, new String[]{"v1", "v2", "v3", "v4"}),

    /**
     * 浮点型 Lambda 元信息。
     */
    FLOAT("float", "Float", null, null, new String[]{"v1", "v2", "v3", "v4"}),

    /**
     * 双精度浮点型 Lambda 元信息。
     */
    DOUBLE("double", "Double", null, null, new String[]{"v1", "v2", "v3", "v4"}),

    /**
     * 对象类型 Lambda 元信息，支持泛型。
     */
    OBJECT("Object", "Object", "R", new String[]{"T", "U", "V", "O"}, new String[]{"v1", "v2", "v3", "v4"});

    /**
     * 类型名称（如：int、boolean、Object）。
     */
    private final String type;

    /**
     * 类型名称的大写形式（如：Int、Boolean、Object）。
     */
    private final String capitalizedName;

    /**
     * 返回类型泛型（仅对象类型使用）。
     */
    private final String returnGeneric;

    /**
     * 参数泛型类型数组（仅对象类型使用）。
     */
    private final String[] paramGenericTypes;

    /**
     * 参数名称数组。
     */
    private final String[] paramNames;

    /**
     * 构造函数，用于初始化枚举值。
     *
     * @param type              类型名称
     * @param capitalizedName   类型名称的大写形式
     * @param returnGeneric     返回类型泛型
     * @param paramGenericTypes 参数泛型类型数组
     * @param paramNames        参数名称数组
     */
    LambdaType(String type, String capitalizedName, String returnGeneric, String[] paramGenericTypes, String[] paramNames) {
        this.type = type;
        this.capitalizedName = capitalizedName;
        this.returnGeneric = returnGeneric;
        this.paramGenericTypes = paramGenericTypes;
        this.paramNames = paramNames;
    }

    /**
     * 获取类型名称的大写形式。
     *
     * @return 大写形式的类型名称
     */
    public String getCapitalizedName() {
        return capitalizedName;
    }

    /**
     * 获取返回类型，优先返回泛型，否则返回基础类型。
     *
     * @return 返回类型
     */
    public String getReturnType() {
        return returnGeneric != null ? returnGeneric : type;
    }

    /**
     * 根据索引获取参数类型。
     *
     * @param index 参数索引
     * @return 参数类型
     * @throws IllegalArgumentException 如果参数索引超出范围或不支持当前类型
     */
    public String getParamType(int index) {
        if (this == TEST) {
            throw new IllegalArgumentException("Not supported for TEST");
        }
        if (paramGenericTypes != null && paramGenericTypes.length != 0) {
            if (index >= paramGenericTypes.length) {
                throw new IllegalArgumentException("the number of parameters is incorrect");
            }
            return paramGenericTypes[index];
        }

        return type;
    }

    /**
     * 根据索引获取参数名称。
     *
     * @param index 参数索引
     * @return 参数名称
     */
    public String getParamName(int index) {
        return paramNames[index];
    }

    /**
     * 判断当前类型是否为泛型。
     *
     * @return 是否为泛型
     */
    public boolean isGeneric() {
        return this == OBJECT;
    }
}
