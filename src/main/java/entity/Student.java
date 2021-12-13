package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Student")
public class Student {	
	
	@OneToMany(mappedBy="id", cascade={CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	private List<StudentDetail> details;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="St_id")
	private int id;
	
	@Column(name="St_detail_id")
	private int detailId;
	
	@Column(name="St_name")
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void add(StudentDetail tempDetail) {
		if(details == null) {
			
		}
		details.add(tempDetail);
		tempDetail.setStudent(this);
	}
}
