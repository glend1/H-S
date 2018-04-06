package com.cogentautomation.view.cards;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.cogentautomation.controller.listeners.FileListener;
import com.cogentautomation.controller.listeners.ImageListener;
import com.cogentautomation.model.HRN;
import com.cogentautomation.model.enumerator.Mode;
import com.cogentautomation.model.enumerator.Task;
import com.cogentautomation.model.enumerator.hazard.EmptyHazard;
import com.cogentautomation.model.enumerator.hazard.GenericHazard;
import com.cogentautomation.model.enumerator.hazard.generic.GenericConsequence;
import com.cogentautomation.model.enumerator.hazard.shared.StringConsequence;
import com.cogentautomation.model.enumerator.hrn.Avoidance;
import com.cogentautomation.model.enumerator.hrn.Exposure;
import com.cogentautomation.model.enumerator.hrn.Harm;
import com.cogentautomation.model.enumerator.hrn.Likelihood;
import com.cogentautomation.model.enumerator.sil.Architecture;
import com.cogentautomation.model.enumerator.sil.Equivalent;
import com.cogentautomation.model.enumerator.sil.Frequency;
import com.cogentautomation.model.enumerator.sil.Performance;
import com.cogentautomation.model.enumerator.sil.Probability;
import com.cogentautomation.model.enumerator.sil.Severity;
import com.cogentautomation.view.ViewImageChooser;

import javax.swing.JRadioButton;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;

import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.EmptyBorder;
import java.awt.Component;

public class ViewEvent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fldName;
	private JTextField fldReductionMeasures;
	private JTextField fldStandards;
	private JTextField fldImage;
	private ViewImageChooser fileChooser;
	private JTextField fldConsequence;
	private JComboBox<Severity> fldSeverity;
	private JComboBox<Frequency> fldFrequency;
	private JComboBox<Probability> fldProbability;
	private JComboBox<Architecture> fldArchitechture;
	private ImageListener imageListener;
	private GenericHazard genericHazard = new EmptyHazard();
	private JComboBox<Mode> fldMode;
	private JComboBox<Harm> fldPreHarm;
	private JComboBox<Likelihood> fldPreLikelihood;
	private JComboBox<Avoidance> fldPreAvoidance;
	private JComboBox<Exposure> fldPreExposure;
	private JComboBox<Harm> fldPostHarm;
	private JComboBox<Likelihood> fldPostLikelihood;
	private JComboBox<Avoidance> fldPostAvoidance;
	private JComboBox<Exposure> fldPostExposure;
	private JRadioButton rdbtnTrueUpgrade;
	private JRadioButton rdbtnFalseUpgrade;
	private JRadioButton rdbtnTrueFunction;
	private JRadioButton rdbtnFalseFunction;
	private JTextPane fldExplanation;
	private JTextPane fldDanger;
	private JRadioButton rdbtnTrueStopTime;
	private JRadioButton rdbtnFalseStopTime;
	private JRadioButton rdbtnTrueDanger;
	private JRadioButton rdbtnFalseDanger;
	private JComboBox<Task> fldTask;
	private JLabel lblPreRSA;
	private JLabel lblPostRSA;
	private JLabel lblPL;
	private JLabel lblEq;
	
	public void setImageListener(ImageListener listener) {
		imageListener = listener;
	}
	
	private void hiddenDanger() {
			if (genericHazard.getHazardDetails().getHazardDanger()) {
				fldDanger.setVisible(true);
			} else {
				fldDanger.setVisible(false);
			}
		
	}
	
	public void loadData(GenericHazard gh) {
		genericHazard = gh;
		fldName.setText(genericHazard.getHazardDetails().getName());
		fldReductionMeasures.setText(genericHazard.getHazardDetails().getReductionMeasures());
		fldStandards.setText(genericHazard.getHazardDetails().getStandards());
		if (genericHazard.getHazardDetails().getImage().getImageBytes() != null) {
			fldImage.setText(genericHazard.getHazardDetails().getImage().getFilename());
			imageListener.imageEmitted(genericHazard.getHazardDetails().getImage().getImage());
		} else {
			fldImage.setText(null);
		};
		fldConsequence.setText(((StringConsequence)genericHazard.getConsequence()).getConsequence());
		fldSeverity.setSelectedItem(genericHazard.getHazardDetails().getSil().getS());
		fldFrequency.setSelectedItem(genericHazard.getHazardDetails().getSil().getF());
		fldProbability.setSelectedItem(genericHazard.getHazardDetails().getSil().getP());
		fldArchitechture.setSelectedItem(genericHazard.getHazardDetails().getSil().getArchitecture());
		setPerformanceArchitecture();
		fldMode.setSelectedItem(genericHazard.getHazardDetails().getMode());
		fldTask.setSelectedItem(genericHazard.getHazardDetails().getTask());
		fldPreHarm.setSelectedItem(genericHazard.getHazardDetails().getPre().getDPH());
		fldPreLikelihood.setSelectedItem(genericHazard.getHazardDetails().getPre().getLO());
		fldPreAvoidance.setSelectedItem(genericHazard.getHazardDetails().getPre().getPA());
		fldPreExposure.setSelectedItem(genericHazard.getHazardDetails().getPre().getFE());
		getRSA(genericHazard.getHazardDetails().getPre(), lblPreRSA);
		fldPostHarm.setSelectedItem(genericHazard.getHazardDetails().getPost().getDPH());
		fldPostLikelihood.setSelectedItem(genericHazard.getHazardDetails().getPost().getLO());
		fldPostAvoidance.setSelectedItem(genericHazard.getHazardDetails().getPost().getPA());
		fldPostExposure.setSelectedItem(genericHazard.getHazardDetails().getPost().getFE());
		getRSA(genericHazard.getHazardDetails().getPost(), lblPostRSA);
		if (genericHazard.getHazardDetails().getUpgrade()) {
			rdbtnTrueUpgrade.setSelected(true); 
		} else {
			rdbtnFalseUpgrade.setSelected(true);
		};
		if (genericHazard.getHazardDetails().getFunction()) {
			rdbtnTrueFunction.setSelected(true); 
		} else {
			rdbtnFalseFunction.setSelected(true);
		};
		fldExplanation.setText(genericHazard.getHazardDetails().getHazardExplanation());
		if (genericHazard.getHazardDetails().getHazardDanger()) {
			rdbtnTrueDanger.setSelected(true);
		} else {
			rdbtnFalseDanger.setSelected(true);
		}
		hiddenDanger();
		fldDanger.setText(genericHazard.getHazardDetails().getHazardDangerDescription());
		if (genericHazard.getHazardDetails().getStopTime()) {
			rdbtnTrueStopTime.setSelected(true); 
		} else {
			rdbtnFalseStopTime.setSelected(true);
		};
	}

	/**
	 * Create the panel.
	 */
	public ViewEvent() {
		setLayout(new MigLayout("", "[][grow][]", "[][][][][][][][][grow][][][][]"));
		
		JLabel lblName = new JLabel("Name");
		add(lblName, "cell 0 0,alignx trailing");
		
		fldName = new JTextField();
		fldName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				genericHazard.getHazardDetails().setName(fldName.getText());
			}
		});
		add(fldName, "cell 1 0 2 1,growx");
		fldName.setColumns(10);
		
		JLabel lblMode = new JLabel("Mode");
		add(lblMode, "cell 0 1,alignx trailing");
		
		fldMode = new JComboBox<Mode>();
		fldMode.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fldMode.getSelectedItem() != null) {
					genericHazard.getHazardDetails().setMode((Mode)fldMode.getSelectedItem());
				};
			}
		});
		fldMode.setModel(new DefaultComboBoxModel<Mode>(Mode.values()));
		add(fldMode, "cell 1 1 2 1,growx");
		
		JLabel lblTask = new JLabel("Task");
		add(lblTask, "cell 0 2,alignx trailing");
		
		fldTask = new JComboBox<Task>();
		fldTask.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fldTask.getSelectedItem() != null) {
					genericHazard.getHazardDetails().setTask((Task)fldTask.getSelectedItem());
				};
			}
		});
		fldTask.setModel(new DefaultComboBoxModel<Task>(Task.values()));
		add(fldTask, "cell 1 2 2 1,growx");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pre-Measures HRN Score", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, "cell 0 3 3 1,grow");
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
		JLabel lblPreHarmdph = new JLabel("Harm (DPH)");
		panel.add(lblPreHarmdph, "cell 0 0,alignx trailing");
		
		fldPreHarm = new JComboBox<Harm>();
		fldPreHarm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fldPreHarm.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getPre().setDPH((Harm)fldPreHarm.getSelectedItem());
					getRSA(genericHazard.getHazardDetails().getPre(), lblPreRSA);
				};
			}
		});
		fldPreHarm.setModel(new DefaultComboBoxModel<Harm>(Harm.values()));
		panel.add(fldPreHarm, "cell 1 0,growx");
		
		JLabel lblPreLikelihoodlo = new JLabel("Likelihood (LO)");
		panel.add(lblPreLikelihoodlo, "cell 0 1,alignx trailing");
		
		fldPreLikelihood = new JComboBox<Likelihood>();
		fldPreLikelihood.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fldPreLikelihood.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getPre().setLO((Likelihood)fldPreLikelihood.getSelectedItem());
					getRSA(genericHazard.getHazardDetails().getPre(), lblPreRSA);
				};
			}
		});
		fldPreLikelihood.setModel(new DefaultComboBoxModel<Likelihood>(Likelihood.values()));
		panel.add(fldPreLikelihood, "cell 1 1,growx");
		
		JLabel lblPreAvoidancepa = new JLabel("Avoidance (PA)");
		panel.add(lblPreAvoidancepa, "cell 0 2,alignx trailing");
		
		fldPreAvoidance = new JComboBox<Avoidance>();
		fldPreAvoidance.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fldPreAvoidance.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getPre().setPA((Avoidance)fldPreAvoidance.getSelectedItem());
					getRSA(genericHazard.getHazardDetails().getPre(), lblPreRSA);
				};
			}
		});
		fldPreAvoidance.setModel(new DefaultComboBoxModel<Avoidance>(Avoidance.values()));
		panel.add(fldPreAvoidance, "cell 1 2,growx");
		
		JLabel lblPreExposurefe = new JLabel("Exposure (FE)");
		panel.add(lblPreExposurefe, "cell 0 3,alignx trailing");
		
		fldPreExposure = new JComboBox<Exposure>();
		fldPreExposure.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fldPreExposure.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getPre().setFE((Exposure)fldPreExposure.getSelectedItem());
					getRSA(genericHazard.getHazardDetails().getPre(), lblPreRSA);
				};
			}
		});
		fldPreExposure.setModel(new DefaultComboBoxModel<Exposure>(Exposure.values()));
		panel.add(fldPreExposure, "cell 1 3,growx");
		
		JLabel lblRsaNumber = new JLabel("RSA Number");
		panel.add(lblRsaNumber, "cell 0 4,alignx right");
		
		lblPreRSA = new JLabel("Unknown");
		panel.add(lblPreRSA, "cell 1 4");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 4 3 1,grow");
		panel_1.setBorder(new TitledBorder(null, "Post-Measures HRN Score", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
		JLabel lblPostHarmdph = new JLabel("Harm (DPH)");
		panel_1.add(lblPostHarmdph, "cell 0 0,alignx trailing");
		
		fldPostHarm = new JComboBox<Harm>();
		fldPostHarm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fldPostHarm.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getPost().setDPH((Harm)fldPostHarm.getSelectedItem());
					getRSA(genericHazard.getHazardDetails().getPost(), lblPostRSA);
				};
			}
		});
		fldPostHarm.setModel(new DefaultComboBoxModel<Harm>(Harm.values()));
		panel_1.add(fldPostHarm, "cell 1 0,growx");
		
		JLabel lblPostLikelihoodlo = new JLabel("Likelihood (LO)");
		panel_1.add(lblPostLikelihoodlo, "cell 0 1,alignx trailing");
		
		fldPostLikelihood = new JComboBox<Likelihood>();
		fldPostLikelihood.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fldPostLikelihood.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getPost().setLO((Likelihood)fldPostLikelihood.getSelectedItem());
					getRSA(genericHazard.getHazardDetails().getPost(), lblPostRSA);
				};
			}
		});
		fldPostLikelihood.setModel(new DefaultComboBoxModel<Likelihood>(Likelihood.values()));
		panel_1.add(fldPostLikelihood, "cell 1 1,growx");
		
		JLabel lblPostAvoidancepa = new JLabel("Avoidance (PA)");
		panel_1.add(lblPostAvoidancepa, "cell 0 2,alignx trailing");
		
		fldPostAvoidance = new JComboBox<Avoidance>();
		fldPostAvoidance.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fldPostAvoidance.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getPost().setPA((Avoidance)fldPostAvoidance.getSelectedItem());
					getRSA(genericHazard.getHazardDetails().getPost(), lblPostRSA);
				};
			}
		});
		fldPostAvoidance.setModel(new DefaultComboBoxModel<Avoidance>(Avoidance.values()));
		panel_1.add(fldPostAvoidance, "cell 1 2,growx");
		
		JLabel lblPostExposurefe = new JLabel("Exposure (FE)");
		panel_1.add(lblPostExposurefe, "cell 0 3,alignx trailing");
		
		fldPostExposure = new JComboBox<Exposure>();
		fldPostExposure.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
				if (fldPostExposure.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getPost().setFE((Exposure)fldPostExposure.getSelectedItem());
					getRSA(genericHazard.getHazardDetails().getPost(), lblPostRSA);
				};
			}
		});
		fldPostExposure.setModel(new DefaultComboBoxModel<Exposure>(Exposure.values()));
		panel_1.add(fldPostExposure, "cell 1 3,growx");
		
		JLabel lblRsaNumber_1 = new JLabel("RSA Number");
		panel_1.add(lblRsaNumber_1, "cell 0 4,alignx right");
		
		lblPostRSA = new JLabel("Unknown");
		panel_1.add(lblPostRSA, "cell 1 4");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Performance Level", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_2, "cell 0 5 3 1,grow");
		panel_2.setLayout(new MigLayout("", "[][grow]", "[][][][][][][]"));
		
		JLabel lblSeverity = new JLabel("Severity");
		panel_2.add(lblSeverity, "cell 0 0,alignx trailing");
		
		fldSeverity = new JComboBox<Severity>();
		fldSeverity.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (fldSeverity.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getSil().setS((Severity)fldSeverity.getSelectedItem());
					setPerformanceArchitecture();
				};
			}
		});
		fldSeverity.setModel(new DefaultComboBoxModel<Severity>(Severity.values()));
		panel_2.add(fldSeverity, "cell 1 0,growx");
		
		JLabel lblFrequency = new JLabel("Frequency");
		panel_2.add(lblFrequency, "cell 0 1,alignx trailing");
		
		fldFrequency = new JComboBox<Frequency>();
		fldFrequency.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fldFrequency.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getSil().setF((Frequency)fldFrequency.getSelectedItem());
					setPerformanceArchitecture();
				};
			}
		});
		fldFrequency.setModel(new DefaultComboBoxModel<Frequency>(Frequency.values()));
		panel_2.add(fldFrequency, "cell 1 1,growx");
		
		JLabel lblProbability = new JLabel("Probability");
		panel_2.add(lblProbability, "cell 0 2,alignx trailing");
		
		fldProbability = new JComboBox<Probability>();
		fldProbability.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (fldProbability.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getSil().setP((Probability)fldProbability.getSelectedItem());
					setPerformanceArchitecture();
				};
			}
		});
		fldProbability.setModel(new DefaultComboBoxModel<Probability>(Probability.values()));
		panel_2.add(fldProbability, "cell 1 2,growx");
		
		JLabel lblPerformance = new JLabel("Required PL");
		panel_2.add(lblPerformance, "cell 0 3,alignx right");
		
		lblPL = new JLabel("Unknown");
		panel_2.add(lblPL, "cell 1 3");
		
		JLabel lblEquivilent = new JLabel("SIL Equivilent");
		panel_2.add(lblEquivilent, "cell 0 5,alignx right");
		
		lblEq = new JLabel("Unknown");
		panel_2.add(lblEq, "cell 1 5");
		
		JLabel lblArchitecture = new JLabel("Architecture");
		panel_2.add(lblArchitecture, "cell 0 6,alignx trailing");
		
		fldArchitechture = new JComboBox<Architecture>();
		fldArchitechture.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fldArchitechture.getSelectedItem() != null) {
					genericHazard.getHazardDetails().getSil().setArchitecture((Architecture)fldArchitechture.getSelectedItem());
				};
			}
		});
		fldArchitechture.setModel(new DefaultComboBoxModel<Architecture>(Architecture.values()));
		panel_2.add(fldArchitechture, "cell 1 6,growx");
		
		JLabel lblUpgrade = new JLabel("Upgrade");
		add(lblUpgrade, "cell 0 6,alignx trailing");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		add(panel_4, "cell 1 6,alignx left,growy");
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		ButtonGroup fldUpgrade = new ButtonGroup();
		
		rdbtnTrueUpgrade = new JRadioButton("True");
		rdbtnTrueUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genericHazard.getHazardDetails().setUpgrade(true);
			}
		});
		rdbtnTrueUpgrade.setBorder(null);
		panel_4.add(rdbtnTrueUpgrade);
		
		rdbtnFalseUpgrade = new JRadioButton("False");
		rdbtnFalseUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genericHazard.getHazardDetails().setUpgrade(false);
			}
		});
		rdbtnFalseUpgrade.setBorder(new EmptyBorder(0, 5, 0, 0));
		panel_4.add(rdbtnFalseUpgrade);
		
		fldUpgrade.add(rdbtnTrueUpgrade);
		fldUpgrade.add(rdbtnFalseUpgrade);
		
		JLabel lblFunction = new JLabel("Function");
		add(lblFunction, "cell 0 7,alignx trailing");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		add(panel_5, "cell 1 7,alignx left,growy");
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		ButtonGroup fldFunction = new ButtonGroup();
		
		rdbtnTrueFunction = new JRadioButton("True");
		rdbtnTrueFunction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genericHazard.getHazardDetails().setFunction(true);
			}
		});
		rdbtnTrueFunction.setBorder(null);
		panel_5.add(rdbtnTrueFunction);
		
		rdbtnFalseFunction = new JRadioButton("False");
		rdbtnFalseFunction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genericHazard.getHazardDetails().setFunction(false);
			}
		});
		rdbtnFalseFunction.setBorder(new EmptyBorder(0, 5, 0, 0));
		panel_5.add(rdbtnFalseFunction);
		
		fldFunction.add(rdbtnTrueFunction);
		fldFunction.add(rdbtnFalseFunction);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Hazard", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_3, "cell 0 8 3 1,grow");
		panel_3.setLayout(new MigLayout("hidemode 3", "[][grow]", "[][grow][grow][]"));
		
		JLabel lblConsequence = new JLabel("Consequence");
		panel_3.add(lblConsequence, "cell 0 0,alignx trailing");
		
		fldConsequence = new JTextField();
		fldConsequence.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				genericHazard.setConsequence((GenericConsequence)new StringConsequence(fldConsequence.getText()));
			}
		});
		panel_3.add(fldConsequence, "cell 1 0,growx");
		fldConsequence.setColumns(10);
		
		JLabel lblExplanation = new JLabel("Explanation");
		panel_3.add(lblExplanation, "cell 0 1,alignx right,aligny top");
		
		fldExplanation = new JTextPane();
		fldExplanation.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				genericHazard.getHazardDetails().setHazardExplanation(fldExplanation.getText());
			}
		});
		fldExplanation.setBorder(UIManager.getBorder("TextField.border"));
		fldExplanation.setMaximumSize(new Dimension(2147483647, 200));
		fldExplanation.setMinimumSize(new Dimension(4, 100));
		panel_3.add(fldExplanation, "cell 1 1,grow");
		
		JLabel lblDanger = new JLabel("Danger");
		lblDanger.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_3.add(lblDanger, "cell 0 2,alignx trailing");
		
		fldDanger = new JTextPane();
		fldDanger.setVisible(false);
		fldDanger.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				genericHazard.getHazardDetails().setHazardDangerDescription(fldDanger.getText());
			}
		});
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(null);
		panel_3.add(panel_7, "cell 1 2,alignx left,growy");
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		ButtonGroup groupDanger = new ButtonGroup();
		
		rdbtnTrueDanger = new JRadioButton("True");
		rdbtnTrueDanger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				genericHazard.getHazardDetails().setHazardDanger(true);
				hiddenDanger();
			}
		});
		rdbtnTrueDanger.setBorder(null);
		panel_7.add(rdbtnTrueDanger);
		
		rdbtnFalseDanger = new JRadioButton("False");
		rdbtnFalseDanger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genericHazard.getHazardDetails().setHazardDanger(false);
				hiddenDanger();
			}
		});
		rdbtnFalseDanger.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdbtnFalseDanger.setBorder(new EmptyBorder(0, 8, 0, 0));
		panel_7.add(rdbtnFalseDanger);
		
		groupDanger.add(rdbtnTrueDanger);
		groupDanger.add(rdbtnFalseDanger);
		
		fldDanger.setBorder(UIManager.getBorder("TextField.border"));
		fldDanger.setMaximumSize(new Dimension(2147483647, 200));
		fldDanger.setMinimumSize(new Dimension(4, 100));
		panel_3.add(fldDanger, "cell 1 3,grow");
		
		JLabel lblEspeStopTime = new JLabel("ESPE Stop Time");
		add(lblEspeStopTime, "cell 0 9,alignx trailing");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		add(panel_6, "cell 1 9,alignx left,growy");
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		ButtonGroup fldStopTime = new ButtonGroup();
		
		rdbtnTrueStopTime = new JRadioButton("True");
		rdbtnTrueStopTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genericHazard.getHazardDetails().setStopTime(true);
			}
		});
		rdbtnTrueStopTime.setBorder(null);
		panel_6.add(rdbtnTrueStopTime);
		
		rdbtnFalseStopTime = new JRadioButton("False");
		rdbtnFalseStopTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genericHazard.getHazardDetails().setStopTime(false);
			}
		});
		rdbtnFalseStopTime.setBorder(new EmptyBorder(0, 8, 0, 0));
		panel_6.add(rdbtnFalseStopTime);
		
		fldStopTime.add(rdbtnTrueStopTime);
		fldStopTime.add(rdbtnFalseStopTime);
		
		JLabel lblReductionMeasures = new JLabel("Reduction Measures");
		add(lblReductionMeasures, "cell 0 10,alignx trailing");
		
		fldReductionMeasures = new JTextField();
		fldReductionMeasures.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				genericHazard.getHazardDetails().setReductionMeasures(fldReductionMeasures.getText());
			}
		});
		add(fldReductionMeasures, "cell 1 10 2 1,growx");
		fldReductionMeasures.setColumns(10);
		
		JLabel lblStandards = new JLabel("Standards");
		add(lblStandards, "cell 0 11,alignx trailing");
		
		fldStandards = new JTextField();
		fldStandards.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				genericHazard.getHazardDetails().setStandards(fldStandards.getText());
			}
		});
		add(fldStandards, "cell 1 11 2 1,growx");
		fldStandards.setColumns(10);
		
		JLabel lblImage = new JLabel("Image");
		add(lblImage, "cell 0 12,alignx trailing");
		
		fldImage = new JTextField();
		fldImage.setEditable(false);
		add(fldImage, "cell 1 12,growx");
		fldImage.setColumns(10);
		
		
		JButton btnImage = new JButton("Add Image...");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new ViewImageChooser();
				fileChooser.setFileListener(new FileListener() {
					@Override
					public void fileEmitted(File file) {
						ImageIcon image = new ImageIcon(file.toString());
						genericHazard.getHazardDetails().setImage(image);
						fldImage.setText(file.getName());
						imageListener.imageEmitted(image);
					}
				});
				fileChooser.setVisible(true);
			}
		});
		add(btnImage, "cell 2 12");
	}

	protected void setPerformanceArchitecture() {
		Severity s = (Severity)fldSeverity.getSelectedItem();
		Frequency f = (Frequency)fldFrequency.getSelectedItem();
		Probability p = (Probability)fldProbability.getSelectedItem();
		if (s == null || f == null || p == null) {
			lblPL.setText("Unknown");
			lblEq.setText("Unknown");
			fldArchitechture.setModel(new DefaultComboBoxModel<Architecture>());
		} else {
			Performance perf = Performance.getPerformance(s, f, p); 
			Equivalent equiv = Equivalent.getEquivalent(s, f, p);
			genericHazard.getHazardDetails().getSil().setPL(perf);
			genericHazard.getHazardDetails().getSil().setSIL(equiv);
			fldArchitechture.setModel(new DefaultComboBoxModel<Architecture>(Architecture.getValues(perf)));
			genericHazard.getHazardDetails().getSil().setArchitecture((Architecture)fldArchitechture.getSelectedItem());
			lblPL.setText(perf.toString());
			lblEq.setText(genericHazard.getHazardDetails().getSil().getSIL().toString());
		}
	}
	
	protected void getRSA(HRN hrn, JLabel label) {
		if (hrn.getScore() == null) {
			label.setText("Unknown");
		} else {			
			label.setText(hrn.getScore() + " " + hrn.getRSA().getDescription());
		}
	}
	
	public JTextField getTextField() {
		return fldStandards;
	}

	public void clear() {
		fldName.setText(null);
		fldReductionMeasures.setText(null);
		fldStandards.setText(null);
		fldImage.setText(null);
		fldConsequence.setText(null);
		fldSeverity.setSelectedItem(null);
		fldFrequency.setSelectedItem(null);
		fldProbability.setSelectedItem(null);
		fldArchitechture.setSelectedItem(null);
		setPerformanceArchitecture();
		fldMode.setSelectedItem(null);
		fldTask.setSelectedItem(null);
		fldPreHarm.setSelectedItem(null);
		fldPreLikelihood.setSelectedItem(null);
		fldPreAvoidance.setSelectedItem(null);
		fldPreExposure.setSelectedItem(null);
		getRSA(new HRN(), lblPreRSA);
		fldPostHarm.setSelectedItem(null);
		fldPostLikelihood.setSelectedItem(null);
		fldPostAvoidance.setSelectedItem(null);
		fldPostExposure.setSelectedItem(null);
		getRSA(new HRN(), lblPostRSA);
		rdbtnTrueUpgrade.setSelected(false); 
		rdbtnFalseUpgrade.setSelected(false);
		rdbtnTrueFunction.setSelected(false); 
		rdbtnFalseFunction.setSelected(false);
		fldExplanation.setText(null);
		rdbtnTrueDanger.setSelected(false);
		rdbtnFalseDanger.setSelected(false);
		hiddenDanger();
		fldDanger.setText(null);
		rdbtnTrueStopTime.setSelected(false); 
		rdbtnFalseStopTime.setSelected(false);
	}

}
