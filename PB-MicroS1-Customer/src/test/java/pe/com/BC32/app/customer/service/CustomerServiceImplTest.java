package pe.com.BC32.app.customer.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pe.com.BC32.app.customer.mapper.CustomerMapper;
import pe.com.BC32.app.customer.service.implement.CustomerServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerMapper mapper;


    @Test
    @Tag("TestExanple")
    @DisplayName("The test that always is OK")
    void alwaysOk() {
        assertTrue(true);
        assertTrue(true, "It will never shown and build");
    }
    @Test
    @DisplayName("The test that always is Error")
    void alwaysError() {
        assertTrue(false);
    }

    /*public void testFindAccountsByCustomerId_simple() {
        when(mapper.entityToDto()).thenReturn(new int[] {});
                assertEquals(1.0, 1, 0.1);


    }*/

    //@BeforeAll
    //@BeforeEach
    //@AfterEach
    //@AfterAll



}
