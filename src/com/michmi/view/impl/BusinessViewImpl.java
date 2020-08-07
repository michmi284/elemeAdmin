package com.michmi.view.impl;

import com.michmi.dao.Impl.BusinessDaoImpl;
import com.michmi.domain.Business;
import com.michmi.view.BusinessView;

import java.util.List;

public class BusinessViewImpl implements BusinessView
{
    @Override
    public void listBusinessAll()
    {
        BusinessDaoImpl dao =new BusinessDaoImpl;
        List<Business> list = dao.listBusiness(null,null);
        System.out.println("商家编号\t商家名称");
        
    }
}
