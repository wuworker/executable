package com.wxl.cli.random.addition;

import com.wxl.cli.AbstractCommand;
import com.wxl.cli.CommandChain;
import com.wxl.cli.CommandContext;
import com.wxl.cli.random.JRandomConstant;
import org.apache.commons.cli.Option;

/**
 * Create by wuxingle on 2020/08/21
 * 设置生成个数
 */
public class CountCommand extends AbstractCommand {

    private static final Option COUNT_OPT = Option.builder("c")
            .longOpt("count")
            .desc("设置生成个数")
            .optionalArg(true)
            .numberOfArgs(1)
            .argName("count")
            .build();

    @Override
    public void execute(CommandContext context, CommandChain chain) {
        if (isCurrentCommand(context)) {
            checkOptionValueLen(context, 1, 1);
            Integer count = getRequireOptionInteger(context, 0);
            context.setAttr(JRandomConstant.ATTR_COUNT, count);
        }
        chain.doNext(context);
    }

    @Override
    public Option option() {
        return COUNT_OPT;
    }
}
