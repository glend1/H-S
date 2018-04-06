package com.cogentautomation.controller.adobe;

import java.awt.Dimension;

import org.pdfclown.documents.Document;
import org.pdfclown.documents.PageFormat.OrientationEnum;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;

import com.cogentautomation.model.Data;

public class MachinePage extends GenericAdobe {
	public MachinePage(Data data, Document document) {
		super(data, document);
	}

	public void make() {
		newPage(OrientationEnum.Portrait);
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    
	    setFont(true, 12);
	    
	    blockComposer.showText("Machine");
	    
	    endBlock(true);
	    
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
	    
	    tBreak = new Dimension(indentBreak.width * 7, 0);
	    
	    blockComposer.showBreak(tBreak);
	    
	    tBreak = new Dimension(indentBreak.width * 7, 2);
	    
	    if (nullCheck(data.getMachines().getMachine().getName())) {
	    	blockComposer.showText(data.getMachines().getMachine().getName());
	    	blockComposer.showBreak(tBreak);	    	
	    };
	    if (nullCheck(data.getMachines().getMachine().getType())) {
	    	blockComposer.showText(data.getMachines().getMachine().getType());
	    	blockComposer.showBreak(tBreak);	    	
	    };
	    if (nullCheck(data.getMachines().getMachine().getManufacturer())) {
	    	blockComposer.showText(data.getMachines().getMachine().getManufacturer());
	    	blockComposer.showBreak(tBreak);	    	
	    };
	    if (nullCheck(data.getMachines().getMachine().getSerial())) {
		    blockComposer.showText(data.getMachines().getMachine().getSerial());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getBuilt())) {
		    blockComposer.showText(data.getMachines().getMachine().getBuilt().toString());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getLocation())) {
		    blockComposer.showText(data.getMachines().getMachine().getLocation());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getModel())) {
		    blockComposer.showText(data.getMachines().getMachine().getModel());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getModifications())) {
	    	blockComposer.showText(data.getMachines().getMachine().getModifications());
	    	blockComposer.showBreak(tBreak);	    	
	    }
	    if (nullCheck(data.getMachines().getMachine().getEnergySources())) {
		    blockComposer.showText(data.getMachines().getMachine().getEnergySources());
		    blockComposer.showBreak(tBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getEnergyRatings())) {
	    	blockComposer.showText(data.getMachines().getMachine().getEnergyRatings());
	    	blockComposer.showBreak(tBreak);	    	
	    }
	    if (nullCheck(data.getMachines().getMachine().getSafetyMeasures())) {
		    blockComposer.showText(data.getMachines().getMachine().getSafetyMeasures());
		    blockComposer.showBreak(tBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getOperatorCount())) {
		    blockComposer.showText(data.getMachines().getMachine().getOperatorCount().toString());
		    blockComposer.showBreak(tBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getShiftCount())) {
		    blockComposer.showText(data.getMachines().getMachine().getShiftCount().toString());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getMonthlyHours())) {
		    blockComposer.showText(data.getMachines().getMachine().getMonthlyHours().toString());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getOperatingManuals())) {
		    blockComposer.showText(data.getMachines().getMachine().getOperatingManuals());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getOperatingProcedures())) {
		    blockComposer.showText(data.getMachines().getMachine().getOperatingProcedures());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getTrainingRecords())) {
		    blockComposer.showText(data.getMachines().getMachine().getTrainingRecords());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getWarningSigns())) {
		    blockComposer.showText(data.getMachines().getMachine().getWarningSigns());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getRawMaterials())) {
		    blockComposer.showText(data.getMachines().getMachine().getRawMaterials());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getMaintenanceManual())) {
		    blockComposer.showText(data.getMachines().getMachine().getMaintenanceManual());
		    blockComposer.showBreak(tBreak);
	    };
	    if (nullCheck(data.getMachines().getMachine().getMaintenanceTrainingRecord())) {
		    blockComposer.showText(data.getMachines().getMachine().getMaintenanceTrainingRecord());
		    blockComposer.showBreak(tBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getUntrainedAccess())) {
	    	blockComposer.showText(data.getMachines().getMachine().getUntrainedAccess());
	    };
	    
	    endBlock(false);
	    
	    
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
	    
	    if (nullCheck(data.getMachines().getMachine().getName())) {
		    blockComposer.showText("Name:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getType())) {
		    blockComposer.showText("Description:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getManufacturer())) {
		    blockComposer.showText("Manufacturer:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getSerial())) {
		    blockComposer.showText("Serial:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getBuilt())) {
		    blockComposer.showText("Manugacture Date:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getLocation())) {
		    blockComposer.showText("Location:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getModel())) {
		    blockComposer.showText("Model:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getModifications())) {
		    blockComposer.showText("Modifications:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getEnergySources())) {
		    blockComposer.showText("Energy Sources:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getEnergyRatings())) {
		    blockComposer.showText("Energy Rating:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getSafetyMeasures())) {
		    blockComposer.showText("Safety Measures:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getOperatorCount())) {
		    blockComposer.showText("Operator Count:");
		    blockComposer.showBreak(newLineBreak);
		}
	    if (nullCheck(data.getMachines().getMachine().getShiftCount())) {
		    blockComposer.showText("Shift Count:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getMonthlyHours())) {
		    blockComposer.showText("Monthly Hours:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getOperatingManuals())) {
		    blockComposer.showText("Operating Manuals:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getOperatingProcedures())) {
		    blockComposer.showText("Operating Procedures:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getTrainingRecords())) {
		    blockComposer.showText("Training Records:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getWarningSigns())) {
		    blockComposer.showText("Warning Signs:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getRawMaterials())) {
		    blockComposer.showText("Raw Materials:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getMaintenanceManual())) {
		    blockComposer.showText("Maintenance Manual:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getMaintenanceTrainingRecord())) {
		    blockComposer.showText("Maintenance Training Records:");
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getMachines().getMachine().getUntrainedAccess())) {
		    blockComposer.showText("Untrained Access:");
		    blockComposer.showBreak(lineBreak);
	    }
	   
	    tBreak = new Dimension(indentBreak.width * 3, indentBreak.height);
	    
	    if (nullCheck(data.getMachines().getMachine().getDescription())) {
		    setFont(true, 12);
	
		    blockComposer.showBreak(lineBreak);
	        blockComposer.showText("Basic Description");
	        
	        setFont(false, 12);
	        
	        blockComposer.showBreak(lineBreak);
		    blockComposer.showText(data.getMachines().getMachine().getDescription());
		    blockComposer.showBreak(lineBreak);
	    }
	    
	    if (nullCheck(data.getMachines().getMachine().getCertification())) {
		    setFont(true, 12);
	
	        blockComposer.showText("Certification");
	        
	        setFont(false, 12);
	        
	        blockComposer.showBreak(lineBreak);
		    blockComposer.showText(data.getMachines().getMachine().getCertification());
		    blockComposer.showBreak(lineBreak);
	    }
	    
	    if (nullCheck(data.getMachines().getMachine().getLongDescription())) {
		    setFont(true, 12);
	
	        blockComposer.showText("Control System Description");
	        
	        setFont(false, 12);
	        
	        blockComposer.showBreak(paragraphBreak);
		    blockComposer.showText(data.getMachines().getMachine().getLongDescription());
		    blockComposer.showBreak(lineBreak);
	    }
	    
	    if (nullCheck(data.getMachines().getMachine().getLimits())) {
		    setFont(true, 12);
	
	        blockComposer.showText("Machine Limits");
	        
	        setFont(false, 12);
	        
	        blockComposer.showBreak(lineBreak);
		    blockComposer.showText(data.getMachines().getMachine().getLimits());
		    blockComposer.showBreak(lineBreak);
	    }
	    
	    endBlock(true);
	    newBlock(XAlignmentEnum.Center, YAlignmentEnum.Top);
	    
	    setFont(false, 12);
	    
	    showImage(new Dimension(avWidth, 150), data.getMachines().getMachine().getImage());
	    
	    endBlock(true);
	}
}
