//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.user.parent.cd_token;

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;


public class HttpApiClient_UAT extends ApacheHttpClient{
    public final static String HOST = "uat.openapi.any-call.com";
    static HttpApiClient_UAT instance = new HttpApiClient_UAT();
    public static HttpApiClient_UAT getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTP);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }




    public void 小程序根据FacilityInfo获取设备(String facilityNo , String idToken , ApiCallback callback) {
        String path = "/openapi/getFacility";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("facilityNo" , facilityNo , ParamPosition.QUERY , true);
        request.addParam("idToken" , idToken , ParamPosition.QUERY , true);



        sendAsyncRequest(request , callback);
    }
    public void 小程序推送日日志创建(String idToken , String templateid , String openid , String msg , ApiCallback callback) {
        String path = "/openapi/createWxmsgPushLog";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("idToken" , idToken , ParamPosition.QUERY , false);
        request.addParam("templateid" , templateid , ParamPosition.QUERY , false);
        request.addParam("openid" , openid , ParamPosition.QUERY , false);
        request.addParam("msg" , msg , ParamPosition.QUERY , false);



        sendAsyncRequest(request , callback);
    }
    public void createCall(String faultDescription , String repairSource , String reportTime ,
                         String systemNumCode , String reportManTel ,
                         String reportMan , String soundUrls ,
                         String shopCode , String photographUrls , String idToken , String soundLength , ApiCallback callback) {
        String path = "/openapi/createReport";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("faultDescription" , faultDescription , ParamPosition.QUERY , false);
        request.addParam("repairSource" , repairSource , ParamPosition.QUERY , false);
        request.addParam("reportTime" , reportTime , ParamPosition.QUERY , false);
        request.addParam("systemNumCode" , systemNumCode , ParamPosition.QUERY , false);
        request.addParam("reportManTel" , reportManTel , ParamPosition.QUERY , false);
        request.addParam("reportMan" , reportMan , ParamPosition.QUERY , false);
        request.addParam("soundUrls" , soundUrls , ParamPosition.QUERY , false);
        request.addParam("shopCode" , shopCode , ParamPosition.QUERY , false);
        request.addParam("photographUrls" , photographUrls , ParamPosition.QUERY , false);
        request.addParam("idToken" , idToken , ParamPosition.QUERY , true);
        request.addParam("soundLength" , soundLength , ParamPosition.QUERY , false);



        sendAsyncRequest(request , callback);
    }
    public void changePwd(String idToken , String oldPwd , String newPwd , ApiCallback callback) {
        String path = "/openapi/passWordUpdate";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM , path);
        request.addParam("idToken" , idToken , ParamPosition.QUERY , false);
        request.addParam("oldPwd" , oldPwd , ParamPosition.QUERY , false);
        request.addParam("newPwd" , newPwd , ParamPosition.QUERY , false);



        sendAsyncRequest(request , callback);
    }
    public void 小程序WxUser根据unionid跟新userId(String unionid , String idToken , String userId , ApiCallback callback) {
        String path = "/openapi/wxuserUpdate";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("unionid" , unionid , ParamPosition.QUERY , true);
        request.addParam("idToken" , idToken , ParamPosition.QUERY , true);
        request.addParam("userId" , userId , ParamPosition.QUERY , true);



        sendAsyncRequest(request , callback);
    }
    public void 小程序Wxuser创建(String idToken , String openid , String unionid , String mobileNo , String imageurl , String type , String userid , ApiCallback callback) {
        String path = "/openapi/createWxUser";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("idToken" , idToken , ParamPosition.QUERY , false);
        request.addParam("openid" , openid , ParamPosition.QUERY , false);
        request.addParam("unionid" , unionid , ParamPosition.QUERY , false);
        request.addParam("mobileNo" , mobileNo , ParamPosition.QUERY , false);
        request.addParam("imageurl" , imageurl , ParamPosition.QUERY , false);
        request.addParam("type" , type , ParamPosition.QUERY , false);
        request.addParam("userid" , userid , ParamPosition.QUERY , false);



        sendAsyncRequest(request , callback);
    }
    public ApiResponse getToken(String userName , String password ) {
        String path = "/service/loginIn";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("userName" , userName , ParamPosition.QUERY , true);
        request.addParam("password" , password , ParamPosition.QUERY , true);



        return sendSyncRequest(request);
    }
}