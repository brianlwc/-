package week01.bw.com.zhoukao_mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import week01.bw.com.zhoukao_mvp.Presenter.MyPresenter;
import week01.bw.com.zhoukao_mvp.View.MyView;

public class MainActivity extends AppCompatActivity implements MyView {
    RecyclerView mRv;
    MyAdapter adapter;
    MyPresenter myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRv = findViewById(R.id.my_rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(manager);
        mRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        myPresenter = new MyPresenter(this);
        myPresenter.handleData();
    }

    @Override
    public void setlistItem(MenuBean menuBean) {
        adapter = new MyAdapter();
        adapter.refresh(this,menuBean.getData());
        mRv.setAdapter(adapter);
    }

    @Override
    public void Failed() {
        Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
    }
}
