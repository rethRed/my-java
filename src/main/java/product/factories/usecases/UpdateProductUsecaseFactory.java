package product.factories.usecases;

import product.domain.usecases.IUpdateProductUsecase;
import product.infra.events.InMemoryEventHandler;
import product.infra.repositories.InMemoryProductRepository;
import product.application.usecases.UpdateProductUsecaseImpl;

public interface UpdateProductUsecaseFactory {

    static public IUpdateProductUsecase create() {
        InMemoryEventHandler eventHandler = new InMemoryEventHandler();
        InMemoryProductRepository productRepository = InMemoryProductRepository.getInstance();
        return new UpdateProductUsecaseImpl(
            productRepository,
            eventHandler
        );
    }
}
