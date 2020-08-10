package com.michmi.view;

import com.michmi.domain.Business;

public interface BusinessView
{
    public void listBusinessAll();

    public void listBusinessBySearch();

    public void saveBusiness();

    //添加商家登录验证的方法
    public Business login();

    public void showBusiness(Integer businessId);

    public void updateBusiness(Integer businessId);

}
