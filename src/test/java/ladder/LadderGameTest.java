package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ladder.LadderGame.LADDER_HEIGHT_MUST_MORE_THEN_ONE;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderGameTest {

    @Test
    void of() {
        // given
        final String usersExpression = "pobi,honux,crong,jk";
        final int ladderHeight = 5;

        // when 
        final LadderGame result = LadderGame.of(usersExpression, ladderHeight);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void of_throw_exception_when_height_not_more_then_one() {
        // given
        final String usersExpression = "pobi,honux,crong,jk";
        final int ladderHeight = 0;

        // when 
        final Throwable thrown = catchThrowable(() -> {
            LadderGame.of(usersExpression, ladderHeight);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LADDER_HEIGHT_MUST_MORE_THEN_ONE);
    }
}
