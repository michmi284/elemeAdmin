package com.michmi;

import com.michmi.domain.Admin;
import com.michmi.domain.Business;
import com.michmi.view.AdminView;
import com.michmi.view.BusinessView;
import com.michmi.view.impl.AdminViewImpl;
import com.michmi.view.impl.BusinessViewImpl;

import java.util.Scanner;

public class ElmBusiness
{
    public static void main(String[] args)
    {
        work();
    }

    public static void work()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------");
        System.out.println("|\t\t\t\t饿了么控制台版后台管理系统 V1.0\t\t\t\t|");
        System.out.println("-----------------------------------------------------------");

        // 调用商家登录方法
        BusinessView businessView = new BusinessViewImpl();
        Business business = businessView.login();
        if (business != null)
        {
            int menu = 0;
            System.out.println("~欢迎来到饿了么商家管理系统~");
            while (menu != 5)
            {

                // 创建一个菜单
                System.out.println("=========\t一级菜单:1.查看商家信息\t2.修改商家信息\t3.更改密码\t4.所属商品管理\t5.退出系统\t=========");
                System.out.println("请选择相应的菜单编号");
                menu = input.nextInt();

                switch (menu)
                {
                    case 1:
                        businessView.listBusinessAll();
                        System.out.println("1.查看商家信息");
                        break;
                    case 2:
                        System.out.println("2.修改商家信息");
                        break;
                    case 3:
                        System.out.println("3.更改密码");
                        break;
                    case 4:
                        System.out.println("4.所属商品管理");
                        break;
                    case 5:
                        System.out.println("========= 欢迎下次光临饿了么系统 =========");
                        break;
                    default:
                        System.out.println("没有这个菜单项");
                        break;
                }

            }

        } else
        {
            System.out.println("账号或密码有误请重新输入");
        }
    }
}
