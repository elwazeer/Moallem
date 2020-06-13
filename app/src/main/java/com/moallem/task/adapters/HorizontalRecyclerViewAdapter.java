package com.moallem.task.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.moallem.task.R;
import com.moallem.task.activities.Video;
import com.moallem.task.models.HorizontalModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalRecyclerViewAdapter extends
        RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalViewHolder> {

    private Context mContext;
    public HorizontalRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    private ArrayList<HorizontalModel> mArrayList;

    public HorizontalRecyclerViewAdapter(Context mContext,
                                         ArrayList<HorizontalModel> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_horizontal, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
        final HorizontalModel current = mArrayList.get(position);
        holder.txtTitle.setText(current.getName());
        holder.ivThumb.setImageResource(current.getImageId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            Intent i = new Intent(mContext, Video.class);

            @Override
            public void onClick(View v) {

                switch(current.getName()) {
                    case "Physics Revision":
                        //i.putExtra("Video", testArray[0].replaceAll("\\s+",""));
                        i.putExtra("Video", "vOne".replaceAll("\\s+",""));
                        mContext.startActivity(i);
                        break;

                    case "Cell Division":
                        i.putExtra("Video", "vTwo".replaceAll("\\s+",""));
                        mContext.startActivity(i);
                        break;

                    case "Ancient Egypt":
                        i.putExtra("Video", "vThree".replaceAll("\\s+",""));
                        mContext.startActivity(i);
                        break;

                    case "Ace Integration":
                        i.putExtra("Video", "vFour".replaceAll("\\s+",""));
                        mContext.startActivity(i);
                        break;

                    default:
                        Toast.makeText(mContext, current.getName(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtTitle)
        TextView txtTitle;

        @BindView(R.id.ivThumb)
        ImageView ivThumb;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
