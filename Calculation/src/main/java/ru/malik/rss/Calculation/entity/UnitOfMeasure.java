/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.rss.Calculation.entity;

// Start of user code (user defined imports)

// End of user code

/**
 * Единица измерения
 * 
 * @author Малик
 */
public class UnitOfMeasure implements Cloneable{
	/**
	 * Description of the property name.
	 */
	private String name = "";
	private String shortName = "";
	private String codeOKEI = "";
	
	/**
	 * Description of the property id.
	 */
	public Long id = Long.valueOf(0L);
	
	// Start of user code (user defined attributes for UnitOfMeasure)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public UnitOfMeasure() {
		// Start of user code constructor for UnitOfMeasure)
		super();
		// End of user code
	}
	
	// Start of user code (user defined methods for UnitOfMeasure)
	
	// End of user code
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

	/**
	 * Returns id.
	 * @return id 
	 */
	public Long getId() {
		return this.id;
	}
	
	/**
	 * Sets a value to attribute id. 
	 * @param newId 
	 */
	public void setId(Long newId) {
	    this.id = newId;
	}
	
	

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getCodeOKEI() {
		return codeOKEI;
	}

	public void setCodeOKEI(String codeOKEI) {
		this.codeOKEI = codeOKEI;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		UnitOfMeasure unitOfMeasureClone = (UnitOfMeasure) super.clone();
		return unitOfMeasureClone;
	}

	

}
