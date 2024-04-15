package com.ait12275.beatbyte.homepage;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.ait12275.beatbyte.albums.Albums;
import com.ait12275.beatbyte.databinding.RecyclerItemViewBinding;

public class AlbumsRecyclerViewAdapter extends ListAdapter<Albums, AlbumsViewHolder> {

    private RecyclerItemViewBinding binding;

    private OnItemClickListener onItemClickListener;

    public AlbumsRecyclerViewAdapter(OnItemClickListener onItemClickListener) {
        super(DIFF_CALLBACK);
        this.onItemClickListener = onItemClickListener;

    }

    public AlbumsRecyclerViewAdapter() {
        super(DIFF_CALLBACK);

    }
    private static final DiffUtil.ItemCallback<Albums> DIFF_CALLBACK = new DiffUtil.ItemCallback<Albums>() {
        @Override
        public boolean areItemsTheSame(@NonNull Albums oldItem, @NonNull Albums newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Albums oldItem, @NonNull Albums newItem) {
            return oldItem.getName().equals(newItem.getName()) && oldItem.getAbout().equals(newItem.getAbout());
        }
    };


    @NonNull
    @Override
    public AlbumsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = RecyclerItemViewBinding.inflate(inflater, parent, false);

        AlbumsViewHolder albumsViewHolder = new AlbumsViewHolder(binding);
        return albumsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsViewHolder holder, int position) {
        // get data from the list, based on their position
        Albums albums = getAlbumAt(position);
        holder.updateAlbum(albums);
        holder.bind(albums, onItemClickListener);

    }

    public Albums getAlbumAt(int position){
        return getItem(position);
    }
}
