package com.zld.cli.example;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

/**
 * @author zhenglidong
 * @version 1.0
 * @date 2024/2/5
 */

@CommandLine.Command(name = "list", description = "list all the files in the current directory", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{

    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");
        String absolutePath = new File(projectPath, "acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(absolutePath);
        files.forEach(System.out::println);
    }
}
