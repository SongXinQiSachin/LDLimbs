package com.sxqsachin.pers.ldlimbs.net.socket;

/**
 *
 * LDLimbsUDPClient
 *
 * Created by SxqSachin on 2017/3/8.
 */

public interface LDLimbsUDPClient extends LDLimbsClient {
    void    sendTo(String host, int port, byte[] data);
    void    receive();
}
