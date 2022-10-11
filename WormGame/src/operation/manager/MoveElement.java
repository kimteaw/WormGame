package operation.manager;

import element.Worm;
import element.block.TelpoBlock;
import element.worm.WormHead;
import operation.ManageElement;

public interface MoveElement {

	MoveInfo moveInfo = new MoveInfo();

	default void moveWorm(int moveX, int moveY) {
		
		//�̵� ���� Ȯ�� �� �̵�
		if (ManageElement.elementManager.wormDirection.getIsMove() == true) {
			//������ �Ӹ� �̵� ȣ��
			moveWormHead(moveX, moveY);
			//������ ���� �̵� ȣ��
			moveWormBody();
		}
		else
			;
	}

	private void moveWormHead(int moveX, int moveY) {
		//���� �Ӹ� ��ǥ ����
		moveInfo.indexXY[0] = ManageElement.elementManager.wormHead.returnX();
		moveInfo.indexXY[1] = ManageElement.elementManager.wormHead.returnY();
		
		//���� �ʵ忡�� ����
		ManageElement.elementManager.gamefield.removeElement(ManageElement.elementManager.wormHead.returnX(), ManageElement.elementManager.wormHead.returnY());
		
		//������ �Ӹ��� ��ǥ ����
		ManageElement.elementManager.wormHead.setXY(moveInfo.directXY[0] + moveX, moveInfo.directXY[1] + moveY);
		
		//���� �ʵ忡 ������ �Ӹ� ����
		ManageElement.elementManager.gamefield.setElement(ManageElement.elementManager.wormHead);
	}
	
	private void moveWormBody() {
		for(int index = 1; index < ManageElement.elementManager.wormHead.returnWormSize(); index++) {
			//������ ��ü �޾ƿ���
			Worm worm = ManageElement.elementManager.wormHead.getWorm(index);
			
			//������ ��ǥ
			int x = worm.returnX();
			int y = worm.returnY();
			
			//���� �ʵ忡�� ����
			ManageElement.elementManager.gamefield.removeElement(x, y);
			
			//������ ������ ��ǥ ����
			worm.setXY(moveInfo.indexXY[0], moveInfo.indexXY[1]);
			
			//���� �ʵ忡 ������ ���� ����
			ManageElement.elementManager.gamefield.setElement(worm);
			
			//���� ������ ������ �־��� �ڸ� ����
			moveInfo.indexXY[0] = x;
			moveInfo.indexXY[1] = y;
		}
	}
	
	default void checkMove(int moveX, int moveY) {
		//���� ��ġ ����
		moveInfo.directXY[0] = ManageElement.elementManager.wormHead.returnX();
		moveInfo.directXY[1] = ManageElement.elementManager.wormHead.returnY();
		
		//�̵� ���� Ȯ�� �� üũ
		if (ManageElement.elementManager.wormDirection.getIsMove() == true) {
			checkArea(moveInfo.directXY[0]+moveX, moveInfo.directXY[1]+moveY);
			}
		else
			;
		
		/*���� ����*/
		//��ǥ ��ȭ �� ���
		//calcMove(moveInfo.moveXY);
		
		//���� Ȯ�� �� ��� �޼ҵ� ����
		//checkArea(moveInfo.directXY[0] + moveInfo.moveXY[0], moveInfo.directXY[1] + moveInfo.moveXY[1]);
	}
	
	private void checkArea(int areaX, int areaY) {
		//�̵��� ������ �ƹ��͵� ������ �۵� ����
		if(null == ManageElement.elementManager.gamefield.checkElement(areaX, areaY)) {
			;
		}
		//�̵��� ������ ����ִ� ����� �޼ҵ� ȣ��
		else {
			ManageElement.elementManager.gamefield.checkElement(areaX, areaY).executeElement();
		}
	}
	
	default void telpoWorm(int telpoX, int telpoY) {
		moveInfo.directXY[0] = telpoX;
		moveInfo.directXY[1] = telpoY;
	}

	default void moveTelpo() {
		//���� �ڷ���Ʈ ����		
		ManageElement.elementManager.deleteElement(ManageElement.elementManager.telpoBlockA.returnX(), ManageElement.elementManager.telpoBlockA.returnY());
		ManageElement.elementManager.deleteElement(ManageElement.elementManager.telpoBlockB.returnX(), ManageElement.elementManager.telpoBlockB.returnY());
		
		//�� �ڷ���Ʈ ����
		ManageElement.elementManager.createTelpoBlock();
	}
}

class MoveInfo {
	
	//0 : �̵� ������ x��ǥ ��, 1 : y��ǥ ��
	int directXY[] = new int[2];
	
	//0 : ���� ��ġ x��ǥ, 1 : ���� ��ġ y��ǥ
	int indexXY[] = new int[2];
	
}

