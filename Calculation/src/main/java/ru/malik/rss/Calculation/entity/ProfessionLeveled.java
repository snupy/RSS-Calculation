/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.rss.Calculation.entity;

import ru.malik.rss.Calculation.entity.Profession;

// End of user code

/**
 * ????????? ???????? ?? ??????
 * 
 * @author ?????
 */
public class ProfessionLeveled extends Profession {
	/**
	 * Description of the property levelName.
	 */
	public String levelName = "";

	// Start of user code (user defined attributes for ProfessionLeveled)

	// End of user code

	/**
	 * The constructor.
	 */
	public ProfessionLeveled() {
		// Start of user code constructor for ProfessionLeveled)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for ProfessionLeveled)

	// End of user code
	/**
	 * Returns levelName.
	 * @return levelName 
	 */
	public String getLevelName() {
		return this.levelName;
	}

	/**
	 * Sets a value to attribute levelName. 
	 * @param newLevelName 
	 */
	public void setLevelName(String newLevelName) {
		this.levelName = newLevelName;
	}

}
