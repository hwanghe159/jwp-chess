package wooteco.chess.database.dao;

import wooteco.chess.database.DBConnector;
import wooteco.chess.domain.board.Position;
import wooteco.chess.domain.piece.Piece;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PiecesDao {

    private final Connection conn;

    public PiecesDao() {
        this.conn = DBConnector.getConnection();
    }

    public Map<Position, Piece> load() throws SQLException {
        String query = "SELECT * FROM pieces";
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        Map<Position, Piece> pieces = new HashMap<>();
        Position position;
        Piece piece;
        do {
            position = Position.of(rs.getString("position"));
            char symbol = rs.getString("piece").charAt(0);
            boolean hasMoved = rs.getBoolean("hasMoved");
            piece = Piece.of(symbol, hasMoved);
            pieces.put(position, piece);
        } while (rs.next());

        return pieces;
    }

    public void save(Map<Position, Piece> pieces) throws SQLException {
        delete();
        for (Position position : pieces.keySet()) {
            savePiece(position, pieces.get(position));
        }
    }

    private void savePiece(Position position, Piece piece) throws SQLException {
        String query = "INSERT INTO pieces VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, position.getKey());
        pstmt.setString(2, Character.toString(piece.getSymbol()));
        pstmt.setBoolean(3, piece.getHasMoved());
        pstmt.executeUpdate();
    }

    public void delete() throws SQLException {
        String query = "DELETE FROM pieces";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.executeUpdate();
    }
}