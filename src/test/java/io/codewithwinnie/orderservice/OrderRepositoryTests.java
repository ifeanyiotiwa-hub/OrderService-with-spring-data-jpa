package io.codewithwinnie.orderservice;

import io.codewithwinnie.orderservice.entity.OrderHeader;
import io.codewithwinnie.orderservice.entity.OrderLine;
import io.codewithwinnie.orderservice.entity.Product;
import io.codewithwinnie.orderservice.entity.ProductStatus;
import io.codewithwinnie.orderservice.repository.OrderHeaderRepository;
import io.codewithwinnie.orderservice.repository.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"io.codewithwinnie.orderservice"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderRepositoryTests {
    
    @Autowired
    OrderHeaderRepository orderHeaderRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    
    @Test
    void testSaveOrderWithOrderLines() {
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomerName("Test-Customer");
        OrderHeader saved = orderHeaderRepository.save(orderHeader);
    
        OrderLine orderLine = new OrderLine();
        orderLine.setQuantityOrdered(5);
        orderLine.setOrderHeader(orderHeader);
        orderHeader.setOrderLines(Set.of(orderLine));
        assertThat(saved.getOrderLines().size()).isEqualTo(1);
    }
    
    @Test
    void testPersistDataToDataBase() {
        OrderHeader oh = new OrderHeader("Test_Customer");
    
        OrderHeader saved = orderHeaderRepository.save(oh);
        OrderHeader fetched = orderHeaderRepository.getById(saved.getId());
        
        System.err.println(fetched);
        assertThat(saved).isNotNull();
        assertThat(fetched).isNotNull();
        var updated = orderHeaderRepository.save(fetched);
        System.err.println("Updated is \n" + updated + "\nFetched is\n" + fetched);
        assertNotNull(updated.getLastUpdatedDate());
        
    }
    
    @Test
    void testProductPersisted() {
        Product product = new Product();
        product.setDescription("Product Description");
        product.setProductStatus(ProductStatus.DISCONTINUED);
        
        Product saved = productRepository.save(product);
        assertThat(saved).isNotNull();
        saved.setProductStatus(ProductStatus.IN_STOCK);
        Product fetched = productRepository.save(saved);
        assertThat(fetched.getProductStatus()).isEqualTo(ProductStatus.IN_STOCK);
    }
}
