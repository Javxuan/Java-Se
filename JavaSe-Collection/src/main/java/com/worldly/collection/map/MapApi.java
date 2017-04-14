package com.worldly.collection.map;

import java.util.*;

/**
 * map集合的api
 *  1.一个映射最多只能包含一个键，不能重复
 *  2.每个键最多只能映射一个值
 * @author Worldly
 * @create 2017-04-13 8:44
 **/
public class MapApi {
    public static void main(String []args){
        Map<String,String> map  = new HashMap<String, String>();
        map.put("a","兰兰");
        map.put("b","空空");
        map.put("c","彩泉");
        map.put("d","岛饭");

        //往map里面添加元素
        show1(map);

        //删除某个元素
        map.remove("d");
        show2(map);

        map.put("e",null);
        //给键值为指定或者 是null的赋值为指定的值
        //map.putIfAbsent("e","now e isnot null");

        System.out.println("map size()"+ map.size());

        //直接得到所有的键值，然后再遍历
        Collection<String> values =  map.values();
        for(String s:values){
            System.out.print("value:"+ s+" ");
        }
    }

    /**
     * 利用keySet来遍历
     *  keySet()方法也是 map里面的一个内部类实例化的方法
     *
     * 思路:  1.先通过keySet()来获取 键的set集合
     *        2.然后再通过遍历set集合得到每个key
     *        3.再根据key 调用 get(key) 得到键值;
     *
     * @param map
     */
    private static  void show1(Map<String,String> map){
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String key = it.next();
            String value = map.get(key);
            System.out.println("key: "+key +" ->value: "+value);
        }
    }

    /**
     * 采用Entry<key,value>来遍历map集合
     * 思路：1.通过map的entrySet()方法的 set<Map.Entry<String,String>> 的set集合
     *       2.再通过遍历set集合 得到每个Map.Entry<String,String> entry
     *       3.然后通过entry的getKey() 和getValue()方法分别得到key 和value值
     *
     * @param map
     */
    private static void show2(Map<String,String> map){
       Set<Map.Entry<String,String>> entrySet = map.entrySet();
       Iterator<Map.Entry<String,String>> it = entrySet.iterator();
       while(it.hasNext()){
           Map.Entry<String,String> entry = it.next();
           String key = entry.getKey();
           String value = entry.getValue();
           System.out.println("key: "+ key +" ->value:"+value);
       }

    }

}
