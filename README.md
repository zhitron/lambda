# Lambda Project

`Lambda Project`是基于 Java 8 的开源项目，旨在提供实用工具和功能扩展，以提高开发效率和代码简洁性。

## 📄 项目简介

本项目是一个基于 Java 的轻量级函数式编程工具包，旨在提供简洁的 Lambda 表达式封装与实用方法。适用于需要简化函数式操作的 Java 项目。

---

## 🚀 快速开始

### 构建要求

- JDK 1.8 或以上
- Maven 3.x

### 添加依赖

你可以通过 Maven 引入该项目：

```xml
<dependency>
    <groupId>com.github.zhitron</groupId>
    <artifactId>lambda</artifactId>
    <version>1.3.0</version>
</dependency>
```

---

## 🧩 功能特性

- 支持链式调用和函数组合
- 提供常用函数接口扩展
- 简化集合操作与流式处理
- 支持原生类型与泛型的函数

## 🔧 使用指南

本项目提供了多种函数式接口，并支持返回值类型和异常处理。适用于简化 Java 中的 Lambda 表达式使用。

### ✅ 1. 函数式接口分类

#### 1.1 无参函数（NonParameter）

适用于不接受任何参数的 Lambda 函数，支持以下返回类型：

- `ToAny<R>`：通用泛型返回值
- `ToVoid`：无返回值
- `ToBoolean`：布尔值
- `ToChar`：字符值
- `ToByte`：字节值
- `ToShort`：短整型值
- `ToInt`：整型值
- `ToLong`：长整型值
- `ToFloat`：浮点值
- `ToDouble`：双精度浮点值

同时支持抛出异常的版本：NonParameterThrow

#### 1.2 单参数函数（SingleParameter）

适用于接受一个参数的 Lambda 函数，支持上述相同类型的返回值。
接口命名示例：`SingleParameter.ToAny<T, R>`

支持异常处理的版本：SingleParameterThrow

#### 1.3 双参数函数（TwiceParameter）

适用于接受两个参数的 Lambda 函数。
接口命名示例：`TwiceParameter.ToAny<T, U, R>`

支持异常处理的版本：TwiceParameterThrow

#### 1.4 三参数函数（TripleParameter）

适用于接受三个参数的 Lambda 函数。
接口命名示例：`TripleParameter.ToAny<T, U, V, R>`

支持异常处理的版本：TripleParameterThrow

#### 1.5 四参数函数（QuadrupleParameter）

适用于接受四个参数的 Lambda 函数。
接口命名示例：`QuadrupleParameter.ToAny<T, U, V, W, R>`

支持异常处理的版本：QuadrupleParameterThrow

#### 1.6 其它函数

- 消费器函数：`com.github.zhitron.lambda.consumer`
- 处理器函数：`com.github.zhitron.lambda.function`
- 断言器函数：`com.github.zhitron.lambda.predicate`
- 提供器函数：`com.github.zhitron.lambda.supplier`

---

### ✅ 2. 异常处理支持

所有接口都提供两个版本：

- **基础版本**：不抛出异常
- **Throw 版本**：通过 `applyThrow(...)` 方法允许抛出检查性异常（checked exception），并默认将异常包装为 `RuntimeException`

示例：

```java
SingleParameterThrow.ToAny<String, Integer, Exception> parser = Integer::parseInt;
Integer result = parser.apply("123"); // 正常调用
```

---

### ✅ 3. 典型使用场景

- 简化集合遍历与操作（如 `forEach`, `map`, `filter` 等）
- 定义带异常处理的回调逻辑
- 构建链式 API 或 DSL
- 替代匿名内部类，提升代码可读性和复用性

---

### ✅ 4. 示例代码

#### 示例 1：使用无参函数

```java
package com.github.zhitron.lambda;

/**
 * @author zhitron
 */
public class Test {
    public static void main(String[] args) {
        NonParameter.ToInt random = () -> new Random().nextInt(100);
        System.out.println(random.apply());
    }
}
```

#### 示例 2：使用单参函数

```java
package com.github.zhitron.lambda;

/**
 * @author zhitron
 */
public class Test {
    public static void main(String[] args) {
        SingleParameter.ToBoolean<String> isEmpty = String::isEmpty;
        System.out.println(isEmpty.apply(""));
    }
}
```

#### 示例 3：使用双参函数 + 异常处理

```java
package com.github.zhitron.lambda;

/**
 * @author zhitron
 */
public class Test {
    public static void main(String[] args) {
        TwiceParameterThrow.ToAny<String, String, Integer, NumberFormatException> parse = Integer::valueOf;

        try {
            int result = parse.apply("123", "456");
            System.out.println(result);
        } catch (NumberFormatException e) {
            e.printStackTrace(System.err);
        }
    }
}
```

---

## ✍️ 开发者

- **Zhitron** (假设为开发者)
- 邮箱: zhitron@foxmail.com
- 组织: [Zhitron](https://github.com/zhitron)

---

## 📦 发布状态

当前版本：`1.2.0`

该项目已发布至 [Maven Central](https://search.maven.org/)，支持快照版本与正式版本部署。

---

## 🛠 源码管理

GitHub 地址：[https://github.com/zhitron/lambda](https://github.com/zhitron/lambda)

使用 Git 进行版本控制：

```bash
git clone https://github.com/zhitron/lambda.git
```

---

## 📚 文档与社区

- Maven 文档可使用 `mvn javadoc:javadoc` 生成。
- 如有问题或贡献，请提交 Issues 或 PR 至 GitHub 仓库。

---

## 📎 License

Apache License

