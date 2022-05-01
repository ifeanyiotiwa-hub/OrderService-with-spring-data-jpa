package io.codewithwinnie.orderservice;

import io.codewithwinnie.orderservice.entity.OrderHeader;
import io.codewithwinnie.orderservice.repository.OrderHeaderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"io.codewithwinnie.orderservice"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SdjpaOrderServiceApplicationTests {
    
    @Autowired
    OrderHeaderRepository orderHeaderRepository;
    
    OrderHeader oh, saved, fetched;
    
    @BeforeEach
    public void setUp() {
        oh = new OrderHeader("Test_Customer");
    
        saved = orderHeaderRepository.save(oh);
        fetched = orderHeaderRepository.getById(saved.getId());
        
    }
    
    @Test
    void contextLoads() {
    }
    
    @Commit
    @Test
    void testPersistDataToDataBase() {
        System.err.println(fetched);
        assertThat(saved).isNotNull();
        assertThat(fetched).isNotNull();
        var updated = orderHeaderRepository.save(fetched);
        System.err.println("Updated is \n" + updated + "\nFetched is\n" + fetched);
        assertNotNull(updated.getLastUpdatedDate());
        
    }
    
    @Test
    void testUpdateDataToDataBase() {
    
        fetched.setCustomerName("Test_Updated_Customer");
        var updated = orderHeaderRepository.save(fetched);
        System.err.println("Updated is \n" + updated + "\nFetched is\n" + fetched);
        assertNotNull(updated.getLastUpdatedDate());
        
    }
}
