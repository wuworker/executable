package com.wxl.cli;

import org.apache.commons.cli.Option;
import org.apache.commons.lang3.StringUtils;

/**
 * Create by wuxingle on 2020/08/07
 * 默认错误处理
 */
public class DefaultCommandErrorHandler implements CommandErrorHandler {

    @Override
    public void handleError(CommandContext context, Command cmd, Throwable error) {
        if (cmd != null) {
            String tipOpt = getTipOpt(cmd.option());
            context.stderr().println("Error option: " + tipOpt + ", " + getCause(error).getMessage());
        } else {
            context.stderr().println(getCause(error).getMessage());
        }
    }


    private String getTipOpt(Option option) {
        String opt = option.getOpt();
        if (StringUtils.isNotBlank(opt)) {
            return "-" + opt;
        }
        return "--" + option.getLongOpt();
    }


    private Throwable getCause(Throwable error) {
        Throwable cause = error.getCause();
        while (cause != null) {
            error = cause;
            cause = error.getCause();
        }
        return error;
    }
}
