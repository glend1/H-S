package com.cogentautomation.view.customrenderers;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;

import com.cogentautomation.controller.listeners.HazardListener;
import com.cogentautomation.model.enumerator.HazardSelection;
import com.cogentautomation.model.enumerator.hazard.GenericHazard;

public class HazardEditor extends AbstractCellEditor implements TreeCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenericHazard hazard;
	private JComboBox<?> comboBox;
	private HazardListener hazardListener;
	private HazardListener hazardListener2;
	
	public void setHazardListener(HazardListener listener) {
		hazardListener = listener;
	}
	
	public void setHazardListener2(HazardListener listener) {
		hazardListener2 = listener;
	}

	@Override
	public Component getTreeCellEditorComponent(JTree tree, Object value,
			boolean isSelected, boolean expanded, boolean leaf, int row) {
		
		HazardComboBox component = null;
		
		if(leaf) {
			
			DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)value;
			hazard = (GenericHazard)treeNode.getUserObject();
			HazardRenderer renderer = new HazardRenderer();
			component = (HazardComboBox)renderer.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, true);			
			comboBox = component.getComboBox();
			
			ItemListener itemListener = new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					comboBox.removeItemListener(this);
					fireEditingStopped();
				}
			};
			
			comboBox.addItemListener(itemListener);

		}
		return component;
	}

	@Override
	public Object getCellEditorValue() {
		hazard.setHazard((HazardSelection)comboBox.getSelectedItem());
		hazardListener.hazardEmitted(hazard);
		hazardListener2.hazardEmitted(hazard);
		return hazard;
	}

	@Override
	public boolean isCellEditable(EventObject event) {
		
		if (!(event instanceof MouseEvent)) {
			return false;
		}
		
		MouseEvent mouseEvent = (MouseEvent)event;
		JTree tree = (JTree)event.getSource();
		
		TreePath path = tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
		
		if (path == null) {
			return false;
		}
		
		Object lastComponent = path.getLastPathComponent();
		
		if (lastComponent == null) {
			return false;
		}
		
		DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)lastComponent;
		
		return treeNode.isLeaf();
	}

}
