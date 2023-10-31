package product.domain.usecases;

import _shared.domain.DomainError;
import product.domain.dtos.ProductDto;

public interface IUpdateProductUsecase {
    
    public void execute(ProductDto productDto) throws DomainError;
}
