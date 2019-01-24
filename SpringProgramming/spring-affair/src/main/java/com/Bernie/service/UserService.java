package com.Bernie.service;

import com.Bernie.TransactionUtil;
import com.Bernie.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bernie
 * @Date 2019/1/18 15:04
 **/
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void add() {
        //userDao.add("Bernie", 18);
        userDao.add("猪猪", 19);
        int i=1/0;

    }

}
