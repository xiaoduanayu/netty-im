package cn.debo.server.handler;

import cn.debo.protocol.request.SingleMessageRequestPacket;
import cn.debo.protocol.response.SingleMessageResponsePacket;
import cn.debo.session.Session;
import cn.debo.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author debo
 * @date 2019-11-07
 */
@ChannelHandler.Sharable
public class SingleMessageRequestHandler extends SimpleChannelInboundHandler<SingleMessageRequestPacket> {
    public static final SingleMessageRequestHandler INSTANCE = new SingleMessageRequestHandler();

    private SingleMessageRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SingleMessageRequestPacket singleMessageRequestPacket) {
        // 1.拿到消息发送方的会话信息
        Session session = SessionUtil.getSession(ctx.channel());
        // 2.通过消息发送方的会话信息构造要发送的消息
        SingleMessageResponsePacket singleMessageResponsePacket = new SingleMessageResponsePacket();
        singleMessageResponsePacket.setFromUserId(session.getUserId());
        singleMessageResponsePacket.setFromUserName(session.getUserName());
        singleMessageResponsePacket.setMessage(singleMessageRequestPacket.getMessage());

        // 3.拿到消息接收方的channel
        Channel toUserChannel = SessionUtil.getChannel(singleMessageRequestPacket.getToUserId());

        // 4.将消息发送给消息接收方
        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(singleMessageResponsePacket);
        } else {
            System.err.println("[" + singleMessageRequestPacket.getToUserId() + "]不在线，信息发送失败!");
        }
    }
}
