package ng.com.hybrid.rickmorty.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ng.com.hybrid.rickmorty.Adapters.Adapter;
import ng.com.hybrid.rickmorty.Api.ApiClient;
import ng.com.hybrid.rickmorty.Api.ApiInterface;
import ng.com.hybrid.rickmorty.Model.Info;
import ng.com.hybrid.rickmorty.Model.EpisodeResults;
import ng.com.hybrid.rickmorty.R;
import ng.com.hybrid.rickmorty.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeFrag extends Fragment{


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<EpisodeResults> results = new ArrayList<>();
    private Adapter adapter;
    private LinearLayout errorLayout;
    private ImageView errorImage;
    private TextView errorTitle, errorMessage;
    private Button btnRetry;
    private ProgressDialog progressDialog;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_episode, container, false);
       progressDialog = new ProgressDialog(getActivity());
        errorLayout = view.findViewById(R.id.errorLayout);
        errorImage = view.findViewById(R.id.errorImage);
        errorTitle = view.findViewById(R.id.errorTitle);
        errorMessage = view.findViewById(R.id.errorMessage);
        btnRetry = view.findViewById(R.id.btnRetry);

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        progressDialog.setTitle("Gathering episodes");
        progressDialog.setMessage("Please wait while we get the episodes");
       // progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(true);
        LoadJson();
        return view;
    }

    public void LoadJson(){
        errorLayout.setVisibility(View.GONE);

  progressDialog.show();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

       String page = "2";
        //Utils.getCountry();
        String language = Utils.getLanguage();

        Call<Info> call;
         call = apiInterface.getEpisodes(page);
        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                if (response.isSuccessful() && response.body().getResults() != null){
progressDialog.dismiss();
                    if (!results.isEmpty()){
                        results.clear();
                    }

                   results = response.body().getResults();
                    adapter = new Adapter(results, getActivity());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();


                } else {


                    String errorCode;
                    switch (response.code()) {
                        case 404:
                            errorCode = "404 not found";
                            break;
                        case 500:
                            errorCode = "500 server broken";
                            break;
                        default:
                            errorCode = "unknown error";
                            break;
                    }
                    progressDialog.dismiss();
                    showErrorMessage(
                            R.drawable.no_result,
                            "No Result",
                            "Please Try Again!\n"+
                                    errorCode);

                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                      progressDialog.dismiss();
                showErrorMessage(
                        R.drawable.oops,
                        "Oops..",
                        "Network failure, Please Try Again");
            }
        });

    }


    private void showErrorMessage(int imageView, String title, String message){
progressDialog.dismiss();
        if (errorLayout.getVisibility() == View.GONE) {
            errorLayout.setVisibility(View.VISIBLE);
        }

        errorImage.setImageResource(imageView);
        errorTitle.setText(title);
        errorMessage.setText(message);

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               progressDialog.dismiss();
               LoadJson();

            }
        });

    }

}
