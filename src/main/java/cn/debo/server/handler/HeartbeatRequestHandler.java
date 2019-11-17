package cn.debo.server.handler;

import cn.debo.protocol.request.HeartbeatRequestPacket;
import cn.debo.protocol.response.HeartbeatResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author debo
 * @date 2019-11-07
 */
@ChannelHandler.Sharable
public class HeartbeatRequestHandler extends SimpleChannelInboundHandler<HeartbeatRequestPacket> {
    public static final HeartbeatRequestHandler INSTANCE = new HeartbeatRequestHandler();

    private HeartbeatRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HeartbeatRequestPacket requestPacket) {
        ctx.writeAndFlush(new HeartbeatResponsePacket());
    }
}
