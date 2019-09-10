package com.prompt.resume.network.api;

import com.prompt.resume.common.RequestParams;
import com.prompt.resume.model.user.dataModel.receive.LoginPwdRec;
import com.prompt.resume.network.HMClient;
import com.prompt.resume.network.entity.HttpResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * author ：hm
 * date : 2019/9/4 10:18
 * package：com.prompt.resume.network.api
 * description :
 */
public interface UserService {

    /**
     * 账户密码登录
     */
    @FormUrlEncoded
    @POST("/api/co/member/v1/loginByPwd")
    Call<HttpResult<LoginPwdRec>> loginPwd(@Field(RequestParams.MOBILE) String mobile, @Field(RequestParams.PASSWORD) String password);


    /**
     * 获取验证码
     *
     * @param mobile
     * @param smsType 注册-REGISTER 修改密码-EDITPASSWORD  通用验证码（如登录）-COMMON
     * @return
     */
    @GET("/api/sms/getSmsCode")
    Call<HttpResult> getSmsCode(@Query(RequestParams.MOBILE) String mobile, @Query(RequestParams.SMSTYPE) String smsType);


    /**
     * 验证码登录
     */
    @FormUrlEncoded
    @POST("/api/co/member/v1/loginBySmsCode")
    Call<HttpResult<LoginPwdRec>> loginSmsCode(@Field(RequestParams.MOBILE) String mobile, @Field(RequestParams.SMSCODE) String smsCode);

    /**
     * 认证
     */
    @FormUrlEncoded
    @POST("/api/co/member/v1/register")
    Call<HttpResult<LoginPwdRec>> authAccount(@Field(RequestParams.MOBILE) String mobile, @Field(RequestParams.NAME) String name,
                                              @Field(RequestParams.COMPNAME) String compName, @Field(RequestParams.EMAIL) String email,
                                              @Field(RequestParams.SMSCODE) String smsCode, @Field(RequestParams.CLIENTTYPE) String clientType,
                                              @Field(RequestParams.INVITECODE) String inviteCode, @Field(RequestParams.PASSWORD) String password);

    /**
     * 修改密码
     */
    @FormUrlEncoded
    @POST("/api/co/member/v1/forgetPwd")
    Call<HttpResult> updatePassword(@Field(RequestParams.MOBILE) String mobile,
                                    @Field(RequestParams.SMSCODE) String smsCode,
                                    @Field(RequestParams.NEWPWD) String newPwd);
}
