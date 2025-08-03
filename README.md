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
    <version>1.4.0</version>
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

基于项目结构和已有 README 内容，我将为项目生成更完整的使用文档。

## 🧩 功能特性

### 1. 函数式接口分类

```
com.github.zhitron.lambda
├── consumer/          # 消费者接口，用于接收参数并执行操作，无返回值。
├── function/          # 函数器接口，用于接收参数并返回一个结果，支持多种返回类型（Object, char, byte, short, int, long, float, double）。
├── operator/          # 操作器接口，用于接收同一类型的参数并返回相同类型的结果，支持多种数据类型（Object, char, byte, short, int, long, float, double, boolean）。
├── predicate/         # 断言器接口，用于接收参数并进行条件判断，返回 boolean 类型结果。
├── supplier/          # 提供者接口，用于提供数据或值，不接收参数，支持多种返回类型（Object, char, byte, short, int, long, float, double, boolean）。
├── NonParameter*      # 无参函数接口
├── SingleParameter*   # 单参函数接口
├── TwiceParameter*    # 双参函数接口
├── TripleParameter*   # 三参函数接口
└── QuadrupleParameter*# 四参函数接口
```

### 2. 接口命名方式

* `com.github.zhitron.lambda.consumer`包下Consumer消费者接口：`(Single|Twice|Triple|Quadruple)Consumer(Arguments)[Throw]`。
* `com.github.zhitron.lambda.function`包下Function函数器接口：`(Single|Twice|Triple|Quadruple)Function(Arguments)To(ReturnType)[Throw]`。
* `com.github.zhitron.lambda.operator`包下Operator操作器接口：`(ReturnType)(Single|Twice|Triple|Quadruple)Operator[Throw]`。
* `com.github.zhitron.lambda.predicate`包下Predicate断言器接口：`(Single|Twice|Triple|Quadruple)Predicate(Arguments)[Throw]`。
* `com.github.zhitron.lambda.supplier`包下Supplier提供者接口：`(ReturnType)Supplier[Throw]`。

**命名说明：**

* Single，Twice，Triple，Quadruple分别代表接收一个参数，两个参数，三个参数，四个参数。
* Arguments，ReturnType分别代表参数类型和返回类型。
* Throw表示接口是否抛出异常。
* Arguments命名细节如下：
  * 如果所有参数一致，则直接使用参数类型作为命名。
  * 如果参数类型不一致:
    1. 无连续一样参数，则使用参数类型列表命名，如参数类型为`int, String, boolean`，则命名为`IntStringBoolean`。
    2. 有连续一样参数，两个连续使用前缀`Tw`,三个连续使用前缀`Tri`。
       * 如参数类型为`int, int, String`，则命名为`TwIntString`。
       * 如参数类型为`int, int, int, String`，则命名为`TriIntString`。

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

