import java.io.Serializable;

public class Score implements Serializable {

	private static final long serialVersionUID = 5950169519310163575L;
	private int score;
	
	public Score(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public String toString() {
		return "Score = " + getScore() + " ;";
	}
}