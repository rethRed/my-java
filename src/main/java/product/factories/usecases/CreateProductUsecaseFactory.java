package product.factories.usecases;

import product.domain.usecases.ICreateProductUsecase;
import product.infra.events.InMemoryEventHandler;
import product.infra.repositories.InMemoryProductRepository;
import product.application.usecases.CreateProductUsecaseImpl;

public class CreateProductUsecaseFactory {
    
    static public ICreateProductUsecase create() {
        InMemoryEventHandler eventHandler = new InMemoryEventHandler();
        InMemoryProductRepository productRepository = InMemoryProductRepository.getInstance();
        return new CreateProductUsecaseImpl(
            productRepository,
            eventHandler
        );
    }
}
