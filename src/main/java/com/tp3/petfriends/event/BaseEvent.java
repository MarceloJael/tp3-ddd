package com.tp3.petfriends.event;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.time.LocalDateTime;

public abstract class BaseEvent {

    @TargetAggregateIdentifier
    private final String id;
    private final LocalDateTime occurredOn;

    public BaseEvent(String id) {
        this.id = id;
        this.occurredOn = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getOccurredOn() {
        return occurredOn;
    }
}