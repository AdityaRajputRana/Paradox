package com.exe.paradox.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.exe.paradox.LoginActivity;
import com.exe.paradox.R;
import com.exe.paradox.Tools.Method;
import com.exe.paradox.rest.api.APIMethods;
import com.exe.paradox.rest.api.interfaces.APIResponseListener;
import com.exe.paradox.rest.response.HomeRP;

public class HomeFragment extends Fragment {

    HomeRP homeRP;

    ProgressBar progressBar;
    LinearLayout mainLayout;

    TextView middleTxt;
    TextView topTxt;
    TextView bottomTxt;
    TextView teamNameTxt;
    TextView playerNameTxt;
    LinearLayout teamInfoLayout;
    LinearLayout levelLayout;


    public HomeFragment() {
        // Required empty public constructor
    }

    public void getData(){
        if (homeRP == null){
            fetchHome();
        } else {
            showData();
        }
    }

    private void fetchHome() {
        progressBar.setVisibility(View.VISIBLE);
        mainLayout.setVisibility(View.GONE);

        APIMethods.getHome(new APIResponseListener<HomeRP>() {
            @Override
            public void success(HomeRP response) {
                homeRP = response;
                showData();
            }

            @Override
            public void fail(String code, String message, String redirectLink, boolean retry, boolean cancellable) {
                progressBar.setVisibility(View.GONE);
                Method.showFailedAlert(getActivity(), code + " - " +  message);
                //Todo Show Non Connectivity Status
                //Todo Show message more effectively with retry btn
            }
        });
    }

    private void showData() {
        playerNameTxt.setText(homeRP.getPlayerName());
        progressBar.setVisibility(View.GONE);
        mainLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        findViews(v);
        return v;
    }

    private void findViews(View v) {
        topTxt = v.findViewById(R.id.topTxt);
        middleTxt = v.findViewById(R.id.middleTxt);
        bottomTxt = v.findViewById(R.id.bottomTxt);
        playerNameTxt = v.findViewById(R.id.nameTxt);
        teamNameTxt = v.findViewById(R.id.teamTxt);

        teamInfoLayout = v.findViewById(R.id.teamInfoLayout);
        levelLayout = v.findViewById(R.id.levelLayout);

        progressBar = v.findViewById(R.id.progresBar);
        mainLayout = v.findViewById(R.id.mainLayout);
    }
}