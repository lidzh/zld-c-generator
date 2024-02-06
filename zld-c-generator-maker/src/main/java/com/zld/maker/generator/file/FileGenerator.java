package com.zld.maker.generator.file;

import cn.hutool.core.io.FileUtil;
import com.zld.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 核心生成器
 */
public class FileGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        System.out.println("项目根路径：" + projectPath);
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "zld-c-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        // 生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);
        List<File> files = FileUtil.loopFiles(projectPath);
        files.forEach(file -> System.out.println(file.getAbsolutePath()));
        // 生成动态文件
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
//        String inputDynamicFilePath = projectPath + File.separator + "classes/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/zld/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

}
