/**
 * 
 */
package com.apimsmicroprofiletomeemaven.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author eloi
 *
 */
@Entity
@Table(name = "color")
@NamedQueries({ @NamedQuery(name = "Color_findAll", query = "SELECT t FROM Color t") })
public class Color implements Serializable {

	private static final long serialVersionUID = -2610127234872198089L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;

	public Color() {
	}

	public Color(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		Color other = (Color) obj;
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
		builder.append("Color: [id=").append(id.toString()).append(", description=").append(description).append("]");
		return builder.toString();
	}

}
