package com.prompt.resume.network.api;

import com.prompt.resume.common.RequestParams;
import com.prompt.resume.model.talent.dataModel.receive.SearchResultRec;
import com.prompt.resume.network.entity.HttpResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author ：hm
 * date : 2019/9/9 9:51
 * package：com.prompt.resume.network.api
 * description :
 */
public interface ResumeService {


    /**
     * 简历列表
     *
     * @param pageNum
     * @param pageSize
     * @param intentState
     * @return
     */
    @GET("/api/resume/v1/promptOfferResumeList")
    Call<HttpResult> promptOfferResumeList(@Query(RequestParams.PAGENUM) int pageNum,
                                           @Query(RequestParams.PAGESIZE) int pageSize, @Query(RequestParams.INTENTSTATE) String intentState);

    @GET("/api/resume/v1/list")
    Call<HttpResult<SearchResultRec>> searchList(@Query(RequestParams.PAGENUM) int pageNum,
                                                 @Query(RequestParams.PAGESIZE) int pageSize, @Query(RequestParams.KEYWORDSBYTYPE) String key);
}
