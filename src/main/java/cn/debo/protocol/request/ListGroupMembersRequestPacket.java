package cn.debo.protocol.request;

import cn.debo.protocol.AbstractPacket;

import static cn.debo.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

/**
 * @author debo
 * @date 2019-11-07
 */
public class ListGroupMembersRequestPacket extends AbstractPacket {

    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
