package product.infra.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import _shared.domain.DomainError;
import product.domain.entities.ProductEntity;
import product.domain.repositories.IProductRepository;

public class InMemoryProductRepository implements IProductRepository {

    private static InMemoryProductRepository instance;

    public static InMemoryProductRepository getInstance()  {
        if(instance == null) instance = new InMemoryProductRepository();
        return instance;
    }

    List<ProductEntity> productEntities = new ArrayList<ProductEntity>();

    @Override
    public void create(ProductEntity productEntity) throws DomainError {
        this.productEntities.add(productEntity);
    }

    @Override
    public void update(ProductEntity productEntity) throws DomainError {
        ProductEntity productEntityOnDataBase = this.findById(productEntity.getId()).get();
        if(productEntityOnDataBase == null) return;

        this.productEntities.remove(productEntityOnDataBase);
        this.productEntities.add(productEntity);
    }

    @Override
    public void delete(ProductEntity productEntity) throws DomainError {
        ProductEntity productEntityOnDataBase = this.findById(productEntity.getId()).get();
        if(productEntityOnDataBase == null) return;

        this.productEntities.remove(productEntityOnDataBase);
    }

    @Override
    public Optional<ProductEntity> findById(String id) {
        return this.productEntities.stream()
            .filter(productEntity -> productEntity.getId().equals(id))
            .findFirst();
    }
    
}
