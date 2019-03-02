package ng.com.hybrid.rickmorty.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;
import ng.com.hybrid.rickmorty.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFrag extends Fragment {

   private ImageView facebook,twitter,github;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_about, container, false);

       facebook = view.findViewById(R.id.facebook);
       twitter = view.findViewById(R.id.twitter);
       github = view.findViewById(R.id.github);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent face = new Intent();
                face.setAction(Intent.ACTION_VIEW);
                face.addCategory(Intent.CATEGORY_BROWSABLE);
                face.setData(Uri.parse("http://www.facebook.com/tristan.kluivert"));
                startActivity(face);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twit = new Intent();
                twit.setAction(Intent.ACTION_VIEW);
                twit.addCategory(Intent.CATEGORY_BROWSABLE);
                twit.setData(Uri.parse("http://www.twitter.com/Edkluivert?s=09"));
                startActivity(twit);
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent git = new Intent();
                git.setAction(Intent.ACTION_VIEW);
                git.addCategory(Intent.CATEGORY_BROWSABLE);
                git.setData(Uri.parse("http://www.github.com/Tristankluivert"));
                startActivity(git);
            }
        });

        return view;
    }

}
