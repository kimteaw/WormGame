 package operation.manager;

import element.Worm;
import element.worm.*;
import operation.ManageElement;
import screen.*;

//element ��ü ���� ��� �������̽�
public interface DeleteElement {

	//��� ���� �޼ҵ�
	default void deleteElement(int elementX, int elementY) {
		//���� �ʵ忡�� ���� �޼ҵ� ȣ��
		GameField.gamefield.removeElement(elementX, elementY);
	}
	
	//������ ���� ���� �޼ҵ�
	default void deleteWormBody() {
		//������ ������ ���� ������ ��ü �޾ƿ��� 
		Worm worm = ManageElement.elementManager.wormHead.returnLastWormBody();
		
		//������ �Ӹ��� ��� ���ӿ���
		if(worm instanceof WormHead) {
			new GameOver();
		}
		//�Ӹ��� �ƴ� ��� ��� ����
		else {
			deleteElement(worm.returnX(), worm.returnY());
			ManageElement.elementManager.wormHead.lastWormBodyDelete();

		}
	}
}
