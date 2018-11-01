package com.example.myapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;

public class Main2Activity extends AppCompatActivity {

    private ImageView mImg;
    public static final String PATH_IMAGE_URI = "http://www.imooc.com/data/picasso/images/1.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //设置图像调试
        mImg = (ImageView) findViewById(R.id.img);
        Picasso picasso = Picasso.with(this);
        RequestCreator request = picasso.load(PATH_IMAGE_URI);


        //裁剪
//        request.resize(100, 100);
//        request.centerCrop();

        //设置占位符图片
//        request.placeholder(R.mipmap.ic_launcher);

        //旋转
//        request.rotate(90);

        //网络加载错误显示的图片
//        request.error(R.mipmap.ic_launcher);
        request.transform(new DefineTransformation());
        //添加自定义图形类型
        request.into(mImg);
    }

    //类型转换
    class DefineTransformation implements Transformation {

        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            Bitmap result = Bitmap.createBitmap(source, x, y, size / 2, size / 2);
            if (result != source) {
                source.recycle();
            }
            return result;
        }

        @Override
        public String key() {
            return "icon";
        }
    }
}
