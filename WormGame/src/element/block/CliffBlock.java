package element.block;

import java.awt.*;
import element.*;
import screen.GameOver;

public class CliffBlock extends Block {

	public CliffBlock(int blockX, int blockY) {
		super(blockX, blockY);
		super.color = Color.GRAY;		
		// TODO Auto-generated constructor stub
		
		//���� Ȯ��
		System.out.println("���� ��� ������ ȣ��");
	}

	
	/*���� ��� execute �޼ҵ�*/

	@Override
	public void executeBlock() {
		// TODO Auto-generated method stub
		executeCliffBlock();
	}
	private void executeCliffBlock() {
		//�����̸� ���δ�
		new GameOver();
		//IsGameOver = true;
	}

}
