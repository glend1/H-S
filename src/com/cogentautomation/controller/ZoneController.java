package com.cogentautomation.controller;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.cogentautomation.model.Zone;
import com.cogentautomation.model.enumerator.hazard.EventHazard;
import com.cogentautomation.model.enumerator.hazard.GenericHazard;
import com.cogentautomation.model.enumerator.hazard.OriginHazard;
import com.cogentautomation.model.enumerator.hazard.TaskHazard;
import com.cogentautomation.model.enumerator.hazard.event.EventOrigin;
import com.cogentautomation.model.enumerator.hazard.event.EventType;
import com.cogentautomation.model.enumerator.hazard.origin.OriginConsequence;
import com.cogentautomation.model.enumerator.hazard.origin.OriginOrigin;
import com.cogentautomation.model.enumerator.hazard.origin.OriginType;
import com.cogentautomation.model.enumerator.hazard.task.TaskOrigin;
import com.cogentautomation.model.enumerator.hazard.task.TaskType;

public class ZoneController {
	
	public DefaultTreeModel newData(Zone zone) {
		return new DefaultTreeModel(
				new DefaultMutableTreeNode("JTree") {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					{
						DefaultMutableTreeNode event = new DefaultMutableTreeNode("Event");
						for (EventType et: EventType.values()) {
							DefaultMutableTreeNode eos = new DefaultMutableTreeNode(et);
							for (EventOrigin eo: EventOrigin.getValues(et)) {
								eos.add(new DefaultMutableTreeNode(find(zone, new EventHazard(et, eo))));
							}
							event.add(eos);
						}
						add(event);
						DefaultMutableTreeNode origin = new DefaultMutableTreeNode("Origin");
						for (OriginType ot: OriginType.values()) {
							DefaultMutableTreeNode oos = new DefaultMutableTreeNode(ot);
							for (OriginOrigin oo: OriginOrigin.getValues(ot)) {
								DefaultMutableTreeNode oon = new DefaultMutableTreeNode(oo);
								for (OriginConsequence oc: OriginConsequence.getValues(ot, oo)) {
									oon.add(new DefaultMutableTreeNode(find(zone, new OriginHazard(ot, oo, oc))));
								}
								oos.add(oon);
							}
							origin.add(oos);;
						}
						add(origin);
						DefaultMutableTreeNode task = new DefaultMutableTreeNode("Task");
						for (TaskType tt: TaskType.values()) {
							DefaultMutableTreeNode tts = new DefaultMutableTreeNode(tt);
							for (TaskOrigin to: TaskOrigin.getValues(tt)) {
								tts.add(new DefaultMutableTreeNode(find(zone, new TaskHazard(tt, to))));
							}
							task.add(tts);
						}
						add(task);
					}
				}
			);
	}
	
	private GenericHazard find(Zone zone, GenericHazard gh) {
		GenericHazard hazard = gh;
		if (zone != null) {
			for (GenericHazard lh : zone.getHazards().getHazards()) {
				if (gh.compareTo(lh)) {
					hazard = lh;
					break;
				}
			}
		}
		return hazard;
	}

}
