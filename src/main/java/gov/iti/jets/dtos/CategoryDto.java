package gov.iti.jets.dtos;


import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class CategoryDto implements Serializable {
    private int categoryId;
    private String categoryName;
    private Set<OrderDetailsDto> orderDetailsDto;

    public Set<OrderDetailsDto> getOrderDetailsDto() {
        return orderDetailsDto;
    }

    public void setOrderDetailsDto(Set<OrderDetailsDto> orderDetailsDto) {
        this.orderDetailsDto = orderDetailsDto;
    }

    public CategoryDto(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
    public CategoryDto( String categoryName) {
        this.categoryName = categoryName;
    }
    public CategoryDto(){

    }

    @Override
    public String toString() {
        return "CategoryBean{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto that = (CategoryDto) o;
        return categoryId == that.categoryId && Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName);
    }
}






