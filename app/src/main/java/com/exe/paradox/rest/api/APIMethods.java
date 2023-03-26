package com.exe.paradox.rest.api;


import com.exe.paradox.Level1Activity;
import com.exe.paradox.Models.User;
import com.exe.paradox.rest.api.interfaces.APIResponseListener;
import com.exe.paradox.rest.requests.CreateUserReq;
import com.exe.paradox.rest.requests.HomeReq;
import com.exe.paradox.rest.requests.Level1Req;
import com.exe.paradox.rest.response.CreateUserRP;
import com.exe.paradox.rest.response.HomeRP;
import com.exe.paradox.rest.response.Level1RP;
import com.exe.paradox.rest.response.PrizesRP;
import com.exe.paradox.rest.response.RanklistRP;
import com.exe.paradox.rest.response.RulesRP;

public class APIMethods {
    public static void createUser(APIResponseListener<CreateUserRP> listener) {
        CreateUserReq req = new CreateUserReq();
        API.postData(listener, req, EndPoints.createUser, CreateUserRP.class);
    }

    public static void getHome(APIResponseListener<HomeRP> listener){
        HomeReq req = new HomeReq();
        API.postData(listener, req, EndPoints.home, HomeRP.class);
    }

    public static void getLevel1Question(APIResponseListener<Level1RP> listener){
        HomeReq req = new HomeReq();
        API.postData(listener, req, EndPoints.getLevel1Question, Level1RP.class);
    }

    public static void submitLevel1Answer(String answer, APIResponseListener<Level1RP> listener){
        Level1Req req = new Level1Req(answer);
        API.postData(listener, req, EndPoints.submitLevel1Answer, Level1RP.class);
    }


    public static void getRanklist(APIResponseListener<RanklistRP> listener){
        HomeReq req = new HomeReq();
        API.postData(listener, req, EndPoints.rankList, RanklistRP.class);
    }

    //paginated leaderboard
    public static void getRanklist(int page, APIResponseListener<RanklistRP> listener){
        HomeReq req = new HomeReq(page);
        API.postData(listener, req, EndPoints.rankList, RanklistRP.class);
    }


    public static void getProfile(APIResponseListener<User> listener){
        HomeReq req = new HomeReq();
        API.postData(listener, req, EndPoints.profile, User.class);
    }

    public static void getRules(APIResponseListener<RulesRP> listener){
        HomeReq req = new HomeReq();
        API.postData(listener, req, EndPoints.rules, RulesRP.class);
    }

    public static void getPrizes(APIResponseListener<PrizesRP> listener){
        HomeReq req = new HomeReq();
        API.postData(listener, req, EndPoints.prizes, PrizesRP.class);
    }
}