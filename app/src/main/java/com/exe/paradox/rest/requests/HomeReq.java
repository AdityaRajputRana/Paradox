package com.exe.paradox.rest.requests;

import com.google.firebase.auth.FirebaseAuth;

public class HomeReq {
    String uid;
    public HomeReq(){
        this.uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}
