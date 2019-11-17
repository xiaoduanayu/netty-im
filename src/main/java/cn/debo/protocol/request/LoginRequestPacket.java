package cn.debo.protocol.request;

import cn.debo.protocol.AbstractPacket;

import static cn.debo.protocol.command.Command.LOGIN_REQUEST;

/**
 * @author debo
 * @date 2019-11-07
 */
public class LoginRequestPacket extends AbstractPacket {
    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
