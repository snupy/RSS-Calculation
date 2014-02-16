package ru.malik.rss.Calculation.mvc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ru.malik.economics.model.Nomenclature;
import ru.malik.economics.model.UnitOfMeasure;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class NomenclatureListFrame extends DefaultListFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NomenclatureListFrame frame = new NomenclatureListFrame();
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
	public NomenclatureListFrame() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ArrayList<Nomenclature> nomenclatures = new ArrayList<Nomenclature>();
		{
			nomenclatures.add(new Nomenclature());
			nomenclatures.get(nomenclatures.size() - 1).setName("Гвоздь");
			nomenclatures.get(nomenclatures.size() - 1).setUnitOfMeasures(
					new UnitOfMeasure());
			nomenclatures.add(new Nomenclature());
			nomenclatures.get(nomenclatures.size() - 1).setName("Гвоздь2");
			nomenclatures.get(nomenclatures.size() - 1).setUnitOfMeasures(
					new UnitOfMeasure());
		}
		NomenclatureListPanel nomenclatureListPanel = new NomenclatureListPanel(
				nomenclatures);
		getContentPane().add(nomenclatureListPanel, BorderLayout.CENTER);

	}

}
