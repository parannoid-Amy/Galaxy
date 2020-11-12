package com.example.galaxy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import com.example.fragment.NewFragment;
import com.example.fragment.ProductsFragment;
import com.example.fragment.SettlementFragment;
import com.example.fragment.UserFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.annotation.NonNull;



public class MainActivity extends AppCompatActivity {
    private ViewPager2 vp;
    public static ImageView newiv;
    public static TextView newtv;
    public static ImageView productiv;
    public static TextView producttv;
    public static ImageView settlementiv;
    public static TextView settlementtv;
    public static ImageView useriv;
    public static TextView usertv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        setContentView(R.layout.activity_main);
        initFragment();
        initClick();
    }

    private void initClick() {
        newiv=findViewById(R.id.imageHome);
        newtv=findViewById(R.id.textHome);
        productiv =findViewById(R.id.imageMovie);
        producttv =findViewById(R.id.textMovie);
        settlementiv=findViewById(R.id.imageCinema);
        settlementtv=findViewById(R.id.textCinema);
        useriv=findViewById(R.id.imageUser);
        usertv=findViewById(R.id.textUser);

        //给首页选项添加点击事件
        LinearLayout btnhome=findViewById(R.id.btnMain);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(0,false);
                initHomeBtnColor();
            }
        });
        //给电影选项添加添加事件
        LinearLayout btnproduct=findViewById(R.id.btnMovie);
        btnproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(1,false);
                initProductBtnColor();
            }
        });
        //给影院选项添加点击事件
        LinearLayout btnsettlement=findViewById(R.id.btnCinema);
        btnsettlement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(2,false);
                initSettlementBtnColor();
            }
        });
        //给我的选项添加点击事件
        LinearLayout btnuser=findViewById(R.id.btnUser);
        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(3,false);
                initUserBtnColor();
            }
        });


    }

    private void initFragment() {
        //创建Fragment集合
        final List<Fragment> list=new ArrayList<>();
        list.add(new NewFragment());
        list.add(new ProductsFragment());
        list.add(new SettlementFragment());
        list.add(new UserFragment());

        vp=findViewById(R.id.viewPager);               //获得ViewPager2控件
//设置预加载的Fragment页面数量，可防止流式布局StaggeredGrid数组越界错误。
        vp.setOffscreenPageLimit(list.size() - 1);                                                                     													//设置适配器
        FragmentStateAdapter adapter=new FragmentStateAdapter(MainActivity.this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return list.get(position);
            }
            @Override
            public int getItemCount() {
                return list.size();
            }
        };

        vp.setAdapter(adapter);                     //把适配器添加给ViewPager2


    }

    /**
     * 选中首页选项时的颜色
     */
    public static void initHomeBtnColor(){
        newiv.setImageResource(R.mipmap.home);
        newtv.setTextColor(Color.rgb(0,188,250));
        productiv.setImageResource(R.mipmap.movie);
        producttv.setTextColor(Color.rgb(148,148,148));
        settlementiv.setImageResource(R.mipmap.cinema);
        settlementtv.setTextColor(Color.rgb(148,148,148));
        useriv.setImageResource(R.mipmap.user);
        usertv.setTextColor(Color.rgb(148,148,148));
    }

    /**
     * 选中电影选项时的颜色
     */
    public static void initProductBtnColor(){
        newiv.setImageResource(R.mipmap.home);
        newtv.setTextColor(Color.rgb(148,148,148));
        productiv.setImageResource(R.mipmap.movie);
        producttv.setTextColor(Color.rgb(0,188,250));
        settlementiv.setImageResource(R.mipmap.cinema);
        settlementtv.setTextColor(Color.rgb(148,148,148));
        useriv.setImageResource(R.mipmap.user);
        usertv.setTextColor(Color.rgb(148,148,148));
    }
    /**
     * 选中影院选项时的颜色
     */
    public static void initSettlementBtnColor(){
        newiv.setImageResource(R.mipmap.home);
        newtv.setTextColor(Color.rgb(148,148,148));
        productiv.setImageResource(R.mipmap.movie);
        producttv.setTextColor(Color.rgb(0,188,250));
        settlementiv.setImageResource(R.mipmap.cinema);
        settlementtv.setTextColor(Color.rgb(0,188,250));
        useriv.setImageResource(R.mipmap.user);
        usertv.setTextColor(Color.rgb(148,148,148));
    }
    /**
     * 选中我的选项时的颜色
     */
    public static void initUserBtnColor(){
        newiv.setImageResource(R.mipmap.home);
        newtv.setTextColor(Color.rgb(148,148,148));
        productiv.setImageResource(R.mipmap.movie);
        producttv.setTextColor(Color.rgb(148,148,148));
        settlementiv.setImageResource(R.mipmap.cinema);
        settlementtv.setTextColor(Color.rgb(148,148,148));
        useriv.setImageResource(R.mipmap.user);
        usertv.setTextColor(Color.rgb(0,188,212));
    }




}