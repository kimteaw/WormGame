package element;

public abstract class Block extends Element {
	
	/*블록 클래스 생성자*/
	public Block(int blockX, int blockY) {
		super(blockX, blockY);
		
		//동작 확인
		System.out.println("블록 생성자 호출");
	}
	
	/*블록 클래스 추상 메소드*/
	//블록의 기능을 작동 시키는 추상 메소드
	@Override
	public void executeElement() {
		// TODO 자동 생성된 메소드 스텁
		executeBlock();
	}
	abstract public void executeBlock();
}