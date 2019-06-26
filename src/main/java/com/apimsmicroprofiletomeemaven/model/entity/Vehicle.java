/**
 * 
 */
package com.apimsmicroprofiletomeemaven.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author eloi
 *
 */
@Entity
@Table(name = "vehicle")
@NamedQueries({ @NamedQuery(name = "Vehicle_findAll", query = "SELECT t FROM Vehicle t") })
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 3271704991172089926L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Color color;
	private String plate;
	private Integer modelYear;
	private LocalDateTime updatedIn;
	private Integer manufactureYear;
	private boolean active;

	public Vehicle() {
	}

	public Vehicle(Long id, Color color, String plate, Integer modelYear, LocalDateTime updatedIn,
			Integer manufactureYear, boolean active) {
		this.id = id;
		this.color = color;
		this.plate = plate;
		this.modelYear = modelYear;
		this.updatedIn = updatedIn;
		this.manufactureYear = manufactureYear;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Integer getModelYear() {
		return modelYear;
	}

	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}

	public LocalDateTime getUpdatedIn() {
		return updatedIn;
	}

	public void setUpdatedIn(LocalDateTime updatedIn) {
		this.updatedIn = updatedIn;
	}

	public Integer getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(Integer manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id.toString() == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Vehicle: [id=").append(id.toString()).append(", plate=").append(plate).append("]");
		return builder.toString();
	}

}
