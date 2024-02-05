package com.zld.cli.example;

import picocli.CommandLine;

/**
 * @author zhenglidong
 * @version 1.0
 * @date 2024/2/5
 */

@CommandLine.Command(name = "zld", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        System.out.println("输入具体指令");
    }

    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
