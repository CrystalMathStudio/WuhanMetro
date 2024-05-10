package com.crystalmath.WuhanMetro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/*
当前任务列表：
1. 对接地图SDK，建议百度地图
2. 开发设置页面，能设置偏好，能保存到文件中
3. 收集地铁数据，给出至少六条地铁路线的站点列表，包含经纬度、一天中人流量变化、少量事故信息等
*/

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottom_navi);

        navigationView.setItemIconTintList(null);
        navigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.menu_home:
                    break;
                case R.id.menu_set:
                    break;
                case R.id.menu_my:
                    break;
            }
            return true;
        });
    }
}
