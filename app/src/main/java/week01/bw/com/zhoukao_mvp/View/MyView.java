package week01.bw.com.zhoukao_mvp.View;

import week01.bw.com.zhoukao_mvp.MenuBean;

//处理数据展示到UI
public interface MyView {
    void setlistItem(MenuBean menuBean);
    void Failed();
}
