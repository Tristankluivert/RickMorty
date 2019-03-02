package ng.com.hybrid.rickmorty.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;


import ng.com.hybrid.rickmorty.Model.EpisodeResults;
import ng.com.hybrid.rickmorty.R;
import ng.com.hybrid.rickmorty.Utils;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    private List<EpisodeResults> results;
    private Context context;
   // private OnItemClickListener onItemClickListener;


    public Adapter(List<EpisodeResults> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_episode, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holders, int position) {
        final MyViewHolder holder = holders;
       EpisodeResults model = results.get(position);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(Utils.getRandomDrawbleColor());
        requestOptions.error(Utils.getRandomDrawbleColor());
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.centerCrop();

        /*Glide.with(context)
                .load(model.getUrlToImage())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.imageView);*/

        holder.name.setText(model.getName());
        holder.episode.setText(model.getEpisode());
        holder.air_date.setText(model.getAir_date());

       // holder.time.setText(" \u2022 " + Utils.DateToTimeFormat(model.getPublishedAt()));
        holder.imageView.setImageResource(R.drawable.rickmortytheme);
        holder.created.setText(model.getCreated());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

 /*   public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }*/

   /* public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }*/

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, episode, air_date, created, textdate;
        CardView cardi;
        ImageView imageView;

       // OnItemClickListener onItemClickListener;

        public MyViewHolder(View itemView) {

            super(itemView);

           // itemView.setOnClickListener(this);
          name = itemView.findViewById(R.id.name);
           episode = itemView.findViewById(R.id.episode);
          air_date = itemView.findViewById(R.id.date);

          created = itemView.findViewById(R.id.crate);
          textdate = itemView.findViewById(R.id.textdate);
          cardi = itemView.findViewById(R.id.cardi);
          imageView = itemView.findViewById(R.id.image);



           // this.onItemClickListener = onItemClickListener;

        }

       // @Override
     /*   public void onClick(View v) {
            onItemClickListener.onItemClick(v, getAdapterPosition());
        }*/
    }
}
