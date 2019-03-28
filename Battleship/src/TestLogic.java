import java.awt.Color;

public class TestLogic extends GameLogic{

	public TestLogic(Game game) {
		super(game);
	}

	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Game game) {
		game.addEntity(new Player1Ship(70,80,0,40,10,Color.gray));
		
	}

}
