package product.domain.dtos;

import product.domain.entities.ProductEntity;

public class ProductDto {

    public String name;
    public String description;
    public Double price;
    private String id;

    public ProductDto() {}

    public ProductDto(ProductEntity productEntity) {
        this.name = productEntity.getName();
        this.description = productEntity.getDescription();
        this.price = productEntity.getPrice();
        this.id = productEntity.getId();
    }

    public String getId() {
        return this.id;
    }

    public Boolean hasAnyProperty() {
        return this.name != null || 
        this.description != null || 
        this.price != null;
    }

    public static class Builder {
        
        final private ProductDto productDto = new ProductDto();

        public Builder name(String name) {
            this.productDto.name = name;
            return this;
        }

        public Builder description(String description) {
            this.productDto.description = description;
            return this;
        }

        public Builder price(Double price) {
            this.productDto.price = price;
            return this;
        }

        public Builder id(String id) {
            this.productDto.id = id;
            return this;
        }

        public ProductDto build() {
            return this.productDto;
        }
    }
}
