import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.example.card.Card;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CardTest {
    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        //for example not for prod
        log.info("hello");
    }

    @Test
    void getOwner() {
//      Card card = new Card("3476380078654534", LocalDate.of(2022, Month.JANUARY, 1), "Иванов Иван Иванович", 10000, false);
        Card card = new Card("3476380078654534", LocalDate.of(2022, Month.JANUARY, 1), null, 10000, false);

        Set<ConstraintViolation<Card>> constraintViolations =
                validator.validate( card );

        assertEquals( "must not be not null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void getPin() {
  //    Card card = new Card("3476380078654534", LocalDate.of(2022, Month.JANUARY, 1), "Иванов Иван Иванович", 3333, false);
        Card card = new Card("3476380078654534", LocalDate.of(2022, Month.JANUARY, 1), "Иванов Иван Иванович", 10000, false);

        Set<ConstraintViolation<Card>> constraintViolations =
                validator.validate( card );

        assertEquals( 1, constraintViolations.size() );

        assertEquals(
                "size must be between 0 and 9999",
                constraintViolations.iterator().next().getMessage()
        );
    }
}
