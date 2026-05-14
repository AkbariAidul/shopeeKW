package com.haikaldanaidul.shopeeapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridItemAdapter extends BaseAdapter {
    Context context;

    String[] title, price, sold;

    int[] image;

    LayoutInflater inflater;

    public GridItemAdapter(Context context, String[] title, String[] price, String[] sold, int[] image) {
        this.context = context;
        this.title = title;
        this.price = price;
        this.sold = sold;
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
            convertView = inflater.inflate(R.layout.grid_item_layout, null);
        }
        //identifier, convertView=parameter
        ImageView itemImg = convertView.findViewById(R.id.itemImg);
        TextView txtTitle = convertView.findViewById(R.id.itemTitle);
        TextView txtPrice = convertView.findViewById(R.id.itemPrice);
        TextView txtSold = convertView.findViewById(R.id.itemSold);

        //mengatur tampilan grid_item_layout.xml sesuai inputan array yang diterima oleh GridItemAdapter.java
        itemImg.setImageResource(image[position]);
        txtTitle.setText(title[position]);
        txtPrice.setText(price[position]);
        txtSold.setText(sold[position]);

        return convertView;
    }
}
