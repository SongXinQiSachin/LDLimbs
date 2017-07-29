package com.sxqsachin.pers.ldlimbs.net.remotecontrol;

/**
 *
 * RemoteControlType
 *
 * Created by SxqSachin on 2017/3/8.
 */

public enum RemoteControlType implements IRemoteControlType {

    SETMOUSEPOS{
        @Override
        public String getName() {
            return "EVENT_00010";
        }
    },
    SETMOUSEPRECISION {
        @Override
        public String getName() {
            return "EVENT_00001";
        }
    },

    CMD{
        @Override
        public String getName() {
            return "EVENT_10000";
        }
    };
    public enum MouseEvent implements IRemoteControlType {
        BEGINMOVE{
            @Override
            public String getName() {
                return "EVENT_00011";
            }
        },
        ENDMOVE{
            @Override
            public String getName() {
                return "EVENT_00012";
            }
        },
        LMOUSEBUTTONDOWN{
            @Override
            public String getName() {
                return "EVENT_00002";
            }
        },
        LMOUSEBUTTONUP{
            @Override
            public String getName() {
                return "EVENT_00003";
            }
        },
        RMOUSEBUTTONDOWN{
            @Override
            public String getName() {
                return "EVENT_00004";
            }
        },
        RMOUSEBUTTONUP{
            @Override
            public String getName() {
                return "EVENT_00005";
            }
        },
        MMOUSEBUTTONDOWN{
            @Override
            public String getName() {
                return "EVENT_00006";
            }
        },
        MMOUSEBUTTONUP{
            @Override
            public String getName() {
                return "EVENT_00007";
            }
        },
    }
}

interface IRemoteControlType {
    String  getName();
}
