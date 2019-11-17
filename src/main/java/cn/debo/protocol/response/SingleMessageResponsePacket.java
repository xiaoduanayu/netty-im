package cn.debo.protocol.response;

import cn.debo.protocol.AbstractPacket;
import cn.debo.protocol.command.Command;

/**
 * @author debo
 * @date 2019-11-07
 */
public class SingleMessageResponsePacket extends AbstractPacket {

    private String fromUserId;

    private String fromUserName;

    private String message;

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.SINGLE_MESSAGE_RESPONSE;
    }
}
