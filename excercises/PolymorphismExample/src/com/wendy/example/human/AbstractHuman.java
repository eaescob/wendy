package com.wendy.example.human;

public abstract class AbstractHuman implements Human {
	public abstract void sayName();
	
	private String name;
	
	public AbstractHuman(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void stepLeft() {
		System.out.printf("%s took step to the left\n", getName());
	}
	
	public void stepRight() {
		System.out.printf("%s took step to the right\n", getName());
	}
	
	public void poop() {
		System.out.printf("%s just pooped\n", getName());
	}
	
	public void stepForward() {
		System.out.printf("%s took step forward\n", getName());
	}
	
	public void stepBack() {
		System.out.printf("%s took a step back\n", getName());
	}
	
	public void fart() {
		System.out.printf("%s just farted%n", getName());
	}

}
