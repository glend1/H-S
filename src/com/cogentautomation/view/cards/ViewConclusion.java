package com.cogentautomation.view.cards;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import com.cogentautomation.controller.listeners.FileListener;
import com.cogentautomation.model.Conclusion;
import com.cogentautomation.model.CustomImage;
import com.cogentautomation.view.ViewImageChooser;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;

public class ViewConclusion extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fldImage;
	private ViewImageChooser fileChooser;
	private JPanel panel = new JPanel();
	private Conclusion conclusion;
	private JTextPane fldConclusion;

	/**
	 * Create the panel.
	 */
	public ViewConclusion() {
		setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		JLabel lblConclusion = new JLabel("Conclusion");
		add(lblConclusion, "cell 0 0,aligny top");
		
		fldConclusion = new JTextPane();
		fldConclusion.setBorder(UIManager.getBorder("TextField.border"));
		fldConclusion.setMaximumSize(new Dimension(2147483647, 200));
		fldConclusion.setMinimumSize(new Dimension(4, 100));
		fldConclusion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				conclusion.setConclusion(fldConclusion.getText());
			}
		});
		add(fldConclusion, "cell 1 0,grow");
		
		JLabel lblImages = new JLabel("Images");
		add(lblImages, "cell 0 1,alignx right,aligny top");
		
		add(panel, "cell 1 1,growx,aligny top");
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		fldImage = new JTextField();
		fldImage.setEditable(false);
		panel_2.add(fldImage);
		fldImage.setColumns(10);
		
		JButton btnNewImage = new JButton("New Image...");
		btnNewImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new ViewImageChooser();
				fileChooser.setFileListener(new FileListener() {
					@Override
					public void fileEmitted(File file) {
						CustomImage image = new CustomImage(new ImageIcon(file.toString()));
						addImage(image);
						conclusion.addImage(image);
					}
				});
				fileChooser.setVisible(true);
			}
		});
		panel_2.add(btnNewImage);

	}
	
	private void clearPanel() {
		for (int i = 0; i < (panel.getComponentCount() - 1); i++) {
			panel.remove(i);
		}
	}

	public void clear() {
		fldConclusion.setText(null);
		clearPanel();
		panel.revalidate();
		panel.repaint();
	}

	public void loadData(Conclusion con) {
		conclusion = con;
		fldConclusion.setText(conclusion.getConclusion());
		clearPanel();
		for (CustomImage image : conclusion.getImages()) {
			addImage(image);
		}
		panel.revalidate();
		panel.repaint();

	}
	
	public void addImage(CustomImage image) {
		JPanel dynamicPanel = new JPanel();
		dynamicPanel.setLayout(new BoxLayout(dynamicPanel, BoxLayout.X_AXIS));
		
		JTextField imgField = new JTextField();
		imgField.setText(image.getFilename());
		imgField.setEditable(false);
		dynamicPanel.add(imgField);
		imgField.setColumns(10);
		
		JPanel subPanel = new JPanel();
		dynamicPanel.add(subPanel);
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.X_AXIS));
		
		JButton btnUpdateButton = new JButton("Change Image...");
		btnUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewImageChooser fc = new ViewImageChooser();
				fc.setFileListener(new FileListener() {
					@Override
					public void fileEmitted(File file) {
						/*ImageIcon img = new ImageIcon(file.toString());
						conclusion.updateImage(imgField.getText(), img);
						imgField.setText(img.toString());*/
						System.out.println(image);
					}
				});
				fc.setVisible(true);
			}
		});
		subPanel.add(btnUpdateButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conclusion.deleteImage(image);
				panel.remove(dynamicPanel);
				panel.revalidate();
				panel.repaint();
			}
		});
		subPanel.add(btnDelete);
		
		panel.add(dynamicPanel, panel.getComponentCount() - 1);
		panel.revalidate();
		panel.repaint();
	}

}
