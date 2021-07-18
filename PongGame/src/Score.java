import java.awt.*;

public class Score extends Rectangle {

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1_score;
    int player2_score;

    Score(int GAME_WIDTH, int GAME_HEIGHT){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }

    public void draw(Graphics g){
        g.setColor(Color.cyan);
        g.setFont(new Font("Consolas",Font.PLAIN,70));
        g.drawLine(GAME_WIDTH/2,0,GAME_WIDTH/2,GAME_HEIGHT);
        g.drawString(String.valueOf(player1_score), (GAME_WIDTH/2)-90, 50);
        g.drawString(String.valueOf(player2_score), (GAME_WIDTH/2)+90, 50);
    }
}
