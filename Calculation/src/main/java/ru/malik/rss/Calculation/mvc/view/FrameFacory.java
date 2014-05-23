package ru.malik.rss.Calculation.mvc.view;

import javax.swing.JFrame;

public class FrameFacory {
	private static FrameFacory frameFacory;

	public static FrameFacory getInstance() {
		if (frameFacory == null) {
			frameFacory = new FrameFacory();
		}
		return frameFacory;
	}

	private FrameFacory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JFrame getNewFrame(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		return frame;
	}
}
