package com.michmi.test;

import com.michmi.dao.Impl.BusinessDaoImpl;
import com.michmi.domain.Business;

public class TestBusiness
{
    public static void main(String[] args)
    {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.listBusiness(null,null);

    }
}
