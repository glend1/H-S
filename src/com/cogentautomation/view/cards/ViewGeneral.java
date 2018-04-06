package com.cogentautomation.view.cards;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.cogentautomation.controller.listeners.FileListener;
import com.cogentautomation.controller.listeners.ImageListener;
import com.cogentautomation.model.Data;
import com.cogentautomation.view.ViewImageChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewGeneral extends JPanel {
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
	private JLabel lblLogo;
	private JTextField fldLogo;
	private JLabel lblProject;
	private JTextField fldProject;
	private JLabel lblMotivation;
	private JTextPane fldMotivation;
	private ViewImageChooser fileChooser;
	private JButton btnImage;
	private ImageListener imageListener;
	private Data data;
	
	public void setImageListener(ImageListener listener) {
		imageListener = listener;
	}
	
	public void loadData(Data d) {
		data = d;
		fldName.setText(data.getClient().getName());
		fldAddress1.setText(data.getClient().getAddress1());
		fldAddress2.setText(data.getClient().getAddress2());
		fldTown.setText(data.getClient().getTown());
		fldCounty.setText(data.getClient().getCounty());
		fldPostCode.setText(data.getClient().getPostCode());
		fldPhone.setText(data.getClient().getPhone());
		fldEMail.setText(data.getClient().getEMail());
		if (data.getClient().getImage().getImageBytes() != null) {
			fldLogo.setText(data.getClient().getImage().getFilename());
			imageListener.imageEmitted(data.getClient().getImage().getImage());
		};
		fldProject.setText(data.getProjectNumber());
		fldMotivation.setText(data.getMotivation());
	}

	/**
	 * Create the panel.
	 */
	public ViewGeneral() {

		setLayout(new MigLayout("", "[][grow][]", "[][][][][][][][][][][][][][][]"));
		
		lblProject = new JLabel("Project");
		add(lblProject, "cell 0 0,alignx trailing");
		
		fldProject = new JTextField();
		fldProject.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				data.setProjectNumber(fldProject.getText());
			}
		});
		add(fldProject, "cell 1 0 2 1,growx");
		fldProject.setColumns(10);
		
		lblMotivation = new JLabel("Motivation");
		lblMotivation.setVerticalAlignment(SwingConstants.TOP);
		add(lblMotivation, "cell 0 1,aligny top");
		
		fldMotivation = new JTextPane();
		fldMotivation.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				data.setMotivation(fldMotivation.getText());
			}
		});
		fldMotivation.setBorder(UIManager.getBorder("TextField.border"));
		fldMotivation.setMaximumSize(new Dimension(2147483647, 200));
		fldMotivation.setMinimumSize(new Dimension(4, 100));
		add(fldMotivation, "cell 1 1 2 1,growx");
		
		JLabel lblName = new JLabel("Name");
		add(lblName, "cell 0 3,alignx trailing");
		
		fldName = new JTextField();
		fldName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				data.getClient().setName(fldName.getText());
			}
		});
		add(fldName, "cell 1 3 2 1,growx");
		fldName.setColumns(10);
		
		lblLogo = new JLabel("Logo");
		add(lblLogo, "cell 0 4,alignx trailing");
		
		fldLogo = new JTextField();
		fldLogo.setEditable(false);
		add(fldLogo, "cell 1 4,growx");
		fldLogo.setColumns(10);
		
		
		btnImage = new JButton("New Image...");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new ViewImageChooser();
				fileChooser.setFileListener(new FileListener() {
					@Override
					public void fileEmitted(File file) {
						ImageIcon image = new ImageIcon(file.toString());
						data.getClient().setImage(image);
						fldLogo.setText(file.getName());
						imageListener.imageEmitted(image);
					}
				});
				fileChooser.setVisible(true);
			}
		});
		add(btnImage, "cell 2 4");
		
		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "cell 0 6,alignx trailing");
		
		fldAddress1 = new JTextField();
		fldAddress1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				data.getClient().setAddress1(fldAddress1.getText());
			}
		});
		add(fldAddress1, "cell 1 6 2 1,growx");
		fldAddress1.setColumns(10);
		
		fldAddress2 = new JTextField();
		fldAddress2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				data.getClient().setAddress2(fldAddress2.getText());
			}
		});
		add(fldAddress2, "cell 1 7 2 1,growx");
		fldAddress2.setColumns(10);
		
		JLabel lblTown = new JLabel("Town");
		add(lblTown, "cell 0 8,alignx trailing");
		
		fldTown = new JTextField();
		fldTown.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				data.getClient().setTown(fldTown.getText());
			}
		});
		add(fldTown, "cell 1 8 2 1,growx");
		fldTown.setColumns(10);
		
		JLabel lblCounty = new JLabel("County");
		add(lblCounty, "cell 0 9,alignx trailing");
		
		fldCounty = new JTextField();
		fldCounty.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				data.getClient().setCounty(fldCounty.getText());
			}
		});
		add(fldCounty, "cell 1 9 2 1,growx");
		fldCounty.setColumns(10);
		
		JLabel lblPostCode = new JLabel("Post Code");
		add(lblPostCode, "cell 0 10,alignx trailing");
		
		fldPostCode = new JTextField();
		fldPostCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				data.getClient().setPostCode(fldPostCode.getText());
			}
		});
		add(fldPostCode, "cell 1 10 2 1,growx");
		fldPostCode.setColumns(10);
		
		lblPhone = new JLabel("Phone");
		add(lblPhone, "cell 0 12,alignx trailing");
		
		fldPhone = new JTextField();
		fldPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				data.getClient().setPhone(fldPhone.getText());
			}
		});
		add(fldPhone, "cell 1 12 2 1,growx");
		fldPhone.setColumns(10);
		
		lblEmail = new JLabel("E-Mail ");
		add(lblEmail, "cell 0 14,alignx trailing");
		
		fldEMail = new JTextField();
		fldEMail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				data.getClient().setEMail(fldEMail.getText());
			}
		});
		add(fldEMail, "cell 1 14 2 1,growx");
		fldEMail.setColumns(10);

	}
	
	public JTextField getTextField() {
		return fldName;
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
		fldLogo.setText(null);
		fldProject.setText(null);
		fldMotivation.setText(null);
	}

}
