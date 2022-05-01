package io.codewithwinnie.orderservice;

import io.codewithwinnie.orderservice.entity.OrderHeader;
import io.codewithwinnie.orderservice.repository.OrderHeaderRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"io.codewithwinnie.orderservice"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SdjpaOrderServiceApplicationTests {
    
    @Autowired
    OrderHeaderRepository orderHeaderRepository;
    
    @Test
    void contextLoads() {
    }
    
    @Test
    void testPersistDataToDataBase() {
        OrderHeader oh = new OrderHeader("Test_Customer");
        
        OrderHeader saved = orderHeaderRepository.save(oh);
        OrderHeader fetched = orderHeaderRepository.getById(saved.getId());
        assertThat(saved).isNotNull();
        assertThat(fetched).isNotNull();
        
    }
}
