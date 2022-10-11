package operation.manager;

import element.Worm;
import element.block.TelpoBlock;
import element.worm.WormHead;
import operation.ManageElement;

public interface MoveElement {

	MoveInfo moveInfo = new MoveInfo();

	default void moveWorm(int moveX, int moveY) {
		
		//이동 상태 확인 후 이동
		if (ManageElement.elementManager.wormDirection.getIsMove() == true) {
			//지렁이 머리 이동 호출
			moveWormHead(moveX, moveY);
			//지렁이 몸통 이동 호출
			moveWormBody();
		}
		else
			;
	}

	private void moveWormHead(int moveX, int moveY) {
		//현재 머리 좌표 저장
		moveInfo.indexXY[0] = ManageElement.elementManager.wormHead.returnX();
		moveInfo.indexXY[1] = ManageElement.elementManager.wormHead.returnY();
		
		//게임 필드에서 삭제
		ManageElement.elementManager.gamefield.removeElement(ManageElement.elementManager.wormHead.returnX(), ManageElement.elementManager.wormHead.returnY());
		
		//지렁이 머리의 좌표 설정
		ManageElement.elementManager.wormHead.setXY(moveInfo.directXY[0] + moveX, moveInfo.directXY[1] + moveY);
		
		//게임 필드에 지렁이 머리 저장
		ManageElement.elementManager.gamefield.setElement(ManageElement.elementManager.wormHead);
	}
	
	private void moveWormBody() {
		for(int index = 1; index < ManageElement.elementManager.wormHead.returnWormSize(); index++) {
			//지렁이 객체 받아오기
			Worm worm = ManageElement.elementManager.wormHead.getWorm(index);
			
			//지렁이 좌표
			int x = worm.returnX();
			int y = worm.returnY();
			
			//게임 필드에서 삭제
			ManageElement.elementManager.gamefield.removeElement(x, y);
			
			//지렁이 몸통의 좌표 설정
			worm.setXY(moveInfo.indexXY[0], moveInfo.indexXY[1]);
			
			//게임 필드에 지렁이 몸통 저장
			ManageElement.elementManager.gamefield.setElement(worm);
			
			//원래 지렁이 몸통이 있었던 자리 저장
			moveInfo.indexXY[0] = x;
			moveInfo.indexXY[1] = y;
		}
	}
	
	default void checkMove(int moveX, int moveY) {
		//현재 위치 저장
		moveInfo.directXY[0] = ManageElement.elementManager.wormHead.returnX();
		moveInfo.directXY[1] = ManageElement.elementManager.wormHead.returnY();
		
		//이동 상태 확인 후 체크
		if (ManageElement.elementManager.wormDirection.getIsMove() == true) {
			checkArea(moveInfo.directXY[0]+moveX, moveInfo.directXY[1]+moveY);
			}
		else
			;
		
		/*삭제 예정*/
		//좌표 변화 값 계산
		//calcMove(moveInfo.moveXY);
		
		//공간 확인 및 요소 메소드 실행
		//checkArea(moveInfo.directXY[0] + moveInfo.moveXY[0], moveInfo.directXY[1] + moveInfo.moveXY[1]);
	}
	
	private void checkArea(int areaX, int areaY) {
		//이동할 공간에 아무것도 없으면 작동 안함
		if(null == ManageElement.elementManager.gamefield.checkElement(areaX, areaY)) {
			;
		}
		//이동할 공간에 들어있는 요소의 메소드 호출
		else {
			ManageElement.elementManager.gamefield.checkElement(areaX, areaY).executeElement();
		}
	}
	
	default void telpoWorm(int telpoX, int telpoY) {
		moveInfo.directXY[0] = telpoX;
		moveInfo.directXY[1] = telpoY;
	}

	default void moveTelpo() {
		//기존 텔레포트 삭제		
		ManageElement.elementManager.deleteElement(ManageElement.elementManager.telpoBlockA.returnX(), ManageElement.elementManager.telpoBlockA.returnY());
		ManageElement.elementManager.deleteElement(ManageElement.elementManager.telpoBlockB.returnX(), ManageElement.elementManager.telpoBlockB.returnY());
		
		//새 텔레포트 생성
		ManageElement.elementManager.createTelpoBlock();
	}
}

class MoveInfo {
	
	//0 : 이동 기준점 x좌표 값, 1 : y좌표 값
	int directXY[] = new int[2];
	
	//0 : 현재 위치 x좌표, 1 : 현재 위치 y좌표
	int indexXY[] = new int[2];
	
}

