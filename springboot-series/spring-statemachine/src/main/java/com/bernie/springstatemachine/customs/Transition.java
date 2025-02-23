package com.bernie.springstatemachine.customs;

/**
 * @Author: zhengyanxiong
 * @Date: Date: 2025/2/23 22:31
 */
public interface Transition<S extends Enum<S>, E extends Enum<E>, C> {

    S getSource();

    E getEvent();

    S getTarget();

    default boolean validate(C context) {
        return true;
    }

    default void execute(C context) {
    }

    default boolean matches(S currentState, E event) {
        return getSource() == currentState && getEvent() == event;
    }
}
