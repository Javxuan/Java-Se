package com.worldly.enums;

/**
 * 在枚举上实现接口
 *
 * @author Worldly
 * @create 2017-04-19 21:03
 **/
public class EnumInterface {
    public static void main(String [] args){
        EnumColor enumColor = EnumColor.GREEN;
        enumColor.getColor();
    }

}

/**
 * 枚举
 *  已经继承了Enum所以不能再继承。
 */
enum EnumColor implements Info{
    /**
     * 1.既可以让所有的对象都实现 同一个方法。
     * 2.常理来说，每个对象都有不同的颜色所以都有不同的getColor方法
     *   因为每个对象都可以有自己的构造方法
     */
    RED {
        public void getColor() {
            System.out.println("Red");
        }
    },GREEN{
        public void getColor() {
            System.out.println("green");
        }
    },YELLOW{
        public void getColor() {
            System.out.println("yellow");
        }
    };

    /**
     * 在每个对象都实现了接口的构造方法的时候，公共的就不用了
     */
    public void getColor(){
        System.out.println("公共implements的方法");
    }
}

/**
 * 接口
 */
interface  Info{
    void getColor();
}