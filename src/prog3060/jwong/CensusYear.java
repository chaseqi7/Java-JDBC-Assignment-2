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
@Table(name="CensusYear", schema="APP")
public class CensusYear {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="censusYearID", nullable=false)
	private int censusYearID;
	
	@Column(name="CENSUSYEAR", nullable=false)
	private int censusYear;
	
	@OneToMany(mappedBy="censusYear")
	private Set<Age> ages = new HashSet<Age>();
	
	@OneToMany(mappedBy="censusYear")
	private Set<Household> households = new HashSet<Household>();
	
	
	public CensusYear() {
		
	}

	public int getCensusYearID() {
		return censusYearID;
	}

	public void setCensusYearID(int censusYearID) {
		this.censusYearID = censusYearID;
	}

	public int getCensusYear() {
		return censusYear;
	}

	public void setCensusYear(int censusYear) {
		this.censusYear = censusYear;
	}

	public Set<Age> getAges() {
		return ages;
	}

	public void setAges(Set<Age> ages) {
		this.ages = ages;
	}

	public Set<Household> getHouseholds() {
		return households;
	}

	public void setHouseholds(Set<Household> households) {
		this.households = households;
	}
}
