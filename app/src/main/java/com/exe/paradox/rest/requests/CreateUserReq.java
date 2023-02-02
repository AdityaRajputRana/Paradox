package com.exe.paradox.rest.requests;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreateUserReq {
    String uid;
    String email;
    String name;
    String displayPicture;
    public CreateUserReq(){
        FirebaseUser u = FirebaseAuth.getInstance().getCurrentUser();
        if (u != null) {
            this.uid = u.getUid();
            this.email = u.getEmail();
            this.name = u.getDisplayName();
            this.displayPicture = u.getPhotoUrl().toString();
        }
    }


}
