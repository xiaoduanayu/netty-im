package cn.debo.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author debo
 * @date 2019-11-07
 */
public interface ConsoleCommand {

    /**
     * 执行具体命令
     *
     * @param scanner
     * @param channel
     */
    void exec(Scanner scanner, Channel channel);
}
