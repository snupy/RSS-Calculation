package ru.malik.rss.Calculation.mvc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class DefaultEditWindow {

	private JFrame frame;
	private final JPanel panManage = new JPanel();
	private final JPanel panContent = new JPanel();
	private final Action acOk = new OkSwingAction();
	private final Action acCancel = new CancelSwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultEditWindow window = new DefaultEditWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DefaultEditWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panContent, BorderLayout.CENTER);
		frame.getContentPane().add(panManage, BorderLayout.SOUTH);
		panManage.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton okButton = new JButton("Ок");
		acOk.putValue(AbstractAction.NAME, okButton.getText());
		okButton.setAction(acOk);
		panManage.add(okButton);
		
		JButton cancelButton = new JButton("Отмена");
		acCancel.putValue(AbstractAction.NAME, cancelButton.getText());
		cancelButton.setAction(acCancel);
		panManage.add(cancelButton);
	}

	
	
	public JFrame getFrame() {
		return frame;
	}

	protected void setFrame(JFrame frame) {
		this.frame = frame;
	}

	protected JPanel getPanManage() {
		return panManage;
	}

	

	protected JPanel getPanContent() {
		return panContent;
	}



	private class OkSwingAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			okPerformed();
		}
	}
	
	private class CancelSwingAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			cancelPerformed();
		}
	}
	
	public void okPerformed(){
		
	}
	public void cancelPerformed(){
		getFrame().dispose();
	}
}
