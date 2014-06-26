/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.rss.Calculation.entity;

import ru.malik.rss.Calculation.entity.Resource;

public class MaterialResource extends Resource {
	/*public Double volume;
	
	public Long id;*/

	public Nomenclature nomenclatures;

	/*public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}*/

	public Nomenclature getNomenclatures() {
		return nomenclatures;
	}

	public void setNomenclatures(Nomenclature nomenclatures) {
		this.nomenclatures = nomenclatures;
	}

	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/


}
