package com.jacksen.recyclerviewdemo;

import android.view.View;

/**
 * Created by jacksen on 2016/5/3.
 */
public interface OnItemClickListener {

    void onItemClick(View view, int position);

    void onItemLongClick(View view, int position);
}
