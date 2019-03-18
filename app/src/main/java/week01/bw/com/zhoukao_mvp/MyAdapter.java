package week01.bw.com.zhoukao_mvp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    List<MenuBean.DataBean> list = new ArrayList<>();
    Context context;

    public void refresh(Context context,List<MenuBean.DataBean> data){
        this.context = context;
        list.clear();
        this.list.addAll(data);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(list.get(i).getTitle());
        Glide.with(context).load(list.get(i).getPic())
                .bitmapTransform(new CropCircleTransformation(myViewHolder.itemView.getContext()))
                .into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_img);
            textView = itemView.findViewById(R.id.item_tv);
        }
    }
}
