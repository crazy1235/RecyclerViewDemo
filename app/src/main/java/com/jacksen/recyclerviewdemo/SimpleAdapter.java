package com.jacksen.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacksen on 2016/5/10.
 */
public class SimpleAdapter extends BaseAdapter<String, SimpleViewHolder> {

    private boolean flag = false;

    private List<Integer> itemHeights = new ArrayList<>();

    /**
     * @param context
     * @param list
     */
    public SimpleAdapter(Context context, List<String> list) {
        super(context, list);
        for (int i = 0; i < list.size(); i++) {
            itemHeights.add((int) (250 + Math.random() * 350));
        }
    }

    @Override
    protected SimpleViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    protected void onBindHolder(SimpleViewHolder holder, int position) {
        if (flag) {
            resetItemHeight(holder, position);
        }
        holder.textView.setText(list.get(position));
    }

    /**
     * @param holder
     */
    private void resetItemHeight(SimpleViewHolder holder, int position) {
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = itemHeights.get(position);
        holder.itemView.setLayoutParams(lp);
    }

    /**
     *
     */
    public void setRandomHeight(boolean flag) {
        this.flag = flag;
    }

    /**
     * add one item
     *
     * @param position
     */
    public void addItem(int position) {
        list.add(position, "I am the new one.");
        itemHeights.add(position, (int) (250 + Math.random() * 350));
        notifyItemInserted(position);
    }

    /**
     * delete one item
     *
     * @param position
     */
    public void deleteItem(int position) {
        if (2 < list.size()) {
            list.remove(2);
            itemHeights.remove(position);
            notifyItemRemoved(2);
        }
    }


}

class SimpleViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public SimpleViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.item_tv);
    }
}
