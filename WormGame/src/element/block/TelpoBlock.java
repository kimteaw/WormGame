package element.block;
import java.awt.Color;

import element.Block;
import element.Worm;
import operation.ManageElement;
import screen.GameField;


public class TelpoBlock extends Block {
			
	/*텔레포트 블록 필드*/
	int telpoOtherXY[] = new int[2]; //다른 텔리포트 블록의 위치 저장
	
	/*텔레포트 블록 생성자*/
	private TelpoBlock(int blockX, int blockY) {
		super(blockX, blockY);
		super.color = Color.BLUE;
		// TODO Auto-generated constructor stub		
		
		//동작 확인
		System.out.println("텔레포트 블록 생성자 호출");
	}
	public TelpoBlock(int blockX, int blockY, int telpoOtherXY[]) {
		this(blockX, blockY);
		this.telpoOtherXY = telpoOtherXY; 
	}
	
	
	/*텔레포트 블록 메소드*/
	public int[] telpoOtherReturn() {
		return this.telpoOtherXY;
	}
	
	/*텔레포트 블록 execute 메소드*/
	@Override
	public void executeBlock() {
		// TODO Auto-generated method stub
		executeTelpoBlock();
	}
	private void executeTelpoBlock() {
		//다른 블록 좌표로 지렁이 머리를 이동시킨다
		ManageElement.elementManager.telpoWorm(this.telpoOtherXY[0], this.telpoOtherXY[1]);
		
	}
	
}
