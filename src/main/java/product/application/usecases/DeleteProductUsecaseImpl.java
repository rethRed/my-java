package product.application.usecases;

import java.util.Optional;

import _shared.domain.DomainError;
import _shared.events.IEventHandler;
import product.domain.entities.ProductEntity;
import product.domain.entities.errors.ProductErrors;
import product.domain.repositories.IProductRepository;
import product.domain.usecases.IDeleteProductUsecase;

public class DeleteProductUsecaseImpl implements IDeleteProductUsecase {
    private final IProductRepository productRepository;
    private final IEventHandler eventHandler;

    public DeleteProductUsecaseImpl(
        IProductRepository productRepository,
        IEventHandler eventHandler
    ){
        this.productRepository = productRepository;
        this.eventHandler = eventHandler;
    }

    @Override
    public void execute(String productId) throws DomainError {

        Optional<ProductEntity> productEntity = productRepository.findById(productId);
        if(productEntity.isEmpty()) throw new ProductErrors.ProductNotFoundError();

        this.productRepository.delete(productEntity.get());
        this.eventHandler.publish(productEntity.get());
    }
}
