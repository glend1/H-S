package com.cogentautomation.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.cogentautomation.controller.AdobeController;
import com.cogentautomation.controller.ExportController;
import com.cogentautomation.controller.ImageResize;
import com.cogentautomation.controller.ImportController;
import com.cogentautomation.controller.NavigationController;
import com.cogentautomation.controller.Utils;
import com.cogentautomation.controller.listeners.BooleanListener;
import com.cogentautomation.controller.listeners.FileListener;
import com.cogentautomation.controller.listeners.HazardListener;
import com.cogentautomation.controller.listeners.ImageListener;
import com.cogentautomation.controller.listeners.StringListener;
import com.cogentautomation.model.Conclusion;
import com.cogentautomation.model.Data;
import com.cogentautomation.model.Machine;
import com.cogentautomation.model.Person;
import com.cogentautomation.model.Zone;
import com.cogentautomation.model.enumerator.HazardSelection;
import com.cogentautomation.model.enumerator.hazard.GenericHazard;
import com.cogentautomation.view.cards.ViewBlank;
import com.cogentautomation.view.cards.ViewConclusion;
import com.cogentautomation.view.cards.ViewEvent;
import com.cogentautomation.view.cards.ViewGeneral;
import com.cogentautomation.view.cards.ViewMachine;
import com.cogentautomation.view.cards.ViewOrigin;
import com.cogentautomation.view.cards.ViewPeople;
import com.cogentautomation.view.cards.ViewZone;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;

public class ViewMain {
	//TODO: add a delete button on the hazard in the nav menu and update the data/hazard-view 
	private JFrame frmMachinerySafetyAssessment = new JFrame();
	private JTree tree;
	private Data data = new Data();
	private JButton btnAdd;
	private JButton btnDelete;
	private ViewAddNode addNode;
	private ViewGeneral general = new ViewGeneral();
	private ViewPeople people = new ViewPeople();
	private ViewMachine machine = new ViewMachine();
	private ViewZone zone = new ViewZone();
	private ViewEvent event = new ViewEvent();
	private ViewOrigin origin = new ViewOrigin();
	private ViewConclusion conclusion = new ViewConclusion();
	private ViewAbout about = new ViewAbout();
	private ViewConfirm confirm = new ViewConfirm(frmMachinerySafetyAssessment);
	protected DefaultMutableTreeNode treeSelection;
	private DefaultMutableTreeNode parentNode;
	private ViewAdobeChooser adobeChooser;
	private JPanel cards;
	private CardLayout layout;
	private JLabel imgImage;
	private JPanel generalPanel;
	private JPanel machinePanel;
	private JPanel peoplePanel;
	private JPanel zonePanel;
	private JPanel eventPanel;
	private JPanel originPanel;
	private JPanel conclusionPanel;
	private JPanel imagePanel;
	private JPanel buttonPanel;
	private ExportController export;
	private ImportController importC;
	private JPanel blankPanel;
	private ViewBlank blank = new ViewBlank();
	
	private void reloadTree (Data data) {
		NavigationController nc = new NavigationController();
		tree.setModel(nc.newData(data));
		SwingUtilities.invokeLater(
	    		 new Runnable() {
	    			 @Override
	    			 public void run() {
	    				 ((DefaultTreeModel) tree.getModel()).reload();	    	
	    			 }
	    		 }
	     );
	}
	
	private void reloadNode (DefaultMutableTreeNode node) {
		((DefaultTreeModel) tree.getModel()).reload(node);
	}
	
	private void close() {
	        ViewClose vc = new ViewClose();
	        vc.setVisible(true);
	}
	
	private void setSelection() {
		TreePath path = tree.getSelectionPath();
		if (path != null) {
			treeSelection = (DefaultMutableTreeNode) path.getLastPathComponent();
			parentNode = (DefaultMutableTreeNode) path.getPathComponent(path.getPathCount() - 2);
		} else {
			//treeSelection = (DefaultMutableTreeNode) tree.getModel().getRoot();
			//parentNode = null;
		}
	}
	
	private DefaultMutableTreeNode getMachineNode() {
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
		DefaultMutableTreeNode machineNode = null;
		for (int i = 0; i < tree.getModel().getChildCount(root); i++) {
			if (tree.getModel().getChild(root, i).toString().trim().equalsIgnoreCase("machine")) {
				machineNode = (DefaultMutableTreeNode)tree.getModel().getChild(root, i);
				break;
			}
		}
		return machineNode;
	}
	
	public void changeMainFrame(DefaultMutableTreeNode selection) {
		Object obj = selection.getUserObject();
		removeImage();
		switch (selection.getUserObject().getClass().getSimpleName()) {
		case "Data":
			SwingUtilities.invokeLater(
					new Runnable() {
					    @Override
					    public void run() {
					    	layout.show(cards, "general");
					    	general.loadData((Data)obj);					    	
					    }
					});
			break;
		case "Machine":
			SwingUtilities.invokeLater(
					new Runnable() {
					    @Override
					    public void run() {
							machine.getDatePicker().setPrefWidth(machine.getTextField().getWidth());
							layout.show(cards, "machine");
							machine.loadData((Machine)obj);
					    }
					});
			break;
		case "Person":
			SwingUtilities.invokeLater(
					new Runnable() {
					    @Override
					    public void run() {
							people.getDatePicker().setPrefWidth(people.getTextField().getWidth());
							layout.show(cards, "people");
							people.loadData((Person)obj);
					    }
					});
			break;
		case "Zone":
			SwingUtilities.invokeLater(
					new Runnable() {
					    @Override
					    public void run() {
							layout.show(cards, "zone");
							zone.loadData((Zone)obj);
					    }
					});
			break;			
		case "EventHazard":
		case "TaskHazard":
			SwingUtilities.invokeLater(
					new Runnable() {
					    @Override
					    public void run() {
							layout.show(cards, "event");
							event.loadData((GenericHazard)obj);
					    }
					});
			break;
		case "OriginHazard":
			SwingUtilities.invokeLater(
					new Runnable() {
					    @Override
					    public void run() {
							layout.show(cards, "origin");
							origin.loadData((GenericHazard)obj);
					    }
					});
			break;
		case "Conclusion":
			SwingUtilities.invokeLater(
					new Runnable() {
					    @Override
					    public void run() {
							layout.show(cards, "conclusion");
							conclusion.loadData((Conclusion)obj);
					    }
					});
			break;
		default:
			SwingUtilities.invokeLater(
					new Runnable() {
					    @Override
					    public void run() {
							layout.show(cards, "blank");
					    }
					});
			break;				
		}
	}
	

	private void removeImage() {
		imgImage.setIcon(null);
		imagePanel.setVisible(false);
	}
	
	public void addNode(DefaultMutableTreeNode existingNode, DefaultMutableTreeNode newNode) {
		existingNode.add(newNode);
		reloadNode(existingNode);
	}

	public void removeNode(DefaultMutableTreeNode parent, DefaultMutableTreeNode existingNode) {
		parent.remove(existingNode);
		reloadNode(parent);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMain window = new ViewMain();
					window.frmMachinerySafetyAssessment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMachinerySafetyAssessment.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewMain.class.getResource("/com/cogentautomation/Cogent-Automation-Logo.png")));
		frmMachinerySafetyAssessment.setTitle("Machinery Safety Assessment");
		frmMachinerySafetyAssessment.setResizable(false);
		frmMachinerySafetyAssessment.setBounds(100, 100, 1024, 765);
		frmMachinerySafetyAssessment.setLocationRelativeTo(null);
		frmMachinerySafetyAssessment.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 
		frmMachinerySafetyAssessment.addWindowListener( new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		    	close();
		    }
		});
		
		JMenuBar menuBar = new JMenuBar();
		frmMachinerySafetyAssessment.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		confirm.setBooleanListener(new BooleanListener() {
			@Override
			public void booleanEmitted(boolean bool) {
				if (bool) {
					removeImage();
					general.clear();
					people.clear();
					machine.clear();
					zone.clear();
					event.clear();
					origin.clear();
					conclusion.clear();
					data = new Data();
					reloadTree(data);
					SwingUtilities.invokeLater(
						new Runnable() {
						    @Override
						    public void run() {
								layout.show(cards, "blank");
						    }
						}
					);
				};
			};
		});
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirm.setVisible(true);
				
			}
		});
		mntmNew.setIcon(new ImageIcon(ViewMain.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open...");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importC = new ImportController();
				importC.getFileChooser().setVisible(true);
				
				importC.getFileChooser().setFileListener(new FileListener() {

					@Override
					public void fileEmitted(File file) {
						try {
							 FileInputStream fileIn = new FileInputStream(file);
						     ObjectInputStream in = new ObjectInputStream(fileIn);
						     data = ((Data) in.readObject());
						     reloadTree(data);
						     in.close();
						     fileIn.close();
						     frmMachinerySafetyAssessment.setTitle("Machinery Safety Assessment - " + file);
						} catch (IOException | ClassNotFoundException e) {
							e.printStackTrace();
						}
						SwingUtilities.invokeLater(
							new Runnable() {
								@Override
								public void run() {
									layout.show(cards, "blank");
								}
							}
						);
					}

				});
			}
		});
		mntmOpen.setIcon(new ImageIcon(ViewMain.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save...");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				export = new ExportController();
				export.Save(data, frmMachinerySafetyAssessment);
			}
		});
		mntmSave.setIcon(new ImageIcon(ViewMain.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mnFile.add(mntmSave);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExport = new JMenuItem("Export...");
		mntmExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adobeChooser = new ViewAdobeChooser();
				adobeChooser.setFileListener(new FileListener() {
					@Override
					public void fileEmitted(File file) {
						AdobeController ac = new AdobeController();
						try {
							ac.write(data, file.getPath());
						} catch (NullPointerException e) {
							ViewError error = new ViewError("Could not Export PDF.");
							error.setVisible(true);
						}
					}
				});
				adobeChooser.setVisible(true);
			}
		});
		mntmExport.setIcon(null);
		mnFile.add(mntmExport);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.setEnabled(false);
		mnHelp.add(mntmHelp);
		
		JSeparator separator_2 = new JSeparator();
		mnHelp.add(separator_2);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
		
		JPanel panel = new JPanel();
		frmMachinerySafetyAssessment.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		buttonPanel = new JPanel();
		panel_2.add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new MigLayout("", "[][]", "[]"));
		
		
		btnAdd = new JButton("Add Zone...");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNode = new ViewAddNode();
				addNode.setStringListener(new StringListener() {
					public void textEmitted(String text) {
						if (!text.isEmpty()) {
							Machine machData = (Machine)getMachineNode().getUserObject();
							Zone zone = new Zone();
							zone.setName(text);
							machData.getZones().newZone(zone);
							DefaultMutableTreeNode tn = new DefaultMutableTreeNode(zone);
							addNode(getMachineNode(), tn);
							TreePath tp = Utils.getPath(tn);
							tree.setSelectionPath(tp);
						};
					}
				});
				addNode.setVisible(true);
			}
		});
		buttonPanel.add(btnAdd, "cell 0 0,grow");
		
		btnDelete = new JButton("Delete Zone");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Machine machData = (Machine)getMachineNode().getUserObject();
				setSelection();
				for (Zone zone : machData.getZones().getZones()) {
					Zone selection = (Zone)treeSelection.getUserObject();
					if (zone == selection) {
						machData.getZones().removeZone(zone);
						removeNode(parentNode, treeSelection);
					}
				};
			};
		});
		buttonPanel.add(btnDelete, "cell 1 0,grow");
		
		imagePanel = new JPanel();
		imagePanel.setVisible(false);
		imagePanel.setBorder(null);
		panel_2.add(imagePanel, BorderLayout.SOUTH);
		
		imgImage = new JLabel();
		imgImage.setBorder(null);
		ImageListener listener = new ImageListener() {
			@Override
			public void imageEmitted(ImageIcon image) {
				imgImage.setIcon(ImageResize.resize(buttonPanel.getWidth() - 10, image));
				imagePanel.setVisible(true);
			};
		};
		machine.setImageListener(listener);
		zone.setImageListener(listener);
		origin.setImageListener(listener);
		general.setImageListener(listener);
		event.setImageListener(listener);
		imagePanel.add(imgImage);
		
		general.loadData(data);
		
		tree = new JTree();
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				TreePath path = arg0.getPath();
				setSelection();
				changeMainFrame(treeSelection);
				if (path.getPathCount() == 3 && path.getPathComponent(1).toString().trim().equalsIgnoreCase("machine") ) {
					btnDelete.setEnabled(true);
				} else {
					btnDelete.setEnabled(false);
				}				
			}
		});
		reloadTree(data);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setRootVisible(false);
		treeSelection = (DefaultMutableTreeNode) tree.getModel().getRoot();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setPreferredSize(buttonPanel.getPreferredSize());
		scrollPane.setViewportView(tree);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		
		generalPanel = new JPanel();
		JScrollPane generalScroll = new JScrollPane();
		generalScroll.setBorder(null);
		generalScroll.getVerticalScrollBar().setUnitIncrement(16);
		generalPanel.setLayout(new BorderLayout(0, 0));
		generalScroll.setViewportView(general);
		generalPanel.add(generalScroll);
		
		machinePanel = new JPanel();
		JScrollPane machineScroll = new JScrollPane();
		machineScroll.setBorder(null);
		machineScroll.getVerticalScrollBar().setUnitIncrement(16);
		machinePanel.setLayout(new BorderLayout(0, 0));
		machineScroll.setViewportView(machine);
		machinePanel.add(machineScroll);
		
		peoplePanel = new JPanel();
		JScrollPane peopleScroll = new JScrollPane();
		peopleScroll.setBorder(null);
		peopleScroll.getVerticalScrollBar().setUnitIncrement(16);
		peoplePanel.setLayout(new BorderLayout(0, 0));
		peopleScroll.setViewportView(people);
		peoplePanel.add(peopleScroll);
		
		zone.setHazardListener(new HazardListener() {
			@Override
			public void hazardEmitted(GenericHazard hazard) {
				DefaultMutableTreeNode dtn = null;
				setSelection();
				for (int i = 0 ; i < treeSelection.getChildCount(); i++) {
					if (hazard.compareTo((GenericHazard)((DefaultMutableTreeNode)treeSelection.getChildAt(i)).getUserObject())) {
						dtn = (DefaultMutableTreeNode)treeSelection.getChildAt(i);
						break;
					}
				}
				if (hazard.getHazard() == HazardSelection.HAZARD) {
					if (dtn == null) {
						//TODO: Create tree to mirror to mirror hazard list
						/*DefaultMutableTreeNode hazardNode = null;
						DefaultMutableTreeNode typeNode;
						DefaultMutableTreeNode originNode;
						DefaultMutableTreeNode consequenceNode;
						switch (hazard.getClass().getSimpleName().toLowerCase()) {
							case ("eventhazard"):
								hazardNode = new DefaultMutableTreeNode("Event");
								break;
							case ("originhazard"):
								hazardNode = new DefaultMutableTreeNode("Origin");
								break;
							case ("taskhazard"):
								hazardNode = new DefaultMutableTreeNode("Task");
								break;
							default:
								hazardNode = new DefaultMutableTreeNode("Unknown Hazard");
						}
						addNode(treeSelection, hazardNode);
						typeNode = new DefaultMutableTreeNode(hazard.getType());
						addNode(hazardNode, typeNode);
						if (hazard.getClass().getSimpleName().equalsIgnoreCase("originhazard")) {
							originNode = new DefaultMutableTreeNode(hazard.getOrigin());
							addNode(typeNode, originNode);
							consequenceNode = new DefaultMutableTreeNode(hazard);
							addNode(originNode, consequenceNode);
						} else {
							originNode = new DefaultMutableTreeNode(hazard);
							addNode(typeNode, originNode);
						}*/
						addNode(treeSelection, new DefaultMutableTreeNode(hazard));
						TreePath tp = Utils.getPath(treeSelection);
						tree.setSelectionPath(tp);
					}
				} else {
					if (dtn != null) {
						removeNode(treeSelection, dtn);
						//TODO: tidy tree as necessary
					}
				}
			}
		});
		zonePanel = new JPanel();
		JScrollPane zoneScroll = new JScrollPane();
		zoneScroll.setBorder(null);
		zoneScroll.getVerticalScrollBar().setUnitIncrement(16);
		zonePanel.setLayout(new BorderLayout(0, 0));
		zoneScroll.setViewportView(zone);
		zonePanel.add(zoneScroll);
		
		eventPanel = new JPanel();
		JScrollPane eventScroll = new JScrollPane();
		eventScroll.setBorder(null);
		eventScroll.getVerticalScrollBar().setUnitIncrement(16);
		eventPanel.setLayout(new BorderLayout(0, 0));
		eventScroll.setViewportView(event);
		eventPanel.add(eventScroll);
		
		originPanel = new JPanel();
		JScrollPane originScroll = new JScrollPane();
		originScroll.setBorder(null);
		originScroll.getVerticalScrollBar().setUnitIncrement(16);
		originPanel.setLayout(new BorderLayout(0, 0));
		originScroll.setViewportView(origin);
		originPanel.add(originScroll);
		
		blankPanel = new JPanel();
		JScrollPane blankScroll = new JScrollPane();
		blankScroll.setBorder(null);
		blankScroll.getVerticalScrollBar().setUnitIncrement(16);
		blankPanel.setLayout(new BorderLayout(0, 0));
		blankScroll.setViewportView(blank);
		blankPanel.add(blankScroll);
		
		conclusionPanel = new JPanel();
		JScrollPane conclusionScroll = new JScrollPane();
		conclusionScroll.setBorder(null);
		conclusionScroll.getVerticalScrollBar().setUnitIncrement(16);
		conclusionPanel.setLayout(new BorderLayout(0, 0));
		conclusionScroll.setViewportView(conclusion );
		conclusionPanel.add(conclusionScroll);
		
		cards = new JPanel();
		frmMachinerySafetyAssessment.getContentPane().add(cards, BorderLayout.CENTER);
		cards.setLayout(new CardLayout(0, 0));
		
		cards.add(blankPanel, "blank");
		cards.add(generalPanel, "general");
		cards.add(machinePanel, "machine");
		cards.add(peoplePanel, "people");
		cards.add(zonePanel, "zone");
		cards.add(eventPanel, "event");
		cards.add(originPanel, "origin");
		cards.add(conclusionPanel, "conclusion");
		
		layout = (CardLayout)(cards.getLayout());
	}
}
