package com.zld.maker;

import com.zld.maker.cli.example.CommandExecutor;

/**
 * @author zhenglidong
 * @version 1.0
 * @date 2024/2/2
 */
public class Main {

    public static void main(String[] args) {
//        args = new String[]{"generate", "-l", "-a", "-o"};
//                args = new String[]{"config"};
//        args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
