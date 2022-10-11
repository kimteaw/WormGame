package screen;

import java.awt.*;

import javax.swing.*;

import element.*;
import element.block.CliffBlock;

public class ElementPanel extends JPanel {

	/*요소 패널의 필드*/
	
	//element 객체 저장
	Element element;
	
	//그리기 크기
	final int drawSize = 16;
	
	/*요소 패널의 생성자*/
	public ElementPanel(int panelX, int panelY) {
		
		//요소 패널의 위치와 크기 설정
		setBounds(panelX*GameField.gamefield.elementSize, panelY*GameField.gamefield.elementSize, GameField.gamefield.elementSize, GameField.gamefield.elementSize);
		
		//배경색 설정 - 투명 //위치 바꿔야할수도잇음
		setOpaque(false);
		
		//게임 필드에 배치하기
		GameField.gamefield.add(this);
		
		//동작 확인
		System.out.println("요소 패널 생성 및 배치 : " + panelX + ", " + panelY);

	}

	
	/*요소 패널의 메소드*/
	
	//요소 정보 저장하는 메소드
	public void inputElement(Element element) {
		this.element = element;
		
		//패널 다시 그리기
		repaint();
	}
	
	@Override
	//요소 그리기
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//element가 없을 때
		if(element == null) {
			;
		}
		//element가 있을 때
		else {
			//element 객체로 부터 색깔 받아오기
			g.setColor(element.returnColor());
			
			//도형 그리기 메소드 호출
			drawFigure(g);
		}
	}
	
	//element 종류에 따라 그리는 도형
	public void drawFigure(Graphics g) { 
	
		//지렁이 = 원형
		if(element instanceof Worm) {
			g.fillOval(0, 0, drawSize, drawSize);
		}
		//element가 절벽블록일 때
		else if(element instanceof CliffBlock) {
			//절벽 그리기 호출
			drawCliff(g);
		}
		//블록 = 사각형
		else if(element instanceof Block) {
			g.fillRect(0, 0, drawSize, drawSize);
		}
		//아이템 = 마름모
		else if(element instanceof Item) {
			int x[] = {drawSize /2, 0, drawSize / 2 , drawSize};
			int y[] = {0, drawSize / 2, drawSize, drawSize /2 };
			g.fillPolygon(x, y, 4);
		}
		//아무 것도 해당하지 않으면 그리지 않음
		else
			;
		
	}
	
	//절벽 그리기
	public void drawCliff(Graphics g) {
	
		//왼쪽 상단
		if(element.returnX() == 0 && element.returnY() == 0) {
			g.fillRect(0, 0, drawSize, drawSize);
		}
		//오른쪽 하단
		else if(element.returnX() == GameField.gamefield.elementNum-1 && element.returnY() == GameField.gamefield.elementNum-1) {
			g.fillRect(GameField.gamefield.elementSize-drawSize, GameField.gamefield.elementSize-drawSize, drawSize, drawSize);
		}
		//왼쪽 하단
		else if(element.returnX() == 0 && element.returnY() == GameField.gamefield.elementNum-1) {
			g.fillRect(0, GameField.gamefield.elementSize-drawSize, drawSize, drawSize);
		}
		//오른쪽 상단
		else if(element.returnX() == GameField.gamefield.elementNum-1 && element.returnY() == 0) {
			g.fillRect(GameField.gamefield.elementSize-drawSize, 0, drawSize, drawSize);
		}
		//상단
		else if(element.returnY() == 0) {
			g.fillRect(0, 0, GameField.gamefield.elementSize, drawSize);
		}
		//하단
		else if(element.returnY() == GameField.gamefield.elementNum-1) {
			g.fillRect(0, GameField.gamefield.elementSize-drawSize, GameField.gamefield.elementSize, drawSize);
		}
		//좌측
		else if(element.returnX() == 0) {
			g.fillRect(0, 0, drawSize, GameField.gamefield.elementSize);
		}
		//우측
		else if(element.returnX() == GameField.gamefield.elementNum-1) {
			g.fillRect(GameField.gamefield.elementSize-drawSize, 0, drawSize, GameField.gamefield.elementSize);
		}	
	}
}
