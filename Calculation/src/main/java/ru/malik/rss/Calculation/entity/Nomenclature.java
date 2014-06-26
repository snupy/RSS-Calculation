/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.rss.Calculation.entity;

// Start of user code (user defined imports)

// End of user code

/**
 * ???????????? ? ??????? ????? ???? ?????.
 * 
 * @author ?????
 */
/**
 * @author Малик
 *
 */
public class Nomenclature {
	private Long id = Long.valueOf(0L);
	private NomenclatureCategory nomenclatureCategory;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void test(){
		System.out.println(unitOfMeasures);
		System.out.println(getUnitOfMeasures());
	}
	
	/**
	 * Description of the property unitOfMeasures.
	 */
	public UnitOfMeasure unitOfMeasures = null;

	/**
	 * Description of the property Name.
	 */
	private String Name = "";

	// Start of user code (user defined attributes for Nomenclature)

	// End of user code

	/**
	 * The constructor.
	 */
	public Nomenclature() {
		// Start of user code constructor for Nomenclature)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Nomenclature)

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
	 * Returns Name.
	 * @return Name 
	 */
	public String getName() {
		return this.Name;
	}

	/**
	 * Sets a value to attribute Name. 
	 * @param newName 
	 */
	public void setName(String newName) {
		this.Name = newName;
	}

	public NomenclatureCategory getNomenclatureCategory() {
		return nomenclatureCategory;
	}

	public void setNomenclatureCategory(NomenclatureCategory nomenclatureCategory) {
		this.nomenclatureCategory = nomenclatureCategory;
	}

	
	
}
