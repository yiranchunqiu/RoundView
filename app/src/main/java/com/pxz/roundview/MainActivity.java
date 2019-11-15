package com.pxz.roundview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 类说明：首页
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/15 10:07
 */
public class MainActivity extends AppCompatActivity {
    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        tvText = findViewById(R.id.tv_text);
    }

    private void initData() {
        //设置不可点击
        tvText.setEnabled(false);
    }
}