package com.github.zhitron.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.github.zhitron.lambda.LambdaType.*;

/**
 * LambdaGenerator 是一个代码生成器，用于生成各种 Lambda 表达式功能的 Java 接口。
 * <p>
 * 该类通过 LambdaType 枚举和 LambdaTemplate 类，动态生成具有不同参数组合和返回类型的函数式接口。
 * 生成的接口包括 Function（函数）、Consumer（消费者）、Predicate（谓词）等目录，每个目录下包含
 * 不同参数个数和类型的 Lambda 接口。
 *
 * @author zhitron
 */
public class LambdaGenerator extends TemplateGenerator {

    /**
     * 主方法，程序入口点。
     * <p>
     * 此方法执行以下步骤：
     * 1. 创建 function 目录并生成各种函数式接口；
     * 2. 创建 consumer 目录并生成各种消费者式接口；
     * 3. 创建 predicate 目录并生成各种谓词式接口。
     *
     * @param args 命令行参数
     * @throws Exception 如果执行过程中发生任何异常
     */
    public static void main(String[] args) throws Exception {
        new LambdaGenerator().executeThrow();
    }

    /**
     * 定义需要抛出异常的执行方法
     * 此方法执行以下步骤：
     * 1. 创建 function 目录并生成各种函数式接口；
     * 2. 创建 consumer 目录并生成各种消费者式接口；
     * 3. 创建 predicate 目录并生成各种谓词式接口。
     *
     * @throws Exception 异常类型，由接口实现时指定
     */
    @Override
    public void executeThrow() throws Exception {
        // 泛型参数数组，用于生成包含泛型参数的 Lambda 接口。
        LambdaType[] generics = {OBJECT};
        // 基本类型参数数组，用于生成包含基本类型参数的 Lambda 接口。
        LambdaType[] primitives = {BOOLEAN, INT, LONG, DOUBLE};

        // 1、生成全是对象泛型的函数式接口
        generateCode(generics, generics, generics, generics);

        // 2、生成全是普通类型的函数式接口
        generateCode(primitives, primitives, primitives, primitives);

        // 3、参数一为泛型，其余参数为普通类型
        generateCode(generics, primitives, primitives, primitives);

        // 4、参数一为泛型，参数二为泛型，其余参数为普通类型
        generateCode(generics, generics, primitives, primitives);

        // 5、参数一为泛型，参数二为泛型，参数三为泛型，其余参数为普通类型
        generateCode(generics, generics, generics, primitives);

        // 6、生成全量单参数的函数式接口
        generateCode(new LambdaType[]{OBJECT, BOOLEAN, CHAR, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE}, null, null, null);
    }

    /**
     * 根据不同的Lambda类型生成对应的函数式接口代码文件
     * 此方法针对function、consumer和predicate三种目录分别生成不同类型的函数式接口
     *
     * @param p1s 第一个参数类型的Lambda类型数组
     * @param p2s 第二个参数类型的Lambda类型数组
     * @param p3s 第三个参数类型的Lambda类型数组
     * @param p4s 第四个参数类型的Lambda类型数组
     * @throws IOException 如果在创建目录或写入文件时发生I/O错误
     */
    private void generateCode(LambdaType[] p1s, LambdaType[] p2s, LambdaType[] p3s, LambdaType[] p4s) throws IOException {
        // 生成 function 目录下的各种函数式接口（具有返回值）
        Path path = root.resolve("function");
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        // 可选的返回类型数组，用于生成不同返回类型的 Lambda 接口。
        for (LambdaType r : new LambdaType[]{OBJECT, CHAR, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE}) {
            if (p1s != null) {
                for (LambdaType p1 : p1s) {
                    LambdaTemplate lt1 = new LambdaTemplate(r, p1);
                    lt1.writeToDirectory(path, charset);
                    if (p2s != null) {
                        for (LambdaType p2 : p2s) {
                            LambdaTemplate lt2 = new LambdaTemplate(r, p1, p2);
                            lt2.writeToDirectory(path, charset);
                            if (p3s != null) {
                                for (LambdaType p3 : p3s) {
                                    LambdaTemplate lt3 = new LambdaTemplate(r, p1, p2, p3);
                                    lt3.writeToDirectory(path, charset);
                                    if (p4s != null) {
                                        for (LambdaType p4 : p4s) {
                                            LambdaTemplate lt4 = new LambdaTemplate(r, p1, p2, p3, p4);
                                            lt4.writeToDirectory(path, charset);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 生成 consumer 目录下的各种消费者式接口（无返回值）
        path = root.resolve("consumer");
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        if (p1s != null) {
            for (LambdaType p1 : p1s) {
                LambdaTemplate lt1 = new LambdaTemplate(null, p1);
                lt1.writeToDirectory(path, charset);
                if (p2s != null) {
                    for (LambdaType p2 : p2s) {
                        LambdaTemplate lt2 = new LambdaTemplate(null, p1, p2);
                        lt2.writeToDirectory(path, charset);
                        if (p3s != null) {
                            for (LambdaType p3 : p3s) {
                                LambdaTemplate lt3 = new LambdaTemplate(null, p1, p2, p3);
                                lt3.writeToDirectory(path, charset);
                                if (p4s != null) {
                                    for (LambdaType p4 : p4s) {
                                        LambdaTemplate lt4 = new LambdaTemplate(null, p1, p2, p3, p4);
                                        lt4.writeToDirectory(path, charset);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 生成 predicate 目录下的各种谓词式接口（返回布尔值）
        path = root.resolve("predicate");
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        if (p1s != null) {
            for (LambdaType p1 : p1s) {
                LambdaTemplate lt1 = new LambdaTemplate(BOOLEAN, p1);
                lt1.writeToDirectory(path, charset);
                if (p2s != null) {
                    for (LambdaType p2 : p2s) {
                        LambdaTemplate lt2 = new LambdaTemplate(BOOLEAN, p1, p2);
                        lt2.writeToDirectory(path, charset);
                        if (p3s != null) {
                            for (LambdaType p3 : p3s) {
                                LambdaTemplate lt3 = new LambdaTemplate(BOOLEAN, p1, p2, p3);
                                lt3.writeToDirectory(path, charset);
                                if (p4s != null) {
                                    for (LambdaType p4 : p4s) {
                                        LambdaTemplate lt4 = new LambdaTemplate(BOOLEAN, p1, p2, p3, p4);
                                        lt4.writeToDirectory(path, charset);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
