package totaliserAnswer;

import org.junit.jupiter.api.*;
import totaliserQuestion.Totaliser;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TotaliserTest {
    private Totaliser tot;
    private Totaliser tot2;

    @BeforeEach
    public void init(){
        tot = new Totaliser();
        tot2 = new Totaliser();
    }

    @Test
    public void testResetEqualsZero() {
        tot.reset();
        assertEquals(0, tot.getSum());
    }

    @Test
    public void testResetEqualsZeroAfterAddingValue(){
        tot.enterValue(7);
        tot.reset();
        assertEquals(0, tot.getSum());
    }
    @Test
    public void testGetSumOneValue() throws Exception{
        tot.enterValue(7);
        assertEquals(7,tot.getSum());
    }

    @Test
    public void testGetSumTwoValues(){
        tot.enterValue(7);
        tot.enterValue(5);
        assertEquals(12, tot.getSum());
    }
    @Test
    public void testGetSumDoesNotEqualZero() throws Exception {
        tot.enterValue(7);
        if(tot.getSum() == 0){
            throw new Exception("Getsum not equal to value entered.");
        }
    }

    @Test
    public void testGetSumOverflow() throws Exception {
        tot.enterValue(Integer.MAX_VALUE);
        tot.enterValue(Integer.MAX_VALUE);
        if (tot.getSum() < 0){
            throw new Exception("Overflow Exception");
        }
    }

    @Test
    public void testGetSumEqualsZero(){
        assertEquals(0, tot.getSum());
    }

    @Test
    public void testEnterValueNegative(){
        tot.enterValue(-1);
        tot.enterValue(-6);
        assertEquals(-7, tot.getSum());
    }
    @Test
    public void testMultipleObjects(){
        tot.enterValue(5);
        tot2.enterValue(10);
        assertEquals(5, tot.getSum());
        //assertEquals(10, tot2.getSum());
    }
}
