package io.codewithwinnie.orderservice.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    private String customerName;
    
    
    public OrderHeader(String customerName) {
        this.customerName = customerName;
    }
    
    public OrderHeader() {
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderHeader that = (OrderHeader) o;
        return Objects.equals(id, that.id) && Objects.equals(customerName, that.customerName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, customerName);
    }
}
