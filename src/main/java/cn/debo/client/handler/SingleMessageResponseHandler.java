package cn.debo.client.handler;

import cn.debo.protocol.response.SingleMessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author debo
 * @date 2019-11-07
 */
public class SingleMessageResponseHandler extends SimpleChannelInboundHandler<SingleMessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SingleMessageResponsePacket singleMessageResponsePacket) {
        String fromUserId = singleMessageResponsePacket.getFromUserId();
        String fromUserName = singleMessageResponsePacket.getFromUserName();
        System.out.println(fromUserName + "(" + fromUserId + ")：" + singleMessageResponsePacket
                .getMessage());
    }
}
