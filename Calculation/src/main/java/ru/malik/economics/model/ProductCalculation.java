/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.economics.model;

import java.util.HashSet;

// Start of user code (user defined imports)

// End of user code

/**
 * ����������� ��������
 * 
 * @author �����
 */
public class ProductCalculation {
	/**
	 * Description of the property workVolumes.
	 */
	public HashSet<WorkVolume> workVolumes = new HashSet<WorkVolume>();

	/**
	 * Description of the property resources.
	 */
	public HashSet<Resource> resources = new HashSet<Resource>();

	// Start of user code (user defined attributes for ProductCalculation)

	// End of user code

	/**
	 * The constructor.
	 */
	public ProductCalculation() {
		// Start of user code constructor for ProductCalculation)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for ProductCalculation)

	// End of user code
	/**
	 * Returns workVolumes.
	 * @return workVolumes 
	 */
	public HashSet<WorkVolume> getWorkVolumes() {
		return this.workVolumes;
	}

	/**
	 * Returns resources.
	 * @return resources 
	 */
	public HashSet<Resource> getResources() {
		return this.resources;
	}

}
