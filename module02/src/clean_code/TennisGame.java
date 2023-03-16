package clean_code;

public class TennisGame {
    final static int SCORE_WIN = 4;
    final static int SCORE_WIN_MORE = 2;
    static String score = "";
    static int tempScore = 0;
    int score1;
    int score2;

    public TennisGame() {
    }

    public TennisGame(int score1, int score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    public static void setScore(String score) {
        TennisGame.score = score;
    }

    public static int getTempScore() {
        return tempScore;
    }

    public static void setTempScore(int tempScore) {
        TennisGame.tempScore = tempScore;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public  String getScore() {
        if (score1 == score2) {
            checkDeuce(score1);
        } else if (score1 >= SCORE_WIN || score2 >= SCORE_WIN) {
            result(score1, score2);
        } else {
            callScore(score1, score2);
        }
        return score;
    }

    public void checkDeuce(int score1) {
        switch (score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
    }

    public  void result(int score1, int score2) {
        int minusResult = score1 - score2;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= SCORE_WIN_MORE) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
    }

    public  void callScore(int score1, int score2) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = score1;
            } else {
                score += "-";
                tempScore = score2;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
    }
}
