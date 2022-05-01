package io.codewithwinnie.orderservice;

import io.codewithwinnie.orderservice.repository.OrderHeaderRepository;
import io.codewithwinnie.orderservice.repository.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
class SdjpaOrderServiceApplicationTests {

    
    @Test
    void contextLoads() {
    }
    

}
