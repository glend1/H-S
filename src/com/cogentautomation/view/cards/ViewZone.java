package com.cogentautomation.view.cards;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeModel;

import com.cogentautomation.controller.ZoneController;
import com.cogentautomation.controller.listeners.FileListener;
import com.cogentautomation.controller.listeners.HazardListener;
import com.cogentautomation.controller.listeners.ImageListener;
import com.cogentautomation.model.Zone;
import com.cogentautomation.model.enumerator.hazard.GenericHazard;
import com.cogentautomation.view.ViewImageChooser;
import com.cogentautomation.view.customrenderers.HazardEditor;
import com.cogentautomation.view.customrenderers.HazardRenderer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewZone extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fldName;
	private JTextField fldImage;
	private ViewImageChooser fileChooser;
	private ImageListener imageListener;
	private HazardEditor hazardEditor = new HazardEditor();
	private Zone zone;
	private JTextPane fldDescription;
	private JTree tree;
	
	public void setImageListener(ImageListener listener) {
		imageListener = listener;
	}
	
	public void setHazardListener(HazardListener listener) {
		 hazardEditor.setHazardListener(listener);
	}
	
	public void loadData(Zone z) {
		zone = z;
		fldName.setText(zone.getName());
		if (zone.getImage().getImageBytes() != null) {
			fldImage.setText(zone.getImage().getFilename());
			imageListener.imageEmitted(zone.getImage().getImage());
		};
		fldDescription.setText(zone.getDescription());
		/*if (zone.getModel() != null) {
			tree.setModel(zone.getModel());
		} else {
			ZoneTree zt = new ZoneTree();
			tree.setModel(zt.getZoneTree());
		};*/
		tree.setModel(newTree(zone));
		DefaultTreeModel dtm = (DefaultTreeModel)tree.getModel();
		dtm.reload();
	}
	
	/**
	 * Create the panel.
	 */
	public ViewZone() {
		setLayout(new MigLayout("", "[][grow][]", "[][][][grow]"));
		
		JLabel lblName = new JLabel("Name");
		add(lblName, "cell 0 0,alignx trailing");
		
		fldName = new JTextField();
		fldName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				zone.setName(fldName.getText());
			}
		});
		lblName.setLabelFor(fldName);
		add(fldName, "cell 1 0 2 1,growx");
		fldName.setColumns(10);
		
		JLabel lblImage = new JLabel("Image");
		add(lblImage, "cell 0 1,alignx trailing");
		
		fldImage = new JTextField();
		lblImage.setLabelFor(fldImage);
		fldImage.setEditable(false);
		add(fldImage, "cell 1 1,growx");
		fldImage.setColumns(10);
		
		
		JButton btnImage = new JButton("Add Image...");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new ViewImageChooser();
				fileChooser.setFileListener(new FileListener() {
					@Override
					public void fileEmitted(File file) {
						ImageIcon image = new ImageIcon(file.toString());
						zone.setImage(image);
						fldImage.setText(file.getName());
						imageListener.imageEmitted(image);
					}
				});
				fileChooser.setVisible(true);
			}
		});
		add(btnImage, "cell 2 1");
		
		JLabel lblDescription = new JLabel("Description");
		add(lblDescription, "cell 0 2,aligny top");
		
		fldDescription = new JTextPane();
		fldDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				zone.setDescription(fldDescription.getText());
			}
		});
		lblDescription.setLabelFor(fldDescription);
		fldDescription.setBorder(UIManager.getBorder("TextField.border"));
		fldDescription.setMaximumSize(new Dimension(2147483647, 200));
		fldDescription.setMinimumSize(new Dimension(4, 100));
		add(fldDescription, "cell 1 2 2 1,grow");
		
		hazardEditor.setHazardListener2(new HazardListener() {
			@Override
			public void hazardEmitted(GenericHazard hazard) {
				GenericHazard isset = null; 
				//zone.setModel((DefaultTreeModel)tree.getModel());
				for (GenericHazard iHazard : zone.getHazards().getHazards()) {
					if (hazard.compareTo(iHazard)) {
						isset = iHazard;
						break;
					}
				}
				if (isset != null) {
					isset.setHazard(hazard.getHazard());
				} else {
					zone.getHazards().newHazard(hazard);
				}
			};
		});
		tree = new JTree();
		tree.setEditable(true);
		tree.setRootVisible(false);
		tree.setCellRenderer(new HazardRenderer());
		tree.setCellEditor(hazardEditor);
		tree.setModel(newTree(zone));
		add(tree, "cell 0 3 3 1,grow");

	}
	
	public JTextField getTextField() {
		return fldName;
	}

	public void clear() {
		fldName.setText(null);
		fldImage.setText(null);
		fldDescription.setText(null);
		tree.setModel(newTree(zone));
		DefaultTreeModel dtm = (DefaultTreeModel)tree.getModel();
		dtm.reload();
	}
	
	public DefaultTreeModel newTree(Zone zone) {
		ZoneController zc = new ZoneController();
		return zc.newData(zone);
	}
}
