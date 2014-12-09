package com.wendy.example.human.run;

import com.wendy.example.human.*;
import com.wendy.example.human.impl.*;

public class RunExample {
	public static void main(String[] args) {
		Human humans[] = new Human[]{ new Wendy(), new Emilio() };
		
		for(Human human : humans) {
			human.sayName();
			human.stepLeft();
			human.stepBack();
			human.stepRight();
			human.stepForward();
			human.fart();
			human.poop();
		}
		
	}
}
