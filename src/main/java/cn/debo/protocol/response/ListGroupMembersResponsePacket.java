package cn.debo.protocol.response;

import cn.debo.protocol.AbstractPacket;
import cn.debo.session.Session;

import java.util.List;

import static cn.debo.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * @author debo
 * @date 2019-11-07
 */
public class ListGroupMembersResponsePacket extends AbstractPacket {

    private String groupId;

    private List<Session> sessionList;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
