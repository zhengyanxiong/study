package com.bernie.springstatemachine.customs;

/**
 * @Author: zhengyanxiong
 * @Date: Date: 2025/2/23 22:18
 */
public interface StateMachineListener<S extends Enum<S>, E extends Enum<E>, C> {

    default void beforeTransition(S source, E event, C context) {
    }

    default void afterTransition(TransitionRecord<S, E, C> record) {
    }

    default void onError(S source, E event, C context, Exception ex) {
    }
}
