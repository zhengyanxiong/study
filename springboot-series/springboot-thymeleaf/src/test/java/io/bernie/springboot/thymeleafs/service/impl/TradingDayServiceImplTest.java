package io.bernie.springboot.thymeleafs.service.impl;


import io.bernie.springboot.thymeleafs.service.TradingDayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/5 23:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TradingDayServiceImplTest {
    @Autowired
    private TradingDayService tradingDayService;

    @Test
    public void isTradingDay() {
        LocalDate localDate = LocalDate.parse("2020-11-08");
        System.out.println(localDate.toString() + ":" + tradingDayService.isTradingDay(localDate));
    }

    @Test
    public void queryNextTradingDay() {
        LocalDate localDate = LocalDate.parse("2020-11-05");
        Optional<LocalDate> result = tradingDayService.queryNextTradingDay(localDate);
        System.out.println(result.map(date -> localDate.toString() + "的下一个交易日:" + date.toString()).orElse("不存在"));
    }

    @Test
    public void queryBetween() {
        LocalDate fromDate = LocalDate.parse("2020-11-01");
        LocalDate toDate = LocalDate.parse("2020-11-11");
        List<LocalDate> localDateList = tradingDayService.queryBetween(fromDate,toDate);
        for (LocalDate localDate : localDateList) {
            System.out.println(localDate.toString());
        }
    }

    @Test
    public void queryFirstTradingDayOfMonth() {
        LocalDate fromDate = LocalDate.parse("2020-10-30");
        Optional<LocalDate> result = tradingDayService.queryFirstTradingDayOfMonth(fromDate);
        System.out.println(result.map(date -> fromDate.toString() + "所属月份的第一个交易日:" + date.toString()).orElse("不存在"));
    }
}