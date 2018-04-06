package com.cogentautomation.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.Toolkit;

public class ViewAbout extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ViewAbout() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("About");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAbout.class.getResource("/com/cogentautomation/Cogent-Automation-Logo.png")));
		setAlwaysOnTop(true);
		setBounds(100, 100, 859, 351);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[][][][]"));
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(ViewAbout.class.getResource("/com/cogentautomation/logo.png")));
			contentPanel.add(lblNewLabel, "cell 0 0,aligny top");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Copyright of Cogent Automation Ltd. 2016\u00A9  Programmed by Glen Dovey.");
			contentPanel.add(lblNewLabel_1, "cell 0 1,alignx center");
		}
		{
			JLabel lblVersion = new JLabel("Version 1.0");
			contentPanel.add(lblVersion, "cell 0 2,alignx center");
		}
		{
			JLabel lblCopyright = new JLabel("This application uses PDFClown and is licenced under LGPL, PDFClown can be found at https://pdfclown.org/");
			contentPanel.add(lblCopyright, "cell 0 3,alignx center");
		}
	}

}
