package com.zld.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @author zhenglidong
 * @version 1.0
 * @date 2024/2/2
 */
public class StaticGenerator {

    public static void copyFilesByHutool(String inputPath,String outputPath){

        FileUtil.copy(inputPath,outputPath,false);
    }

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        File parentFile = new File(projectPath).getParentFile();
        String absolutePath = new File(parentFile, "zld-c-generator-demo-projects/acm-template").getAbsolutePath();
        String outputFile = projectPath;
        copyFilesByHutool(absolutePath,outputFile);
    }

}
