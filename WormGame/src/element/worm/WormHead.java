package element.worm;

import java.awt.Color;
import element.Worm;

public class WormHead extends Worm{
	public WormHead(int WormX, int WormY) {
		super(WormX,WormY);
		super.color = Color.WHITE;
		// TODO Auto-generated constructor stub
	
		/*이상은 추가 - 벡터*/
		wormVector.add(0, this);
		
		//동작 확인
		System.out.println("지렁이헤드 생성자 호출");
	}
	@Override
	public void executeWorm() {
		
		executeWormHead();
	}
	public void executeWormHead() {
		
	}
}
