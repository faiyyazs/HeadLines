package com.headlines.bindingadapters;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.headlines.data.converters.DateConverter;
import com.headlines.remote.Resource;
import com.headlines.ui.BaseAdapter;

import java.util.Date;
import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class ViewBindingAdapters {


    private ViewBindingAdapters(){

    }

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;

        if(resource == null || resource.data == null)
            return;

        if(adapter instanceof BaseAdapter){
            ((BaseAdapter)adapter).setData((List) resource.data);
        }
    }


    @BindingAdapter(value = {"formattedDate","timeFormat"},requireAll = true)
    public static void setFormattedDate(TextView textView, Date date, boolean time){
        if (date != null) {
            textView.setText(DateConverter.formatDate(date, time));
        }
    }


    @BindingAdapter(value = {"url"})
    public static void setImageUrl(ImageView imageView, String url){
        if (url != null) {
            Glide.with(imageView.getContext())
                    .load(url).into(imageView);
        }
    }





}
