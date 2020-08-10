package com.michmi.view.impl;

import com.michmi.dao.BusinessDao;
import com.michmi.dao.Impl.BusinessDaoImpl;
import com.michmi.domain.Business;
import com.michmi.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView
{
    Scanner input = new Scanner(System.in);

    @Override
    public void listBusinessAll()
    {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b : list)
        {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" + b.getBusinessExplain() + "\t" + b.getStartPrice() + "\t" + b.getDeliveryPrice());
        }
    }

    /**
     * 搜索
     */
    @Override
    public void listBusinessBySearch()
    {
        String businessName = "";
        String businessAddress = "";
        String inputStr = "";
        System.out.println("是否需要输入商家名称关键字(y/n): ");
        inputStr = input.next();
        if (inputStr.equals("y"))
        {
            System.out.println("请输入商家名称关键字：");
            businessName = input.next();
        }
        System.out.println("是否需要输入商家地址关键字(y/n): ");
        inputStr = input.next();
        if (inputStr.equals("y"))
        {
            System.out.println("请输入商家地址关键字：");
            businessAddress = input.next();
        }

        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b : list)
        {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" + b.getBusinessExplain() + "\t" + b.getStartPrice() + "\t" + b.getDeliveryPrice());
        }

    }

    /**
     * 保存商家
     */
    @Override
    public void saveBusiness()
    {
        System.out.println("请输入商家名字：");
        String businessName = input.next();

        BusinessDaoImpl dao = new BusinessDaoImpl();
        int businessId = dao.saveBusiness(businessName);
        if (businessId > 0)
        {
            System.out.println("新建商家成功！ 商家编号为" + businessId);

        } else
        {
            System.out.println("新建商家失败！");

        }

    }

    @Override
    public Business login()
    {
        System.out.println("请输入商家的编号：");
        Integer businessId = input.nextInt();
        System.out.println("请输入密码：");
        String password = input.next();
        BusinessDaoImpl dao = new BusinessDaoImpl();

//        Business business = dao.getBusinessByNameByPass(businessId, password);
//        return business;

        return dao.getBusinessByNameByPass(businessId, password);
    }
}
