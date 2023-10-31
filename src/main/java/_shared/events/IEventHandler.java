package _shared.events;

import _shared.domain.AggregateRoot;

public interface IEventHandler {
    public void publish(AggregateRoot aggregateRoot);
}
