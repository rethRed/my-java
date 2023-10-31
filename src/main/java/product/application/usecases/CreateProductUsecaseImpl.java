package product.application.usecases;

import _shared.domain.DomainError;
import _shared.events.IEventHandler;
import product.domain.dtos.ProductDto;
import product.domain.entities.ProductEntity;
import product.domain.repositories.IProductRepository;
import product.domain.usecases.ICreateProductUsecase;

public class CreateProductUsecaseImpl implements ICreateProductUsecase {

    private final IProductRepository productRepository;
    private final IEventHandler eventHandler;

    public CreateProductUsecaseImpl(
        IProductRepository productRepository,
        IEventHandler eventHandler
    ){
        this.productRepository = productRepository;
        this.eventHandler = eventHandler;
    }

    @Override
    public ICreateProductUsecase.OutputDto execute(ProductDto productDto) throws DomainError {

        ProductEntity productEntity = ProductEntity.create(productDto);
        this.productRepository.create(productEntity);
        this.eventHandler.publish(productEntity);

        return new ICreateProductUsecase.OutputDto (
            productEntity.getId()
        );
    }


}
