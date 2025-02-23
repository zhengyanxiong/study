package com.bernie.springstatemachine.customs;

import java.util.List;


/**
 * 通用状态机接口
 * @param <S> 状态枚举
 * @param <E> 状态事件枚举
 * @param <C> 上下文
 * @Author: zhengyanxiong
 * @Date: Date: 2025/2/23 22:10
 */
public interface StateMachine <S extends Enum<S>, E extends Enum<E>, C> {
    /**
     * 触发状态转换
     * @param event 触发事件
     * @param context 业务上下文
     * @return 新状态
     */
    S fire(E event, C context);

    /**
     * 添加状态转换规则
     */
    void addTransition(Transition<S, E, C> transition);

    /**
     * 获取当前状态
     */
    S getCurrentState();

    /**
     * 获取状态变更历史
     */
    List<TransitionRecord<S, E, C>> getHistory();

    /**
     * 注册监听器
     */
    void registerListener(StateMachineListener<S, E, C> listener);
}
