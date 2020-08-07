package com.michmi.test;

import com.michmi.dao.AdminDao;
import com.michmi.dao.Impl.AdminDaoImpl;
import com.michmi.domain.Admin;

public class TestAdmin {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDaoImpl();
        Admin admin = adminDao.getAdminByNameByPass("zhangsan", "123");
        System.out.println(admin);
    }
}
