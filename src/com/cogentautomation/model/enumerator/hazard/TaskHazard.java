package com.cogentautomation.model.enumerator.hazard;

import java.io.Serializable;

import com.cogentautomation.model.enumerator.hazard.generic.GenericConsequence;
import com.cogentautomation.model.enumerator.hazard.generic.GenericOrigin;
import com.cogentautomation.model.enumerator.hazard.generic.GenericType;
import com.cogentautomation.model.enumerator.hazard.shared.StringConsequence;
import com.cogentautomation.model.enumerator.hazard.task.TaskOrigin;
import com.cogentautomation.model.enumerator.hazard.task.TaskType;

public class TaskHazard extends GenericHazard implements GenericHazardInterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TaskType type;
	private TaskOrigin origin;
	private StringConsequence consequence = new StringConsequence();
	
	public TaskHazard (GenericType type, GenericOrigin origin) {
		setType(type);
		setOrigin(origin);
	}
	public GenericType getType() {
		return type;
	}
	public void setType(GenericType type) {
		this.type = (TaskType) type;
	}
	/*public List<TaskOrigin> getOrigins(TaskType type) {
		return TaskOrigin.getValues(type);
	}*/
	public GenericOrigin getOrigin() {
		return origin;
	}
	public void setOrigin(GenericOrigin origin) {
		for (TaskType types: ((TaskOrigin) origin).getTypes()) {
			if (types == type) {
				this.origin = (TaskOrigin) origin;
				break;
			}
		}
	}
	public GenericConsequence getConsequence() {
		return consequence;
	}
	public void setConsequence(GenericConsequence consequence) {
		if (origin != null) {
			this.consequence = (StringConsequence) consequence;
		};
	}
	public String toString() {
		return getOrigin().toString();
	}
}
