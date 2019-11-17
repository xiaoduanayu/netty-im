package cn.debo.protocol.serialize.impl;

import cn.debo.protocol.serialize.Serializer;
import com.alibaba.fastjson.JSON;

/**
 * @author debo
 * @date 2019-11-07
 */
public class JsonSerializer implements Serializer {

    @Override
    public byte getSerializerAlgorithm() {
        return 1;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
