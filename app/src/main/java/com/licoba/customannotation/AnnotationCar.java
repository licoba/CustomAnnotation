package com.licoba.customannotation;

import android.util.Log;

import java.lang.reflect.Field;

public class AnnotationCar {
    private static AnnotationCar annotationCar;

    public static AnnotationCar instance() {
        synchronized (AnnotationCar.class) {
            if (annotationCar == null) {
                annotationCar = new AnnotationCar();
            }
            return annotationCar;
        }
    }

    public void inject(Object o) {
        Class<?> aClass = o.getClass();
        // getDeclaredFields  获得某个类的所有声明的字段，即包括public、private和proteced
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            Log.e("field", field.getName());
            // 找到MainActivity里面 所有的 通过@MyTag注解修饰的 成员变量
            if (field.isAnnotationPresent(MyTag.class)) {
                MyTag annotation = field.getAnnotation(MyTag.class);
                Class<?> type = field.getType();
                if (Car.class.equals(type)) {
                    try {
                        field.setAccessible(true);
                        // 直接设置o，也就是MainActivity.this 里的filed成员变量
                        Log.e("inject","设置值");
                        field.set(o, new Car(annotation.name(), annotation.size()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

