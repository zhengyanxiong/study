package com.Bernie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author Bernie
 * @Date 2019/1/18 15:31
 **/
@Component
public class TransactionUtil {

    @Autowired
    private DataSourceTransactionManager transactionManager;

    /**
     * 开启事务
     */
    public TransactionStatus begin(){
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        System.out.println("开启事务");
        return status;
    }
    /**
     * 提交事务
     */
    public void commit(TransactionStatus status){
        transactionManager.commit(status);
        System.out.println("提交事务");
    }
    /**
     * 回滚事务
     */
    public void rollback(TransactionStatus status){
        transactionManager.rollback(status);
        System.out.println("回滚事务");
    }
}
