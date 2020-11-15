/*
package com.Bernie.nowcoder.editor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

*/
/**
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
 * <p>
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）
 * <p>
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（40分）
 *
 * @author: Bernie
 * @date: 2020/11/9
 *//*

class RMBConversion {
    private static final String[] numCapital = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
    private static final String[] numUnit = {"拾", "佰", "仟", "万", "亿", "元", "角", "分", "零", "整"};

    */
/**
     * 汉语中数字大写
     *//*

    private static final String[] CN_UPPER_NUMBER = {"零", "壹", "贰", "叁", "肆",
            "伍", "陆", "柒", "捌", "玖"};
    */
/**
     * 汉语中货币单位大写，这样的设计类似于占位符
     *//*

    private static final String[] CN_UPPER_MONETRAY_UNIT = {"分", "角", "元",
            "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
            "佰", "仟"};
    */
/**
     * 特殊字符：整
     *//*

    private static final String CN_FULL = "整";
    */
/**
     * 特殊字符：负
     *//*

    private static final String CN_NEGATIVE = "负";
    */
/**
     * 金额的精度，默认值为2
     *//*

    private static final int MONEY_PRECISION = 2;
    */
/**
     * 特殊字符：零元整
     *//*

    private static final String CN_ZEOR_FULL = "零元" + CN_FULL;

    */
/**
     * 把输入的金额转换为汉语中人民币的大写
     *
     * @param numberOfMoney 输入的金额
     * @return 对应的汉语大写
     *//*

    public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
        StringBuffer sb = new StringBuffer();
        int signum = numberOfMoney.signum();//返回此BigDecimal的正负号函数。此方法返回-1，0，或1，此BigDecimal的值分类为负，零或正值
        // 零元整的情况
        if (signum == 0) {
            return CN_ZEOR_FULL;
        }
        //这里会进行金额的四舍五入
        long number = numberOfMoney.movePointRight(MONEY_PRECISION)//movePointRight它等效于将该值的小数点向右移动n位
                .setScale(0, BigDecimal.ROUND_HALF_UP)
                */
/**
                 * BigDecimal.setScale()方法用于格式化小数点
                 * setScale(1)表示保留一位小数，默认用四舍五入方式
                 * setScale(1,BigDecimal.ROUND_DOWN)直接删除多余的小数位，如2.35会变成2.3
                 * setScale(1,BigDecimal.ROUND_UP)进位处理，2.35变成2.4
                 * setScale(1,BigDecimal.ROUND_HALF_UP)四舍五入，2.35变成2.4
                 * setScaler(1,BigDecimal.ROUND_HALF_DOWN)四舍五入，2.35变成2.3，如果是5则向下舍
                 *//*

                .abs().//返回一个BigDecimal，其值是此BigDecimal的绝对值
                longValue();// 将此BigDecimal转换为long。
        // 得到小数点后两位值
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        if (scale <= 0) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && ((scale % 10 <= 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            // 每次获取到最后一个数
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                }
                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!(getZero)) {
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                }
                getZero = true;
            }
            // 让number每次都去掉最后一个数
            number = number / 10;
            ++numIndex;
        }
        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        // 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
        if (!(scale > 0)) {
            sb.append(CN_FULL);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double money = sc.nextDouble();
            BigDecimal numberOfMoney = new BigDecimal(money);//Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算。
            System.out.println(number2CNMontrayUnit(numberOfMoney));;
        }


    }


    */
/**
     * 题目描述
     * 问题描述：有4个线程和1个公共的字符数组。
     * 线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，
     * 线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定
     *//*

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                int num = scanner.nextInt();
                Object a = new Object();
                Object b = new Object();
                Object c = new Object();
                Object d = new Object();
                Thread thread1 = new Thread(new ThreadPrintAbcd("A",a,b,num));
                Thread thread2 = new Thread(new ThreadPrintAbcd("B",b,c,num));
                Thread thread3 = new Thread(new ThreadPrintAbcd("C",c,d,num));
                Thread thread4 = new Thread(new ThreadPrintAbcd("D",d,a,num));

                thread1.start();
                thread2.start();
                thread3.start();
                thread4.start();
            }
        }
    }
    class ThreadPrintAbcd implements Runnable{
        private static int newIndex=0;
        private static int runIndex=0;
        private boolean isFirstRun=true;
        private Object self;
        private Object next;
        private String name;
        private int id;
        private int num;

        public ThreadPrintAbcd(String name,Object self,Object next,int num){
            id = newIndex++;
            this.name = name;
            this.self = self;
            this.next = next;
            this.num = num;
        }
        @Override
        public void run() {
            while (num > 0){
                synchronized(self){
                    if(id > runIndex){
                        try {
                            self.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(name);
                    if(isFirstRun){
                        runIndex ++;
                        isFirstRun=false;
                    }
                    synchronized (next) {
                        next.notify();
                    }
                    num--;
                    if(num >0){
                        try {
                            self.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}*/
