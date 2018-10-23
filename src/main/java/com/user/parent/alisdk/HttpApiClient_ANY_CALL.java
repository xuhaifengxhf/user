//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.user.parent.alisdk;

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;


public class HttpApiClient_ANY_CALL extends ApacheHttpClient{
    public final static String HOST = "openapi.any-call.com";
    static HttpApiClient_ANY_CALL instance = new HttpApiClient_ANY_CALL();
    public static HttpApiClient_ANY_CALL getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTP);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }
    public ApiResponse myApiToken(String userName , String passWord) {
        String path = "/service/loginIn";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("userName" , userName , ParamPosition.QUERY , false);
        request.addParam("passWord" , passWord , ParamPosition.QUERY , false);



        return sendSyncRequest(request);
    }

    /**
     *  小程序WxUser根据unionid和type更新接口
     * @param unionid
//     * @param idToken
//     * @param type
     * @param callback
     */
    public void updateByUnionIdAndType(String unionid , String userId,String token , ApiCallback callback) {
        String path = "/openapi/wxuserUpdate";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("unionid" , unionid , ParamPosition.QUERY , true);
        request.addParam("idToken" , token , ParamPosition.QUERY , true);
        request.addParam("userId" , userId , ParamPosition.QUERY , true);

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

}