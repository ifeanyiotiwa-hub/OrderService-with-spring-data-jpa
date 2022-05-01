package io.codewithwinnie.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created on 5/2/2022
 * @author Ifeanyichukwu Otiwa
 */
@Entity
public class Category extends BaseEntity {
    private String description;
    @ManyToMany
    @JoinTable(name = "product_category"
            , joinColumns = @JoinColumn(name = "category_id")
            , inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;
    
    public Set<Product> getProducts() {
        return products;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        
        Category category = (Category) o;
    
        return getDescription() != null ? getDescription().equals(category.getDescription()) :
                       category.getDescription() == null;
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }
}
