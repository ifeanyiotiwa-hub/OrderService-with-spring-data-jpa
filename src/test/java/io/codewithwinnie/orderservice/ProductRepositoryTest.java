package io.codewithwinnie.orderservice;

import io.codewithwinnie.orderservice.entity.Product;
import io.codewithwinnie.orderservice.entity.ProductStatus;
import io.codewithwinnie.orderservice.repository.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created on 5/2/2022
 * @author Ifeanyichukwu Otiwa
 */
@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"io.codewithwinnie.orderservice"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepositoryTest {
    
    @Autowired
    private ProductRepository productRepository;
    
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
    
    @Test
    void testGetCategory() {
        Product product = productRepository.findProductByDescription("PRODUCT1");
        
        assertThat(product).isNotNull();
    }
}
