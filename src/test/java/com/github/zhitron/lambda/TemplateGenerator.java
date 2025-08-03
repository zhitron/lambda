package com.github.zhitron.lambda;

import com.github.zhitron.ActuatorThrow;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * LambdaGenerator 是一个代码生成器，用于生成各种 Lambda 表达式功能的 Java 接口。
 * <p>
 * 该类通过 LambdaType 枚举和 LambdaTemplate 类，动态生成具有不同参数组合和返回类型的函数式接口。
 * 生成的接口包括 Function（函数）、Consumer（消费者）、Predicate（谓词）等目录，每个目录下包含
 * 不同参数个数和类型的 Lambda 接口。
 *
 * @author zhitron
 */
public abstract class TemplateGenerator implements ActuatorThrow<Exception> {
    /**
     * 生成的 Java 文件的根目录路径。
     */
    protected final Path root;

    /**
     * 使用的字符集编码。
     */
    protected final Charset charset;

    public TemplateGenerator() {
        this(Paths.get("").resolve("src/main/java/com/github/zhitron/lambda").toAbsolutePath(), StandardCharsets.UTF_8);
    }

    public TemplateGenerator(Path root, Charset charset) {
        this.root = root;
        this.charset = charset;
    }

    /**
     * 定义需要抛出异常的执行方法
     *
     * @throws Exception 异常类型，由接口实现时指定
     */
    @Override
    public abstract void executeThrow() throws Exception;
}
