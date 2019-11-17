package cn.debo.util;

import cn.debo.session.Session;
import io.netty.util.AttributeKey;

import java.util.UUID;

/**
 * @author chenjc
 * @since 2019-11-09
 */
public class LoginUtil {

    public static final AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

    public static final Object MONITOR = new Object();

    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0].toUpperCase();
    }
}
