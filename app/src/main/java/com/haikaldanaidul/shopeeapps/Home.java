package com.haikaldanaidul.shopeeapps;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        if(Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.shopee));
        }

        //c = content
        int[] cimg = {
                R.drawable.item_1,
                R.drawable.item_2,
                R.drawable.item_3,
                R.drawable.item_4,
                R.drawable.item_1,
                R.drawable.item_2,
        };
        String[] ctitle = {
                "Ryu Mesin Pressure\nWasher RPW-100...",
                "Tatakan box motor\nTouring...",
                "Corolla mesin cuci\nmobil motor...",
                "Celana panjang tactical\ncargo pria...",
                "Tatakan box motor\nTouring...",
                "Corolla mesin cuci\nmobil motor...",
        };
        String[] cprice = {
                "Rp234.600",
                "Rp100.000",
                "Rp700.500",
                "Rp777.600",
                "Rp812.600",
                "Rp333.000"
        };
        String[] csold = {
                "4 terjual",
                "4 terjual",
                "4 terjual",
                "4 terjual",
                "4 terjual",
                "4 terjual"
        };

        GridItemAdapter gridItemAdapter = new GridItemAdapter(Home.this, ctitle, cprice, csold, cimg); //item yang ingin ditampilkan
        GridView gridItem = findViewById(R.id.gridItem); //identifier
        gridItem.setAdapter(gridItemAdapter); //menampilkan item di gridView

        gridItem.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openDetail = new Intent(Home.this, DetailItem.class);
                openDetail.putExtra("title", ctitle[position]);
                openDetail.putExtra("price", cprice[position]);
                openDetail.putExtra("img", cimg[position]+"");
                startActivity(openDetail );
            }
        });
    }

    public void openCart(View view){
        Intent toCart = new Intent(Home.this, Cart.class);
        startActivity(toCart);
    }
}