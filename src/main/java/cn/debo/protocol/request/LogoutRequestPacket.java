package cn.debo.protocol.request;

import cn.debo.protocol.AbstractPacket;
import cn.debo.protocol.command.Command;

/**
 * @author debo
 * @date 2019-11-07
 */
public class LogoutRequestPacket extends AbstractPacket {

    @Override
    public Byte getCommand() {
        return Command.LOGOUT_REQUEST;
    }
}
