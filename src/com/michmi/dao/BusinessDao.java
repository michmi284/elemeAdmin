package com.michmi.dao;

import com.michmi.domain.Business;

import java.util.List;

public interface BusinessDao
{
    public List<Business> listBusiness(String businessName, String businessAddress);

    public int saveBusiness(String businessName);


    public Business getBusinessByNameByPass(Integer businessId, String password);

    public int removeBusiness(int businessId);

    public Business getBusinessByBusinessId(Integer businessId);

    public int updateBusiness(Business business);

    public int updateBusinessByPassword(Integer businessId, String password);

    public Business getBusinessById(Integer businessId);
}
