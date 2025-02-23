package com.bernie.springstatemachine.customs;

import java.util.Map;

import com.bernie.springstatemachine.customs.builder.StateMachineBuilder;
import com.bernie.springstatemachine.spring.enums.Events;
import com.bernie.springstatemachine.spring.enums.States;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhengyanxiong
 * @Date: Date: 2025/2/23 23:00
 */
class StateMachineTest {

    @Test
    public void testStateMachine() {
        StateMachine<States, Events, Object> build = StateMachineBuilder.create(States.class, Events.class)
                .initialState(States.SI)
                .withTransition()
                .from(States.SI).on(Events.E1).to(States.S1)
                .add()
                .withTransition()
                .from(States.S1).on(Events.E2).to(States.S2)
                .add()
                .withListener(new PrintLogListener<>())
                .build();
        States fire = build.fire(Events.E1, Map.of("S1", States.S1, "S2", States.S2));
        System.out.println(fire);
    }
}