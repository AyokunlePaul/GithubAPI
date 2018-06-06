package com.dev.eipeks.graymergetest.screens.main.adapter;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.eipeks.graymergetest.R;
import com.dev.eipeks.graymergetest.core.api.models.RepositoryModel;
import com.dev.eipeks.graymergetest.databinding.LayoutRepositoryItemsBinding;

import java.util.List;

public class RepositoryRecyclerAdapter extends RecyclerView.Adapter<RepositoryRecyclerAdapter.RepositoryViewHolder>{

    private List<RepositoryModel> models;
    private LayoutInflater inflater;
    private OnRepositoryItemClickListener clickListener;

    public RepositoryRecyclerAdapter(List<RepositoryModel> models){
        this.models = models;
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null){
            inflater = LayoutInflater.from(parent.getContext());
        }
        LayoutRepositoryItemsBinding binding = DataBindingUtil.inflate(inflater, R.layout.layout_repository_items, parent, false);
        return new RepositoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
        RepositoryModel model = models.get(position);
        holder.bind(model);
        holder.setListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void setRepositoryItemClickListener(OnRepositoryItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    public interface OnRepositoryItemClickListener{
        void onRepositoryItemClicked(RepositoryModel model);
    }

    class RepositoryViewHolder extends RecyclerView.ViewHolder {
        private LayoutRepositoryItemsBinding binding;
        private RepositoryModel model;
        RepositoryViewHolder(LayoutRepositoryItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        void bind(RepositoryModel model){
            binding.setModel(model);
            binding.organizationAvatar.setImageURI(Uri.parse(model.getOwner().getAvatarUrl()));
            this.model = model;
        }
        void setListener(final OnRepositoryItemClickListener clickListener){
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null){
                        clickListener.onRepositoryItemClicked(model);
                    }
                }
            });
        }
    }
}
