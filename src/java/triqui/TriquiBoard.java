package triqui;

/**
 *
 * @author emontoya
 */
public class TriquiBoard {

    boolean turn;

    String X = "X";
    String O = "O";
    String E = "--";

    String[] board = new String[9];

    String statusI = "I";
    String statusP = "P";

    String status = statusI;

    public TriquiBoard() {
        Reset();
    }

    public void Reset() {
        for (int i = 0; i < 9; i++) {
            board[i] = E;
        }
        status = statusI;
    }

    public void setCell(int pos, String symbol) {
        if (pos < 9) {
            board[pos] = symbol;
        }
    }

    public String getCell(int pos) {
        String res = E;
        if (pos < 9) {
            res = board[pos];
            status = statusP;
        }
        return res;
    }

    public String[] getBoard() {
        return board;
    }

    public void setStatus(String msg) {
        status = msg;
    }

    public String getStatus() {
        return status;
    }

}
