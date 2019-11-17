package cn.debo.server.handler;

import cn.debo.protocol.AbstractPacket;
import cn.debo.protocol.command.Command;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author debo
 * @date 2019-11-07
 */
@ChannelHandler.Sharable
public class HandlerAggregator extends SimpleChannelInboundHandler<AbstractPacket> {
    public static final HandlerAggregator INSTANCE = new HandlerAggregator();

    private Map<Byte, SimpleChannelInboundHandler<? extends AbstractPacket>> handlerMap;

    private HandlerAggregator() {
        handlerMap = new HashMap<>();
        handlerMap.put(Command.SINGLE_MESSAGE_REQUEST, SingleMessageRequestHandler.INSTANCE);
        handlerMap.put(Command.CREATE_GROUP_REQUEST, CreateGroupRequestHandler.INSTANCE);
        handlerMap.put(Command.JOIN_GROUP_REQUEST, JoinGroupRequestHandler.INSTANCE);
        handlerMap.put(Command.QUIT_GROUP_REQUEST, QuitGroupRequestHandler.INSTANCE);
        handlerMap.put(Command.LIST_GROUP_MEMBERS_REQUEST, ListGroupMembersRequestHandler.INSTANCE);
        handlerMap.put(Command.GROUP_MESSAGE_REQUEST, GroupMessageRequestHandler.INSTANCE);
        handlerMap.put(Command.LOGOUT_REQUEST, LogoutRequestHandler.INSTANCE);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AbstractPacket packet) throws Exception {
        handlerMap.get(packet.getCommand()).channelRead(ctx, packet);
    }
}
