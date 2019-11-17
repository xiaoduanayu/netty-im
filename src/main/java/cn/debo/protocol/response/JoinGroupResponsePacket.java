package cn.debo.protocol.response;

import cn.debo.protocol.AbstractPacket;

import static cn.debo.protocol.command.Command.JOIN_GROUP_RESPONSE;

/**
 * @author debo
 * @date 2019-11-07
 */
public class JoinGroupResponsePacket extends AbstractPacket {
    private String groupId;

    private boolean success;

    private String reason;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_RESPONSE;
    }
}
