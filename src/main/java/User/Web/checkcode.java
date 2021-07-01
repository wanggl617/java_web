package User.Web;/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @title 阳光正好，微风不燥
 * @data 2021/6/1
 */
@WebServlet("/check")
public class checkcode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1.创建一个对象，表示在内存中的图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1  填充背景色
        Graphics graphics = image.getGraphics();//获取 画笔对象
        graphics.setColor(Color.CYAN);//设置颜色，用来填充背景色
        graphics.fillRect(0,0,width,height);
        //2.2 画边框
        graphics.setColor(Color.WHITE);
        graphics.drawRect(0,0,width-1,height-1);
        //2.3 写字
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer Buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int r = random.nextInt(str.length());
            graphics.setColor(Color.magenta);
            char ch = str.charAt(r);
            Buffer.append(ch);
            graphics.drawString(String.valueOf(ch), width/5*i, 25);
        }
        String end_code= Buffer.toString();
        HttpSession session = req.getSession();
        session.setAttribute("checkcode",end_code);
        //2.4 画干扰线
        graphics.setColor(Color.BLUE);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,x2,y1,y2);
        }
        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",resp.getOutputStream()) ;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}