package prog3060.jwong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Age", schema="APP")
public class Age {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ageID", nullable=false)
	private int ageID;
	
	@ManyToOne
	@JoinColumn(name="ageGroup", nullable=false)
	private AgeGroup ageGroup;
	
	@ManyToOne
	@JoinColumn(name="censusYear", nullable=false)
	private CensusYear censusYear;
	
	@ManyToOne
	@JoinColumn(name="geographicArea", nullable=false)
	private GeographicArea geographicArea;
	
	@Column(name="combined", nullable=false)
	private int combined;
	
	@Column(name="male", nullable=false)
	private int male;
	
	@Column(name="female", nullable=false)
	private int female;
	
	public Age() {
		
	}

	public int getAgeID() {
		return ageID;
	}

	public void setAgeID(int ageID) {
		this.ageID = ageID;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public CensusYear getCensusYear() {
		return censusYear;
	}

	public void setCensusYear(CensusYear censusYear) {
		this.censusYear = censusYear;
	}

	public GeographicArea getGeographicArea() {
		return geographicArea;
	}

	public void setGeographicArea(GeographicArea geographicArea) {
		this.geographicArea = geographicArea;
	}

	public int getCombined() {
		return combined;
	}

	public void setCombined(int combined) {
		this.combined = combined;
	}

	public int getMale() {
		return male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	public int getFemale() {
		return female;
	}

	public void setFemale(int female) {
		this.female = female;
	}

	
}
