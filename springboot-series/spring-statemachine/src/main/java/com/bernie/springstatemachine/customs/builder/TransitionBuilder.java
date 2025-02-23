package com.bernie.springstatemachine.customs.builder;

import java.util.function.Consumer;
import java.util.function.Predicate;

import com.bernie.springstatemachine.customs.TransitionImpl;


/**
 * @Author: zhengyanxiong
 * @Date: Date: 2025/2/23 22:41
 */
public class TransitionBuilder <S extends Enum<S>, E extends Enum<E>, C> {
    private final StateMachineBuilder<S, E, C> parent;
    private S source;
    private E event;
    private S target;
    private Predicate<C> condition = c -> true;
    private Consumer<C> action = c -> {};

    public TransitionBuilder(StateMachineBuilder<S, E, C> parent) {
        this.parent = parent;
    }

    public TransitionBuilder<S, E, C> from(S source) {
        this.source = source;
        return this;
    }

    public TransitionBuilder<S, E, C> on(E event) {
        this.event = event;
        return this;
    }

    public TransitionBuilder<S, E, C> to(S target) {
        this.target = target;
        return this;
    }

    public TransitionBuilder<S, E, C> when(Predicate<C> condition) {
        this.condition = condition;
        return this;
    }

    public TransitionBuilder<S, E, C> perform(Consumer<C> action) {
        this.action = action;
        return this;
    }

    public StateMachineBuilder<S, E, C> add() {
        parent.transitions.add(new TransitionImpl<>(source, event, target) {
            @Override
            public boolean validate(C context) {
                return condition.test(context);
            }

            @Override
            public void execute(C context) {
                action.accept(context);
            }
        });
        return parent;
    }
}
