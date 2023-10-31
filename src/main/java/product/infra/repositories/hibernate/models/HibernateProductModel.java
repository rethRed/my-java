package product.infra.repositories.hibernate.models;

import javax.persistence.*;

import product.domain.dtos.ProductDto;
import product.domain.entities.ProductEntity;

@Entity
public class HibernateProductModel {
    @Id
    private String id;

    private String name;

    private String description;

    private Double price;

    public HibernateProductModel() {}

    public HibernateProductModel(ProductDto productDto) {
        this.id = productDto.getId();
        this.name = productDto.name;
        this.description = productDto.description;
        this.price = productDto.price;
    }

    public ProductDto toDto() {
        return new ProductDto.Builder()
            .id(this.id)
            .name(this.name)
            .description(this.description)
            .price(this.price)
            .build();
    }

    public ProductEntity toDomainEntity() {
        return new ProductEntity(this.toDto(), id);
    }

}
