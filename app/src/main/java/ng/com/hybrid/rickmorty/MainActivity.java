package ng.com.hybrid.rickmorty;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import ng.com.hybrid.rickmorty.Fragments.AboutFrag;
import ng.com.hybrid.rickmorty.Fragments.CharacterFrag;
import ng.com.hybrid.rickmorty.Fragments.EpisodeFrag;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                new EpisodeFrag()).commit();



        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedfragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_episode:

                    selectedfragment = new EpisodeFrag();
                   break;
                case R.id.navigation_characters:
                    selectedfragment = new CharacterFrag();

                    break;

                case R.id.navigation_info:
                   selectedfragment = new AboutFrag();
                   break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    selectedfragment).commit();


            return true;
        }
    };
}
