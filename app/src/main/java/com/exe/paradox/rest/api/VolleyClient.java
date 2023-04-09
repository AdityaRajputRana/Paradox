package com.exe.paradox.rest.api;

import com.android.volley.RequestQueue;
import com.exe.paradox.Essentials.Application;

public class VolleyClient {

//    public static String BASE_URL = "https://paradox-backend.onrender.com/";
    public static String BASE_URL = "https://643f-2401-4900-4479-e62f-873d-df03-8336-e0e4.ngrok-free.app/";
    public static String HOST= "quasar-edtech.vercel.app/edtech";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    private static RequestQueue requestQueue = Application.getMainRequestQueue();

}
