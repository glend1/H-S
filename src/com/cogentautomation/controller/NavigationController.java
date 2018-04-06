package com.cogentautomation.controller;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.cogentautomation.model.Data;
import com.cogentautomation.model.Machine;
import com.cogentautomation.model.Person;
import com.cogentautomation.model.Zone;
import com.cogentautomation.model.enumerator.HazardSelection;
import com.cogentautomation.model.enumerator.hazard.GenericHazard;

public class NavigationController {
	public DefaultTreeModel newData(Data data) {
		return new DefaultTreeModel(
				new DefaultMutableTreeNode("Data") {

					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					{
						DefaultMutableTreeNode node_1;
						DefaultMutableTreeNode node_2;
						DefaultMutableTreeNode node_3;
						add(new DefaultMutableTreeNode(data));
						node_1 = new DefaultMutableTreeNode("People");
							for (Person person : data.getPeople().getPeople()) {
								node_1.add(new DefaultMutableTreeNode(person));
							}
						add(node_1);
						for (Machine machine : data.getMachines().getMachines()) {
							node_1 = new DefaultMutableTreeNode(machine);
							for (Zone zone : machine.getZones().getZones()) {
								node_2 = new DefaultMutableTreeNode(zone);
								for (GenericHazard hazard : zone.getHazards().getHazards()) {
									//TODO: generate tree structure like how it is in the hazard list
									if (hazard.getHazard() == HazardSelection.HAZARD) {
										node_3 = new DefaultMutableTreeNode(hazard);
										node_2.add(node_3);
									}
								}
								node_1.add(node_2);
							}
							add(node_1);
						}
						add(new DefaultMutableTreeNode(data.getConclusion()));
					}
				}
			);
	}
}