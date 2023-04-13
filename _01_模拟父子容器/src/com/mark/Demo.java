package com.mark;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        WebApplicationContext springContext = new WebApplicationContext();
        springContext.put("service", "service");

        WebApplicationContext mvcContext = new WebApplicationContext();
        mvcContext.put("controller", "controller");

        //将springContext传入mvcContext，既实现了父子容器关系（mvcContext中有springContext数据）
        mvcContext.setParent(springContext);

        //从子容器mvc中获取父容器service
        System.out.println(mvcContext.get("service"));
    }
}

/**
 * 用来模拟代替容器类
 */
class WebApplicationContext {

    //用来记录父容器的引用
    private WebApplicationContext parent;

    public Map<String,String> map = new HashMap<>();

    public void put(String Key, String Value) {
        map.put(Key,Value);
    }

    public void setParent(WebApplicationContext parent) {
        this.parent = parent;
    }

    public String get(String Key) {
        //从自己容器中获取
        String s = map.get(Key);
        if(s == null && parent != null)
        {
            //如果获取不到就从父容器中获取
            s = parent.get(Key);
        }
        return s;
    }
}
