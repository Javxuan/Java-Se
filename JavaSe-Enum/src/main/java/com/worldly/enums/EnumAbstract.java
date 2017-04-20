package com.worldly.enums;

/**
 * 枚举实现抽象方法
 *
 * @author Worldly
 * @create 2017-04-19 21:16
 **/
public class EnumAbstract {
    public static void main(String []args){
        EnumOnOff enumOnOff = EnumOnOff.OFF;
        EnumOnOff enumOnOff1 =enumOnOff.push();
        System.out.println(enumOnOff1);
    }

}

enum EnumOnOff{
    /**
     * 实例对象必须 implements　抽象方法。
     */
    ON{
        public EnumOnOff push(){
            System.out.println("on  to off ");
            return EnumOnOff.OFF;
        }
    },OFF {
        public EnumOnOff push(){
            System.out.println("off  to on ");
            return EnumOnOff.ON;
         }
    };

    /**
     * 电灯的开关。
     *
     * @return
     */
    public abstract  EnumOnOff push();
}
