package com.bawei.volleystudio1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.volleystudio1.bean.JsonBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private List<JsonBean.ResultBean> list;

    public RecyclerAdapter(Context context, List<JsonBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, int i) {
        viewHolder.textPrice.setText(list.get(i).getPrice()+"");
        viewHolder.textTitle.setText(list.get(i).getCommodityName());
        viewHolder.textNum.setText(list.get(i).getSaleNum()+"");
        Glide.with(context).load(list.get(i).getMasterPic()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textTitle,textPrice,textNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            textTitle = (TextView)itemView.findViewById(R.id.textTitle);
            textPrice = (TextView)itemView.findViewById(R.id.textPrice);
            textNum = (TextView)itemView.findViewById(R.id.textNum);
        }
    }
}
