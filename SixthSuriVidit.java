import java.util.Random;

public class SixthSuriVidit implements Player {
    private static String name = "SuriVidit";
    private Random random = new Random();

    public String move(String[] myMoves, String[] opponentMoves, int myScore, int opponentScore) {
        if (myMoves.length == 0) return "r";
        return counterMove(predictOpponent(opponentMoves));
    }

    private String predictOpponent(String[] moves) {
        int r = 0, p = 0, s = 0;
        for (String move : moves) {
            if (move == null) continue;
            if (move.equals("r")) r++;
            else if (move.equals("p")) p++;
            else if (move.equals("s")) s++;
        }
        if (r >= p && r >= s) return "r";
        if (p >= s) return "p";
        return "s";
    }

    private String counterMove(String predictedMove) {
        if (predictedMove.equals("r")) return "p";
        if (predictedMove.equals("p")) return "s";
        return "r";
    }

    public String getName() {
        return name;
    }
}