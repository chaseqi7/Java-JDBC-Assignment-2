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
@Table(name="AgeGroup", schema="APP")
public class AgeGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ageGroupID", nullable=false)
	private int ageGroupID;
	
	@Column(name="DESCRIPTION", nullable=false)
	private String description;
	
	@OneToMany(mappedBy="ageGroup")
	private Set<Age> ages = new HashSet<Age>();
	
	public AgeGroup() {
		
	}

	public int getAgeGroupID() {
		return ageGroupID;
	}

	public void setAgeGroupID(int ageGroupID) {
		this.ageGroupID = ageGroupID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Age> getAges() {
		return ages;
	}

	public void setAges(Set<Age> ages) {
		this.ages = ages;
	}
}
