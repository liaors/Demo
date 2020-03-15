package com.rs.demo.basemvp;

import com.rs.demo.basemvp.bean.BaseResult;
import com.rs.demo.basemvp.bean.LoginBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceInterface {

    /**
     *
     * @param source 1导购 2客户
     * @param queryBody
     * @return
     */
    @POST(URL.login)
    Observable<BaseResult<LoginBean>> login(@Path("source") int source, @Body Map<String, Object> queryBody);

    @GET(URL.quaryPage)
    Observable<BaseResult<LoginBean>> quaryPage(@Query("id") int id, @Query("mobile") String mobile);
}
