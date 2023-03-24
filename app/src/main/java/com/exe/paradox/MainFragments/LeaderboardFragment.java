package com.exe.paradox.MainFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exe.paradox.Adapters.LeaderboardRVAdapter;
import com.exe.paradox.R;
import com.exe.paradox.Tools.Method;
import com.exe.paradox.databinding.FragmentLeaderboardBinding;
import com.exe.paradox.rest.api.APIMethods;
import com.exe.paradox.rest.api.interfaces.APIResponseListener;
import com.exe.paradox.rest.response.RanklistRP;

public class LeaderboardFragment extends Fragment {

    FragmentLeaderboardBinding binding;
    LeaderboardRVAdapter adapter;
    LinearLayoutManager manager;


    public LeaderboardFragment() {
        // Required empty public constructor
    }


    private void loadRankList() {
        APIMethods.getRanklist(new APIResponseListener<RanklistRP>() {
            @Override
            public void success(RanklistRP response) {
                binding.progressBar.setVisibility(View.GONE);
                adapter = new LeaderboardRVAdapter(response);
                manager = new LinearLayoutManager(getActivity());
                binding.recyclerView.setAdapter(adapter);
                binding.recyclerView.setLayoutManager(manager);
                binding.recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void fail(String code, String message, String redirectLink, boolean retry, boolean cancellable) {
                binding.progressBar.setVisibility(View.GONE);
                Method.showFailedAlert(getActivity(), code + " - " + message);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLeaderboardBinding.inflate(inflater, container, false);
        loadRankList();
        return binding.getRoot();
    }
}