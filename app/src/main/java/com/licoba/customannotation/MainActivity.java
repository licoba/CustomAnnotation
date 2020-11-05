package com.licoba.customannotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity {


    @MyTag(name = "宝马",size = 100)
    Car myCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //这里我们要首先注册一下这个类
        AnnotationCar.instance().inject(this);
        //当程序运行的时候这里将会输出该类Car的属性值。
        Log.e("myCar","Car is "+myCar.toString());

    }

}