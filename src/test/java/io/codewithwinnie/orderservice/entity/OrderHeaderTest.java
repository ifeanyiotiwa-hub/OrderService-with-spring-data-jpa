package io.codewithwinnie.orderservice.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderHeaderTest {
    
    @Test
    void testEqualsOrderHeaderWithSameId_ShouldPass() {
        OrderHeader oH1 = new OrderHeader();
        oH1.setId(44L);
    
        OrderHeader oH2 = new OrderHeader();
        oH2.setId(44L);
        
        assertThat(oH1).isEqualTo(oH2);
    }
    
    @Test
    void testEqualsOrderHeaderWithDifferentId_ShouldPass() {
        OrderHeader oH1 = new OrderHeader();
        oH1.setId(44L);
        
        OrderHeader oH2 = new OrderHeader();
        oH2.setId(444L);
        
        assertThat(oH1).isNotEqualTo(oH2);
    }
}