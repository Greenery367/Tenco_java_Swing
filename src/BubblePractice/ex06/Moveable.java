package BubblePractice.ex06;

public interface Moveable {
	
	void right();
	void left();
	void up();
	default void down() {};

}
