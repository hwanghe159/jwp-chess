package wooteco.chess.strategy;

import wooteco.chess.piece.Piece;
import wooteco.chess.piece.PieceType;
import wooteco.chess.piece.Team;
import wooteco.chess.position.File;
import wooteco.chess.position.Position;
import wooteco.chess.position.Rank;

import java.util.HashMap;
import java.util.Map;

import static wooteco.chess.piece.PieceType.*;
import static wooteco.chess.piece.Team.BLACK;
import static wooteco.chess.piece.Team.WHITE;
import static wooteco.chess.position.Rank.*;

public class NormalInitStrategy implements PiecesInitStrategy {
    @Override
    public Map<Position, Piece> init() {
        Map<Position, Piece> pieces = new HashMap<>();

        pieces.put(Position.of("a8"), new Piece(BLACK, ROOK));
        pieces.put(Position.of("b8"), new Piece(BLACK, KNIGHT));
        pieces.put(Position.of("c8"), new Piece(BLACK, BISHOP));
        pieces.put(Position.of("d8"), new Piece(BLACK, QUEEN));
        pieces.put(Position.of("e8"), new Piece(BLACK, KING));
        pieces.put(Position.of("f8"), new Piece(BLACK, BISHOP));
        pieces.put(Position.of("g8"), new Piece(BLACK, KNIGHT));
        pieces.put(Position.of("h8"), new Piece(BLACK, ROOK));

        pieces.put(Position.of("a1"), new Piece(WHITE, ROOK));
        pieces.put(Position.of("b1"), new Piece(WHITE, KNIGHT));
        pieces.put(Position.of("c1"), new Piece(WHITE, BISHOP));
        pieces.put(Position.of("d1"), new Piece(WHITE, QUEEN));
        pieces.put(Position.of("e1"), new Piece(WHITE, KING));
        pieces.put(Position.of("f1"), new Piece(WHITE, BISHOP));
        pieces.put(Position.of("g1"), new Piece(WHITE, KNIGHT));
        pieces.put(Position.of("h1"), new Piece(WHITE, ROOK));

        for (File file : File.valuesExceptNone()) {
            pieces.put(Position.of(file, SEVEN), new Piece(BLACK, PAWN));
            pieces.put(Position.of(file, TWO), new Piece(WHITE, PAWN));
            Rank.valuesRangeClosed(THREE, SIX)
                    .forEach(rank -> pieces.put(Position.of(file, rank), new Piece(Team.NONE, PieceType.NONE)));
        }
        return pieces;
    }
}
