package com.sxqsachin.pers.ldlimbs.net.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * SimpleLDLimbsUDPClient
 *
 * Created by SxqSachin on 2017/3/8.
 */

public class SimpleLDLimbsUDPClient implements LDLimbsUDPClient {

    public SimpleLDLimbsUDPClient() {
    }

    @Override
    public void init() {
        if (socket == null) {
            try {
                socket = new DatagramSocket(9000);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendTo(String host, int port, byte[] data) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receive() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] bytes = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
                while (stillReceive) {
                    try {
                        socket.receive(packet);
                        System.out.println(new String(packet.getData()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void close() {
        socket.disconnect();
        socket.close();
    }

    @Override
    public boolean isConnected() {
        return socket != null && socket.isConnected();
    }

    private DatagramSocket socket = null;
    private boolean stillReceive = true;
}
