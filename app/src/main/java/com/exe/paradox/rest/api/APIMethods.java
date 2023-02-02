package com.exe.paradox.rest.api;


import com.exe.paradox.rest.api.interfaces.APIResponseListener;
import com.exe.paradox.rest.requests.CreateUserReq;
import com.exe.paradox.rest.response.CreateUserRP;

public class APIMethods {
    public static void createUser(APIResponseListener<CreateUserRP> listener) {
        CreateUserReq req = new CreateUserReq();
        API.postData(listener, req, EndPoints.createUser, CreateUserRP.class);
    }

}