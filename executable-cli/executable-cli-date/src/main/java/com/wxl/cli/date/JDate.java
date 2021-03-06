package com.wxl.cli.date;

import com.wxl.cli.CommandExecutor;
import com.wxl.cli.CommandExecutorBuilder;
import com.wxl.cli.HelpCommand;
import com.wxl.cli.date.addition.PatternCommand;
import org.apache.commons.cli.HelpFormatter;

/**
 * Create by wuxingle on 2020/08/06
 * jdate
 * 日期相关命令工具
 */
public class JDate {

    public static void main(String[] args) {
        HelpCommand helpCommand = new HelpCommand(new HelpFormatter(),
                "默认格式化样式为: yyyy-MM-dd HH:mm:ss.SSS",
                null,
                false);

        CommandExecutor executor = new CommandExecutorBuilder()
                .setName("jdate")
                .addCommand(
                        new CalendarCommand(),
                        new PatternCommand(),

                        new FormatCommand(),
                        new ParseCommand(),
                        new AddCommand(),
                        new MinusCommand(),
                        helpCommand,
                        new NowCommand()
                )
                .build();

        executor.execute(args);
    }


}

