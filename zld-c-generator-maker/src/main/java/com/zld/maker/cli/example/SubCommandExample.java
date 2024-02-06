package com.zld.maker.cli.example;


import picocli.CommandLine;

/**
 * @author zhenglidong
 * @version 1.0
 * @date 2024/2/5
 */
@CommandLine.Command(name = "main", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable {
    @Override
    public void run() {
        System.out.println("执行主命令");
    }

    @CommandLine.Command(name = "add", description = "添加", mixinStandardHelpOptions = true)
    static class AddCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行子命令");
        }
    }

    public static void main(String[] args) {
        // 执行主命令
//        String[] myArgs = new String[]{};
        // 查看主命令的帮助手册
//        String[] myArgs = new String[] { "--help" };
        // 执行增加命令
//        String[] myArgs = new String[] { "add" };
        // 执行增加命令的帮助手册
        String[] myArgs = new String[] { "add", "--help" };
        // 执行不存在的命令，会报错
//        String[] myArgs = new String[] { "update" };
        int exitCode = new CommandLine(new SubCommandExample())
                .addSubcommand(new AddCommand())
                .execute(myArgs);
        System.exit(exitCode);
    }
}
