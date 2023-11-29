package com.example.up.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.up.R;
import com.example.up.database.Database;
import com.example.up.database.entities.artists;

import java.util.List;

public class artistAdapter extends ArrayAdapter<artists> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<artists> items;

    Database db;

    public artistAdapter(Context context, int resourse, List<artists> items){
        super(context,resourse,items);
        this.items = items;
        this.layout=resourse;
        this.inflater = LayoutInflater.from(context);

        db=Database.getDatabase(getContext());
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        artists item = items.get(position);

        viewHolder.FirstName.setText(item.artist_first_name);
        viewHolder.LastName.setText(item.artist_last_name);
        return convertView;
    }

    private class ViewHolder{
        final TextView FirstName;
        final TextView LastName;
        public ViewHolder(View view){
            FirstName = view.findViewById(R.id.artist_first_name);
            LastName = view.findViewById(R.id.artist_last_name);
        }
    }

    @Override
    public void remove(@Nullable artists object) {
        if (object == null) {
            return;
        }
        items.remove(object);
        super.remove(object);
        notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
