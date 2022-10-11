package screen;

import java.awt.Color;
import java.util.*;
import javax.swing.JPanel;
import element.*;
import element.item.GoodItem;

//게임 필드 패널 클래스
public class GameField extends JPanel {
	
	//프로그램 실행 시 게임 필드 객체 생성, 이후 추가 생성 불가 
	public static final GameField gamefield = new GameField(); 
	
	/*게임 필드 필드*/
	public final int elementNum = 24; //요소의 갯수
	public final int elementSize = 20; //요소의 크기
	
	private HashMap<Locate, Element> elementMap = new HashMap<>(); //좌표와 요소를 저장하는 해시맵 
	private HashMap<Locate, ElementPanel> panelMap = new HashMap<>(); //좌표와 요소패널을 저장하는 해시맵 

	
	/*게임 필드 생성자*/
	private GameField() {
		//배치 관리자 제거
		this.setLayout(null);
		//게임 필드의 크기와 위치
		this.setBounds(0, 0, returnFieldSize(), returnFieldSize());
		//동작 확인
		System.out.println("gamefield 객체 생성");
	}
	
	/*게임 필드 메소드*/
	
	//게임 필드 크기를 리턴해주는 메소드
	public int returnFieldSize() {
		return elementNum*elementSize;
	}
	
	//필드를 초기화하는 메소드
	public void initField() {
		//좌표 : (0~23, 0~23)
		for(int x = 0; x < elementNum; x++) {
			for(int y = 0; y < elementNum; y++) {
				//해시맵 키: Locate(좌표) 객체 순차적으로 생성 후 삽입 
				elementMap.put(new Locate(x, y), null); //요소맵 값: null
				panelMap.put(new Locate(x, y), new ElementPanel(x, y)); //패널맵 값: 빈 패널
			}
		}
		
		//게임 필드 다시 그리기
		revalidate();
		repaint();
		
		//배경색 설정 - 검정
		setBackground(Color.BLACK);
	}
	
	//해당 좌표에 들어있는 element를 리턴해주는 메소드
	public Element checkElement(int checkX, int checkY) {
		//해당 좌표와 일치하는 좌표 키 값에 들어있는 element가 없으면 null 리턴
		return elementMap.get(new Locate(checkX, checkY));
	}
	
	//생성된 element를 받아서 해시맵에 저장하는 메소드
	public void setElement(Element element) {		
		Locate locate = new Locate(element.returnX(), element.returnY());
		
		//요소맵에 요소 집어넣기
		elementMap.replace(locate, element);
		
		//패널 설정 호출
		setPanel(locate, element);
		
		//동작 확인
		System.out.println("해시맵에 요소 set");
	}
	
	//element 삭제 메소드
	public void removeElement(int elementX, int elementY) {
		Locate locate = new Locate(elementX, elementY);
		
		//요소맵에 null 넣기
		elementMap.replace(locate, null);

		//패널 설정 호출 - null
		setPanel(locate, null);
	}
	
	//해당 좌표에 들어있는 panel을 설정하는 메소드 - 요소 삭제 및 저장 시 호출
	private void setPanel(Locate locate, Element element) {
		panelMap.get(locate).inputElement(element);
	}
}

//좌표 키 클래스
class Locate {
	
	/*좌표 클래스 필드*/
	private int X; //X좌표, Y좌표
	private int Y;
	
	
	/*좌표 클래스 생성자*/
	public Locate(int x, int y) {
		this.X = x;
		this.Y = y;
	}
	
	/*좌표 클래스 메소드*/
	public int returnX() {
		return this.X;
	}
	public int returnY() {
		return this.Y;
	}
	
	
	/*오버라이딩*/
	//equals 오버라이딩
	@Override
	public boolean equals(Object object) {
		Locate locateObject = (Locate) object;
		System.out.print(locateObject);
		if (this.X == locateObject.X && this.Y == locateObject.Y)
			return true;
		else
			return false;
	}
	
	//해시코드 오버라이딩
	@Override
	public int hashCode() {
		return Objects.hash(X, Y);
	}
}

