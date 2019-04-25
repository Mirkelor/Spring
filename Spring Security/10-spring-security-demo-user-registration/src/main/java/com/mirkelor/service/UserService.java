package com.mirkelor.service;

import com.mirkelor.entity.User;
import com.mirkelor.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
