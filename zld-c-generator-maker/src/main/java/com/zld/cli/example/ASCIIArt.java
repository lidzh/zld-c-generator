package com.zld.cli.example;
import cn.hutool.core.io.IoUtil;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * @author zhenglidong
 * @version 1.0
 * @date 2024/2/4
 */

// some exports omitted for the sake of brevity
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable {

    @Option(names = {"-s", "--font-size"}, description = "Font size")
    int fontSize = 19;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = {"Hello,", "picocli"};

    @Override
    public void run() {
        System.out.printf("Font size:%d%n", fontSize);
        for (String word : words) {
            System.out.println(word);
        }
        // The business logic of the command goes here...
        // In this case, code for generation of ASCII art graphics
        // (omitted for the sake of brevity).
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }
}
