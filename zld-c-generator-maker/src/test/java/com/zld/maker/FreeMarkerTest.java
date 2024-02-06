package com.zld.maker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhenglidong
 * @version 1.0
 * @date 2024/2/4
 */
public class FreeMarkerTest {

    @Test
    public void test() throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);


        // 创建FreeMarker配置实例
         Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        // 设置FreeMarker模板文件目录
         cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
         cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("myweb.html.ftl");
        // 创建数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2023);
        List<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "https://codefather.cn");
        menuItem1.put("label", "编程导航");
        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "https://laoyujianli.com");
        menuItem2.put("label", "老鱼简历");
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        dataModel.put("menuItems", menuItems);
        // 加载模板文件
        FileWriter myweb = new FileWriter("myweb.html");
        template.process(dataModel, myweb);
        // 关闭流
        myweb.close();
    }
}
