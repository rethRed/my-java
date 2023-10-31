package product.domain.usecases;

import _shared.domain.DomainError;

public interface IDeleteProductUsecase {
    public void execute(String productId) throws DomainError;
}
