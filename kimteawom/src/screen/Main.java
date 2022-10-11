package screen;

import java.util.*;
import element.*;
import operation.*;
import operation.manager.CreateElement;
import element.block.*;
import element.item.*;
import element.worm.*;
import screen.*;

//���� Ŭ����
public class Main {
	
	public static void main(String[] args) throws InterruptedException {

		System.out.println("*******************");
		System.out.println("���α׷� ����");
		System.out.println("*******************");
		
		GameFrame gameFrame = new GameFrame(); //���� ������ ����
		gameFrame.setContentPane(GameField.gamefield); //���� �����ӿ� ���� �ʵ� ��ġ

		ManageElement.elementManager.initElement();
	}
}

/*
 * ���� �޼ҵ� ����
 * gameFrame ���� 
 * gameField ����
 * createElement ����
 * element ����
 * 
 * */