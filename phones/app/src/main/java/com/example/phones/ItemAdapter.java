package com.example.phones;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter {
    // sawait generate context

    ArrayList<Phones> phoneList = new ArrayList<>();
    Context context;

    public ItemAdapter(ArrayList<Phones> phoneList, Context context) {
        this.phoneList = phoneList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_item, parent, false);
     ViewHolder vh = new ViewHolder(view);
     // 3araft xml in these two lines

     return vh;
     // i changed the retirn

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ((ViewHolder)holder).textname.setText(phoneList.get(position).getPhoneName());
        ((ViewHolder)holder).textprice.setText(phoneList.get(position).getPhonePrice() + "") ;
        // ((ViewHolder)holder).img.setImageResource(phoneList.get(position).getPhoneImg());
        Picasso.with(context).load(phoneList.get(position).getPhoneImg()).into(((ViewHolder)holder).img);
        // i cant type this in the adapter
        ((ViewHolder)holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailsAcivity.class);
                intent.putExtra("phone", phoneList.get(position));
                context.startActivity(intent);
            }
        });
        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Phones removedphone = phoneList.get(position);
                AlertDialog.Builder alert = new AlertDialog.Builder(context)
                        .setTitle("Attention")
                        .setMessage("Are you sure you want to delete?")
                        .setPositiveButton("delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                phoneList.remove(position);
                                notifyDataSetChanged();
                                Snackbar.make(context, view , "1 item deleted", 3000)
                                        .setAction("Undo", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                phoneList.add(removedphone);

                                            }
                                        }).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                alert.show();
            }
        });




    }


    @Override
    public int getItemCount() {
        return phoneList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView textname, textprice;
        View v;
        ImageView delete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            img = v.findViewById(R.id.imageView);
            textname = v.findViewById(R.id.textViewName);
            textprice = v.findViewById(R.id.textViewPrice);
            delete =v.findViewById(R.id.imageViewDelete);

        }
    }


}
