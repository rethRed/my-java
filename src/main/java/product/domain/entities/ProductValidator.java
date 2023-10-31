package product.domain.entities;

import _shared.domain.DomainError;
import product.domain.entities.errors.ProductErrors;

public class ProductValidator {
    
    private ProductEntity productEntity;

    public ProductValidator(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    // name
    public void validateName() throws DomainError {
        this.validateNameOperation(this.productEntity.getName());
    }
    public void validateName(String name) throws DomainError {
        this.validateNameOperation(name);
    }
    private void validateNameOperation(String name) throws DomainError {
        if(name == null || name.isEmpty()) throw new ProductErrors.ProductNameNotProvidedError();
        if(name.length() < 3) throw new ProductErrors.ProductNameLengthNotValidError();
        if(name.length() > 100) throw new ProductErrors.ProductNameLengthNotValidError();
    }

    // description
    public void validateDescription() throws DomainError {
        this.validateDescriptionOperation(this.productEntity.getDescription());
    }
    public void validateDescription(String description) throws DomainError {
        this.validateDescriptionOperation(description);
    }
    private void validateDescriptionOperation(String description) throws DomainError {
        if(description == null || this.productEntity.getDescription().isEmpty()) throw new ProductErrors.ProductDescriptionNotProvidedError();
    }

    // price
    public void validatePrice() throws DomainError {
        this.validatePriceOperation(this.productEntity.getPrice());
    }
    public void validatePrice(Double price) throws DomainError {
        this.validatePriceOperation(price);
    }
    private void validatePriceOperation(Double price) throws DomainError {
        if(price == null) throw new ProductErrors.ProductPriceNotProvidedError();
    }

    public void validateAll() throws DomainError {
        this.validateName();
        this.validateDescription();
        this.validatePrice();
    }
    
}
