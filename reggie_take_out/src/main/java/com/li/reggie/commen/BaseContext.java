package com.li.reggie.commen;

/**
 * Thread localを通じて、ログインのユーザーIDを取れるツール
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long Id){
        threadLocal.set(Id);
    }
    public static Long getCurrentId(){
        return threadLocal.get();
    }

}
