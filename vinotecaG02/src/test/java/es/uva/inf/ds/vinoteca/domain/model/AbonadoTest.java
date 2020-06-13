
package es.uva.inf.ds.vinoteca.domain.model;

import es.uva.inf.ds.vinoteca.domain.models.Abonado;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pamarti
 * @author alerome
 * @author ivagonz
 */
public class AbonadoTest {
    
    private Abonado ab;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        ab = new Abonado(1,"referencia0","123456789");
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void constructorCorrecto(){
        assertSame(1,ab.getNumeroAbonado());
        assertEquals("referencia0",ab.getOpenIdRef());
        assertEquals("123456789",ab.getNIF());
    }
    
    @Test
    public void constructorErroneo(){
        assertThrows(IllegalArgumentException.class, ()->{
            Abonado ab1 = new Abonado(2,"referencia1","1234567890");
        });
    }
    
    @Test
    public void setterNumeroAbonado(){
        ab.setNumeroAbonado(10);
        assertSame(10,ab.getNumeroAbonado());
    }
    
    @Test
    public void setterOpenIdRef(){
        ab.setOpenIdRef("dummy");
        assertEquals("dummy",ab.getOpenIdRef());
    }
    
    @Test
    public void setterNIF(){
        ab.setNIF("111111111");
        assertEquals("111111111",ab.getNIF());
    }
    
    @Test
    public void setterNIFErroneo(){
        assertThrows(IllegalArgumentException.class, ()->{
            ab.setNIF("1234567890");
        });
    }
}