package com.lazaro.jspdemo.models;

public class Assignment {
	private String title;
	private int difficulty;
	
	public Assignment() {}

	public Assignment(String title, int difficulty) {
		this.title = title;
		this.difficulty = difficulty;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	
}
