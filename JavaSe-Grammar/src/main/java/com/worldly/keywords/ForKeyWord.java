package com.worldly.keywords;

/**
 * for循环关键字
 * @author xiaoqixuan
 * @create 2017/5/24 16:16
 */
public class ForKeyWord {
    public static void main(String []args){
        forOneCondition();

        forTwoCondition();
    }

    /**
     * 一个初始化变量 单个循环条件的 for循环
     *  执行的步骤：
     *    i=0; ----> 0<10 true?false ---->{}  ------->i++;
     *             再i<10 true?false ---->{}  ------->i++;
     */
    public static void forOneCondition(){
        int [] arr = {2,3,4,1,3,5,8,10,9,20};
        for(int i=0;i<arr.length;i++){
            int a=i;
            System.out.println("a= "+a+"    condition="+i);
        }
    }

    /**
     * 两个初始化变量 单个循环条件 for循环
     */
    public static void forTwoCondition(){
        String maxStr= "woaijava jacadoc ai woshijava";
        String minStr = "ijavaaf";
        for(int i=0;i<minStr.length();i++){
            /**
             * 采用两个循环条件来截取子串。
             */
            for(int y=0,z=minStr.length()-i;z!=minStr.length()+1;y++,z++){
                String temp = minStr.substring(y,z);
                if(maxStr.contains(temp)){
                    System.out.println(temp);
                    return ;
                }
            }
        }
    }


}
