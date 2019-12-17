package com.njrhzn.ew.Activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.njrhzn.ew.Adapter.ProductAdapter;
import com.njrhzn.ew.App.AppManager;
import com.njrhzn.ew.Model.Product;
import com.njrhzn.ew.Model.SpaceItemDecoration;
import com.njrhzn.ew.R;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

public class ProductListActivity extends MySwipeBackActivity {
    private SwipeBackLayout mSwipeBackLayout;
    private RecyclerView mRecyclerView;
    private List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSwipeBackEnable(true);
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_product_list;
    }

    @Override
    protected void initView() {
        /**
         * 初始化RecyclerView
         */
        mRecyclerView = (RecyclerView) findViewById(R.id.lv_product);
        // 定义一个线性布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(0,50));
    }

    @Override
    protected void initData() {
        if(productList==null){
            productList = new ArrayList<>();
            productList.add(new Product("原味豆浆",0,false,new BigDecimal(5)));
            productList.add(new Product("甜味豆浆",0,false,new BigDecimal(7)));
            productList.add(new Product("红枣豆浆",0,false,new BigDecimal(8)));
        }
        ProductAdapter adapter = new ProductAdapter(new WeakReference<Context>(this), productList);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void registerReceiver() {

    }

    @Override
    protected void unregisterReceiver() {

    }

    @Override
    protected void removeMessage() {

    }

    @Override
    protected void addActivity() {
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void finishActivity() {
        AppManager.getAppManager().finishActivity(this);
        productList = null;
    }
}
