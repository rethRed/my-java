package product.factories.usecases;

import product.domain.usecases.ICreateProductUsecase;
import product.infra.events.InMemoryEventHandler;
import product.infra.repositories.hibernate.HibernateProductRepository;
import product.application.usecases.CreateProductUsecaseImpl;

public class CreateProductUsecaseFactory {
    
    static public ICreateProductUsecase create() {
        InMemoryEventHandler eventHandler = new InMemoryEventHandler();
        HibernateProductRepository productRepository = new HibernateProductRepository();
        return new CreateProductUsecaseImpl(
            productRepository,
            eventHandler
        );
    }
}
