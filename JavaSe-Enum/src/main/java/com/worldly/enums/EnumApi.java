package com.worldly.enums;

/**
 * 枚举的api测试
 *  1.枚举由来的原因：为了某一类型的变量只能在固定值里的一个，避免出现错误。
 *  2.如果不才用枚举的话，就要使用常量来确定。但是用户在用的时候你也不规定用户只能取常量。
 *
 * @author Worldly
 * @create 2017-04-18 17:01
 **/
public class EnumApi  {
    public static void main(String [] args){
        /**
         * 既然 RED是 RedLigtColor 的实例，那个就可以用 RedLighiColor类型去接收。
         * 自动重写了toString()方法。
         */
        RedLigtColor redLigtColor = RedLigtColor.RED;
        /**
         * 默认输出 的时候是调用了  Enum子类 调用 Enum的 name()方法  。oridal()序号方法
         */
        System.out.println(redLigtColor);
        //枚举名
        System.out.println(redLigtColor.name());
        //序号
        System.out.println(redLigtColor.ordinal());

        RedLigtColor[] redLigtColors = RedLigtColor.values();
        for(RedLigtColor r : redLigtColors){
            System.out.println(r.getColor());
        }

        /*
         *把给字符串变成枚举对象
         * 其他字符串不行，枚举不认。
         */
        RedLigtColor r = RedLigtColor.valueOf("on");
        System.out.println(r.getColor());

        System.out.println(RedLigtColor.GREEN.getColor());
    }
}

/**
 * 采用 enum关键字定义的类 就extends Enum 类。
 * 所以枚举不能再继承。
 */
enum RedLigtColor{
    /**
     * RED都是这些枚举预先定义好的对象实例。
     */
    RED(1,"红"),GREEN(2,"绿"),YELLOW(3,"黄");

    int code;
    String color;

    /**
     * 构造函数私有的，为了让外面不能通过构造方法来构造新的对象。
     * @param code
     * @param color
     */
    private  RedLigtColor(int code,String color){
        this.code = code;
        this.color=color;
    }

    public int getCode(){
        return code;
    }
    public void setCode(int code){
        this.code = code;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

}
