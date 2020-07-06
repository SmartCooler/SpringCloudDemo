package com.springboot.common.utils;

public class StringUtils {

    /**
     * 判断是否为空
     * @param param
     * @return
     */
    public static boolean isNotEmpty(String param){
        if(param!="" || param!=null){
            return true;
        }else{
            return false;
        }
    }

}
