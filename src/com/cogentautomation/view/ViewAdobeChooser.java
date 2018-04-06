package com.cogentautomation.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.cogentautomation.controller.listeners.FileListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAdobeChooser extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileListener fileListener;
	
	public void setFileListener(FileListener listener) {
		fileListener = listener;
	}

	/**
	 * Create the dialog.
	 */
	public ViewAdobeChooser() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Export Data");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAddNode.class.getResource("/com/cogentautomation/Cogent-Automation-Logo.png")));
		setAlwaysOnTop(true);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setApproveButtonText("Save");
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(e.getActionCommand()) {
					case "ApproveSelection":
						fileListener.fileEmitted(fileChooser.getSelectedFile());
						break;
					case "CancelSelection":
					default:
						break;
				}
				setVisible(false);
			}
		});
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Adobe Acrobat Portable Document Format (.pdf)", "pdf"));
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		getContentPane().add(fileChooser, BorderLayout.CENTER);
	}

}
