package element;

import java.awt.Color;
import java.util.*;
import element.worm.WormBody;
import element.worm.WormHead;
import operation.ManageElement;
import screen.GameField;

public abstract class Worm extends Element {

	//������ ����
	protected static Vector<Worm> wormVector = new Vector<>(30);
	
	public Worm(int elementX, int elementY) {
		super(elementX, elementY);
		
		//���� Ȯ��
		System.out.println("������ ������ ȣ��");
		// TODO Auto-generated constructor stub
	}
	


	/*������ ���� �޼ҵ�*/
	public int returnWormSize() {
		int wormSize = wormVector.size();
		return wormSize;
	}
	public Worm getWorm(int index) {
		return wormVector.get(index);
	}
	public Worm returnWorm() {
		return wormVector.get(0);
	}
	

	public Worm returnLastWormBody() {
		return wormVector.get(wormVector.size()-1);
	}
	public void lastWormBodyDelete() {
		wormVector.remove(ManageElement.elementManager.wormHead.returnWormSize()-1);
	}

	public void executeElement() {
		// TODO �ڵ� ������ �޼ҵ� ����
		executeWorm();
	}
	
	public abstract void executeWorm();

}
