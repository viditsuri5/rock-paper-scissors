import java.util.*;

public class MJ implements Player
{
    private static String name = "Mengjiao";

    public String move(String [] myMoves, String [] opponentMoves, int myScore, int opponentScore)
    {
        int moveIndex = getCurrentMoveIndex(opponentMoves);
        if (moveIndex > 0)
        {
            String previousMove = opponentMoves[moveIndex-1];
            return moveToLose(previousMove);
        }
        return "p";
    }

    // Find out which move the game is on.
    private int getCurrentMoveIndex(String[] moves)
    {
        int index = 0;
        while (moves[index] != null)
        {
            index++;
        }
        return index;
    }

    // Given a move, return the move that would lose.
    private String moveToLose(String move)
    {
        String moves = "rspr";
        int index = moves.indexOf(move);
        return moves.substring(index+1, index+2);
    }

    public String getName()
    {
        return name;
    }
}

