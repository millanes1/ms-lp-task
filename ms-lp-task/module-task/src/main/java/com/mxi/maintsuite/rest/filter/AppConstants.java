package com.mxi.maintsuite.rest.filter;

/**
 * Created by millanes on 23-03-17.
 */
public class AppConstants {


    public static final int GENERIC_APP_ERROR_CODE = 500;
    public static final String BLOG_POST_URL = "post url";


    public static final String MESSAGE_200 = "Success";
    public static final String MESSAGE_400 = "The request was invalid or cannot be otherwise served.";
    public static final String MESSAGE_401 = "Authentication credentials were missing or incorrect.";
    public static final String MESSAGE_403 = "The request is understood, but it has been refused or access is not allowed.";
    public static final String MESSAGE_404 = "The URI requested is invalid or the rest requested does not exists.";
    public static final String MESSAGE_429 = "The request cannot be served due to the application’s rate limit having been exhausted for the rest.";
    public static final String MESSAGE_503 = "The server is up, but overloaded with requests. Try again later.";
    public static final String MESSAGE_500 = "Something is broken";
}