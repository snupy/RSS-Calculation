package ru.malik.rss.Calculation.mvc.view;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.Test;

public class DialogButtonsFactoryTest {

	public boolean acFire = false;
	
	@Test
	public void testCreateJButton() {
		
		ActionListener testActionListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				acFire = true;
			}
		};
		JButton testButton = null;

		{// Проверка на создание кнопки
			try {
				testButton = DialogButtonsFactory.createJButton("Test",
						testActionListener);
			} catch (Exception e) {
				fail("Ошибка создания кнопки");
			}

			assertNotNull("Кнопка не создалась", testButton);
		}

		{// Проверка на создание кнопки по константной надписи
			try {
				testButton = DialogButtonsFactory.createJButton(
						DialogButtonsFactory.DB_OK, testActionListener);
			} catch (Exception e) {
				fail("Ошибка создания кнопки");
			}
			assertNotNull("Кнопка не создалась", testButton);
		}

		{// Проверка на срабатывание на нажатие клавиши
			JFrame frame = new JFrame() {

				{
					setVisible(true);
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			};
			frame.setAlwaysOnTop(true);

			Point buttonPoint = frame.add(testButton).getLocationOnScreen();

			frame.pack();
			try {
				Robot robot = new Robot(frame.getGraphicsConfiguration()
						.getDevice());
				robot.mouseMove(buttonPoint.x + testButton.getWidth() / 2,
						buttonPoint.y + testButton.getHeight() / 2);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.setAutoWaitForIdle(true);
				robot.setAutoDelay(100);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				
				assertTrue("Не сработало на нажатие клавиши",acFire);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
			frame.hide();
		}

	}

}
