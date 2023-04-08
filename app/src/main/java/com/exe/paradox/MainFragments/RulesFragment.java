package com.exe.paradox.MainFragments;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exe.paradox.R;
import com.exe.paradox.Tools.Method;
import com.exe.paradox.databinding.FragmentRulesBinding;
import com.exe.paradox.rest.api.APIMethods;
import com.exe.paradox.rest.api.interfaces.APIResponseListener;
import com.exe.paradox.rest.response.RulesRP;

public class RulesFragment extends Fragment {

    FragmentRulesBinding binding;
    RulesRP rulesRP;
    public RulesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentRulesBinding.inflate(inflater, container, false);
        loadRules();
        return binding.getRoot();
    }

    private void loadRules() {
        if (rulesRP != null) {
            setUI();
            return;
        }
        APIMethods.getRules(new APIResponseListener<RulesRP>() {
            @Override
            public void success(RulesRP response) {
                binding.progressBar.setVisibility(View.GONE);
                rulesRP = response;
                setUI();
            }

            @Override
            public void fail(String code, String message, String redirectLink, boolean retry, boolean cancellable) {
                binding.progressBar.setVisibility(View.GONE);
                Method.showFailedAlert(getActivity(), code + " - " + message);
            }
        });
    }

    private void setUI() {
        binding.progressBar.setVisibility(View.GONE);
        if (rulesRP.getHeader() != null && !rulesRP.getHeader().isEmpty()) {
            binding.headTxt.setVisibility(View.VISIBLE);
            binding.headTxt.setText(rulesRP.getHeader());
        }

        if (rulesRP.getBody() != null && !rulesRP.getBody().isEmpty()) {
            binding.bodyTxt.setVisibility(View.VISIBLE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                binding.bodyTxt.setText(Html.fromHtml(rulesRP.getBody(), Html.FROM_HTML_MODE_COMPACT));
            } else {
                binding.bodyTxt.setText(Html.fromHtml(rulesRP.getBody()));
            }
        }
    }
}