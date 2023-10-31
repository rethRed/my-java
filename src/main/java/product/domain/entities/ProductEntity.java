package product.domain.entities;


import _shared.domain.AggregateRoot;
import _shared.domain.DomainError;
import product.domain.dtos.ProductDto;
import product.domain.entities.errors.ProductErrors;

public class ProductEntity extends AggregateRoot {
    
    public ProductValidator validator = new ProductValidator(this);

    private String name;
    private String description;
    private Double price;

    public ProductEntity(
            String name, 
            String description, 
            Double price
        ) {
   
        this.name = name;
        this.description = description;
        this.price = price;
    }

    private void mapDtoToEntity(ProductDto productDto) {
        this.name = productDto.name;
        this.description = productDto.description;
        this.price = productDto.price;
    }

    public ProductEntity(ProductDto productDto, String id) throws DomainError {
        super(id);
        this.mapDtoToEntity(productDto);
        this.validator.validateAll();
    }

    private ProductEntity(ProductDto productDto) throws DomainError {
        super();
        this.mapDtoToEntity(productDto);
        this.validator.validateAll();
    }

    public static ProductEntity create(ProductDto productDto) throws DomainError {
        return new ProductEntity(productDto);
    }


    public void update(ProductDto productDto) throws DomainError {

        if(!productDto.hasAnyProperty()) throw new ProductErrors.NoPropertyToChangeError();

        if(productDto.name != null && !productDto.name.equals(this.name)) {
            this.changeName(productDto.name);
        }

        if(productDto.description != null && !productDto.description.equals(this.description)) {
            this.changeDescription(productDto.description);
        }

        if(productDto.price != null && !productDto.price.equals(this.price)) {
            this.changePrice(productDto.price);
        }

    }

    public ProductDto toDto() {
        return new ProductDto(this);
    }

    public void changeName(String name) throws DomainError {
        if(name.equals(this.name)) throw new ProductErrors.NameIsTheSameError();
        this.name = name;
        this.validator.validateName(name);
    }

    public void changeDescription(String description) throws DomainError {
        if(description.equals(this.description)) throw new ProductErrors.DescriptionIsTheSameError();
        this.description = description;
        this.validator.validateDescription(description);
    }

    public void changePrice(Double price) throws DomainError {
        if(price.equals(this.price)) throw new ProductErrors.PriceIsTheSameError();
        this.price = price;
        this.validator.validatePrice(price);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }


}
