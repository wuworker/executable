package com.wxl.cli.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.wxl.cli.CommandChain;
import com.wxl.cli.CommandContext;
import org.apache.commons.cli.Option;

/**
 * Create by wuxingle on 2020/09/28
 * json 路径提取
 */
public class PathFilterCommand extends JsonCommand {

    private static final Option FILTER_OPT = Option.builder("f")
            .longOpt("filter")
            .desc("json path过滤")
            .optionalArg(true)
            .numberOfArgs(1)
            .argName("[json_path]")
            .build();

    @Override
    public void execute(CommandContext context, CommandChain chain) {
        if (isCurrentCommand(context)) {
            String path = getRequireOptionValue(context, 0);

            JsonElement element = parseJson(context);
            Gson gson = getGsonBuilder(context).setPrettyPrinting().create();
            String jsonStr = gson.toJson(element);

            try {
                Object value = JsonPath.read(jsonStr, path);
                context.stdout().println(gson.toJson(value));
            } catch (PathNotFoundException e) {
                context.stdout().println("null");
            }

            return;
        }
        chain.doNext(context);
    }

    @Override
    public Option option() {
        return FILTER_OPT;
    }
}
