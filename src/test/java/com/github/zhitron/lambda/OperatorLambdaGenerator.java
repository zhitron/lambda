package com.github.zhitron.lambda;

import java.nio.file.Files;
import java.nio.file.Path;

import static com.github.zhitron.lambda.LambdaType.*;

/**
 * OperatorLambdaGenerator 是一个代码生成器，用于生成各种 Operator 函数式接口。
 * <p>
 * 该类继承自 TemplateGenerator，通过 OperatorLambdaTemplate 模板类，
 * 动态生成具有不同参数组合和返回类型的 Operator 函数式接口。
 * 生成的接口包括 Operator 目录，每个目录下包含不同参数个数和类型的 Lambda 接口。
 *
 * @author zhitron
 */
public class OperatorLambdaGenerator extends TemplateGenerator {

    /**
     * 程序入口函数，创建OperatorLambdaGenerator实例并执行executeThrow方法
     *
     * @param args 命令行参数数组
     * @throws Exception 当executeThrow方法执行过程中发生异常时抛出
     */
    public static void main(String[] args) throws Exception {
        new OperatorLambdaGenerator().executeThrow();
    }

    /**
     * 定义需要抛出异常的执行方法，用于生成各种函数式接口文件
     *
     * @throws Exception 异常类型，由接口实现时指定
     */
    @Override
    public void executeThrow() throws Exception {
        // 可选的返回类型数组，用于生成不同返回类型的 Lambda 接口。
        LambdaType[] elements = {OBJECT, BOOLEAN, CHAR, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE};

        // 生成 function 目录下的各种函数式接口（具有返回值）
        Path path = root.resolve("operator");
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        // 为每种返回类型生成1-4个参数的函数式接口模板文件
        for (LambdaType element : elements) {
            new OperatorLambdaTemplate(element, 1).writeToDirectory(path, charset);
            new OperatorLambdaTemplate(element, 2).writeToDirectory(path, charset);
            new OperatorLambdaTemplate(element, 3).writeToDirectory(path, charset);
            new OperatorLambdaTemplate(element, 4).writeToDirectory(path, charset);
        }
    }

}
