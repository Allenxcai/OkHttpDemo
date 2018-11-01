package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final String PATH_BASE_URI = "http://www.imooc.com/data/picasso/images/";

    private ListView mLst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Picasso.with(this).setIndicatorsEnabled(true);
        mLst = (ListView) this.findViewById(R.id.lst_icons);
        mLst.setAdapter(new IconAdapter(getDataUris()));
    }

    class IconAdapter extends BaseAdapter {
        private List<String> mDataUries;

        public IconAdapter(List<String> dataUris) {
            mDataUries = dataUris;
        }

        @Override
        public int getCount() {
            return mDataUries != null ? mDataUries.size() : 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView icon = new ImageView(MainActivity.this);
            //使用下载:自动缓存到磁盘内存或者内存缓存
            Picasso picasso = Picasso.with(MainActivity.this);
            RequestCreator request = picasso.load(mDataUries.get(i));
            request.into(icon);
            return icon;
        }
    }

    //获取图片地址
    public List<String> getDataUris() {

        List<String> datas = new ArrayList<String>();
        datas.add(PATH_BASE_URI + "1.jpg");
        datas.add(PATH_BASE_URI + "2.jpg");
        datas.add(PATH_BASE_URI + "3.jpg");
        datas.add(PATH_BASE_URI + "4.jpg");
        datas.add(PATH_BASE_URI + "5.jpg");
        datas.add(PATH_BASE_URI + "6.jpg");
        datas.add(PATH_BASE_URI + "6.jpg");
        datas.add(PATH_BASE_URI + "6.jpg");
        datas.add(PATH_BASE_URI + "6.jpg");
        datas.add(PATH_BASE_URI + "6.jpg");
        datas.add(PATH_BASE_URI + "6.jpg");
        datas.add(PATH_BASE_URI + "6.jpg");
        datas.add(PATH_BASE_URI + "6.jpg");
        datas.add(PATH_BASE_URI + "6.jpg");
        datas.add(PATH_BASE_URI + "6.jpg");
        return datas;
    }
}
