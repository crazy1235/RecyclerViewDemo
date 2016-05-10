package com.jacksen.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;

/**
 * Created by jacksen on 2016/5/10.
 */
public abstract class OnScrollDetector extends RecyclerView.OnScrollListener {

    private OnLoadListener onLoadListener;

    public OnScrollDetector() {
    }

    public OnScrollDetector(OnLoadListener onLoadListener) {
        this.onLoadListener = onLoadListener;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }
}
