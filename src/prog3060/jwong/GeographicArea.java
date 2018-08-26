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
@Table(name="GeographicArea", schema="APP")
public class GeographicArea {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="geographicAreaId", nullable=false)
	private int geographicAreaId;
	
	@Column(name="code", nullable=false)
	private int code;
	
	@Column(name="level", nullable=false)
	private int level;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="alternativeCode", nullable=false)
	private int alternativeCode;
	
	@OneToMany(mappedBy="geographicArea")
	private Set<Household> households = new HashSet<Household>();
	
	@OneToMany(mappedBy="geographicArea")
	private Set<Age> ages = new HashSet<Age>();
	
	public GeographicArea() {
		
	}

	public int getGeographicAreaId() {
		return geographicAreaId;
	}

	public void setGeographicAreaId(int geographicAreaId) {
		this.geographicAreaId = geographicAreaId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlternativeCode() {
		return alternativeCode;
	}

	public void setAlternativeCode(int alternativeCode) {
		this.alternativeCode = alternativeCode;
	}

	public Set<Household> getHouseholds() {
		return households;
	}

	public void setHouseholds(Set<Household> households) {
		this.households = households;
	}

	public Set<Age> getAges() {
		return ages;
	}

	public void setAges(Set<Age> ages) {
		this.ages = ages;
	}

}
