package com.rs.demo;

import android.support.annotation.Nullable;
import android.widget.BaseAdapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Rs on 2018/6/26.
 */

public class MainAdapter extends BaseMultiItemQuickAdapter<MainBean, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MainAdapter(List<MainBean> data) {
        super(data);
        addItemType(MainBean.TEXT,R.layout.item_mainactivity);
        addItemType(MainBean.IMG,R.layout.headview);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainBean item) {
        switch (helper.getItemViewType()){
            case MainBean.TEXT:
                helper.setText(R.id.text, item.getName())
                        .setText(R.id.pt_text, item.getPosition() + "");
                break;
                case MainBean.IMG:
                    break;
        }

    }
}
