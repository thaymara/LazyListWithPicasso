package com.example.tmara.lazylistpicasso;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class RowListAdapter extends ArrayAdapter<RowModel> {

    private List<RowModel> mListRowModel;

    private Context mContext;

    public RowListAdapter(Context mContext, List<RowModel> mListRowModel){
        super(mContext, R.layout.activity_activity_row_list, mListRowModel);
        this.mListRowModel = mListRowModel;
        this.mContext = mContext;
    }

    private static class ViewHolder{
        private ImageView image;
        private TextView title;
        private TextView description;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        final ViewHolder holder;
        View rowNewConvertView = convertView;

        if (rowNewConvertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowNewConvertView = inflater.inflate(R.layout.activity_activity_row_list, null);

            holder = new ViewHolder();

            holder.title = (TextView) rowNewConvertView.findViewById(R.id.txtTitulo);
            holder.description = (TextView) rowNewConvertView.findViewById(R.id.txtGenero);
            holder.image = (ImageView) rowNewConvertView.findViewById(R.id.imgSerie);

            rowNewConvertView.setTag(holder);
        } else{
            holder = (ViewHolder) rowNewConvertView.getTag();
        }

        RowModel rowItem = (RowModel) mListRowModel.get(position);

        holder.title.setText(rowItem.getTitle());
        holder.description.setText(rowItem.getDescritpion());

        Picasso.with(mContext)
                .load(rowItem.getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(holder.image);

        return rowNewConvertView;
    }
}
