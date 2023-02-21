package com.exe.paradox.MainFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.exe.paradox.Adapters.BannerPageAdapter;
import com.exe.paradox.R;
import com.exe.paradox.Tools.Method;
import com.exe.paradox.Tools.TimeUtils;
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
    ViewPager viewPager;


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

        Log.i("eta", "fetching home");
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
        if (homeRP.isSolo()){
            teamNameTxt.setText("(Playing Solo)");
        } else {
            teamNameTxt.setText(homeRP.getTeamName());
        }

        if (homeRP.isLevelActive()){
            topTxt.setText("Level");
            middleTxt.setText(homeRP.getLevelName());
            bottomTxt.setText("Enter");
        } else {
            //Todo: Implement a counter and update once counter ends
            TimeUtils.TimeDifference timeDifference = new TimeUtils().getTimeDifference();
            topTxt.setText("Level " + homeRP.getLevelName() + " starting in");
            TimeUtils.getDifference(timeDifference, homeRP.getLevelStartsAt());
            middleTxt.setText(timeDifference.time);
            bottomTxt.setText(timeDifference.units);
        }

        //Todo: If the level is locked update UI

        levelLayout.setOnClickListener(view -> onLevelClick());
        teamInfoLayout.setOnClickListener(view -> changeTeam());
        progressBar.setVisibility(View.GONE);
        mainLayout.setVisibility(View.VISIBLE);

        //showingBanners
        BannerPageAdapter adapter = new BannerPageAdapter(getActivity().getSupportFragmentManager(), homeRP.getBanners(), homeRP.getLeaderboard(), getActivity());
        viewPager.setAdapter(adapter);

    }

    private void changeTeam() {
        //Todo: show dialog to change solo/team/join other team
    }

    private void onLevelClick() {
        //Todo launch another activity or toast that level is not yet unlocked
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        findViews(v);
        getData();
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

        progressBar = v.findViewById(R.id.progressBar);
        mainLayout = v.findViewById(R.id.mainLayout);
        viewPager = v.findViewById(R.id.viewPager);
    }
}