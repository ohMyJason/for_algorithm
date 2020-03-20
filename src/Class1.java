/**
 * @author 刘佳昇
 * @Date 2020/2/29 23:10
 */

import java.awt.*;
import javax.swing.*;


public class Class1 extends JFrame{

    //定义一个类，在构造方法中进行初始化
    MyPanel mp = null;
    public static void main(String[] args) {
// TODO Auto-generated method stub

        Class1 class1 = new Class1();
    }


    //构造方法，完成相应的初始化
    public Class1()
    {
        mp = new MyPanel();

        this.add(mp);
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


}


//定义一个MyPanel类(我自己的面板,适用于绘图和现实绘图的区域)
class MyPanel extends JPanel
{
//覆盖JPanel的paint方法
    //Graphics 是绘图的重要类，你可以把它理解为一直画笔


    public void paint(Graphics g)
    {
//1，调用父类函数完成初始化
//这句话不能少
        super.paint(g);

//先画一个圆
        g.drawOval(500,500,10,10);
        //画字符串
        g.setColor(Color.red);
        g.setFont(new Font("",Font.BOLD,8));
        g.drawString("0,0", 500, 500);




        ////填充椭圆
        g.setColor(Color.red);
        g.fillOval(510, 510, 10, 10);
        //画字符串
        g.setColor(Color.red);
        g.setFont(new Font("",Font.BOLD,8));
        g.drawString("0,0", 500, 500);

////画一条直线
//        g.drawLine(40,40 , 60, 60);
//
////矩形边框
//        g.drawRect(70, 70, 80, 80);
//
////填充矩形
//        g.setColor(Color.BLUE);
//        g.fillRect(90,90,100,100);
//

//
////画图片
//
//

    }
}
