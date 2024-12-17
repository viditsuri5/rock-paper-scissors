import java.util.Random;

public class SixthSuriVidit implements Player {
    private static String name = "SuriVidit";
    private Random random = new Random();

    public String move(String[] myMoves, String[] opponentMoves, int myScore, int opponentScore) {
        if (myMoves.length == 0) {
            return "r";
        }
        String opponentNextMove = predictOpponent(opponentMoves);
        return decideMove(opponentNextMove);
    }

    private String predictOpponent(String[] moves) {
        int rock = 0, paper = 0, scissors = 0;

        for (String move : moves) {
            if (move == null) continue;
            if (move.equals("r")) rock++;
            else if (move.equals("p")) paper++;
            else if (move.equals("s")) scissors++;
        }

        if (rock >= paper && rock >= scissors) return "r";
        if (paper >= scissors) return "p";
        return "s";
    }

    private String decideMove(String predictedMove) {
        if (random.nextDouble() < 0.2) {
            return randomMove();
        }
        if (predictedMove.equals("r")) return "p";
        if (predictedMove.equals("p")) return "s";
        return "r";
    }

    private String randomMove() {
        int choice = random.nextInt(3);
        return choice == 0 ? "r" : choice == 1 ? "p" : "s";
    }

    public String getName() {
        return name;
    }
}