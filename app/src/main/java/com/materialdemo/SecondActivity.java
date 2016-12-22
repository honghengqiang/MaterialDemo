package com.materialdemo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends BaseActivity implements View.OnClickListener {

    private NavigationView navigationView;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, 0, 0);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navViewToTop();

        navigationView = (NavigationView)findViewById(R.id.navigationView);
        //如果我想让图片就是显示他本身  本质通知适配器刷新数据
        navigationView.setItemIconTintList(null);

        //给他们设置监听事件
        //头部监听
        View view = navigationView.getHeaderView(0);
        view.findViewById(R.id.iv).setOnClickListener(this);
        view.findViewById(R.id.name).setOnClickListener(this);
        view.findViewById(R.id.maxId).setOnClickListener(this);
        //菜单监听
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()) {
                   case R.id.menu1 :
                        startActivity(new Intent(SecondActivity.this,TopImageActivity.class));
                       break;
                   default:
                       break;
               }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }

    public void toastMsg(String message){
        Toast.makeText(SecondActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    //当系统版本小于5.0时，进行如下设置：
    private void navViewToTop() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            mDrawerLayout.setFitsSystemWindows(true);
            mDrawerLayout.setClipToPadding(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv :
                toastMsg("图标");
                break;
            case R.id.name :
                toastMsg("名字");
                break;
            case R.id.maxId :
                toastMsg("MaxId");
                break;
        }
    }
}
