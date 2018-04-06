package com.cogentautomation.view.customrenderers;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

import com.cogentautomation.model.enumerator.hazard.GenericHazard;

public class HazardRenderer implements TreeCellRenderer {
	private HazardComboBox leafRenderer = new HazardComboBox();
	private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();
	private GenericHazard hazard;

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object treeNode, boolean selected, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		if (leaf) {
			hazard = (GenericHazard)((DefaultMutableTreeNode)treeNode).getUserObject();
			leafRenderer.setText(hazard.toString());
			leafRenderer.setHazard(hazard.getHazard());
			return leafRenderer;
		}
		return nonLeafRenderer.getTreeCellRendererComponent(tree, treeNode, selected, expanded, leaf, row, hasFocus);
	}

}
