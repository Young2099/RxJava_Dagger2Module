package com.demo.panguso.rxjava_dagger2.common;

/**
 * Created by ${yangfang} on 2016/11/17.
 */
public class ApiConstants {

    // 头条id
    public static final String HEADLINE_ID = "T1348647909107";
    // 房产id
    public static final String HOUSE_ID = "5YyX5Lqs";

    // 头条TYPE
    public static final String HEADLINE_TYPE = "headline";
    // 房产TYPE
    public static final String HOUSE_TYPE = "house";

    // 其他TYPE
    public static final String OTHER_TYPE = "list";


    /**
     * 根据新闻Id获取类型
     *
     * @param id
     * @return
     */
    public static String getType(String id) {
        switch (id) {
            case HEADLINE_ID:
                return HEADLINE_TYPE;
            case HOUSE_ID:
                return HOUSE_TYPE;
        }
        return OTHER_TYPE;


    }
}
