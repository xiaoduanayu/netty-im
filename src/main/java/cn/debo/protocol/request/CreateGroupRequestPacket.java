package cn.debo.protocol.request;

import cn.debo.protocol.AbstractPacket;

import java.util.List;

import static cn.debo.protocol.command.Command.CREATE_GROUP_REQUEST;

/**
 * @author debo
 * @date 2019-11-07
 */
public class CreateGroupRequestPacket extends AbstractPacket {

    private List<String> userIdList;

    public List<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
    }

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_REQUEST;
    }
}
