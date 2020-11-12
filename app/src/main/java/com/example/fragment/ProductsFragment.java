package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.adapter.NewAdapter;
import com.example.adapter.ProductRightAdapter;
import com.example.entity.Product;
import com.example.galaxy.MainActivity;
import com.example.galaxy.R;

import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {
    public static List<List<Product>> list=new ArrayList<>();  //定义存放右边列表所有选项数据的集合
    public static RecyclerView rightrv;
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
    private void  initRecyclerView(View view){
        RecyclerView  rv=view.findViewById(R.id.newRecycler);       //获得RecyclerView控件对象                                                                              														   //设置为StaggeredGridLayout流式布局
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));                                                                              														   //定义新品小吃图片数组
        int[] image={R.mipmap.bf11,R.mipmap.bf3,R.mipmap.om1,R.mipmap.om7,R.mipmap.yc1,
                R.mipmap.nf10,R.mipmap.nf8};                                                                              														   //定义新品小吃说明数组
        String[] text={"嘎嘣脆香煎饼果子","鲜嫩多汁小笼包","薯条鸡肉丸组合","北欧蜜汁奶粉果",
                "什锦串串烤","川味凉面","自贡脆脆兔"};

        NewAdapter adapter=new NewAdapter(getActivity(),image,text); //调用适配器

        //定义5组小吃图片
        int[] nfimage={R.mipmap.nf1,R.mipmap.nf2,R.mipmap.nf3,R.mipmap.nf4,R.mipmap.nf5,R.mipmap.nf6,
                R.mipmap.nf7,R.mipmap.nf8,R.mipmap.nf9,R.mipmap.nf10,R.mipmap.nf11};
        int[] bfimage={R.mipmap.bf1,R.mipmap.bf2,R.mipmap.bf3,R.mipmap.bf4,R.mipmap.bf5,R.mipmap.bf6,
                R.mipmap.bf7,R.mipmap.bf8,R.mipmap.bf9,R.mipmap.bf10,R.mipmap.bf11};
        int[] ycimage={R.mipmap.yc1,R.mipmap.yc2,R.mipmap.yc3,R.mipmap.yc4,R.mipmap.yc5,R.mipmap.yc6,
                R.mipmap.yc7,R.mipmap.yc8,R.mipmap.yc9,R.mipmap.yc10};
        int[] yzimage={R.mipmap.yz1,R.mipmap.yz2,R.mipmap.yz3,R.mipmap.yz4,R.mipmap.yz5,R.mipmap.yz6,
                R.mipmap.yz7,R.mipmap.yz8,R.mipmap.yz9,R.mipmap.yz10,R.mipmap.yz11,};
        int[] omimage={R.mipmap.om1,R.mipmap.om2,R.mipmap.om3,R.mipmap.om4,R.mipmap.om5,
                R.mipmap.om6,R.mipmap.om7,R.mipmap.om8,R.mipmap.om9,R.mipmap.om10,};
//定义5组小吃名称
        String[] nfname={"南方小吃1","南方小吃2","南方小吃3","南方小吃4","南方小吃5","南方小吃6",
                "南方小吃7","南方小吃8","南方小吃9","南方小吃10","南方小吃11"};
        String[] bfname={"北方小吃1","北方小吃2","北方小吃3","北方小吃4","北方小吃5","北方小吃6",
                "北方小吃7","北方小吃8","北方小吃9","北方小吃10","北方小吃11"};
        String[] ycname={"原创小吃1","原创小吃2","原创小吃3","原创小吃4","原创小吃5","原创小吃6",
                "原创小吃7","原创小吃8","原创小吃9","原创小吃10"};
        String[] yzname={"亚洲小吃1","亚洲小吃2","亚洲小吃3","亚洲小吃4","亚洲小吃5","亚洲小吃6",
                "亚洲小吃7","亚洲小吃8","亚洲小吃9","亚洲小吃10","亚洲小吃11"};
        String[] omname={"欧美小吃1","欧美小吃2","欧美小吃3","欧美小吃4","欧美小吃5","欧美小吃6",
                "欧美小吃7","欧美小吃8","欧美小吃9","欧美小吃10"};
        //定义5组小吃价格
        String[] nfprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5","8.0"};
        String[] bfprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5","8.0"};
        String[] ycprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5"};
        String[] yzprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5","8.0"};
        String[] omprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5"};
        //获取南方小吃分类数据，并添加的集合里。
        List<Product>  listright1=getList(nfimage, nfname, nfprice);
        list.add(listright1);
        //获取北方小吃分类数据，并添加的集合里。
        List<Product>  listright2=getList(bfimage, bfname, bfprice);
        list.add(listright2);
        //获取原创小吃分类数据，并添加的集合里。
        List<Product>  listright3=getList(ycimage, ycname, ycprice);
        list.add(listright3);
        //获取亚洲小吃分类数据，并添加的集合里。
        List<Product>  listright4=getList(yzimage, yzname, yzprice);
        list.add(listright4);
        //获取欧美小吃分类数据，并添加的集合里。
        List<Product>  listright5=getList(omimage, omname, omprice);
        list.add(listright5);
        rightrv=view.findViewById(R.id.rightRecycler);    //bro你这接着做，还没做完的对吧，所以没这个东西           //获得右边列表控件对象
        //设置为上下结构的LinearLayout布局
        rightrv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        //调用右边列表适配器类
        ProductRightAdapter rightAdapter=new ProductRightAdapter(getActivity(),listright1);

        rightrv.setAdapter(rightAdapter);                          //把适配器设置给右边列表控件



    }

    /**
     * 本方法用于生成右边列表选项数据集合
     * @param iamges 传入一组小吃图片
     * @param names 传入一组小吃名称
     * @param prices 传入一组小吃价格
     * @return 返回一个分类的所有小吃数据集合
     */
    public List<Product> getList(int[] iamges, String[] names, String[] prices){
        List<Product>  listright=new ArrayList<>();                 //存放右边列表所有数据
        Product product;                                      //用于存放一个选项数据
        for(int i=0;i<iamges.length;i++){
            product=new Product();
            product.setImage(iamges[i]);
            product.setName(names[i]);
            product.setPrice(prices[i]);
            listright.add(product);
        }
        return listright;
    }


}
