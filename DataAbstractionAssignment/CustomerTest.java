import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer steve;
    Customer stewie;
    Customer peter;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private static String defaultDate = "Deposit of: $10.0 Date: Wed Dec 31 16:00:00 PST 1969 into account: Checking\r\n";
    private static String defaultWithdraw = "Withdrawal of: $50.0 Date: Wed Dec 31 16:00:00 PST 1969 from account: Checking\r\n";



    @BeforeEach
    void setUp() {
        steve = new Customer("Steve", 69330, 0, 0);
        stewie = new Customer("Stewie", 45220, 10, 20);
        peter = new Customer("Peter", 65700, -20, -70);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }




    @Test
    public void testCustomerNoDeposit() {
        steve.displayDeposits();
        assertEquals("", outContent.toString());
        steve.deposit(0, new Date(), Customer.CHECKING);
        steve.displayDeposits();
        assertEquals("", outContent.toString());

    }
    @Test
    public void testCustomerDeposit() {
        steve.displayDeposits();
        assertEquals("", outContent.toString());
        steve.deposit(10, new Date(0), Customer.CHECKING);
        steve.displayDeposits();
        assertEquals(defaultDate, outContent.toString());
    }
    @Test
    public void testCustomerWithdraw() {
        stewie.displayWithdraws();
        assertEquals("", outContent.toString());
        stewie.withdraw(50,new Date(0), Customer.CHECKING); //creates a withdrawal with a default date
        stewie.displayWithdraws();
        assertEquals(defaultWithdraw, outContent.toString());//compares withdrawal with default date to what the output SHOULD look like
    }





    @AfterEach
    void tearDown() {
    }
}