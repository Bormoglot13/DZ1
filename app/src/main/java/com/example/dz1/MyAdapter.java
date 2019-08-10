package com.example.dz1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<MyData> data;

    public MyAdapter(ArrayList<MyData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        MyData item = data.get(position);
        holder.tv_name.setText(item.name);
        holder.tv_surname.setText(item.surname);
        switch (item.type) {
            case 0: holder.iv_type.setImageResource(R.drawable.ic_android_black_24dp);
            break;
            case 1: holder.iv_type.setImageResource(R.drawable.ic_designer);
            break;
            case 2: holder.iv_type.setImageResource(R.drawable.ic_cheff);
            break;
            default:
                holder.iv_type.setImageResource(R.drawable.ic_person_black_24dp);

        }
        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"button edit click",Toast.LENGTH_SHORT).show();
            }
        });
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"button delete click",Toast.LENGTH_SHORT).show();
                data.remove(position);
                //MyAdapter.this.notifyDataSetChanged();
                MyAdapter.this.notifyItemRemoved(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name,tv_surname;
        public ImageButton btn_edit,btn_delete;
        public ImageView iv_type;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_surname = itemView.findViewById(R.id.tv_surname);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            btn_edit = itemView.findViewById(R.id.btn_edit);
            iv_type = itemView.findViewById(R.id.iv_type);
        }
    }
}
