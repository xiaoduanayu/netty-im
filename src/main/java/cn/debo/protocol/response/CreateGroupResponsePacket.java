package cn.debo.protocol.response;

import cn.debo.protocol.AbstractPacket;

import java.util.List;

import static cn.debo.protocol.command.Command.CREATE_GROUP_RESPONSE;

/**
 * @author debo
 * @date 2019-11-07
 */
public class CreateGroupResponsePacket extends AbstractPacket {
    private boolean success;

    private String groupId;

    private List<String> userNameList;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getUserNameList() {
        return userNameList;
    }

    public void setUserNameList(List<String> userNameList) {
        this.userNameList = userNameList;
    }

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }
}
