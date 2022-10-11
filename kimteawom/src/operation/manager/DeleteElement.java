 package operation.manager;

import element.Worm;
import element.worm.*;
import operation.ManageElement;
import screen.*;

//element 객체 삭제 기능 인터페이스
public interface DeleteElement {

	//요소 삭제 메소드
	default void deleteElement(int elementX, int elementY) {
		//게임 필드에서 삭제 메소드 호출
		GameField.gamefield.removeElement(elementX, elementY);
	}
	
	//지렁이 몸통 삭제 메소드
	default void deleteWormBody() {
		//지렁이 벡터의 가장 마지막 객체 받아오기 
		Worm worm = ManageElement.elementManager.wormHead.returnLastWormBody();
		
		//지렁이 머리일 경우 게임오버
		if(worm instanceof WormHead) {
			new GameOver();
		}
		//머리가 아닐 경우 요소 삭제
		else {
			deleteElement(worm.returnX(), worm.returnY());
			ManageElement.elementManager.wormHead.lastWormBodyDelete();

		}
	}
}
