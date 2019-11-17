package cn.debo.protocol.response;

import cn.debo.protocol.AbstractPacket;

import static cn.debo.protocol.command.Command.HEARTBEAT_RESPONSE;

/**
 * @author debo
 * @date 2019-11-07
 */
public class HeartbeatResponsePacket extends AbstractPacket {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
