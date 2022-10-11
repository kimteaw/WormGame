package operation;

import operation.manager.*;
import element.block.TelpoBlock;
import element.worm.WormHead;
import operation.manager.*;
import screen.GameField;

//element 관리 클래스
public class ManageElement implements CreateElement, DeleteElement, MoveElement {
	
	/*관리 클래스의 필드*/
	
	//프로그램 실행 시 elementManager 객체 생성, 이후 추가 생성 불가 
	public static final ManageElement elementManager = new ManageElement();
	private boolean isGameOver = false;
	//게임 필드의 레퍼런스 저장
	public GameField gamefield = GameField.gamefield;
	
	//지렁이 머리의 레퍼런스 저장
	public WormHead wormHead;
	
	//텔레포트 블록의 레퍼런스 저장
	public TelpoBlock telpoBlockA;
	public TelpoBlock telpoBlockB;
	
	//지렁이 방향 레퍼런스 저장
	public WormDirection wormDirection;
	
	//웜이벤트 저장
	
	/*관리 클래스의 생성자*/
	
	private ManageElement() {
		//동작 확인
		System.out.println("요소 매니저 객체 생성");

	}
	
	
	/*관리 클래스의 메소드*/
	
	public void addManageWorm(WormHead wormHead) {
		this.wormHead = wormHead;
	}
	
	public void addManageTelpo(TelpoBlock telpoBlockA, TelpoBlock telpoBlockB) {
		this.telpoBlockA = telpoBlockA;
		this.telpoBlockB = telpoBlockB;
	}
	public boolean returnisGameOver() {
		return this.isGameOver;
	}
	public void setisGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
}
/*
 **초기 설정**
 * 지렁이 머리 생성 
 * 블록들 생성
 * 아이템들 생성
 * 
 **게임 중**
 * 좋은 아이템 먹으면 새 좋은 아이템 생성
 * 몸통 길이 추가
 * 일정 시간 후 혼한, 나쁜 아이템 생성 및 삭제 반복
 * */