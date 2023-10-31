import _shared.domain.DomainError;
import product.domain.dtos.ProductDto;
import product.domain.usecases.ICreateProductUsecase;
import product.domain.usecases.IUpdateProductUsecase;
import product.factories.usecases.CreateProductUsecaseFactory;
import product.factories.usecases.UpdateProductUsecaseFactory;

public class Main {
    
    public static void main(String[] args) {
        try {
            ProductDto productDto = new ProductDto.Builder()
                .name("any_name")
                .description("any_description")
                .price(100.00)
                .build();
            ICreateProductUsecase createProductUsecase = CreateProductUsecaseFactory.create();
            ICreateProductUsecase.OutputDto output = createProductUsecase.execute(productDto);

            ProductDto updateProductDto = new ProductDto.Builder()
                .name("new_name")
                .id(output.id)
                .build();
            IUpdateProductUsecase updateProductUsecase = UpdateProductUsecaseFactory.create();
            updateProductUsecase.execute(updateProductDto);

        }catch(DomainError e) {
            System.out.println(e.getErrorName());
        }
    }
}
