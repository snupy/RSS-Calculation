package ru.malik.rss.Calculation.mvc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ru.malik.economics.model.Nomenclature;

import java.awt.BorderLayout;

public class NomenclatureEditFrame extends DefaultEditFrame {

	private Nomenclature model;
	private NomenclaturePanel nomenclaturePanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NomenclatureEditFrame frame = new NomenclatureEditFrame(new Nomenclature());
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
	public NomenclatureEditFrame(Nomenclature model) {
		this();
		setModel(model);

	}
	
	public NomenclatureEditFrame(){
		super();
		createFrame();
		
	}

	protected void createFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nomenclaturePanel = new NomenclaturePanel();
		getContentPane().add(nomenclaturePanel, BorderLayout.CENTER);
		this.pack();
	}

	public Nomenclature getModel() {
		return model;
	}

	public void setModel(Nomenclature model) {
		this.model = model;
		nomenclaturePanel.setModel(model);
	}

	public NomenclaturePanel getNomenclaturePanel() {
		return nomenclaturePanel;
	}

	@Override
	public void save() {
		getNomenclaturePanel().save();
		super.save();
	}
	
}
