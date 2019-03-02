package ng.com.hybrid.rickmorty.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import ng.com.hybrid.rickmorty.Model.Origin;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ng.com.hybrid.rickmorty.Model.Characters;
import ng.com.hybrid.rickmorty.Model.Location;
import ng.com.hybrid.rickmorty.R;
import ng.com.hybrid.rickmorty.Utils;

public class myAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;

    List<Characters> results;

    public myAdapter(List<Characters> result, Context context) {
        this.results = result;
        this.context = context;
        layoutInflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.characterlayout,container,false);
        Characters model = results.get(position);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(Utils.getRandomDrawbleColor());
        requestOptions.error(Utils.getRandomDrawbleColor());
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.centerCrop();
        CircleImageView imageView = view.findViewById(R.id.imageView);
        Glide.with(context)
                .load(model.getImage())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {

                        return false;
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);

        //Initialising
        TextView charname,loca, origin, status , createdate, gender;

        //Instatiating
        charname = view.findViewById(R.id.charname);
        loca = view.findViewById(R.id.loca);
        origin = view.findViewById(R.id.origin);
        status = view.findViewById(R.id.status);
        createdate = view.findViewById(R.id.createdate);
        gender = view.findViewById(R.id.gender);

        //Usage
       charname.setText(model.getCharactername());
        loca.setText(model.getLocation().getLocationame());
        origin.setText(model.getOrigin().getPlanet());
       status.setText(model.getStatus());
       createdate.setText(model.getCreatedwhen());
       gender.setText(model.getGender());

       container.addView(view);
        return view;
    }
}
