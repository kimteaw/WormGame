package element.block;
import java.awt.Color;
import element.Block;
import screen.GameOver;

public class KillBlock extends Block {

	public KillBlock(int blockX, int blockY) {
		super(blockX, blockY);
		super.color = Color.RED;
		// TODO Auto-generated constructor stub
		
		//���� Ȯ��
		System.out.println("ų ��� ������ ȣ��");
	}
	

	/*ų ��� execute �޼ҵ�*/

	@Override
	public void executeBlock() {
		// TODO Auto-generated method stub
		executeKillBlock();
	}
	private void executeKillBlock() {
		//�����̸� ���δ� - ������ �ҹ�⸦ ���ش�
		new GameOver();
		//IsGameOver = true;
	}
}
