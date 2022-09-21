package com.example.phones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView nametext = findViewById(R.id.textViewName);
        TextView pricetext = findViewById(R.id.textViewPrice);
        ImageView img = findViewById(R.id.imageView2);

        Bundle bundle = getIntent().getExtras();

        Phones sentphone = (Phones) bundle.getSerializable("phone");

                nametext.setText(sentphone.getPhoneName());
        pricetext.setText(sentphone.getPhonePrice() + "KD" );
        // img.setImageResource(sentphone.getPhoneImg());
        Picasso.with(this).load(sentphone.getPhoneImg()).into(img);

    }
}