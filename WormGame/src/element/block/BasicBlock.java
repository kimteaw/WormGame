package element.block;
import java.awt.Color;
import element.*;
import operation.ManageElement;
import operation.WormDirection;

public class BasicBlock extends Block {

	public BasicBlock(int blockX, int blockY) {
		super(blockX, blockY);
		super.color = Color.ORANGE;
		// TODO Auto-generated constructor stub
		
		//동작 확인
		System.out.println("기본 블록 생성자 호출");
	}
	
	
	/*기본 블록 execute 메소드*/

	@Override
	public void executeBlock() {
		// TODO Auto-generated method stub
		executeBasicBlock();
	}
	private void executeBasicBlock() {
		//지렁이 머리가 해당 좌표를 못지나가게 한다
		ManageElement.elementManager.wormDirection.setIsMove(false);
	}
}
