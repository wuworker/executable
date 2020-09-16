package com.wxl.cli.random.addition;

import com.wxl.cli.AbstractCommand;
import com.wxl.cli.CommandChain;
import com.wxl.cli.CommandContext;
import com.wxl.cli.random.JRandomConstant;
import org.apache.commons.cli.Option;

/**
 * Create by wuxingle on 2020/08/21
 * 生成的随机字母全部小写
 */
public class LowerCommand extends AbstractCommand {

    private static final Option LOWER_OPT = Option.builder()
            .longOpt("lower")
            .desc("生成的随机字母全部小写")
            .optionalArg(true)
            .hasArg(false)
            .build();

    @Override
    public void execute(CommandContext context, CommandChain chain) {
        if (isCurrentCommand(context)) {
            context.setAttr(JRandomConstant.ATTR_LOWER, true);
        }
        chain.doNext(context);
    }

    @Override
    public Option option() {
        return LOWER_OPT;
    }
}
