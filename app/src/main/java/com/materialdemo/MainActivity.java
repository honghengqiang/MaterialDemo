package com.materialdemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private FloatingActionButton button;
    private CollapsingToolbarLayout main_collapsing;
    private Snackbar snackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);

        main_collapsing = (CollapsingToolbarLayout)findViewById(R.id.main_collapsing);
        main_collapsing.setExpandedTitleColor(Color.rgb(83,204,67));
        main_collapsing.setCollapsedTitleTextColor(Color.rgb(204,67,99));

        button = (FloatingActionButton)findViewById(R.id.button);
        button.setOnClickListener(this);



        //设置回退键
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar = Snackbar.make(v,"返回", Snackbar.LENGTH_LONG);
                Toast.makeText(MainActivity.this, "返回", Toast.LENGTH_SHORT).show();

                snackbar.setAction("Dismiss", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                snackbar.dismiss();
                            }
                        });
                snackbar.show();
            }
        });

    }


    @Override
    public void onClick(View v) {
        if(v!=null) {
            switch (v.getId()) {
                case R.id.button :
                    startActivity(new Intent(MainActivity.this,SecondActivity.class));
                    break;
                default:
                    break;

            }
        }
    }
}
