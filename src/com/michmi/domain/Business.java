package com.michmi.domain;

public class Business
{
    private Integer businessId;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double startPrice;
    private Double deliveryPrice;

    public Business()
    {
    }

    public Business(Integer businessId, String password, String businessName, String businessAddress, String businessExplain, Double startPrice, Double deliveryPrice)
    {
        this.businessId = businessId;
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessExplain = businessExplain;
        this.startPrice = startPrice;
        this.deliveryPrice = deliveryPrice;
    }

    public Integer getBusinessId()
    {
        return businessId;
    }

    public void setBusinessId(Integer businessId)
    {
        this.businessId = businessId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getBusinessName()
    {
        return businessName;
    }

    public void setBusinessName(String businessName)
    {
        this.businessName = businessName;
    }

    public String getBusinessAddress()
    {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress)
    {
        this.businessAddress = businessAddress;
    }

    public String getBusinessExplain()
    {
        return businessExplain;
    }

    public void setBusinessExplain(String businessExplain)
    {
        this.businessExplain = businessExplain;
    }

    public Double getStartPrice()
    {
        return startPrice;
    }

    public void setStartPrice(Double startPrice)
    {
        this.startPrice = startPrice;
    }

    public Double getDeliveryPrice()
    {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice)
    {
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public String toString()
    {
        return "Business{" +
                "businessId=" + businessId +
                ", password='" + password + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", businessExplain='" + businessExplain + '\'' +
                ", startPrice=" + startPrice +
                ", deliveryPrice=" + deliveryPrice +
                '}';
    }
}
