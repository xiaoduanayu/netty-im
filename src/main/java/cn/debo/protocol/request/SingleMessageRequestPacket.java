package cn.debo.protocol.request;

import cn.debo.protocol.AbstractPacket;
import cn.debo.protocol.command.Command;

/**
 * @author debo
 * @date 2019-11-07
 */
public class SingleMessageRequestPacket extends AbstractPacket {
    private String toUserId;
    private String message;

    public SingleMessageRequestPacket() {
    }

    public SingleMessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.SINGLE_MESSAGE_REQUEST;
    }
}
