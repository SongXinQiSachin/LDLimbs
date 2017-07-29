package com.sxqsachin.pers.ldlimbs.net.socket;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * SimpleLDLimbsUDPServer
 *
 * Created by SxqSachin on 2017/3/8.
 */

public class SimpleLDLimbsUDPServer implements LDLimbsUDPServer {
    public SimpleLDLimbsUDPServer(int port) {
        this.port = port;
    }

    @Override
    public void init() {
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {

    }

    public int getPort() {
        return port;
    }

    private DatagramSocket socket = null;

    private int port = 0;
    private byte[] bytes = new byte[1024];
}
