package cn.debo.protocol.response;

import cn.debo.protocol.AbstractPacket;

import static cn.debo.protocol.command.Command.LOGOUT_RESPONSE;

/**
 * @author debo
 * @date 2019-11-07
 */
public class LogoutResponsePacket extends AbstractPacket {

    private boolean success;

    private String reason;

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
        return LOGOUT_RESPONSE;
    }
}
