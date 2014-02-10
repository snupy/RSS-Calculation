/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.economics.model;

import java.util.HashSet;

// Start of user code (user defined imports)

// End of user code

/**
 * ����� "������". ��������: ������ �� ������� ������; ������ �� �������� ����.
 * 
 * @author �����
 */
public class Work {
	/**
	 * Description of the property unitOfMeasures.
	 */
	public UnitOfMeasure unitOfMeasures = null;

	/**
	 * Description of the property resources.
	 */
	public HashSet<Resource> resources = new HashSet<Resource>();

	/**
	 * Description of the property workVolumes.
	 */
	public HashSet<WorkVolume> workVolumes = new HashSet<WorkVolume>();

	/**
	 * Description of the property name.
	 */
	public String name = "";

	// Start of user code (user defined attributes for Work)

	// End of user code

	/**
	 * The constructor.
	 */
	public Work() {
		// Start of user code constructor for Work)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Work)

	// End of user code
	/**
	 * Returns unitOfMeasures.
	 * @return unitOfMeasures 
	 */
	public UnitOfMeasure getUnitOfMeasures() {
		return this.unitOfMeasures;
	}

	/**
	 * Sets a value to attribute unitOfMeasures. 
	 * @param newUnitOfMeasures 
	 */
	public void setUnitOfMeasures(UnitOfMeasure newUnitOfMeasures) {
		this.unitOfMeasures = newUnitOfMeasures;
	}

	/**
	 * Returns resources.
	 * @return resources 
	 */
	public HashSet<Resource> getResources() {
		return this.resources;
	}

	/**
	 * Returns workVolumes.
	 * @return workVolumes 
	 */
	public HashSet<WorkVolume> getWorkVolumes() {
		return this.workVolumes;
	}

	/**
	 * Returns name.
	 * @return name 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets a value to attribute name. 
	 * @param newName 
	 */
	public void setName(String newName) {
		this.name = newName;
	}

}
