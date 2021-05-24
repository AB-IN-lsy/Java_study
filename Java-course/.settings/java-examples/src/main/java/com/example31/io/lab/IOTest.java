package com.example31.io.lab;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class IOTest {
    public static void main(String[] args) {
        String fileName = "C:/example/from.txt";

        System.out.println("----- 创建文件 ------");
        createFile(fileName);

        System.out.println("-----  将字符串写入文件 -------");
        // \r\n在txt文本中换行
        String str =
                "白日依山尽\r\n" +
                        "黄河入海流\r\n" +
                        "欲穷千里目\r\n" +
                        "更上一层楼\r\n";
        writeToFile(fileName, str);

        System.out.println("--------- 基于基本IO流实现文件的复制 ----------");
        String toFile = "C:/example/to.txt";
        copyByIO(fileName, toFile);

        System.out.println("--------- 基于NIO实现文件的复制 ----------");
        String toFile2 = "C:/example/nio/to.txt";
        copyByNIO(fileName, toFile2);

        System.out.println("---------- 删除指定文件 -------------");
        deleteFile(toFile);
        System.out.println("---------- 遍历指定目录文件 -------------");
        String dir = "C:/example";
        walkDirectories(dir);
    }

    /**
     * 基于指定文件名称创建目录及文件
     * 如果文件已经存在，则忽略
     *
     * @param fileName
     */
    private static void createFile(String fileName)  {
        /**
         * 创建文件，即使用File类，就得抛出异常
         * 由于主函数没有处理该异常的函数，故直接在方法中try catch处理
         */
        Path dir = Path.of(fileName);
        /**
         * 创建路径
         */
        try {
            if(!Files.exists(dir)){
                /**
                 * 首先判断路径是否存在，避免重复创建
                 * 先创建父路径，不会报异常
                 * 再创建子路径，如果存在就会报异常，故一开始需要判断是否存在路径
                 */
                Files.createDirectories(dir.getParent());
                Files.createFile(Path.of(fileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提示：文件以字节操作，因此可以
     * 字符串，转字节数组，直接基于Files写入文件
     *
     * @param fileName
     * @param content
     */
    private static void writeToFile(String fileName, String content) {
        /**
         * 前提是路径需要存在
         */
        try {
            Files.write(Path.of(fileName), content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于基本IO，以及字节数组缓冲区，复制文件
     * 打印显示循环读写循环次数
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByIO(String sourceFile, String targetFile) {
        createFile(targetFile);
        try(FileInputStream in = new FileInputStream(sourceFile);
            FileOutputStream out = new FileOutputStream(targetFile)) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while((len = in.read(buffer)) != -1){
                out.write(buffer, 0, len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于NIO，实现文件的复制
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByNIO(String sourceFile, String targetFile) {
        createFile(targetFile);
        try {
            /**
             * 实现覆盖选项
             */
            Files.copy(Path.of(sourceFile), Path.of(targetFile), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     *
     * @param fileName
     */
    private static void deleteFile(String fileName) {
        try {
            Files.deleteIfExists(Path.of(fileName));
            /**
             * 不会抛路径不存在的异常
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历打印指定目录下全部目录/文件名称
     *
     * @param dir
     */
    private static void walkDirectories(String dir) {
        try {
            Files.walk(Path.of(dir))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

