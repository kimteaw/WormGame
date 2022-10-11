package element.item;

import java.awt.Color;

import element.Item;
import element.Worm;
import element.worm.WormBody;
import operation.ManageElement;

public class GoodItem extends Item {
	
	public GoodItem(int blockX, int blockY) {
		super(blockX, blockY);
		super.color = Color.CYAN;
		// TODO Auto-generated constructor stub
		
		//동작 확인
		System.out.println("좋은 아이템 생성자 호출");
	}
	
	public static void goodItemEat() {
		if(ManageElement.elementManager.wormHead.returnWormSize() < 29) {
			ManageElement.elementManager.createWormBody(1, 1);
		}
		System.out.print("좋은 아이템을 먹었어");
		
		
}

	@Override
	public void executeItem() {
		// TODO 자동 생성된 메소드 스텁
		goodItemEat();
		ManageElement.elementManager.wormDirection.setisReverse(false);
		ManageElement.elementManager.createGoodItem();
	}
	
	
}
