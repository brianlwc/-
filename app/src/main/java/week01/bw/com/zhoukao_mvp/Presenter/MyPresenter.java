package week01.bw.com.zhoukao_mvp.Presenter;


import week01.bw.com.zhoukao_mvp.MenuBean;
import week01.bw.com.zhoukao_mvp.Module.ModuleData;
import week01.bw.com.zhoukao_mvp.Module.ModuleInterface;
import week01.bw.com.zhoukao_mvp.View.MyView;

public class MyPresenter implements ModuleInterface {
    MyView myView;
    ModuleData moduleData = new ModuleData(this);

    public MyPresenter(MyView myView) {
        this.myView = myView;
    }

    public void handleData(){
        moduleData.getData();
    }

    @Override
    public void LoadSuccess(MenuBean menuBean) {
        myView.setlistItem(menuBean);
    }

    @Override
    public void LoadFailed() {
        myView.Failed();
    }

}
