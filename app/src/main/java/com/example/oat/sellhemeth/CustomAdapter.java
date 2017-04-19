package com.example.oat.sellhemeth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends BaseAdapter {
    Context mContext;

    List<String> strImg = new ArrayList<String>();
    List<String> strUser = new ArrayList<String>();
    List<String> strPhone = new ArrayList<String>();


    public CustomAdapter(Context context, List<String> strImg,List<String> strUser,List<String> strPhone) {
        this.mContext = context;
        this.strImg = strImg;
        this.strUser= strUser;
        this.strPhone=strPhone;
    }

    public int getCount() {
        return strImg.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = mInflater.inflate(R.layout.listview_row, parent, false);

        TextView textView = (TextView) view.findViewById(R.id.textView1);
        textView.setText(strUser.get(position));

        TextView textView1 = (TextView) view.findViewById(R.id.textView2);
        textView1.setText(strPhone.get(position));

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);
       // imageView.setBackgroundResource(strImg.get(position));


        Glide.with(mContext)
                .load("http://10.0.2.2/co/"+strImg.get(position))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);













        return view;
    }


}


