package com.bernie.springstatemachine.customs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * @Author: zhengyanxiong
 * @Date: Date: 2025/2/23 22:27
 */
public class DefaultStateMachine<S extends Enum<S>, E extends Enum<E>, C> implements StateMachine<S, E, C> {

    private S currentState;
    private final List<Transition<S, E, C>> transitions = new CopyOnWriteArrayList<>();
    private final List<TransitionRecord<S, E, C>> history = new ArrayList<>();
    private final List<StateMachineListener<S, E, C>> listeners = new ArrayList<>();

    public DefaultStateMachine(S currentState) {
        this.currentState = currentState;
    }

    @Override
    public synchronized S fire(E event, C context) {
        Transition<S, E, C> transition = findTransition(event);
        if (!transition.validate(context)) {
            throw new IllegalArgumentException("Invalid transition");
        }
        // 触发前监听
        listeners.forEach(l -> l.beforeTransition(
                currentState, event, context));

        // 执行转换
        S oldState = currentState;
        currentState = transition.getTarget();

        // 执行动作
        transition.execute(context);

        // 记录历史
        TransitionRecord<S, E, C> record = new TransitionRecord<>(
                oldState, currentState, event, context);
        history.add(record);

        // 触发后监听
        listeners.forEach(l -> l.afterTransition(record));

        return currentState;
    }

    private Transition<S, E, C> findTransition(E event) {
        return transitions.stream()
                .filter(t -> t.matches(currentState, event))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "No transition found for " + currentState + " + " + event));
    }

    @Override
    public void addTransition(Transition<S, E, C> transition) {
        transitions.add(transition);
    }

    @Override
    public S getCurrentState() {
        return currentState;
    }

    @Override
    public List<TransitionRecord<S, E, C>> getHistory() {
        return history;
    }

    @Override
    public void registerListener(StateMachineListener<S, E, C> listener) {
        listeners.add(listener);
    }
}
