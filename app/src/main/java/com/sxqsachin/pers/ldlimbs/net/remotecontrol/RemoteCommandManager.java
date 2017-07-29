package com.sxqsachin.pers.ldlimbs.net.remotecontrol;

import com.sxqsachin.pers.ldlimbs.net.socket.LDLimbsUDPClient;
import com.sxqsachin.pers.ldlimbs.net.socket.SimpleLDLimbsUDPClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * RemoteCommandManager
 *
 * Created by SxqSachin on 2017/3/8.
 */

public class RemoteCommandManager {
    private static LDLimbsUDPClient client;

    private static String host;
    private static int port;

    private static ExecutorService cmdPool;

    public static void init() {
        cmdPool = Executors.newSingleThreadExecutor();
    }

    public static void stop() {
        if (client != null) {
            client.close();
        }
    }

    public static boolean isConnected() {
        return client != null && client.isConnected();
    }

    public static void bindToRemote(String host, int port) {
        client = new SimpleLDLimbsUDPClient();
        client.init();

        RemoteCommandManager.host = host;
        RemoteCommandManager.port = port;
    }

    public static void postCmd(final String cmd) {
        if (client == null) {
            return;
        }

        cmdPool.execute(new Runnable() {
            @Override
            public void run() {
                String data = RemoteControlType.CMD.getName() + cmd;
                client.sendTo(host, port, data.getBytes());
            }
        });
    }

    public static void setCursorPos(final int x, final int y) {
        if (client == null) {
            return;
        }
        cmdPool.execute(new Runnable() {
            @Override
            public void run() {
                String data = RemoteControlType.SETMOUSEPOS.getName() + x + "|" + y;
                client.sendTo(host, port, data.getBytes());
            }
        });
    }

    public static void setCursorPrecision(final float precision) {
        if (client == null) {
            return;
        }
        cmdPool.execute(new Runnable() {
            @Override
            public void run() {
                String data = RemoteControlType.SETMOUSEPRECISION.getName() + precision;
                client.sendTo(host, port, data.getBytes());
            }
        });
    }

    public static void sendMouseEvent(final RemoteControlType.MouseEvent event) {
        if (client == null) {
            return;
        }
        cmdPool.execute(new Runnable() {
            @Override
            public void run() {
                String data = event.getName();
                client.sendTo(host, port, data.getBytes());
            }
        });
    }
}
