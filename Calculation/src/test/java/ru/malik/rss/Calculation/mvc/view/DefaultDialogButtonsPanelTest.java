package ru.malik.rss.Calculation.mvc.view;

import static org.junit.Assert.*;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.Test;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class DefaultDialogButtonsPanelTest {

	@Test
	public void testDefaultDialogButtonsPanel() {
		ActionListener actionListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		};
		ArrayList<JButton> buttons = new ArrayList<JButton>();

		buttons.add(DialogButtonsFactory.createJButton(
				DialogButtonsFactory.DB_OK, actionListener));
		buttons.add(DialogButtonsFactory.createJButton(
				DialogButtonsFactory.DB_CANCEL, actionListener));
		DefaultDialogButtonsPanel testPanel = new DefaultDialogButtonsPanel(
				buttons);

		assertNotNull("Объект не создается", testPanel);
	}

	@Test
	public void testCreateDefaultDialogButtonsOkCancelPanel() {

		ActionListener actionListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		};

		DefaultDialogButtonsPanel testPanel = DefaultDialogButtonsPanel
				.createDefaultDialogButtonsOkCancelPanel(actionListener,
						actionListener);
		assertNotNull("Объект не создается", testPanel);
	}

	/*@Test
	public void testGUITest() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		ActionListener acl1 = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		};

		ActionListener acl2 = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		};
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		new DialogButtonsFactory();
		buttons.add(DialogButtonsFactory.createJButton(
				DialogButtonsFactory.DB_OK, acl1));
		buttons.add(DialogButtonsFactory.createJButton(
				DialogButtonsFactory.DB_CANCEL, acl2));
		
		DefaultDialogButtonsPanel panel = new DefaultDialogButtonsPanel(buttons);
		
		frame.add(panel);
		frame.pack();
		
		
	}*/
}
