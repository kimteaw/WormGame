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
		
		//���� Ȯ��
		System.out.println("�⺻ ��� ������ ȣ��");
	}
	
	
	/*�⺻ ��� execute �޼ҵ�*/

	@Override
	public void executeBlock() {
		// TODO Auto-generated method stub
		executeBasicBlock();
	}
	private void executeBasicBlock() {
		//������ �Ӹ��� �ش� ��ǥ�� ���������� �Ѵ�
		ManageElement.elementManager.wormDirection.setIsMove(false);
	}
}
