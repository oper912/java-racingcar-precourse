package racingcar.strategy;

import java.util.Random;

public class RandomMoveableStrategy implements MoveableStrategy {
    private static final int RANDOM_MAX_BOUND = 10;
    private static final int MOVE_CRITERION_NUMBER = 4;
    private static final Random random = new Random();

    @Override
    public boolean moveable() {
        return random.nextInt(RANDOM_MAX_BOUND) >= MOVE_CRITERION_NUMBER;
    }
}
