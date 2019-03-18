package week01.bw.com.zhoukao_mvp.Module;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;
import week01.bw.com.zhoukao_mvp.MenuBean;

public interface RetrofitInterface {
    @GET
    Observable<MenuBean> getDataUrl(@Url String url);
}
