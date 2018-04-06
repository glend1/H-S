package com.cogentautomation.view.customrenderers;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

import com.cogentautomation.model.enumerator.HazardSelection;

public class HazardComboBox extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblLabel = new JLabel("");
	private JComboBox<?> comboBox = new JComboBox<Object>(HazardSelection.values());
	
	public HazardComboBox() {
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(HazardComboBox.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		add(label);
		
		comboBox.setBorder(new EmptyBorder(2, 5, 2, 5));
		comboBox.setBackground(Color.WHITE);
		add(comboBox);
		
		lblLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblLabel);
	}

	public JComboBox<?> getComboBox() {
		return comboBox;
	}

	public JLabel getLabel() {
		return lblLabel;
	}
	
	public void setText(String name) {
		getLabel().setText(name);
	}
	
	public void setHazard(HazardSelection obj) {
		getComboBox().setSelectedItem(obj);
	}

}
