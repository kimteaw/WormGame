package element.block;

import java.awt.*;
import element.*;
import screen.GameOver;

public class CliffBlock extends Block {

	public CliffBlock(int blockX, int blockY) {
		super(blockX, blockY);
		super.color = Color.GRAY;		
		// TODO Auto-generated constructor stub
		
		//동작 확인
		System.out.println("절벽 블록 생성자 호출");
	}

	
	/*절벽 블록 execute 메소드*/

	@Override
	public void executeBlock() {
		// TODO Auto-generated method stub
		executeCliffBlock();
	}
	private void executeCliffBlock() {
		//지렁이를 죽인다
		new GameOver();
		//IsGameOver = true;
	}

}
