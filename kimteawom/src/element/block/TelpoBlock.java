package element.block;
import java.awt.Color;

import element.Block;
import element.Worm;
import operation.ManageElement;
import screen.GameField;


public class TelpoBlock extends Block {
			
	/*�ڷ���Ʈ ��� �ʵ�*/
	int telpoOtherXY[] = new int[2]; //�ٸ� �ڸ���Ʈ ����� ��ġ ����
	
	/*�ڷ���Ʈ ��� ������*/
	private TelpoBlock(int blockX, int blockY) {
		super(blockX, blockY);
		super.color = Color.BLUE;
		// TODO Auto-generated constructor stub		
		
		//���� Ȯ��
		System.out.println("�ڷ���Ʈ ��� ������ ȣ��");
	}
	public TelpoBlock(int blockX, int blockY, int telpoOtherXY[]) {
		this(blockX, blockY);
		this.telpoOtherXY = telpoOtherXY; 
	}
	
	
	/*�ڷ���Ʈ ��� �޼ҵ�*/
	public int[] telpoOtherReturn() {
		return this.telpoOtherXY;
	}
	
	/*�ڷ���Ʈ ��� execute �޼ҵ�*/
	@Override
	public void executeBlock() {
		// TODO Auto-generated method stub
		executeTelpoBlock();
	}
	private void executeTelpoBlock() {
		//�ٸ� ��� ��ǥ�� ������ �Ӹ��� �̵���Ų��
		ManageElement.elementManager.telpoWorm(this.telpoOtherXY[0], this.telpoOtherXY[1]);
		
	}
	
}
