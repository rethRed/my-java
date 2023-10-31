package product.domain.usecases;

import _shared.domain.DomainError;
import product.domain.dtos.ProductDto;

public interface ICreateProductUsecase {
    
    class OutputDto {
        public String id;

        public OutputDto(String id) {
            this.id = id;
        }
    }

    public OutputDto execute(ProductDto productDto) throws DomainError;
}

