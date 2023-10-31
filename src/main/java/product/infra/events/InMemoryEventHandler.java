package product.infra.events;

import _shared.domain.AggregateRoot;
import _shared.events.IEventHandler;

public class InMemoryEventHandler implements IEventHandler {

    @Override
    public void publish(AggregateRoot aggregateRoot) {
        System.out.println("Event published: ");
    }
    
}
