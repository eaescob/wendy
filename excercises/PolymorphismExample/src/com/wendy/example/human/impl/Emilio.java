package com.wendy.example.human.impl;

import com.wendy.example.human.*;

public class Emilio extends AbstractHuman {
	public Emilio() {
		super("Emilio");
	}
	
	public void sayName() {
		System.out.println("Hi I'm Emilio");
	}
	
	@Override
	public void poop() {
		System.out.printf("%s pooped a lot%n", getName());
	}
}
