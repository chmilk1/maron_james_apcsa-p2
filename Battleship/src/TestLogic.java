import java.awt.Color;

public class TestLogic extends GameLogic{

	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Game game) {
		game.entitys.add(new Ship(70,80,0,40,10,Color.gray));
		
	}

}
