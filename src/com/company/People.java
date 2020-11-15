package com.company;


public class People {

    private int age = 18;
    private int weight = 60;
    public String toString(){                               //覆写tostring方法
            return "年龄是："+age+"岁"+" "+"体重是："+weight+"公斤";
    }
    public void tell(){                                     //普通方法
        System.out.println("我"+age+"岁了"+"我有"+weight+"公斤");
    }
    private void stduy(){                                   //私有方法
        System.out.println("我在偷偷学习");
    }
}
