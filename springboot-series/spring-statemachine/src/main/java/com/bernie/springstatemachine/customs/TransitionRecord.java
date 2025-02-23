package com.bernie.springstatemachine.customs;

import java.util.Map;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;

/**
 * @Author: zhengyanxiong
 * @Date: Date: 2025/2/23 22:22
 */
@Data
public  class  TransitionRecord <S, E, C>{
    private long timestamp;

    private S sourceState;

    private S targetState;

    private E event;

    private String  contextSnapshot;

    public TransitionRecord(S sourceState, S targetState, E event, C contextSnapshot) {
        this.timestamp = System.currentTimeMillis();
        this.sourceState = sourceState;
        this.targetState = targetState;
        this.event = event;
        this.contextSnapshot = contextSnapshot.toString();
    }
}
