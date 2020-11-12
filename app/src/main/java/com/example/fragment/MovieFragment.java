package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.galaxy.MainActivity;
import com.example.galaxy.R;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.adapter.NewAdapter;


public class MovieFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.movie_fragment,container,false);          //关联布局文件
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView  rv=view.findViewById(R.id.newRecycler);       //获得RecyclerView控件对象                                                                              														   //设置为StaggeredGridLayout流式布局
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));                                                                              														   //定义新品小吃图片数组
        int[] image={R.mipmap.bf11,R.mipmap.bf3,R.mipmap.om1,R.mipmap.om7,R.mipmap.yc1,
                R.mipmap.nf10,R.mipmap.nf8};                                                                              														   //定义新品小吃说明数组
        String[] text={"嘎嘣脆香煎饼果子","鲜嫩多汁小笼包","薯条鸡肉丸组合","北欧蜜汁奶粉果",
                "什锦串串烤","川味凉面","自贡脆脆兔"};

        NewAdapter adapter=new NewAdapter(getActivity(),image,text); //调用适配器

    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.initProductBtnColor();
    }


}
