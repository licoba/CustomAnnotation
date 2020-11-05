package com.licoba.customannotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
// @Inherited 表明可以被继承
// 可以参考这篇文章 https://www.jianshu.com/p/4a3ffb79c10e
public @interface MyTag {
    //声明返回值类型
    String name () default "" ;
    int size () default 0 ;
}