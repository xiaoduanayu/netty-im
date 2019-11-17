package cn.debo.protocol.response;

import cn.debo.protocol.AbstractPacket;

import static cn.debo.protocol.command.Command.LOGIN_RESPONSE;

/**
 * @author debo
 * @date 2019-11-07
 */
public class LoginResponsePacket extends AbstractPacket {
    private String userId;

    private String userName;

    private boolean success;

    private String reason;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return LOGIN_RESPONSE;
    }
}
