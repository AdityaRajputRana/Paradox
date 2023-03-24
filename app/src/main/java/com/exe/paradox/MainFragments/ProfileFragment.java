package com.exe.paradox.MainFragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.exe.paradox.LoginActivity;
import com.exe.paradox.R;
import com.exe.paradox.databinding.FragmentLeaderboardBinding;
import com.exe.paradox.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;


public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;



    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        setListeners();
        setPersonalDetails();
        return binding.getRoot();
    }

    private void setPersonalDetails() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null){
            Toast.makeText(getActivity(), "Please log in to continue!", Toast.LENGTH_SHORT).show();
            return;
        }

        binding.nameTxt.setText(user.getDisplayName());
        Picasso.get()
                .load(user.getPhotoUrl())
                .into(binding.profileImg);
    }

    private void setListeners() {
        binding.logoutBtn.setOnClickListener(view ->{
            new AlertDialog.Builder(getActivity())
                    .setTitle("Log out")
                    .setMessage("Are you sure you want to sign out of your account?\nYour progress will remain saved on our servers.")
                    .setCancelable(true)
                    .setPositiveButton("Log out", (dialog, which) -> {
                        FirebaseAuth.getInstance().signOut();
                        getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
                    })
                    .setNegativeButton("Cancel", ((dialog, which) -> dialog.dismiss()))
                    .show();
        });
    }
}