package element.worm;

import java.awt.Color;
import element.Worm;

public class WormHead extends Worm{
	public WormHead(int WormX, int WormY) {
		super(WormX,WormY);
		super.color = Color.WHITE;
		// TODO Auto-generated constructor stub
	
		/*�̻��� �߰� - ����*/
		wormVector.add(0, this);
		
		//���� Ȯ��
		System.out.println("��������� ������ ȣ��");
	}
	@Override
	public void executeWorm() {
		
		executeWormHead();
	}
	public void executeWormHead() {
		
	}
}
