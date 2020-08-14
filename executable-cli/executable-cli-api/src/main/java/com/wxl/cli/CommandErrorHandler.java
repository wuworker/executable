package com.wxl.cli;

/**
 * Create by wuxingle on 2020/08/07
 * 命令执行错误处理
 */
public interface CommandErrorHandler {


    void handleError(CommandContext context, Throwable error);
}