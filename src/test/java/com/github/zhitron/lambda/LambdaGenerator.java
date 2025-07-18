package com.github.zhitron.lambda;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
public class LambdaGenerator {
    /**
     * 生成的 Java 文件的根目录路径。
     */
    private static final Path ROOT = Paths.get("").resolve("src/main/java/com/github/zhitron/lambda").toAbsolutePath();

    /**
     * 使用的字符集编码。
     */
    private static final Charset charset = StandardCharsets.UTF_8;

    /**
     * 主方法，程序入口点。
     * <p>
     * 此方法执行以下步骤：
     * 1. 创建 function 目录并生成各种函数式接口；
     * 2. 创建 consumer 目录并生成各种消费者式接口；
     * 3. 创建 predicate 目录并生成各种谓词式接口。
     *
     * @param args 命令行参数
     * @throws IOException 如果写入文件时发生 I/O 错误
     */
    public static void main(String[] args) throws IOException {
        // 可选的返回类型数组，用于生成不同返回类型的 Lambda 接口。
        LambdaType[] results = {OBJECT, CHAR, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE};

        // 泛型参数数组，用于生成包含泛型参数的 Lambda 接口。
        LambdaType[] generics = {OBJECT};
        // 基本类型参数数组，用于生成包含基本类型参数的 Lambda 接口。
        LambdaType[] primitives = {BOOLEAN, INT, LONG, DOUBLE};

        // 1、生成全是对象泛型的函数式接口
        generateCode(results, generics, generics, generics, generics);

        // 2、生成全是普通类型的函数式接口
        generateCode(results, primitives, primitives, primitives, primitives);

        // 3、参数一为泛型，其余参数为普通类型
        generateCode(results, generics, primitives, primitives, primitives);

        // 4、参数一为泛型，参数二为泛型，其余参数为普通类型
        generateCode(results, generics, generics, primitives, primitives);

        // 5、参数一为泛型，参数二为泛型，参数三为泛型，其余参数为普通类型
        generateCode(results, generics, generics, generics, primitives);
    }

    /**
     * 根据不同的Lambda类型生成对应的函数式接口代码文件
     * 此方法针对function、consumer和predicate三种目录分别生成不同类型的函数式接口
     *
     * @param rs  返回值类型的Lambda类型数组
     * @param p1s 第一个参数类型的Lambda类型数组
     * @param p2s 第二个参数类型的Lambda类型数组
     * @param p3s 第三个参数类型的Lambda类型数组
     * @param p4s 第四个参数类型的Lambda类型数组
     * @throws IOException 如果在创建目录或写入文件时发生I/O错误
     */
    private static void generateCode(LambdaType[] rs, LambdaType[] p1s, LambdaType[] p2s, LambdaType[] p3s, LambdaType[] p4s) throws IOException {
        // 生成 function 目录下的各种函数式接口（具有返回值）
        Path path = ROOT.resolve("function");
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        for (LambdaType r : rs) {
            for (LambdaType p1 : p1s) {
                LambdaTemplate lt1 = new LambdaTemplate(r, p1);
                lt1.writeToDirectory(path, charset);
                for (LambdaType p2 : p2s) {
                    LambdaTemplate lt2 = new LambdaTemplate(r, p1, p2);
                    lt2.writeToDirectory(path, charset);
                    for (LambdaType p3 : p3s) {
                        LambdaTemplate lt3 = new LambdaTemplate(r, p1, p2, p3);
                        lt3.writeToDirectory(path, charset);
                        for (LambdaType p4 : p4s) {
                            LambdaTemplate lt4 = new LambdaTemplate(r, p1, p2, p3, p4);
                            lt4.writeToDirectory(path, charset);
                        }
                    }
                }
            }
        }

        // 生成 consumer 目录下的各种消费者式接口（无返回值）
        path = ROOT.resolve("consumer");
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        for (LambdaType p1 : p1s) {
            LambdaTemplate lt1 = new LambdaTemplate(null, p1);
            lt1.writeToDirectory(path, charset);
            for (LambdaType p2 : p2s) {
                LambdaTemplate lt2 = new LambdaTemplate(null, p1, p2);
                lt2.writeToDirectory(path, charset);
                for (LambdaType p3 : p3s) {
                    LambdaTemplate lt3 = new LambdaTemplate(null, p1, p2, p3);
                    lt3.writeToDirectory(path, charset);
                    for (LambdaType p4 : p4s) {
                        LambdaTemplate lt4 = new LambdaTemplate(null, p1, p2, p3, p4);
                        lt4.writeToDirectory(path, charset);
                    }
                }
            }
        }

        // 生成 predicate 目录下的各种谓词式接口（返回布尔值）
        path = ROOT.resolve("predicate");
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        for (LambdaType p1 : p1s) {
            LambdaTemplate lt1 = new LambdaTemplate(TEST, p1);
            lt1.writeToDirectory(path, charset);
            for (LambdaType p2 : p2s) {
                LambdaTemplate lt2 = new LambdaTemplate(TEST, p1, p2);
                lt2.writeToDirectory(path, charset);
                for (LambdaType p3 : p3s) {
                    LambdaTemplate lt3 = new LambdaTemplate(TEST, p1, p2, p3);
                    lt3.writeToDirectory(path, charset);
                    for (LambdaType p4 : p4s) {
                        LambdaTemplate lt4 = new LambdaTemplate(TEST, p1, p2, p3, p4);
                        lt4.writeToDirectory(path, charset);
                    }
                }
            }
        }
    }
}
