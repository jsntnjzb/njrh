package com.njrhzn.ew.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.njrhzn.ew.R;

import java.util.ArrayList;

public class DropDownListView extends LinearLayout {
    private TextView editText;
    private ImageButton img_btn_arrow;
    private PopupWindow popupWindow = null;
    private ArrayList<String> dataList = null;
    private int popWindow_width = 0;
    private View mView;

    public DropDownListView(Context context) {
        super(context);
    }

    public DropDownListView(Context context,AttributeSet attrs) {
        super(context, attrs);
        initView();
        initData();
    }

    public DropDownListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(){
        LayoutInflater layoutInflater;
        layoutInflater =  (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView  = layoutInflater.inflate(R.layout.dropdownlist_view, this,true);
        editText= mView.findViewById(R.id.text);
        img_btn_arrow = mView.findViewById(R.id.img_btn_arrow);

        this.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(popupWindow == null ){
                    showPopWindow();
                }else{
                    closePopWindow();
                }
            }
        });

        img_btn_arrow.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popupWindow == null ){
                    showPopWindow();
                }else{
                    closePopWindow();
                }
            }
        });
    }

    private void initData(){
        if (dataList==null){
            dataList = new ArrayList<>();
            dataList.add("紫薯热豆浆");
            dataList.add("紫薯冷豆浆");
            dataList.add("原味热豆浆");
            dataList.add("原味冷豆浆");
        }
        editText.setText(dataList.get(0));
        if(popWindow_width==0){
            int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            mView.measure(spec,spec);
            popWindow_width = mView.getMeasuredWidth();
            Log.d("DropDownListView","popWindow_width"+popWindow_width);
        }
    }

    /**
     * 打开下拉列表弹窗
     */
    private void showPopWindow() {
        // 加载popupWindow的布局文件
        LayoutInflater layoutInflater;
        layoutInflater =  (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView  = layoutInflater.inflate(R.layout.dropdownlist_popupwindow, null,false);
        ListView listView = contentView.findViewById(R.id.listView);
        listView.setAdapter(new DropDownListAdapter(getContext(), dataList));
        popupWindow = new PopupWindow(contentView,popWindow_width,LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
//        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.alpha()));
        popupWindow.setContentView(contentView);
        popupWindow.showAsDropDown(this);
        popupWindow.showAtLocation(this, Gravity.BOTTOM,0,0);
    }


    /**
     * 关闭下拉列表弹窗
     */
    private void closePopWindow(){
        popupWindow.dismiss();
        popupWindow = null;
    }
    /**
     * 设置数据
     * @param list
     */
    public void setItemsData(ArrayList<String> list){
        dataList = list;
        editText.setText(list.get(0).toString());
    }

    /**
     * 数据适配器
     * @author caizhiming
     *
     */
    class DropDownListAdapter extends BaseAdapter {

        Context mContext;
        ArrayList<String> mData;
        LayoutInflater inflater;
        public DropDownListAdapter(Context ctx,ArrayList<String> data){
            mContext  = ctx;
            mData = data;
            inflater = LayoutInflater.from(mContext);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            // 自定义视图
            ListItemView listItemView = null;
            if (convertView == null) {
                // 获取list_item布局文件的视图
                convertView = inflater.inflate(R.layout.dropdown_list_item, null);

                listItemView = new ListItemView();
                // 获取控件对象
                listItemView.tv = (TextView) convertView.findViewById(R.id.tv);
//                listItemView.layout = (LinearLayout) convertView.findViewById(R.id.layout_container);
                // 设置控件集到convertView
                convertView.setTag(listItemView);
            } else {
                listItemView = (ListItemView) convertView.getTag();
            }

            // 设置数据
            listItemView.tv.setText(mData.get(position));
            final String text = mData.get(position);
            convertView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    editText.setText(text);
                    closePopWindow();
                }
            });
            return convertView;
        }

    }

    private static class ListItemView{
        TextView tv;
        LinearLayout layout;
    }
}
