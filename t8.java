package com.itheima;

import java.lang.ref.SoftReference;
import java.util.Random;
import java.util.Scanner;

public class t8 {
    public static void main(String[] args) {
        System.out.println("==========欢迎参与双色球博彩============");
        System.out.println("==========共七球 需下注七注！===========");
        System.out.println("==========恭喜您！成功下注14元===========");
        int[] reds = setRedBall();
        System.out.println("==========您选择的红球号码为:===========");
        ouputArrays(reds);
        int[] blues = setBlueBall();
        System.out.println("==========您选择的蓝球号码为:============");
        ouputArrays(blues);

        System.out.println("==============现在开始随机转球==============");
        System.out.println("================3===============");
        System.out.println("================2===============");
        System.out.println("================1===============");

        int[] redBalls = getRedBall();
//        int[] blueBalls = getBlueBall();
        System.out.println("===============中奖红色球号码为:===============");
        ouputArrays(redBalls);
        System.out.println("===============中奖蓝色球号码为:================");
        ouputArrays(blueBalls);
        System.out.println(winning(reds, blues, redBalls, blueBalls));
    }
//获取红球随机数 采用随机打乱1-33数字 再取前三个 已达到随机且不重复的场景
    public static int[] getRedBall() {
        int[] numbers = new int[33];
        int[] redBallNumbers = new int[6];
        Random random = new Random();
        for (int i = 0,j = 1; i < numbers.length; i++,j++) {
            numbers[i]=j;
        }
        for (int i = 0; i < numbers.length; i++) {
            int randomnumber = random.nextInt(33);
            int temp = numbers[randomnumber];
            numbers[randomnumber] = numbers[i];
            numbers[i] = temp;
        }
        for (int i = 0; i < redBallNumbers.length; i++) {
            redBallNumbers[i] = numbers[i];
        }
        return redBallNumbers;
    }
    public static int[] getBlueBall() {
        int[] numbers = new int[16];
        int[] blueBallNumbers = new int[1];
        Random random = new Random();
        for (int i = 0,j = 1; i < numbers.length; i++,j++) {
            numbers[i]=j;
        }
        for (int i = 0; i < numbers.length; i++) {
            int randomnumber = random.nextInt(16);
            int temp = numbers[randomnumber];
            numbers[randomnumber] = numbers[i];
            numbers[i] = temp;
        }
        for (int i = 0; i < blueBallNumbers.length; i++) {
            blueBallNumbers[i] = numbers[i];
        }
        return blueBallNumbers;
    }
//标准化输出数组的方法
    public static void ouputArrays(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if(i!=array.length-1){
                System.out.print(array[i]+",");
            }else {
                System.out.print(array[i] + "]");
            }
        }
        System.out.println();
    }
//输入红球号码
    public static int[] setRedBall() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你选择的红球号码(1-33号数字):");
        int[] reds = new int[6];
        for (int i = 0; i < reds.length; i++) {
            System.out.println((i+1)+"号红球号:");
            OUT:
            while (true){
            int flag = scan.nextInt();
            if(flag>33||flag<1) {
                System.out.println("输入数字错误 请重新输入！！！");
                continue;
             }
            else{
                for (int j = 0; j <= i-1; j++) {
                    if(flag==reds[j]){
                        System.out.println("号码出现重复 请重新输入!");
                        continue OUT;
                    }
                }
                reds[i] = flag;
                break;
            }
            }
        }
        return reds;
    }
    //生成篮球号码
    public static int[] setBlueBall() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你选择的蓝球号码(1-16号数字):");
        int[] blues = new int[1];
        System.out.println("1号蓝球号:");
        int flag = scan.nextInt();
        blues[0] = flag;
        return blues;
    }
    //获取中的奖项
    public static String winning(int[] redballs,int[] blueballs,int[] randomredballs,int[] randomblueballs) {
        int redcount = 0;
        int bluecount = 0;
        for (int i = 0; i < redballs.length; i++) {
            for (int j = 0; j < randomredballs.length; j++) {
                if(redballs[i]==randomredballs[j]){
                    redcount++;
                }else{
                    continue;
                }
            }
        }
        if (blueballs[0]==randomblueballs[0]){
            bluecount++;
        }
        
        return redcount+"/"+bluecount;
    }
}
