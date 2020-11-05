package io.bernie.springboot.thymeleafs.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/5 21:54
 */
public interface TradingDayService {
    //判断是否为交易日
    boolean isTradingDay(LocalDate date);

    //查询下一个交易日
    Optional<LocalDate> queryNextTradingDay(LocalDate date);

    //查询一段时间范围的交易日, 注意包括[from, to]
    List<LocalDate> queryBetween(LocalDate from, LocalDate to);

    //查询日期所属月份的第一个交易日
    Optional<LocalDate> queryFirstTradingDayOfMonth(LocalDate date);
}
