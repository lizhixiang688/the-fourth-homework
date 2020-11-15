package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {   //抛出异常
           Class<?> c=Class.forName("com.company.People");
           People p=(People) c.newInstance();                   //实例化了一个Person对象
           System.out.println("调用对象的方法");
           p.tell();                                            //可以调用对象的方法
           System.out.println("没有更改之前的属性");
           System.out.println(p);                               //调用tostring方法

        Field f[]=c.getDeclaredFields();                        //取得全部的属性并输出
        for(int i=0;i<f.length;i++){
            Class<?> r=f[i].getType();
            int mo=f[i].getModifiers();
            String priv=Modifier.toString(mo);
            System.out.print("属性有：");
            System.out.print(priv+" ");
            System.out.print(r.getName()+" ");
            System.out.print(f[i].getName());
            System.out.println(";");
        }

        Scanner sc=new Scanner(System.in);                      //可以输入想改变的属性和想改变的值
        System.out.println("请输入想要操作的属性");
        String a=sc.nextLine();
       try {
           Field ageField = c.getDeclaredField(a);              //异常处理输入不正确的属性
           System.out.println("请输入想要改变的值");
           int b = sc.nextInt();
           ageField.setAccessible(true);
           ageField.set(p, b);

           System.out.println("正在修改中...");
           Thread.sleep(2000);                            //延时的线程
       }catch(Exception e){
           e.printStackTrace();
       }

        System.out.println("更改之后的属性");
        System.out.println(p);

        System.out.println("调用私有方法");                       //调用对象的私有方法
        Method studyMethod=c.getDeclaredMethod("stduy");
        studyMethod.setAccessible(true);
        studyMethod.invoke(p);
    }
}

