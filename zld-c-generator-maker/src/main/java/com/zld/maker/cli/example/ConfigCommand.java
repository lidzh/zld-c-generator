package com.zld.maker.cli.example;

import cn.hutool.core.util.ReflectUtil;
import com.zld.maker.model.DataModel;
import picocli.CommandLine;

import java.lang.reflect.Field;

/**
 * @author zhenglidong
 * @version 1.0
 * @date 2024/2/5
 */

@CommandLine.Command(name = "config", mixinStandardHelpOptions = true, description = "查看参数信息")
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        System.out.println("查看参数信息");

        Field[] fields = ReflectUtil.getFields(DataModel.class);

        for (Field field : fields) {
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
//            System.out.println("Modifiers: " + java.lang.reflect.Modifier.toString(field.getModifiers()));
            System.out.println("---");
        }
    }
}
