package com.example.phones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Phones> myList = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://phonesshop-1649f-default-rtdb.firebaseio.com/");
    DatabaseReference dbref = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView phoneName, phonePrice;
        ImageView phoneImg;


        phoneName = findViewById(R.id.textViewName);
        phonePrice = findViewById(R.id.textViewPrice);
        phoneImg = findViewById(R.id.imageView);


       // Phones phone1 = new Phones("Samsung Galaxy S22 Ultra" , 464 , R.drawable.s22ultra);
       // Phones phone2 = new Phones("Samsung Galaxy Z Fold" , 574 , R.drawable.zflod3);
       // Phones phone3 = new Phones("Apple iPhone 13 Pro" , 390 , R.drawable.iphone13promax);
       // Phones phone4 = new Phones("Apple iPhone 12 Pro" , 330 , R.drawable.iphone12promax);
      //  Phones phone5 = new Phones("HUAWEI P50 Pocket" , 429 , R.drawable.p50pocket);
       // Phones phone6 = new Phones("Samsung Galaxy S21" , 250 , R.drawable.s21);


        // myList.add(phone1);
       // myList.add(phone2);
       // myList.add(phone3);
      //  myList.add(phone4);
       // myList.add(phone5);
      //  myList.add(phone6);


        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        ItemAdapter adapter = new ItemAdapter(myList, this);
        recyclerView.setAdapter(adapter);

    final Query myphone = dbref.child("Phones");

    myphone.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {

            for(DataSnapshot a : snapshot.getChildren()){
                Phones phone = a.getValue(Phones.class);
                myList.add(phone);
                adapter.notifyDataSetChanged();

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });

// to read the objects and add them to the list
    }
}