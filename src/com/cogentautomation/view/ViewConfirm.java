package com.cogentautomation.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cogentautomation.controller.listeners.BooleanListener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ViewConfirm extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private BooleanListener booleanListener;
	private JFrame frame;

	/**
	 * Create the dialog.
	 * @param frame 
	 */
	public ViewConfirm(JFrame frame) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Warning!");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewConfirm.class.getResource("/com/cogentautomation/Cogent-Automation-Logo.png")));
		setBounds(100, 100, 310, 116);
		getContentPane().setLayout(new BorderLayout());
		setResizable(false);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setFrame(frame);
		{
			JLabel lblAreYouSure = new JLabel("There may be unsaved data, are you sure?");
			lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblAreYouSure, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Yes");
				okButton.addActionListener(this);
				okButton.setActionCommand("yes");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("No");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("no");
				buttonPane.add(cancelButton);
			}
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);	
		switch (e.getActionCommand()) {
		case "yes":
			getBooleanListener().booleanEmitted(true);
			getFrame().setTitle("Machinery Safety Assessment");
			break;
		case "no":
			getBooleanListener().booleanEmitted(false);
			break;
		}
		
	}

	public BooleanListener getBooleanListener() {
		return booleanListener;
	}

	public void setBooleanListener(BooleanListener booleanListener) {
		this.booleanListener = booleanListener;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
