package cn.debo.client.console;

import cn.debo.protocol.request.SingleMessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author debo
 * @date 2019-11-07
 */
public class SingleMessageConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个用户：");
        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new SingleMessageRequestPacket(toUserId, message));
    }
}
