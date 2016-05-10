package com.jacksen.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jacksen on 2016/5/10.
 */
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected Context context;

    protected List<T> list;

    protected OnItemClickListener onItemClickListener;

    /**
     * @param context
     * @param list
     */
    public BaseAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateHolder(parent, viewType);
    }


    /**
     * @param parent
     * @param viewType
     * @return
     */
    protected abstract VH onCreateHolder(ViewGroup parent, int viewType);

    /**
     * @param holder
     * @param position
     */
    protected abstract void onBindHolder(VH holder, int position);

    @Override
    public void onBindViewHolder(final VH holder, int position) {
        //
        onBindHolder(holder, position);

        if (null != onItemClickListener) {
            //
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });
            //
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                    return false;
                }
            });
        }
    }


    /*@Override
    public int getItemViewType(int position) {
        return getItemType(position);
    }*/

    /**
     * @param
     * @return
     */
//    protected abstract int getItemType(int position);
    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
