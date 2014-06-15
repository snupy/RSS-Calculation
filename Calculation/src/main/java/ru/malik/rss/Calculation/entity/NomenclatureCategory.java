package ru.malik.rss.Calculation.entity;

import java.util.ArrayList;
import java.util.List;

public class NomenclatureCategory {
	private String name;
	private Long id;
	private NomenclatureCategory owner;
	private List<NomenclatureCategory> childrens = new ArrayList<NomenclatureCategory>();
	private List<Nomenclature> nomenclatures = new ArrayList<Nomenclature>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public NomenclatureCategory getOwner() {
		return owner;
	}
	public void setOwner(NomenclatureCategory owner) {
		this.owner = owner;
	}
	public List<NomenclatureCategory> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<NomenclatureCategory> childrens) {
		this.childrens = childrens;
	}
	public List<Nomenclature> getNomenclatures() {
		return nomenclatures;
	}
	public void setNomenclatures(List<Nomenclature> nomenclatures) {
		this.nomenclatures = nomenclatures;
	}
	
	
}
