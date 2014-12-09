package com.wendy.example.human.impl;

import com.wendy.example.human.*;

public class Wendy extends AbstractHuman {
	public void sayName() {
		System.out.println("Hi I'm Wendy");
	}
	
	public Wendy() {
		super("Wendy");
	}
	
	@Override
	public void poop() {
		System.out.printf("%s pooped a little%n", getName());
	}
	
	@Override
	public void fart() {
		System.out.printf("%s farts a lot%n", getName());
	}
}
