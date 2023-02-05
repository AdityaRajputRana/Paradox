package com.exe.paradox.rest.api;

import com.android.volley.RequestQueue;
import com.exe.paradox.Essentials.Application;

public class VolleyClient {

    public static String BASE_URL = "https://paradox-backend.onrender.com/";
    public static String HOST= "quasar-edtech.vercel.app/edtech";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    private static RequestQueue requestQueue = Application.getMainRequestQueue();

}
