package triqui;

/**
 *
 * @author emontoya
 */
public class TriquiGame implements ITriquiGame {

    boolean turn;

    String X = "X";
    String O = "O";
    String E = "--";

    TriquiBoard triquiBoard = new TriquiBoard();

    String status = "new game";

    public TriquiGame() {
        Start();
    }

    public void Start() {
        triquiBoard.Reset();
    }

    public boolean Play(int pos) {
        boolean result = true;
        String[] board = triquiBoard.getBoard();
        if (pos < 9 && !board[pos].equals(X) && !board[pos].equals(O)) {
            if (turn) {
                board[pos] = X;
                turn = !turn;

            } else {
                board[pos] = O;
                turn = !turn;
            }
        } else {
            result = false;
        }
        if (!result) {
            status = ">>>jugada invalida";
        }
        return result;
    }

    public String getPlayer() {
        String result = "";
        if (turn) {
            result = X;

        } else {
            result = O;
        }
        return result;
    }

    public String Boardtxt() {
        StringBuffer sb = new StringBuffer();
        int pos = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                sb.append(triquiBoard.getCell(pos++) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getBoard() {
        StringBuffer sb = new StringBuffer();

        sb.append("<table border=0>\n");
        int pos = 0;
        for (int x = 0; x < 3; x++) {
            sb.append("<tr>\n");
            for (int y = 0; y < 3; y++) {
                sb.append("<td>" + triquiBoard.getCell(pos++) + "</td>\n");
            }
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        return sb.toString();
    }

    public String getWinner() {
        String result = "No todavia";
        String [] board = triquiBoard.getBoard();

        if (board[0].equals(X) && board[1].equals(X) && board[2].equals(X)) {
            result = X;
        }

        if (board[3].equals(X) && board[4].equals(X) && board[5].equals(X)) {
            result = X;
        }

        if (board[6].equals(X) && board[7].equals(X) && board[8].equals(X)) {
            result = X;
        }

        if (board[0].equals(X) && board[3].equals(X) && board[6].equals(X)) {
            result = X;
        }

        if (board[1].equals(X) && board[4].equals(X) && board[7].equals(X)) {
            result = X;
        }

        if (board[2].equals(X) && board[5].equals(X) && board[8].equals(X)) {
            result = X;
        }

        if (board[0].equals(X) && board[4].equals(X) && board[8].equals(X)) {
            result = X;
        }

        if (board[2].equals(X) && board[4].equals(X) && board[6].equals(X)) {
            result = X;
        }

        if (board[0].equals(O) && board[1].equals(O) && board[2].equals(O)) {
            result = O;
        }

        if (board[3].equals(O) && board[4].equals(O) && board[5].equals(O)) {
            result = O;
        }

        if (board[6].equals(O) && board[7].equals(O) && board[8].equals(O)) {
            result = O;
        }

        if (board[0].equals(O) && board[3].equals(O) && board[6].equals(O)) {
            result = O;
        }

        if (board[1].equals(O) && board[4].equals(O) && board[7].equals(O)) {
            result = O;
        }

        if (board[2].equals(O) && board[5].equals(O) && board[8].equals(O)) {
            result = O;
        }

        if (board[0].equals(O) && board[4].equals(O) && board[8].equals(O)) {
            result = O;
        }

        if (board[2].equals(O) && board[4].equals(O) && board[6].equals(O)) {
            result = O;
        }

        return result;
    }

    public void setStatus(String msg) {
        status = msg;
    }

    public String getStatus() {
        return status;
    }

}
