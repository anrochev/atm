import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.example.card.Card;
import ru.example.Main;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
public class CardTest {
    private static Validator validator;
    ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
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
//        Card card = new Card("3476380078654534", LocalDate.of(2022, Month.JANUARY, 1), null, 10000, false);
        Card card =  context.getBean("card", Card.class);

        Set<ConstraintViolation<Card>> constraintViolations =
                validator.validate( card );

        Assertions.assertEquals( "must not be not null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void getPin() {
        //    Card card = new Card("3476380078654534", LocalDate.of(2022, Month.JANUARY, 1), "Иванов Иван Иванович", 3333, false);
        //      Card card = new Card("3476380078654534", LocalDate.of(2022, Month.JANUARY, 1), "Иванов Иван Иванович", 10000, false);
        Card card =  context.getBean("card", Card.class);
        Set<ConstraintViolation<Card>> constraintViolations =
                validator.validate( card );

        Assertions.assertEquals( 1, constraintViolations.size() );

        Assertions.assertEquals(
                "size must be between 0 and 9999",
                constraintViolations.iterator().next().getMessage()
        );
    }
}
