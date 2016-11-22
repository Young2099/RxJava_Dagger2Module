package com.demo.panguso.rxjava_dagger2.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by ${yangfang} on 2016/11/22.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PerActivity {
}
