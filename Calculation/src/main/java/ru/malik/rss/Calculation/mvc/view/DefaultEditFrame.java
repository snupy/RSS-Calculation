package ru.malik.rss.Calculation.mvc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.security.acl.Owner;

import javax.swing.Action;

public class DefaultEditFrame extends JFrame {

	private JPanel contentPane;
	private final Action acCLose = new AbstractAction() {

		{
			putValue(NAME, "Закрыть");
		}

		public void actionPerformed(ActionEvent e) {
			close();
		}
	};
	private final Action actSave = new AbstractAction() {
		{
			putValue(NAME, "Сохранить");
		}

		public void actionPerformed(ActionEvent e) {
			save();
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultEditFrame frame = new DefaultEditFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DefaultEditFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panControl = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panControl.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panControl, BorderLayout.SOUTH);

		JButton btnSave = new JButton("Сохранить");
		btnSave.setAction(actSave);
		panControl.add(btnSave);

		JButton btnClose = new JButton("Закрыть");
		btnClose.setAction(acCLose);

		panControl.add(btnClose);
	}

	public void close() {
		Window window = getOwner();
		if (window != null) {
			window.setVisible(true);
		}

		this.dispose();
	}

	public void save() {
		fire
		close();
	}

}
