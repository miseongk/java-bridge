package bridge;

import bridge.domain.Bridge;
import bridge.domain.Result;
import bridge.domain.User;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String CORRECT = "O";
    private static final String INCORRECT = "X";

    private final Bridge bridge;
    private final User user;
    private final Result result;

    public BridgeGame(Bridge bridge, User user) {
        this.bridge = bridge;
        this.user = user;
        result = new Result();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveTo) {
        if (bridge.checkToMove(user.getPosition(), moveTo)) {
            user.move();
            result.update(CORRECT, moveTo);
            return true;
        }

        result.update(INCORRECT, moveTo);

        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.returnStart();
        result.updateNumberOfTrial();
    }
}
