package io.codewithwinnie.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created on 5/1/2022 by
 * @author Ifeanyichukwu Otiwa
 */
@Entity
public class OrderLine extends BaseEntity {
    
    private Integer quantityOrdered;
    
    @ManyToOne
    private OrderHeader orderHeader;
    
    @ManyToOne
    private Product product;
    
    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }
    
    public OrderHeader getOrderHeader() {
        return orderHeader;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }
    
    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        
        OrderLine orderLine = (OrderLine) o;
        
        if (getQuantityOrdered() != null ? !getQuantityOrdered().equals(orderLine.getQuantityOrdered()) :
                    orderLine.getQuantityOrdered() != null)
            return false;
        if (getOrderHeader() != null ? !getOrderHeader().equals(orderLine.getOrderHeader()) :
                    orderLine.getOrderHeader() != null)
            return false;
        return getProduct() != null ? getProduct().equals(orderLine.getProduct()) : orderLine.getProduct() == null;
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getQuantityOrdered() != null ? getQuantityOrdered().hashCode() : 0);
        result = 31 * result + (getProduct() != null ? getProduct().hashCode() : 0);
        return result;
    }
}
