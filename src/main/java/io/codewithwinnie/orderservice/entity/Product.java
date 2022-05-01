package io.codewithwinnie.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.StringJoiner;

@Entity
public class Product extends BaseEntity {
    private String description;
    
    @Enumerated(value = EnumType.STRING)
    private ProductStatus productStatus;
    
    public String getDescription() {
        return description;
    }
    
    public ProductStatus getProductStatus() {
        return productStatus;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        
        Product product = (Product) o;
        
        if (getDescription() != null ? !getDescription().equals(product.getDescription()) :
                    product.getDescription() != null)
            return false;
        return getProductStatus() == product.getProductStatus();
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getProductStatus() != null ? getProductStatus().hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("description='" + description + "'")
                .add("productStatus=" + productStatus)
                .toString();
    }
}
