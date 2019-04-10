package com.koexample.one.welcome;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button Start;
    private TextView Welcome;
    private SharedPreferences dataStore;//存储旧时间点
    private static final String KEY = "TIME";
    private long oldTime = -1L;
    private long nowTime = -1L;
    private DateUtil dateUtil = new DateUtil();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initData();
        initView();
    }

    private void initData() {
        dataStore = getSharedPreferences("WelCome", Context.MODE_PRIVATE);
        oldTime = dataStore.getLong(KEY, -1L);
        nowTime = dateUtil.getDate();
        dataStore.edit()
                .putLong(KEY, nowTime)
                .commit();
    }

    private void initView() {
        Welcome = findViewById(R.id.welcome);
        Start = findViewById(R.id.start);
        Start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int diff = dateUtil.getDiff(oldTime, nowTime);
        if (diff >= 0 && diff <= 2) {//小于三天
            Welcome.setText("欢迎经常使用");
        } else if (diff == -1) {//第一次登录
            Welcome.setText("欢迎初次使用");
        } else {//大于三天
            Welcome.setText("好久不见，欢迎再次使用");
        }
    }
}
