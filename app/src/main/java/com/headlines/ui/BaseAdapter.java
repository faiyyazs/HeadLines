package com.headlines.ui;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Generic Base adapter for recycler views
 * <p>
 * Author: Lajesh D
 * Email: lajeshds2007@gmail.com
 * Created: 7/24/2018
 * Modified: 7/24/2018
 */
public abstract class BaseAdapter<T extends RecyclerView.ViewHolder, D> extends RecyclerView.Adapter<T>{

    public abstract void setData(List<D> data);
}