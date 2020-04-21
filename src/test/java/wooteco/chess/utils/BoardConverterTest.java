package wooteco.chess.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wooteco.chess.Board;
import wooteco.chess.strategy.NormalInitStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardConverterTest {
    @Test
    @DisplayName("보드를 스트링으로 바꾸는 기능 테스트")
    void convertBoardToString() {
        NormalInitStrategy strategy = new NormalInitStrategy();
        Board board = new Board(strategy.init());
        String result = "rnbqkbnrpppppppp................................PPPPPPPPRNBQKBNR";
        assertThat(BoardConverter.convertToString(board)).isEqualTo(result);
    }
}