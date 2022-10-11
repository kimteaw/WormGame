package element;

import java.awt.*;
import screen.*;

//요소 추상 클래스
public abstract class Element {
		
	/*요소 클래스 필드*/
	protected int elementX; //요소의 X좌표
	protected int elementY; //요소의 Y좌표
	protected Color color; //요소마다 갖고있는 고유 색상
	
	/*요소 클래스 생성자*/
	public Element(int elementX, int elementY) {
		this.elementX = elementX;
		this.elementY = elementY;
		
		//동작 확인
		System.out.println("element 생성자 작동");
	}
	
	/*요소 클래스 메소드*/
	//요소의 X좌표 리턴
	public int returnX() {
		return this.elementX;
	}
	//요소의 Y좌표 리턴
	public int returnY() {
		return this.elementY;
	}
	//요소의 고유 색상을 리턴하는 메소드
	public Color returnColor() {
		return this.color;
	}
	//요소의 좌표값을 변경하는 메소드
	public void setXY(int x, int y) {
	      this.elementX = x;
	      this.elementY =y;
	}

	abstract public void executeElement();
}
