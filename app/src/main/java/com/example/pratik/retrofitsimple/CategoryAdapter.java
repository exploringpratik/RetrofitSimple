package com.example.pratik.retrofitsimple;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private static final String TAG = "CategoryAdapter";
    private List<PlaceList> mCategoryList;
    private Context mContext;

    public CategoryAdapter(List<PlaceList> list, Context mContext) {
        this.mCategoryList = list;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_single_category, parent, false);
        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        PlaceList categoryLists = mCategoryList.get(position);
        holder.category.setText(categoryLists.getName());

    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }


    class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView category;

        private CategoryViewHolder(View itemView) {
            super(itemView);
            category = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
