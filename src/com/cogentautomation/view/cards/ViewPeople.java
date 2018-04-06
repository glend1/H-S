package com.cogentautomation.view.cards;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import com.cogentautomation.model.Person;

import java.time.LocalDate;

import javax.swing.JLabel;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewPeople extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fldName;
	private JTextField fldAddress1;
	private JTextField fldAddress2;
	private JTextField fldTown;
	private JTextField fldCounty;
	private JTextField fldPostCode;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JTextField fldPhone;
	private JTextField fldEMail;
	private JLabel lblRole;
	private JTextField fldRole;
	private JLabel lblDate;
	private DatePicker datePicker;
	private Person person;
	
	public void loadData(Person p) {
		person = p;
		fldName.setText(person.getName());
		fldAddress1.setText(person.getAddress1());
		fldAddress2.setText(person.getAddress2());
		fldTown.setText(person.getTown());
		fldCounty.setText(person.getCounty());
		fldPostCode.setText(person.getPostCode());
		fldPhone.setText(person.getPhone());
		fldEMail.setText(person.getEMail());
		fldRole.setText(person.getJobRole());
		datePicker.setValue(person.getDate());
	}
	
	/**
	 * Create the panel.
	 */
	public ViewPeople() {
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][][][]"));
		
		JLabel lblName = new JLabel("Name");
		add(lblName, "cell 0 0,alignx trailing");
		
		fldName = new JTextField();
		fldName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				person.setName(fldName.getText());
			}
		});
		add(fldName, "cell 1 0,growx");
		fldName.setColumns(10);
		
		lblRole = new JLabel("Role");
		add(lblRole, "cell 0 1,alignx trailing");
		
		fldRole = new JTextField();
		fldRole.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				person.setJobRole(fldRole.getText());
			}
		});
		add(fldRole, "cell 1 1,grow");
		fldRole.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "cell 0 3,alignx trailing");
		
		fldAddress1 = new JTextField();
		fldAddress1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				person.setAddress1(fldAddress1.getText());
			}
		});
		add(fldAddress1, "cell 1 3,growx");
		fldAddress1.setColumns(10);
		
		fldAddress2 = new JTextField();
		fldAddress2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				person.setAddress2(fldAddress2.getText());
			}
		});
		add(fldAddress2, "cell 1 4,growx");
		fldAddress2.setColumns(10);
		
		JLabel lblTown = new JLabel("Town");
		add(lblTown, "cell 0 5,alignx trailing");
		
		fldTown = new JTextField();
		fldTown.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				person.setTown(fldTown.getText());
			}
		});
		add(fldTown, "cell 1 5,growx");
		fldTown.setColumns(10);
		
		JLabel lblCounty = new JLabel("County");
		add(lblCounty, "cell 0 6,alignx trailing");
		
		fldCounty = new JTextField();
		fldCounty.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				person.setCounty(fldCounty.getText());
			}
		});
		add(fldCounty, "cell 1 6,growx");
		fldCounty.setColumns(10);
		
		JLabel lblPostCode = new JLabel("Post Code");
		add(lblPostCode, "cell 0 7,alignx trailing");
		
		fldPostCode = new JTextField();
		fldPostCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				person.setPostCode(fldPostCode.getText());
			}
		});
		add(fldPostCode, "cell 1 7,growx");
		fldPostCode.setColumns(10);
		
		lblPhone = new JLabel("Phone");
		add(lblPhone, "cell 0 9,alignx trailing");
		
		fldPhone = new JTextField();
		fldPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				person.setPhone(fldPhone.getText());
			}
		});
		add(fldPhone, "cell 1 9,growx");
		fldPhone.setColumns(10);
		
		lblEmail = new JLabel("E-Mail ");
		add(lblEmail, "cell 0 11,alignx trailing");
		
		fldEMail = new JTextField();
		fldEMail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				person.setEMail(fldEMail.getText());
			}
		});
		add(fldEMail, "cell 1 11,growx");
		fldEMail.setColumns(10);
		
		lblDate = new JLabel("Date");
		add(lblDate, "cell 0 13,alignx trailing");
		
		JFXPanel panelDateTime = new JFXPanel();
		Group group = new Group();
		Scene scene = new Scene(group);
		datePicker = new DatePicker();
		datePicker.setPrefHeight(25);
		datePicker.setValue(LocalDate.now());
		datePicker.setOnAction(new EventHandler<ActionEvent>() {
	            @Override 
	            public void handle(ActionEvent e) {
	            	if (datePicker.getValue() != null) {
	            		person.setDate(datePicker.getValue());
	            	};
	            };
			});
		group.getChildren().add(datePicker);
		panelDateTime.setScene(scene);
		add(panelDateTime, "cell 1 13,grow");
		
	}
	
	public DatePicker getDatePicker() {
		return datePicker;
	}
	
	public JTextField getTextField() {
		return fldEMail;
	}

	public void clear() {
		fldName.setText(null);
		fldAddress1.setText(null);
		fldAddress2.setText(null);
		fldTown.setText(null);
		fldCounty.setText(null);
		fldPostCode.setText(null);
		fldPhone.setText(null);
		fldEMail.setText(null);
		fldRole.setText(null);
		datePicker.setValue(null);
	}

}
