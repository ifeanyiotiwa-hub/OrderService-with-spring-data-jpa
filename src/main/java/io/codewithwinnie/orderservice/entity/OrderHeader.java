package io.codewithwinnie.orderservice.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderHeader extends BaseEntity {
    private String customerName;
    
    
    public OrderHeader(String customerName) {
        this.customerName = customerName;
    }
    
    public OrderHeader() {
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        
        OrderHeader that = (OrderHeader) o;
    
        return getCustomerName() != null ? getCustomerName().equals(that.getCustomerName()) :
                       that.getCustomerName() == null;
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCustomerName() != null ? getCustomerName().hashCode() : 0);
        return result;
    }
}
