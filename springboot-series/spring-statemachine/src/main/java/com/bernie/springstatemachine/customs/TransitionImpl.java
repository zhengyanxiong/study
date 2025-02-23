package com.bernie.springstatemachine.customs;

import java.util.Objects;

/**
 * @Author: zhengyanxiong
 * @Date: Date: 2025/2/23 22:53
 */
public class TransitionImpl<S extends Enum<S>, E extends Enum<E>, C> implements Transition<S, E, C> {
    private final S source;
    private final E event;
    private final S target;

    protected TransitionImpl(S source, E event, S target) {
        this.source = Objects.requireNonNull(source);
        this.event = Objects.requireNonNull(event);
        this.target = Objects.requireNonNull(target);
    }

    @Override
    public S getSource() {
        return source;
    }

    @Override
    public E getEvent() {
        return event;
    }

    @Override
    public S getTarget() {
        return target;
    }
}
