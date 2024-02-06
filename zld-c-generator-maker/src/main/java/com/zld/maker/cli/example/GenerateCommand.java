package com.zld.maker.cli.example;

import cn.hutool.core.bean.BeanUtil;
import com.zld.maker.generator.file.FileGenerator;
import com.zld.maker.model.DataModel;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * @author zhenglidong
 * @version 1.0
 * @date 2024/2/5
 */

@CommandLine.Command(name = "generate", description = "生成代码", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable {

    @CommandLine.Option(names = {"-l", "--loop"}, description = "是否循环执行", interactive = true, echo = true)
    private boolean loop;

    @CommandLine.Option(names = {"-a", "--author"}, description = "作者", interactive = true, echo = true)
    private String author = "zld";

    @CommandLine.Option(names = {"-o", "--outputText"}, description = "输出文本", interactive = true, echo = true)
    private String outputText = "sum = ";

    @Override
    public Object call() throws Exception {
        DataModel mainTemplateConfig = new DataModel();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println("配置信息:" + mainTemplateConfig);
        FileGenerator.doGenerate(mainTemplateConfig);
        return null;
    }
}
