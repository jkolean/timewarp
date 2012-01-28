package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.binding.As;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class TimeEntry extends Model {
	@Required
	@As("MM/dd/yyyy h:mm a")
	public Date start;
	@Required
	@As("MM/dd/yyyy h:mm a")
	public Date end;
	@ManyToOne
	@Required
	public Task task;

	/**
	 * @return duration in milliseconds
	 */
	public long getDurationTime() {
		return end.getTime() - start.getTime();
	}

	/**
	 * @return duration in milliseconds
	 */
	public long getDurationHours() {
		return getDurationTime() / (1000 * 60 * 60);
	}

	/**
	 * @return duration in milliseconds
	 */
	public long getDurationMinutes() {
		return (getDurationTime() / (1000 * 60)) % 60;
	}

	public String toString() {
		long hours = getDurationHours();
		long min = getDurationMinutes();
		String minString = "";
		if (min < 10) {
			minString += "0";
		}
		minString += min;
		return task.toString() + " " + hours + ":" + minString;
	}
}
