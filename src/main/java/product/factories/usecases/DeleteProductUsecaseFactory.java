package product.factories.usecases;

import product.application.usecases.DeleteProductUsecaseImpl;
import product.domain.usecases.IDeleteProductUsecase;
import product.infra.events.InMemoryEventHandler;
import product.infra.repositories.InMemoryProductRepository;

public class DeleteProductUsecaseFactory {
    static public IDeleteProductUsecase create() {
        InMemoryEventHandler eventHandler = new InMemoryEventHandler();
        InMemoryProductRepository productRepository = InMemoryProductRepository.getInstance();
        return new DeleteProductUsecaseImpl(
            productRepository,
            eventHandler
        );
    }
}
