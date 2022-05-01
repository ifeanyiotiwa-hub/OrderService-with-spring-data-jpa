package io.codewithwinnie.orderservice.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@AttributeOverrides({
    @AttributeOverride(name = "shippingAddress.address", column = @Column(name = "shipping_address")),
    @AttributeOverride(name = "shippingAddress.city", column = @Column(name = "shipping_city")),
    @AttributeOverride(name = "shippingAddress.state", column = @Column(name = "shipping_state")),
    @AttributeOverride(name = "shippingAddress.zipCode", column = @Column(name = "shipping_zip_code")),
    @AttributeOverride(name = "billToAddress.address", column = @Column(name = "bill_to_address")),
    @AttributeOverride(name = "billToAddress.city", column = @Column(name = "bill_to_city")),
    @AttributeOverride(name = "billToAddress.state", column = @Column(name = "bill_to_state")),
    @AttributeOverride(name = "billToAddress.zipCode", column = @Column(name = "bill_to_zip_code"))
})
public class OrderHeader extends BaseEntity {
    private String customerName;
    @Embedded
    private Address shippingAddress;
    @Embedded
    private Address billToAddress;
    
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    
    public Address getBillToAddress() {
        return billToAddress;
    }
    
    public void setBillToAddress(Address billToAddress) {
        this.billToAddress = billToAddress;
    }
    
    
    public OrderHeader(String customerName) {
        this.customerName = customerName;
    }
    
    public OrderHeader() {
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public Address getShippingAddress() {
        return shippingAddress;
    }
    
    public Address getBillingAddress() {
        return billToAddress;
    }
    
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
    public void setBillingAddress(Address billToAddress) {
        this.billToAddress = billToAddress;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        
        OrderHeader that = (OrderHeader) o;
        
        if (getCustomerName() != null ? !getCustomerName().equals(that.getCustomerName()) :
                    that.getCustomerName() != null)
            return false;
        if (getShippingAddress() != null ? !getShippingAddress().equals(that.getShippingAddress()) :
                    that.getShippingAddress() != null)
            return false;
        if (getBillToAddress() != null ? !getBillToAddress().equals(that.getBillToAddress()) :
                    that.getBillToAddress() != null)
            return false;
        return getOrderStatus() == that.getOrderStatus();
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCustomerName() != null ? getCustomerName().hashCode() : 0);
        result = 31 * result + (getShippingAddress() != null ? getShippingAddress().hashCode() : 0);
        result = 31 * result + (getBillToAddress() != null ? getBillToAddress().hashCode() : 0);
        result = 31 * result + (getOrderStatus() != null ? getOrderStatus().hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return new StringJoiner("", "\"" + OrderHeader.class.getSimpleName() + "\": {\n", "}")
                .add("\t\"id\": \"" + getId() + "\",\n")
                .add("\t\"customerName\": \"" + customerName + "\",\n")
                .add("\t\"shippingAddress\": \"" + shippingAddress + "\",\n")
                .add("\t\"billToAddress\": \"" + billToAddress + "\",\n")
                .add("\t\"createdDate\": \"" + this.getCreatedDate() + "\",\n")
                .add("\t\"lastUpdatedDate\": \"" + this.getLastUpdatedDate() + "\",\n")
                .add("\t\"orderStatus\": \"" + orderStatus + "\"\n")
                .toString();
    }
}
