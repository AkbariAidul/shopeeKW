package com.haikaldanaidul.shopeeapps;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        if(Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.shopee));
        }

        //c = content
        int[] cartimg = {
                R.drawable.item_1,
                R.drawable.item_2,
                R.drawable.item_3,
                R.drawable.item_4,
        };
        String[] carttitle = {
                "Ryu Mesin Pressure\nWasher RPW-100...",
                "Tatakan box motor\nTouring...",
                "Corolla mesin cuci\nmobil motor...",
                "Celana panjang tactical\ncargo pria...",
        };
        String[] cartprice = {
                "Rp234.600",
                "Rp100.000",
                "Rp700.500",
                "Rp777.600",
        };

        GridCartItemAdapter gridCartItemAdapter = new GridCartItemAdapter(Cart.this, carttitle, cartprice, cartimg); //item yang ingin ditampilkan
        GridView cartGrid = findViewById(R.id.cartGrid); //identifier
        cartGrid.setAdapter(gridCartItemAdapter); //menampilkan item di gridView
    }

    public void openHome(View view){
        Intent toHome = new Intent(Cart.this, Home.class);
        startActivity(toHome);
    }
}