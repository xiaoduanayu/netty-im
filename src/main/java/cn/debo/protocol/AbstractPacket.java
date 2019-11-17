package cn.debo.protocol;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author debo
 * @date 2019-11-07
 */
public abstract class AbstractPacket {
    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;

    /**
     * 命令类型
     *
     * @return
     */
    @JSONField(serialize = false)
    public abstract Byte getCommand();

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }
}
