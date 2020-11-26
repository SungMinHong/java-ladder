package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UsersGeneratorTest {
    @Test
    void generate() {
        // given
        final String usersExpression = "pobi,honux,crong,jk";

        // when
        final Users users = UsersGenerator.generate(usersExpression);

        // then
        assertThat(users).isNotNull();
    }
}
