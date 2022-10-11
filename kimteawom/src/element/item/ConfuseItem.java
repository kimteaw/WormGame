package element.item;

import java.awt.Color;

import element.Item;
import element.Worm;
import operation.ManageElement;
import screen.GameField;

public class ConfuseItem extends Item {

	public ConfuseItem(int elementX, int elementY) {
		super(elementX, elementY);
		super.color = Color.YELLOW;
		// TODO Auto-generated constructor stub
		
		//���� Ȯ��
		System.out.println("ȥ�� ������ ������ ȣ��");
	}
	
	public static void confuseEat() {	
		ManageElement.elementManager.wormDirection.setisReverse(true);
	}

	@Override
	public void executeItem() {
		confuseEat();
		
	}

}
