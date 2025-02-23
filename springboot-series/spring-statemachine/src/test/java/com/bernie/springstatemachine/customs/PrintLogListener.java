package com.bernie.springstatemachine.customs;

/**
 * @Author: zhengyanxiong
 * @Date: Date: 2025/2/23 23:05
 */
public class PrintLogListener<S extends Enum<S>, E extends Enum<E>, C> implements StateMachineListener<S, E, C> {

    @Override
    public void beforeTransition(S source, E event, C context) {
        System.out.println("State change source " + source);
    }

    @Override
    public void afterTransition(TransitionRecord<S, E, C> record) {
        System.out.println(record);
    }
}
