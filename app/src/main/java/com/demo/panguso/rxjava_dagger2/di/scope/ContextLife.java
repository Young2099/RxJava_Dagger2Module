package com.demo.panguso.rxjava_dagger2.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by ${yangfang} on 2016/11/22.
 * If we need two different objects of the same return type,
 * we can use the @Named qualifier annotation.
 * You will define it both it where you provide the singletons (@Provides annotation),
 * and where you inject them (@Inject annotations):
 *
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ContextLife {
    String value() default "Application";
}
