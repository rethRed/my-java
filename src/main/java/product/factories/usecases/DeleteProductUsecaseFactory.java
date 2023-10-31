package product.factories.usecases;

import product.application.usecases.DeleteProductUsecaseImpl;
import product.domain.usecases.IDeleteProductUsecase;
import product.infra.events.InMemoryEventHandler;
import product.infra.repositories.hibernate.HibernateProductRepository;

public class DeleteProductUsecaseFactory {
    static public IDeleteProductUsecase create() {
        InMemoryEventHandler eventHandler = new InMemoryEventHandler();
        HibernateProductRepository productRepository = new HibernateProductRepository();
        return new DeleteProductUsecaseImpl(
            productRepository,
            eventHandler
        );
    }
}
