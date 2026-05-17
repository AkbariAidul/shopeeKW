package com.haikaldanaidul.shopeeapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridCartItemAdapter extends BaseAdapter {
    Context context;

    String[] title, price;

    int[] image;

    LayoutInflater inflater;

    public GridCartItemAdapter(Context context, String[] title, String[] price, int[] image) {
        this.context = context;
        this.title = title;
        this.price = price;
        this.image = image;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            //menghubungkan GridItemAdapter.java dengan grid_item_layout.xml
            convertView = inflater.inflate(R.layout.grid_cart_item, null);
        }
        //identifier, convertView=parameter
        ImageView cartImg = convertView.findViewById(R.id.cartImg);
        TextView cartTitle = convertView.findViewById(R.id.cartTitle);
        TextView cartPrice = convertView.findViewById(R.id.cartPrice);


        //mengatur tampilan grid_cart_item.xml sesuai inputan array yang diterima oleh GridCartItemAdapter.java
        cartImg.setImageResource(image[position]);
        cartTitle.setText(title[position]);
        cartPrice.setText(price[position]);

        return convertView;
    }
}
