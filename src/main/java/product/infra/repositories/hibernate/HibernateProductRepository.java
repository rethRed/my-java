package product.infra.repositories.hibernate;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import _shared.domain.DomainError;
import _shared.infra.repositories.hibernate.HibernateEntityManager;
import product.domain.entities.ProductEntity;
import product.domain.repositories.IProductRepository;
import product.infra.repositories.hibernate.models.HibernateProductModel;

public class HibernateProductRepository implements IProductRepository {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public HibernateProductRepository() {
        this.entityManagerFactory = HibernateEntityManager.getInstance();
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(ProductEntity productEntity) throws DomainError {
     
        HibernateProductModel hibernateProductModel = new HibernateProductModel(productEntity.toDto());
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(hibernateProductModel);

        this.entityManager.getTransaction().commit();
    }

    @Override
    public void update(ProductEntity productEntity) throws DomainError {

        HibernateProductModel hibernateProductModel = new HibernateProductModel(productEntity.toDto());
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(hibernateProductModel);

        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(ProductEntity productEntity) throws DomainError {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(productEntity);
    }

    @Override
    public Optional<ProductEntity> findById(String id) {
        HibernateProductModel productModel = this.entityManager.find(HibernateProductModel.class, id);
        if(productModel == null) return Optional.empty();
        return Optional.of(productModel.toDomainEntity());
    }
    
}
