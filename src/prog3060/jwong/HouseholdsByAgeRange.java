package prog3060.jwong;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="HouseholdsByAgeRange", schema="APP")
public class HouseholdsByAgeRange {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="description", nullable=false)
	private String description;

	@OneToMany(mappedBy="householdsByAgeRange")
	private Set<Household> households = new HashSet<Household>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Household> getHouseholds() {
		return households;
	}

	public void setHouseholds(Set<Household> households) {
		this.households = households;
	}
}
