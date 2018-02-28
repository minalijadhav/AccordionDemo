package com.example.admin.accordiondemo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.accordiondemo.R;

/**
 * Created by Admin on 27/02/2018.
 */

public class ViewPagerAdapter extends PagerAdapter
{
    private Context context;
    private int[] array_list;

    public ViewPagerAdapter(Context context, int[] array_list)
    {
        this.context = context;
        this.array_list = array_list;
    }

    @Override
    public int getCount()
    {
        return array_list.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View convertView = LayoutInflater.from(context).inflate(R.layout.view_pager_item, container, false);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);
        imageView.setBackgroundResource(array_list[position]);

        container.addView(convertView);

        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        View convertView = (View) object;
        container.removeView(convertView);
    }
}
