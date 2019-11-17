package cn.debo.protocol.response;

import cn.debo.protocol.AbstractPacket;
import cn.debo.protocol.command.Command;
import cn.debo.session.Session;

/**
 * @author debo
 * @date 2019-11-07
 */
public class GroupMessageResponsePacket extends AbstractPacket {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    public String getFromGroupId() {
        return fromGroupId;
    }

    public void setFromGroupId(String fromGroupId) {
        this.fromGroupId = fromGroupId;
    }

    public Session getFromUser() {
        return fromUser;
    }

    public void setFromUser(Session fromUser) {
        this.fromUser = fromUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_RESPONSE;
    }
}
