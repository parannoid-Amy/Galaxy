package com.example.adapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.galaxy.R;

public class NewAdapter extends  RecyclerView.Adapter<NewAdapter.ViewHolder>{
    private FragmentActivity activity;
    private int[] image;
    private String[] text;
    public NewAdapter(FragmentActivity activity, int[] image, String[] text) {
    }
    ImageView iv;
    TextView tv;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item,parent,false);
        ViewHolder holder=new ViewHolder(view);                     //调用内部类ViewHolder
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        //异步加载选项数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if((image.length!=0)&&(text.length!=0)){
                            holder.iv.setImageResource(image[position]);
                            holder.tv.setText(text[position]);
                        }
                    }
                });
            }
        }).start();

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        private final ImageView iv;
        private final TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.newImage);               //获得列表选项图片控件
            tv=itemView.findViewById(R.id.newText);                 //获得列表选项文本控件
        }

}
}
