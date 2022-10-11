package operation;

import element.Worm;
import element.block.*;
import element.item.*;
import screen.GameField;

//똠치가 제작함
public class WormDirection {
	
	
	//지렁이 움직이는 위치
	public Direction direction;
	//지렁이 움직임 역방향 변수
	private boolean isReverse = false;
	//지렁이 움직임 감지 변수
	private boolean isMove = true;
	//키입력 여부 변수
	public boolean keyPressed = false;

	public enum Direction {
		RIGHT, LEFT, UP, DOWN
	}

	private int headX,headY,itemX,itemY,size,score;


	
	
	//움직일 때
	public WormDirection() {
		
		this.headX=12;
		this.headY=12;
		this.size=0;
		this.score = 0;
		

		
		//방향 초기 설정
		direction = Direction.RIGHT;
		
		//동작 확인
		System.out.println("방향 전환 실행");

	}

	//위치 return
	public Direction getDirection() {
		return this.direction;
	}
	
	//위치 설정 메소드
	public void setDirection(Direction direction) {
		this.direction = direction;
		
	}
	
	//방향 입력 반대 여부 return
	public boolean getisReverse() {
		return isReverse;
	}
	public void setisReverse(boolean bool) {
		isReverse = bool;
	}

	//움직임 여부 설정 메소드
	public void setIsMove(boolean isMove) {
		this.isMove = isMove;
	}
	
	//움직임 여부 return 메소드
	public boolean getIsMove() {
		return isMove;
	}
	
	//키입력 여부 설정 메소드
	public void setKeyPressed(boolean keyPressed) {
		this.keyPressed = keyPressed;
	}
	
	public boolean getKeyPressed() {
		return keyPressed;
	}


	
}
