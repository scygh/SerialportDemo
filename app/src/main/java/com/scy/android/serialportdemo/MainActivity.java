package com.scy.android.serialportdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import android_serialport_api.SerialPortUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SerialPortUtils serialPortUtils = new SerialPortUtils();
        serialPortUtils.openSerialPort();
        //serialPortUtils.sendSerialPort("你好啊，机器");
        serialPortUtils.setOnDataReceiveListener(new SerialPortUtils.OnDataReceiveListener() {
            @Override
            public void onDataReceive(byte[] buffer, int size) {
                if (buffer != null) {
                    Toast.makeText(MainActivity.this, "接收到串口数据" + new String(buffer, 0, size), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "串口数据为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
