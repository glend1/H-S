package com.cogentautomation.view.cards;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import com.cogentautomation.controller.listeners.FileListener;
import com.cogentautomation.controller.listeners.ImageListener;
import com.cogentautomation.model.Machine;
import com.cogentautomation.view.ViewImageChooser;

import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import net.miginfocom.swing.MigLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ViewMachine extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fldName;
	private JTextField fldDescription;
	private JTextField fldType;
	private JTextField fldManufacturer;
	private JTextField fldSerial;
	private JTextField fldCertification;
	private JTextField fldImage;
	private JTextField fldLimits;
	private JTextField fldLocation;
	private JTextField fldModel;
	private JTextField fldModifications;
	private JTextField fldEnergySources;
	private JTextField fldEnergyRatings;
	private JTextField fldSafetyMeasures;
	private JTextField fldOperatingManuals;
	private JTextField fldOperatingProcedures;
	private JTextField fldTrainingRecords;
	private JTextField fldWarningSigns;
	private JTextField fldRawMaterials;
	private JTextField fldMaintenanceManual;
	private JTextField fldMaintenanceTrainingRecords;
	private JTextField fldUntrainedAccess;
	private ViewImageChooser fileChooser;
	private DatePicker datePicker;
	private ImageListener imageListener;
	private Machine machine; 
	private JTextPane fldLongDescription;
	private JSpinner fldOperatorCount;
	private JSpinner fldShiftCount;
	private JSpinner fldMonthlyHours;
	
	public void setImageListener(ImageListener listener) {
		imageListener = listener;
	}
	
	public void loadData(Machine m) {
		machine = m;
		fldName.setText(machine.getName());
		fldDescription.setText(machine.getDescription());
		fldType.setText(machine.getType());
		fldManufacturer.setText(machine.getManufacturer());
		fldSerial.setText(machine.getSerial());
		fldCertification.setText(machine.getCertification());
		if (machine.getImage().getImageBytes() != null) {
			fldImage.setText(machine.getImage().getFilename());
			imageListener.imageEmitted(machine.getImage().getImage());
		};
		fldLimits.setText(machine.getLimits());
		fldLocation.setText(machine.getLocation());
		fldModel.setText(machine.getModel());
		fldModifications.setText(machine.getModifications());
		fldEnergySources.setText(machine.getEnergySources());
		fldEnergyRatings.setText(machine.getEnergyRatings());
		fldSafetyMeasures.setText(machine.getSafetyMeasures());
		fldOperatingManuals.setText(machine.getOperatingManuals());
		fldOperatingProcedures.setText(machine.getOperatingProcedures());
		fldTrainingRecords.setText(machine.getTrainingRecords());
		fldWarningSigns.setText(machine.getWarningSigns());
		fldRawMaterials.setText(machine.getRawMaterials());
		fldMaintenanceManual.setText(machine.getMaintenanceManual());
		fldMaintenanceTrainingRecords.setText(machine.getMaintenanceTrainingRecord());
		fldUntrainedAccess.setText(machine.getUntrainedAccess());
		datePicker.setValue(machine.getBuilt());
		fldLongDescription.setText(machine.getLongDescription());
		fldOperatorCount.setValue(machine.getOperatorCount());
		fldShiftCount.setValue(machine.getShiftCount());
		fldMonthlyHours.setValue(machine.getMonthlyHours());
	}
	
	/**
	 * Create the panel.
	 */
	public ViewMachine() {
		setLayout(new MigLayout("", "[][grow][]", "[][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblName = new JLabel("Name");
		add(lblName, "cell 0 0,alignx trailing");
		
		fldName = new JTextField();
		fldName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setName(fldName.getText());
			}
		});
		add(fldName, "cell 1 0 2 1,growx");
		fldName.setColumns(10);
		
		JLabel lblDescription = new JLabel("Basic Description");
		add(lblDescription, "cell 0 2,alignx trailing");
		
		fldDescription = new JTextField();
		fldDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setDescription(fldDescription.getText());
			}
		});
		add(fldDescription, "cell 1 2 2 1,growx");
		fldDescription.setColumns(10);
		
		JLabel lblControlSystemDescription = new JLabel("Control System Description");
		add(lblControlSystemDescription, "cell 0 3,alignx right,aligny top");
		
		fldLongDescription = new JTextPane();
		fldLongDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setLongDescription(fldLongDescription.getText());
			}
		});
		fldLongDescription.setBorder(UIManager.getBorder("TextField.border"));
		fldLongDescription.setMaximumSize(new Dimension(2147483647, 200));
		fldLongDescription.setMinimumSize(new Dimension(4, 100));
		add(fldLongDescription, "cell 1 3 2 1,grow");
		
		JLabel lblType = new JLabel("Type");
		add(lblType, "cell 0 4,alignx trailing");
		
		fldType = new JTextField();
		fldType.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setType(fldType.getText());
			}
		});
		add(fldType, "cell 1 4 2 1,growx");
		fldType.setColumns(10);
		
		JLabel lblManufacturer = new JLabel("Manufacturer");
		add(lblManufacturer, "cell 0 5,alignx trailing");
		
		fldManufacturer = new JTextField();
		fldManufacturer.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setManufacturer(fldManufacturer.getText());
			}
		});
		add(fldManufacturer, "cell 1 5 2 1,growx");
		fldManufacturer.setColumns(10);
		
		JLabel lblSerial = new JLabel("Serial");
		add(lblSerial, "cell 0 6,alignx trailing");
		
		fldSerial = new JTextField();
		fldSerial.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setSerial(fldSerial.getText());
			}
		});
		add(fldSerial, "cell 1 6 2 1,growx");
		fldSerial.setColumns(10);
		
		JLabel lblBuilt = new JLabel("Built");
		add(lblBuilt, "cell 0 7,alignx trailing");
		
		JFXPanel panelDateTime = new JFXPanel();
		Group group = new Group();
		Scene scene = new Scene(group);
		datePicker = new DatePicker();
		datePicker.setPrefHeight(25);
		datePicker.setValue(LocalDate.now());
		datePicker.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override 
            public void handle(javafx.event.ActionEvent e) {
            	if (datePicker.getValue() != null) {
            		machine.setBuilt(datePicker.getValue());
            	};
            };
		});
		group.getChildren().add(datePicker);
		panelDateTime.setScene(scene);
		add(panelDateTime, "cell 1 7 2 1,grow");
		
		JLabel lblCertification = new JLabel("Certification");
		add(lblCertification, "cell 0 8,alignx trailing");
		
		fldCertification = new JTextField();
		fldCertification.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setCertification(fldCertification.getText());
			}
		});
		add(fldCertification, "cell 1 8 2 1,growx");
		fldCertification.setColumns(10);
		
		JLabel lblImage = new JLabel("Image");
		add(lblImage, "cell 0 9,alignx trailing");
		
		fldImage = new JTextField();
		fldImage.setEditable(false);
		add(fldImage, "cell 1 9,growx");
		fldImage.setColumns(10);
		
		
		JButton btnImage = new JButton("New Image...");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new ViewImageChooser();
				fileChooser.setFileListener(new FileListener() {
					@Override
					public void fileEmitted(File file) {
						ImageIcon image = new ImageIcon(file.toString());
						machine.setImage(image);
						fldImage.setText(file.getName());
						imageListener.imageEmitted(image);
					}
				});
				fileChooser.setVisible(true);
			}
		});
		add(btnImage, "cell 2 9");
		
		JLabel lblLimits = new JLabel("Limits");
		add(lblLimits, "cell 0 10,alignx trailing");
		
		fldLimits = new JTextField();
		fldLimits.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setLimits(fldLimits.getText());
			}
		});
		add(fldLimits, "cell 1 10 2 1,growx");
		fldLimits.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		add(lblLocation, "cell 0 11,alignx trailing");
		
		fldLocation = new JTextField();
		fldLocation.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setLocation(fldLocation.getText());
			}
		});
		add(fldLocation, "cell 1 11 2 1,growx");
		fldLocation.setColumns(10);
		
		JLabel lblModel = new JLabel("Model");
		add(lblModel, "cell 0 12,alignx trailing");
		
		fldModel = new JTextField();
		fldModel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setModel(fldModel.getText());
			}
		});
		add(fldModel, "cell 1 12 2 1,growx");
		fldModel.setColumns(10);
		
		JLabel lblModifications = new JLabel("Modifications");
		add(lblModifications, "cell 0 13,alignx trailing");
		
		fldModifications = new JTextField();
		fldModifications.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setModifications(fldModifications.getText());
			}
		});
		add(fldModifications, "cell 1 13 2 1,growx");
		fldModifications.setColumns(10);
		
		JLabel lblEnergySources = new JLabel("Energy Sources");
		add(lblEnergySources, "cell 0 15,alignx trailing");
		
		fldEnergySources = new JTextField();
		fldEnergySources.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setEnergySources(fldEnergySources.getText());
			}
		});
		add(fldEnergySources, "cell 1 15 2 1,growx");
		fldEnergySources.setColumns(10);
		
		JLabel lblEnergyRatings = new JLabel("Energy Ratings");
		add(lblEnergyRatings, "cell 0 16,alignx trailing");
		
		fldEnergyRatings = new JTextField();
		fldEnergyRatings.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setEnergyRatings(fldEnergyRatings.getText());
			}
		});
		add(fldEnergyRatings, "cell 1 16 2 1,growx");
		fldEnergyRatings.setColumns(10);
		
		JLabel lblSafetyMeasures = new JLabel("Safety Measures");
		add(lblSafetyMeasures, "cell 0 18,alignx trailing");
		
		fldSafetyMeasures = new JTextField();
		fldSafetyMeasures.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setSafetyMeasures(fldSafetyMeasures.getText());
			}
		});
		add(fldSafetyMeasures, "cell 1 18 2 1,growx");
		fldSafetyMeasures.setColumns(10);
		
		JLabel lblOperatorCount = new JLabel("Operator Count");
		add(lblOperatorCount, "cell 0 20,alignx trailing");
		
		fldOperatorCount = new JSpinner();
		fldOperatorCount.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				machine.setOperatorCount((Integer)fldOperatorCount.getValue());
			}
		});
		add(fldOperatorCount, "cell 1 20 2 1,growx");
		
		JLabel lblShiftCount = new JLabel("Shift Count");
		add(lblShiftCount, "cell 0 21,alignx trailing");
		
		fldShiftCount = new JSpinner();
		fldShiftCount.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				machine.setShiftCount((Integer)fldShiftCount.getValue());
			}
		});
		add(fldShiftCount, "cell 1 21 2 1,growx");
		
		JLabel lblMonthlyHours = new JLabel("Monthly Hours");
		add(lblMonthlyHours, "cell 0 23,alignx trailing");
		
		fldMonthlyHours = new JSpinner();
		fldMonthlyHours.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				machine.setMonthlyHours((Integer)fldMonthlyHours.getValue());
			}
		});
		add(fldMonthlyHours, "cell 1 23 2 1,growx");
		
		JLabel lblOperatingManuals = new JLabel("Operating Manuals");
		add(lblOperatingManuals, "cell 0 25,alignx trailing");
		
		fldOperatingManuals = new JTextField();
		fldOperatingManuals.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				machine.setOperatingManuals(fldOperatingManuals.getText());
			}
		});
		add(fldOperatingManuals, "cell 1 25 2 1,growx");
		fldOperatingManuals.setColumns(10);
		
		JLabel lblOperatingProcedures = new JLabel("Operating Procedures");
		add(lblOperatingProcedures, "cell 0 26,alignx trailing");
		
		fldOperatingProcedures = new JTextField();
		fldOperatingProcedures.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setOperatingProcedures(fldOperatingProcedures.getText());
			}
		});
		add(fldOperatingProcedures, "cell 1 26 2 1,growx");
		fldOperatingProcedures.setColumns(10);
		
		JLabel lblTrainingRecords = new JLabel("Training Records");
		add(lblTrainingRecords, "cell 0 27,alignx trailing");
		
		fldTrainingRecords = new JTextField();
		fldTrainingRecords.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setTrainingRecords(fldTrainingRecords.getText());
			}
		});
		add(fldTrainingRecords, "cell 1 27 2 1,growx");
		fldTrainingRecords.setColumns(10);
		
		JLabel lblWarningSigns = new JLabel("Warning Signs");
		add(lblWarningSigns, "cell 0 29,alignx trailing");
		
		fldWarningSigns = new JTextField();
		fldWarningSigns.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setWarningSigns(fldWarningSigns.getText());
			}
		});
		add(fldWarningSigns, "cell 1 29 2 1,growx");
		fldWarningSigns.setColumns(10);
		
		JLabel lblRawMaterials = new JLabel("Raw Materials");
		add(lblRawMaterials, "cell 0 30,alignx trailing");
		
		fldRawMaterials = new JTextField();
		fldRawMaterials.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setRawMaterials(fldRawMaterials.getText());
			}
		});
		add(fldRawMaterials, "cell 1 30 2 1,growx");
		fldRawMaterials.setColumns(10);
		
		JLabel lblMaintenanceManual = new JLabel("Maintenance Manual");
		add(lblMaintenanceManual, "cell 0 32,alignx trailing");
		
		fldMaintenanceManual = new JTextField();
		fldMaintenanceManual.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setMaintenanceManual(fldMaintenanceManual.getText());
			}
		});
		add(fldMaintenanceManual, "cell 1 32 2 1,growx");
		fldMaintenanceManual.setColumns(10);
		
		JLabel lblMaintenanceTrainingRecords = new JLabel("Maintenance Training Records");
		add(lblMaintenanceTrainingRecords, "cell 0 33,alignx trailing");
		
		fldMaintenanceTrainingRecords = new JTextField();
		fldMaintenanceTrainingRecords.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setMaintenanceTrainingRecord(fldMaintenanceTrainingRecords.getText());
			}
		});
		add(fldMaintenanceTrainingRecords, "cell 1 33 2 1,growx");
		fldMaintenanceTrainingRecords.setColumns(10);
		
		JLabel lblUntrainedAccess = new JLabel("Untrained Access");
		add(lblUntrainedAccess, "cell 0 35,alignx trailing");
		
		fldUntrainedAccess = new JTextField();
		fldUntrainedAccess.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				machine.setUntrainedAccess(fldUntrainedAccess.getText());
			}
		});
		add(fldUntrainedAccess, "cell 1 35 2 1,growx");
		fldUntrainedAccess.setColumns(10);

	}
	
	public DatePicker getDatePicker() {
		return datePicker;
	}
	
	public JTextField getTextField() {
		return fldUntrainedAccess;
	}

	public void clear() {
		fldName.setText(null);
		fldDescription.setText(null);
		fldType.setText(null);
		fldManufacturer.setText(null);
		fldSerial.setText(null);
		fldCertification.setText(null);
		fldImage.setText(null);
		fldLimits.setText(null);
		fldLocation.setText(null);
		fldModel.setText(null);
		fldModifications.setText(null);
		fldEnergySources.setText(null);
		fldEnergyRatings.setText(null);
		fldSafetyMeasures.setText(null);
		fldOperatingManuals.setText(null);
		fldOperatingProcedures.setText(null);
		fldTrainingRecords.setText(null);
		fldWarningSigns.setText(null);
		fldRawMaterials.setText(null);
		fldMaintenanceManual.setText(null);
		fldMaintenanceTrainingRecords.setText(null);
		fldUntrainedAccess.setText(null);
		datePicker.setValue(null);
		fldLongDescription.setText(null);
		fldOperatorCount.setValue(0);
		fldShiftCount.setValue(0);
		fldMonthlyHours.setValue(0);
	}

}
