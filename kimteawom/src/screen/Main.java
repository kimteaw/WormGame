package screen;

import java.util.*;
import element.*;
import operation.*;
import operation.manager.CreateElement;
import element.block.*;
import element.item.*;
import element.worm.*;
import screen.*;

//메인 클래스
public class Main {
	
	public static void main(String[] args) throws InterruptedException {

		System.out.println("*******************");
		System.out.println("프로그램 실행");
		System.out.println("*******************");
		
		GameFrame gameFrame = new GameFrame(); //게임 프레임 생성
		gameFrame.setContentPane(GameField.gamefield); //게임 프레임에 게임 필드 배치

		ManageElement.elementManager.initElement();
	}
}

/*
 * 메인 메소드 실행
 * gameFrame 생성 
 * gameField 생성
 * createElement 생성
 * element 생성
 * 
 * */