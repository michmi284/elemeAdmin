package com.michmi.dao;

import com.michmi.domain.Admin;

public interface AdminDao {
    public Admin getAdminByNameByPass(String adminName, String password);
}
