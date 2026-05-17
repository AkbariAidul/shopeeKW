package com.haikaldanaidul.shopeeapps;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailItem extends AppCompatActivity {

    TextView detailPrice, detailTitle;
    ImageView detailImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_item);

        if(Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.white));
        }

//        Identifier
        detailPrice = findViewById(R.id.detailPrice);
        detailTitle = findViewById(R.id.detailTitle);
        detailImg = findViewById(R.id.detailImg);

        String price = getIntent().getStringExtra("price");
        String title = getIntent().getStringExtra("title");
        String img = getIntent().getStringExtra("img");

        detailPrice.setText(price);
        detailTitle.setText(title);
        detailImg.setImageResource(Integer.parseInt(img));
    }

    public void backToHome(View view){
        Intent openHome = new Intent(DetailItem.this, Home.class);
        startActivity(openHome);
    }

    public void openCartDetail(View view){
        Intent toCart = new Intent(DetailItem.this, Cart.class);
        startActivity(toCart);
    }
}