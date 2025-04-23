import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount();
    }

    @Test
    public void testDepositIncreasesBalance() {
        account.deposit(500.0);
        assertEquals(500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        account.deposit(1000.0);
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalStateException.class)
    public void testWithdrawFailsIfInsufficientFunds() {
        account.deposit(200.0);
        account.withdraw(500.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmountThrowsException() {
        account.deposit(-100.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmountThrowsException() {
        account.withdraw(-50.0);
    }
}