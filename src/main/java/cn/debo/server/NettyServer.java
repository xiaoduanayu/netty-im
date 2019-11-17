package cn.debo.server;

import cn.debo.handler.ImIdleStateHandler;
import cn.debo.handler.PacketHandler;
import cn.debo.handler.codec.PacketCodecHandler;
import cn.debo.server.handler.AuthHandler;
import cn.debo.server.handler.HandlerAggregator;
import cn.debo.server.handler.HeartbeatRequestHandler;
import cn.debo.server.handler.LoginRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author debo
 * @date 2019-11-07
 */
public class NettyServer {

    private static final int PORT = 8000;

    public static void main(String[] args) {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(boosGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        // 空闲检测
                        ch.pipeline().addLast(new ImIdleStateHandler());
                        // 粘包拆包处理器
                        ch.pipeline().addLast(new PacketHandler());
                        // 编解码器
                        ch.pipeline().addLast(PacketCodecHandler.INSTANCE);
                        // 心跳请求处理器
                        ch.pipeline().addLast(HeartbeatRequestHandler.INSTANCE);
                        // 登录处理器
                        ch.pipeline().addLast(LoginRequestHandler.INSTANCE);
                        // 权限校验处理器
                        ch.pipeline().addLast(AuthHandler.INSTANCE);
                        // 处理器聚合器
                        ch.pipeline().addLast(HandlerAggregator.INSTANCE);
                    }
                });
        bind(serverBootstrap, PORT);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口[" + port + "]绑定成功！");
            } else {
                System.err.println("端口[" + port + "]绑定失败！");
            }
        });
    }
}
