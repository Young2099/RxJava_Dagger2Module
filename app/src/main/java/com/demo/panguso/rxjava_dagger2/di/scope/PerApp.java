package com.demo.panguso.rxjava_dagger2.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by ${yangfang} on 2016/11/22.
 */
@Scope//Dagger2可以通过自定义注解限定注解作用域。
@Documented
@Retention(RetentionPolicy.RUNTIME)//运行
public @interface PerApp {
}
