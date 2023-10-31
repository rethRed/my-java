package product.domain.repositories;

import java.util.Optional;

import _shared.domain.DomainError;
import product.domain.entities.ProductEntity;

public interface IProductRepository {
    void create(ProductEntity productEntity) throws DomainError;
    void update(ProductEntity productEntity) throws DomainError;
    void delete(ProductEntity productEntity) throws DomainError;
    Optional<ProductEntity> findById(String id); 
}
