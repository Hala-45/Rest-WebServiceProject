package gov.iti.jets.dtos;

public class CartDto {

    private ProductDto product;
    private int quantity;

    public CartDto(ProductDto productDto, int requiredQuantity) {
        this.product = productDto;
        this.quantity = requiredQuantity;
    }

    public CartDto() {
    }

    @Override
    public String toString() {
        return "CartItemBean{" +
                "productBean=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
