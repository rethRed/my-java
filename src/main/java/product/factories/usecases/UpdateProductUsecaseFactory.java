package product.factories.usecases;

import product.domain.usecases.IUpdateProductUsecase;
import product.infra.events.InMemoryEventHandler;
import product.infra.repositories.hibernate.HibernateProductRepository;
import product.application.usecases.UpdateProductUsecaseImpl;

public interface UpdateProductUsecaseFactory {

    static public IUpdateProductUsecase create() {
        InMemoryEventHandler eventHandler = new InMemoryEventHandler();
        HibernateProductRepository productRepository = new HibernateProductRepository();
        return new UpdateProductUsecaseImpl(
            productRepository,
            eventHandler
        );
    }
}
