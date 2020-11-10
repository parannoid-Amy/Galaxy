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

public class MovieFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.products_fragment,container,false);          //关联布局文件

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        MainActivity.initProductBtnColor();
    }


}
