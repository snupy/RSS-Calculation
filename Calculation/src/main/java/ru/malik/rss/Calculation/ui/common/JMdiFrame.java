package ru.malik.rss.Calculation.ui.common;

import javax.swing.JInternalFrame;

public class JMdiFrame extends JInternalFrame {

	public JMdiFrame() {
		this("");
	}

	public JMdiFrame(String title, boolean resizable, boolean closable,
			boolean maximizable, boolean iconifiable) {
		super(title, resizable, closable, maximizable, iconifiable);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public JMdiFrame(String title, boolean resizable, boolean closable,
			boolean maximizable) {
		this(title, resizable, closable, maximizable, true);

	}

	public JMdiFrame(String title, boolean resizable, boolean closable) {
		this(title, resizable, closable, true);

	}

	public JMdiFrame(String title, boolean resizable) {
		this(title, resizable, true);

	}

	public JMdiFrame(String title) {
		this(title, true);

	}
	
}
