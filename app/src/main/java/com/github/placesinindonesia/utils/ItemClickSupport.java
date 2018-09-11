package com.github.placesinindonesia.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.placesinindonesia.R;

/**
 * Created by Kei Lazu on 9/11/2018
 * check https://github.com/KeiLazu for more
 */
public class ItemClickSupport {

    private final RecyclerView recyclerView;
    private OnItemClickListener onItemClickListener;

    public ItemClickSupport(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.recyclerView.setTag(R.id.item_click_support, this);
        this.recyclerView.addOnChildAttachStateChangeListener(attachStateChangeListener);
    }

    private RecyclerView.OnChildAttachStateChangeListener attachStateChangeListener =
            new RecyclerView.OnChildAttachStateChangeListener() {
                @Override
                public void onChildViewAttachedToWindow(View view) {
                    if (onItemClickListener != null) {
                        view.setOnClickListener(mOnClickListener);
                    }
                }

                @Override
                public void onChildViewDetachedFromWindow(View view) {

                }
            };

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(v);
                onItemClickListener.onItemClicked(recyclerView, holder.getAdapterPosition(), v);
            }
        }
    };

    public static ItemClickSupport addTo(RecyclerView view) {
        ItemClickSupport support = (ItemClickSupport) view.getTag(R.id.item_click_support);
        if (support == null) {
            support = new ItemClickSupport(view);
        }
        return support;
    }
    public static ItemClickSupport removeFrom(RecyclerView view) {
        ItemClickSupport support = (ItemClickSupport) view.getTag(R.id.item_click_support);
        if (support != null) {
            support.detach(view);
        }
        return support;
    }

    private void detach(RecyclerView view) {
        view.removeOnChildAttachStateChangeListener(attachStateChangeListener);
        view.setTag(R.id.item_click_support, null);
    }

    public ItemClickSupport setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
        return this;
    }

    public interface OnItemClickListener {
        void onItemClicked(RecyclerView recyclerView, int position, View v);
    }

}
