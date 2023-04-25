package S2023425;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
class node {
    private String name;
    private String color;
    private double price;
    private int number;
    public void putname(String name){
        this.name = name;
    }
    public String getname(){
        return this.name;
    }
    public void putcolor(String color){
        this.color = color;
    }
    public String getcolor(){
        return this.color;
    }
    public void putprice(double price){
        this.price=price;
    }
    public double getprice(){
        return this.price;
    }
    public void putnumber(int number){
        this.number=number;
    }
    public int getnumber(){
        return this.number;
    }
    @Override
    public String toString() {
        return "商品名：" + this.name +
                "，颜色：" + this.color +
                "，价格：" + this.price +
                "，数量：" + this.number;
    }

}
public class Case6test1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        //显示系统首页，首页当中包括所有的操作
        boolean TF =true;
        while(TF){
            switch (menu()){
                case 1:
                    putcommodity(list);
                    break;
                case 2:
                    showcommodity(list);
                    break;
                case 3:
                    deletecommodity(list);
                    break;
                case 4:
                    TF = false;
                    break;
                default:
                    System.out.println("对不起您的输入有误，请重新输入");
                    break;
            }
        }
    }
    public static void deletecommodity(ArrayList list){
        while(true){
            System.out.println("是否要进行删除");
            System.out.println("1. 删除   2. 退出");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if(num == 1){
                System.out.println("请输入要删除的商品名称");
                String name = sc.next();
                Iterator it = list.iterator();
                while(it.hasNext()){

                    if(it.next().toString().contains(name)){
                        it.remove();
                    }
                }
                for(Object obj : list){
                    System.out.println(obj);
                }
            }
            else if(num==2){
                return;
            }
            else{
                System.out.println("输入有误请重新输入");
            }

        }
    }
    public static void showcommodity(ArrayList list){
        for(Object obj : list){
            System.out.println(obj);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("退出请按数字“1”");
        while(true){
            if(sc.nextInt()==1){
                return;
            }
            else{
                System.out.println("输入不合法，请重新输入");
            }
        }
    }
    public static void putcommodity(ArrayList list){
        int i=0;
       while(true){
           System.out.println("您是否要选择放入");
           System.out.println("1. 放入    2.取消");
           Scanner sc = new Scanner(System.in);
           int TF = sc.nextInt();
           if(TF==1){
               System.out.println("现在开始放入");
               node cd = new node();
               System.out.println("商品名");
               cd.putname(sc.next());
               System.out.println("商品颜色");
               cd.putcolor(sc.next());
               System.out.println("商品价格");
               cd.putprice(sc.nextDouble());
               System.out.println("商品数量");
               cd.putnumber(sc.nextInt());
               list.add(cd);
           }
           else if(TF==2){
               break;
           }
           else{
               System.out.println("输入有误，请重新输入!");
           }
           System.out.println("刚刚放入的商品");
           System.out.println(list.get(i).toString());
           i++;
       }
    }
    public  static int menu(){
        System.out.println("********************************");
        System.out.println("欢迎来到我们的库存管理系统");
        System.out.println("1.商品入库功能");
        System.out.println("2.商品显示功能");
        System.out.println("3.删除商品功能");
        System.out.println("4.退出");
        System.out.println("********************************");
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        return result;
    }

}

