package com.bernie.springstatemachine.customs.builder;

import java.util.ArrayList;
import java.util.List;

import com.bernie.springstatemachine.customs.DefaultStateMachine;
import com.bernie.springstatemachine.customs.StateMachine;
import com.bernie.springstatemachine.customs.StateMachineListener;
import com.bernie.springstatemachine.customs.Transition;
import lombok.Getter;

/**
 * @Author: zhengyanxiong
 * @Date: Date: 2025/2/23 22:42
 */
public class StateMachineBuilder<S extends Enum<S>, E extends Enum<E>, C> {

    private S initialState;
    protected final List<Transition<S, E, C>> transitions = new ArrayList<>();
    private final List<StateMachineListener<S, E, C>> listeners = new ArrayList<>();

    public static <S extends Enum<S>, E extends Enum<E>, C>
    StateMachineBuilder<S, E, C> create(Class<S> stateType, Class<E> eventType) {
        return new StateMachineBuilder<>();
    }

    public StateMachineBuilder<S, E, C> initialState(S initialState) {
        this.initialState = initialState;
        return this;
    }

    public TransitionBuilder<S, E, C> withTransition() {
        return new TransitionBuilder<>(this);
    }

    public StateMachineBuilder<S, E, C> withListener(StateMachineListener<S, E, C> listener) {
        this.listeners.add(listener);
        return this;
    }

    public StateMachine<S, E, C> build() {
        DefaultStateMachine<S, E, C> machine = new DefaultStateMachine<>(initialState);
        transitions.forEach(machine::addTransition);
        listeners.forEach(machine::registerListener);
        return machine;
    }
}
