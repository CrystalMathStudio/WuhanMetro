package com.crystalmath.WuhanMetro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import com.crystalmath.WuhanMetro.frag.BaiduMapFragment;
import com.crystalmath.WuhanMetro.frag.MyFragment;
import com.crystalmath.WuhanMetro.frag.PreferencesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/*
当前任务列表：
1. 对接地图SDK，建议百度地图
2. 开发设置页面，能设置偏好，能保存到文件中
3. 收集地铁数据，给出至少六条地铁路线的站点列表，包含经纬度、一天中人流量变化、少量事故信息等
*/

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private FragmentContainerView fragmentContainer;
    Fragment fragment1 = new BaiduMapFragment();
    Fragment fragment2 = new MyFragment();
    Fragment fragment3=new PreferencesFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentContainer = findViewById(R.id.fragmentContainerView);
        navigationView = findViewById(R.id.bottom_navi);

        navigationView.setItemIconTintList(null);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainerView, fragment1)
                .add(R.id.fragmentContainerView, fragment2)
                .add(R.id.fragmentContainerView, fragment3)
                        .commit();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        replaceFragment(fragment1);
                        break;
                    case R.id.menu_set:
                        replaceFragment(fragment2);
                        break;
                    case R.id.menu_my:
                        replaceFragment(fragment3);
                        break;
                }
                return true;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        // 添加FragmentA到容器中
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack(); // 从回退栈中弹出最近的一个Fragment状态并显示它
        } else {
            super.onBackPressed(); // 如果回退栈为空，则调用父类的onBackPressed方法关闭Activity
        }
    }
}
