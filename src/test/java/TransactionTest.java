import com.praveen.personalfinance.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    String input;
    Transaction transaction;

    @BeforeEach
    void setUp() {
        input = "-d 2/8/2022 -n bp -amt 2000 -note lunch -ctg ess -in";
        transaction = new Transaction(input);
    }

    @Test
    void transactionDate_fullDateTest() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date expectedDate = null;
        try {
            expectedDate = formatter.parse("2/8/2022");
        } catch (ParseException e) {
            System.out.println("exception");
            e.printStackTrace();
        }

        assertEquals(expectedDate, transaction.getTransDate());
    }

    @Test
    void transactor_aliasToNameTest() {
        String expectedTransactor = "Praveen";
        String actualTransactor = transaction.getTransactor();
        assertEquals(expectedTransactor, actualTransactor);
    }

    @Test
    void transactionAmount_Test() {
        double expectedAmount = 2000;
        double actualAmount = transaction.getTransAmount();
        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void transactionNote_test() {
        String expectedNote = "lunch";
        String actualNote = transaction.getTransNote();
        assertEquals(expectedNote, actualNote);
    }

}
