package com.example.simpletodo;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

// Adapter is responsible for displaying data from the model into a row in the recycle view
public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.ViewHolder>{

    public interface OnLongClickListener{
        void onItemLongClicked(int position);
    }
    List<String> items;

    OnLongClickListener longClickListener;

    public itemsAdapter(List<String> items , OnLongClickListener longClickListener )
    {
        this.items = items ;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // use the layout to inflate a view

        View todoView;
        todoView = LayoutInflater.from (parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

        //
        return new ViewHolder(todoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = items.get(position);
       holder.bind(item);






    }



    @Override
    public int getItemCount() {

        return items.size();
    }

    //Container to provide easy access to view that represent each row of the list

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);

        }

        public void bind(String item ) {
            tvItem.setText(item);
            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    /// notify the listener which position was long pressed
                    longClickListener.onItemLongClicked(getAdapterPosition());

                    return true;
                }
            });
        }




        }
    }

