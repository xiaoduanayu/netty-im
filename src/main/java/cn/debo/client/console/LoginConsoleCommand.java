package cn.debo.client.console;

import cn.debo.protocol.request.LoginRequestPacket;
import cn.debo.util.LoginUtil;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author debo
 * @date 2019-11-07
 */
public class LoginConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("输入用户名登录：");
        String userName = scanner.next();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserName(userName);
        loginRequestPacket.setPassword("123456");
        // 发送登录数据包
        channel.writeAndFlush(loginRequestPacket);
        // 等待登录完成
        synchronized (LoginUtil.MONITOR) {
            try {
                LoginUtil.MONITOR.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
