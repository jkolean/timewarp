package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Task extends Model {
	@Required
	@Unique
	public String name;
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	public List<TimeEntry> timeEntry;
	public String toString(){
		return name;
	}
}
