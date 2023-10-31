package product.domain.entities.errors;
import _shared.domain.*;


public class ProductErrors  {
    
    // validation 
    static public class ProductNameNotProvidedError extends DomainError {}
    static public class ProductNameLengthNotValidError extends DomainError {}

    static public class ProductDescriptionNotProvidedError extends DomainError {}

    static public class ProductPriceNotProvidedError extends DomainError {}

    // operations

    static public class NoPropertyToChangeError extends DomainError {}

    static public class NameIsTheSameError extends DomainError {}
    static public class DescriptionIsTheSameError extends DomainError {}
    static public class PriceIsTheSameError extends DomainError {}


    // applicatoin
    static public class ProductNotFoundError extends DomainError {}

}


