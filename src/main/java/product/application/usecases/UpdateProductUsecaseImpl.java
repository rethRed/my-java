package product.application.usecases;

import java.util.Optional;

import _shared.domain.DomainError;
import _shared.events.IEventHandler;
import product.domain.dtos.ProductDto;
import product.domain.entities.ProductEntity;
import product.domain.entities.errors.ProductErrors;
import product.domain.repositories.IProductRepository;
import product.domain.usecases.IUpdateProductUsecase;

public class UpdateProductUsecaseImpl implements IUpdateProductUsecase {
    private final IProductRepository productRepository;
    private final IEventHandler eventHandler;

    public UpdateProductUsecaseImpl(
        IProductRepository productRepository,
        IEventHandler eventHandler
    ){
        this.productRepository = productRepository;
        this.eventHandler = eventHandler;
    }

    @Override
    public void execute(ProductDto productDto) throws DomainError {

        Optional<ProductEntity> productEntity = productRepository.findById(productDto.getId());
        if(productEntity.isEmpty()) throw new ProductErrors.ProductNotFoundError();
        productEntity.get().update(productDto);

        this.productRepository.update(productEntity.get());
        this.eventHandler.publish(productEntity.get());
    }
}
