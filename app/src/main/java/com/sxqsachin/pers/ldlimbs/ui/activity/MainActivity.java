package com.sxqsachin.pers.ldlimbs.ui.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

import com.sxqsachin.pers.ldlimbs.R;
import com.sxqsachin.pers.ldlimbs.databinding.MainActivityBinding;
import com.sxqsachin.pers.ldlimbs.databinding.ui.MainActivityData;
import com.sxqsachin.pers.ldlimbs.net.remotecontrol.RemoteCommandManager;
import com.sxqsachin.pers.ldlimbs.net.remotecontrol.RemoteControlType;

/**
 *
 * MainActivity
 *
 * Created by SxqSachin on 2017/3/8.
 */

public class MainActivity extends AppCompatActivity {

    private MainActivityData    mainActivityData;
    private MainActivityBinding mainActivityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainActivityData = new MainActivityData();

        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        mainActivityBinding.setData(mainActivityData);

        mainActivityData.setToolbarTitle("LDLimbsDataText");
        mainActivityData.setToolbarBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mainActivityData.setToolbarTitleColor(Color.WHITE);

        RemoteCommandManager.init();
//        RemoteCommandManager.bindToRemote("192.168.1.159", 3000);

        mainActivityBinding.btnLbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoteCommandManager.sendMouseEvent(RemoteControlType.MouseEvent.LMOUSEBUTTONDOWN);
                RemoteCommandManager.sendMouseEvent(RemoteControlType.MouseEvent.LMOUSEBUTTONUP);
                System.out.println("ldb");
            }
        });

        mainActivityBinding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Start Connected");
                if (!RemoteCommandManager.isConnected()) {
                    String str = mainActivityBinding.etHost.getText().toString();
                    System.out.println(str);
                    RemoteCommandManager.bindToRemote(str, 3000);
                } else {
                    System.out.println("Connected!");
                }
            }
        });

        mainActivityBinding.btnConfirmCmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainActivityBinding.etCmd.getText().length() > 0) {
                    RemoteCommandManager.postCmd(mainActivityBinding.etCmd.getText().toString());
                }
            }
        });

        mainActivityBinding.rlMain.setOnTouchListener(new View.OnTouchListener() {
            float downX = 0.0f;
            float downY = 0.0f;
            @Override
            public boolean onTouch(View v, final MotionEvent event) {
                ValueAnimator oa = ObjectAnimator.ofFloat(0, 1);

                switch(event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        RemoteCommandManager.setCursorPos((int)event.getX() - (int)downX, (int)event.getY() - (int) downY);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        downX = event.getX();
                        downY = event.getY();
                        RemoteCommandManager.sendMouseEvent(RemoteControlType.MouseEvent.BEGINMOVE);
                        break;

                    case MotionEvent.ACTION_UP:
                        downX = 0.0f;
                        downY = 0.0f;
                        RemoteCommandManager.sendMouseEvent(RemoteControlType.MouseEvent.ENDMOVE);
                        break;
                }
                return true;
            }
        });

        mainActivityBinding.sbPrecision.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RemoteCommandManager.setCursorPrecision((float) progress / 10);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        RemoteCommandManager.stop();
    }
}
