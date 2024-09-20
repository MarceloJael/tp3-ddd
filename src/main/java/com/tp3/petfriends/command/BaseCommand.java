package com.tp3.petfriends.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<T> {

    @TargetAggregateIdentifier
    private final T id;

    protected BaseCommand(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}