
public abstract class GameLogic {
	public abstract void update(Game game);
	public abstract void start(Game game);
	protected Game game;
	
	public GameLogic(Game game) {
		this.game = game;
	}
}
