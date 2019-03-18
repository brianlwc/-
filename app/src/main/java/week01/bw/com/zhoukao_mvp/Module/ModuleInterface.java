package week01.bw.com.zhoukao_mvp.Module;

import week01.bw.com.zhoukao_mvp.MenuBean;

//module下载数据
public interface ModuleInterface {
    void LoadSuccess(MenuBean menuBean);
    void LoadFailed();
}
