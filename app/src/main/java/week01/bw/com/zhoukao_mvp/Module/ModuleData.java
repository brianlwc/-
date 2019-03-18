package week01.bw.com.zhoukao_mvp.Module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import week01.bw.com.zhoukao_mvp.MenuBean;

public class ModuleData {
    ModuleInterface moduleInterface;
    RetrofitInterface retrofitInterface;
    private String baseUrl = "http://www.qubaobei.com/ios/cf/";
    private String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";

    public ModuleData(ModuleInterface moduleInterface) {
        this.moduleInterface = moduleInterface;
    }

    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
        retrofitInterface.getDataUrl(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MenuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MenuBean menuBean) {
                        moduleInterface.LoadSuccess(menuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        moduleInterface.LoadFailed();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
