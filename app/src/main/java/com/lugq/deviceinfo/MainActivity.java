package com.lugq.deviceinfo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Context mContext;
    private TextView tv_ip, tv_screen_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        Button btn_getIp = (Button) findViewById(R.id.get_ip);
        Button get_screen_size = (Button) findViewById(R.id.get_screen_size);
        tv_screen_size = (TextView) findViewById(R.id.tv_screen_size);
        get_screen_size.setOnClickListener(this);
        btn_getIp.setOnClickListener(this);
        tv_ip = (TextView) findViewById(R.id.tv_ip);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.get_ip) {
            String ip = IpUtils.getIpAddressString();
            tv_ip.setText("IP地址：" + ip);
            return;
        }

        if (id == R.id.get_screen_size) {
            int[] wh = ScreenUtil.getScreenSize(mContext);
            tv_screen_size.setText("屏幕宽高：" + wh[0] + "*" + wh[1]);
        }
    }
}
