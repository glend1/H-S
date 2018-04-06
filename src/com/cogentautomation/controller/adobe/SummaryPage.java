package com.cogentautomation.controller.adobe;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Collections;

import org.pdfclown.documents.Document;
import org.pdfclown.documents.PageFormat.OrientationEnum;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;

import com.cogentautomation.controller.HazardComparator;
import com.cogentautomation.model.Data;
import com.cogentautomation.model.enumerator.hazard.GenericHazard;

public class SummaryPage extends GenericAdobe {
	public SummaryPage(Data data, Document document) {
		super(data, document);
	}

	public void make(ArrayList<GenericHazard> hazardList) {
    	Collections.sort(hazardList, new HazardComparator());
    	
    	int i = 1;
    	double tableW;
    	Double firstCell = null;
    	Double secondCell = null;
    	Double thirdCell = null;
    	Double forthCell = null;
    	Double fifthCell = null;
    	Double sixthCell = null;
    	Double seventhCell = null;
    	Double eighthCell = null;
    	
    	double cell1;
    	double cell2;
    	double cell3;
    	double cell4;
    	double cell5;
    	double cell6;
    	double cell7;
    	double cell8;
		
    	for (GenericHazard haz : hazardList) {
    		
    		if (i % summaryItems == 1) {
    			newPage(OrientationEnum.Landscape);
    			
    	    	tableW = (pageSize.getWidth() - Margin_X * 2) / 8;
    			firstCell = new Rectangle2D.Double(Margin_X, Margin_Y, tableW - 10, pageSize.getHeight() - Margin_Y * 2);
    			secondCell = new Rectangle2D.Double(Margin_X + tableW, Margin_Y, tableW - 10, pageSize.getHeight() - Margin_Y * 2);
    			thirdCell = new Rectangle2D.Double(Margin_X + (tableW * 2), Margin_Y, tableW - 10, pageSize.getHeight() - Margin_Y * 2);
    			forthCell = new Rectangle2D.Double(Margin_X + (tableW * 3), Margin_Y, tableW - 10, pageSize.getHeight() - Margin_Y * 2);
    			fifthCell = new Rectangle2D.Double(Margin_X + (tableW * 4), Margin_Y, tableW - 10, pageSize.getHeight() - Margin_Y * 2);
    			sixthCell = new Rectangle2D.Double(Margin_X + (tableW * 5), Margin_Y, tableW - 10, pageSize.getHeight() - Margin_Y * 2);
    			seventhCell = new Rectangle2D.Double(Margin_X + (tableW * 6), Margin_Y, tableW - 10, pageSize.getHeight() - Margin_Y * 2);
    			eighthCell = new Rectangle2D.Double(Margin_X + (tableW * 7), Margin_Y, tableW - 10, pageSize.getHeight() - Margin_Y * 2);
    			
    			newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, firstCell);
    	    	setFont(false, 12);
    	    	blockComposer.showText("Priority");
    	    	currY = 0;
    	    	endBlock(true);
    	    	cell1 = currY;
    	    	
    	    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, secondCell);
    	    	setFont(false, 12);
    	    	blockComposer.showText("Initial HRN");
    	    	currY = 0;
    	    	endBlock(true);
    	    	cell2 = currY;
    	    	
    	    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdCell);
    	    	setFont(false, 12);
    	    	blockComposer.showText("Hazard Name");
    	    	currY = 0;
    	    	endBlock(true);
    	    	cell3 = currY;
    	    	
    	    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, forthCell);
    	    	setFont(false, 12);
    	    	blockComposer.showText("Hazard Description");
    	    	currY = 0;
    	    	endBlock(true);
    	    	cell4 = currY;
    	    	
    	    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, fifthCell);
    	    	setFont(false, 12);
    	    	blockComposer.showText("Initial Risk Evaluation");
    	    	currY = 0;
    	    	endBlock(true);
    	    	cell5 = currY;
    	    	
    	    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, sixthCell);
    	    	setFont(false, 12);
    	    	blockComposer.showText("Risk Reduction Measures");
    	    	currY = 0;
    	    	endBlock(true);
    	    	cell6 = currY;
    	    	
    	    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, seventhCell);
    	    	setFont(false, 12);
    	    	blockComposer.showText("Residual HRN");
    	    	currY = 0;
    	    	endBlock(true);
    	    	cell7 = currY;
    	    	
    	    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, eighthCell);
    	    	setFont(false, 12);
    	    	blockComposer.showText("Residual Risk Evaluation");
    	    	currY = 0;
    	    	endBlock(true);
    	    	cell8 = currY;
    	    	
    	    	currY = 0;
    	    	if (cell1 > cell2) {
    	    		currY = cell1;
    	    	} else {
    	    		currY = cell2;
    	    	}
    	    	if (cell3 > currY) {
    	    		currY = cell3;
    	    	}
    	    	if (cell4 > currY) {
    	    		currY = cell4;
    	    	}
    	    	if (cell5 > currY) {
    	    		currY = cell5;
    	    	}
    	    	if (cell6 > currY) {
    	    		currY = cell6;
    	    	}
    	    	if (cell7 > currY) {
    	    		currY = cell7;
    	    	}
    	    	if (cell8 > currY) {
    	    		currY = cell8;
    	    	}
    	    	
    			firstCell.y = Margin_Y + currY;
    			secondCell.y = Margin_Y + currY;
    			thirdCell.y = Margin_Y + currY;
    			forthCell.y = Margin_Y + currY;
    			fifthCell.y = Margin_Y + currY;
    			sixthCell.y = Margin_Y + currY;
    			seventhCell.y = Margin_Y + currY;
    			eighthCell.y = Margin_Y + currY;
    		}
    		
    		newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, firstCell);
        	setFont(false, 12);
	    	blockComposer.showText(Integer.toString(i));
	    	i++;
	    	currY = firstCell.y;
	    	endBlock(true);
	    	cell1 = currY;
	    	
	    	if (nullCheck(haz.getHazardDetails().getPre().getScore())) {
		    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, secondCell);
	        	setFont(false, 12);
	        	blockComposer.showText(haz.getHazardDetails().getPre().getScore().toString());
	        	currY = secondCell.y;
		    	endBlock(true);
	    	};
	    	cell2 = currY;
	    	
	    	if (nullCheck(haz.getHazardDetails().getName())) {
		    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdCell);
	        	setFont(false, 12);
	        	blockComposer.showText(haz.getHazardDetails().getName());
	        	currY = thirdCell.y;
		    	endBlock(true);
	    	};
	    	cell3 = currY;
	    	
	    	if (nullCheck(haz.getConsequence())) {
		    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, forthCell);
	        	setFont(false, 12);
	        	blockComposer.showText(haz.getConsequence().toString());
	        	currY = forthCell.y;
		    	endBlock(true);
	    	};
	    	cell4 = currY;
	    	
	    	if (nullCheck(haz.getHazardDetails().getPre().getRSA())) {
		    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, fifthCell);
	        	setFont(false, 12);
	        	ColourCode(haz.getHazardDetails().getPre().getRSA().getColour(), fifthCell.width);
	        	currY = fifthCell.y;
		    	endBlock(true);
	    	};
	    	cell5 = currY;
	    	
	    	if (nullCheck(haz.getHazardDetails().getPre().getRSA())) {
		    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, sixthCell);
	        	setFont(false, 12);
	        	blockComposer.showText(haz.getHazardDetails().getPre().getRSA().getLongDescription());
	        	currY = sixthCell.y;
		    	endBlock(true);
	    	};
	    	cell6 = currY;
	    	
	    	if (nullCheck(haz.getHazardDetails().getPost().getScore())) {
		    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, seventhCell);
	        	setFont(false, 12);
	        	blockComposer.showText(haz.getHazardDetails().getPost().getScore().toString());
	        	currY = seventhCell.y;
		    	endBlock(true);
	    	};
	    	cell7 = currY;
	    	
	    	if (nullCheck(haz.getHazardDetails().getPost().getRSA())) {
		    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, eighthCell);
	        	setFont(false, 12);
	        	ColourCode(haz.getHazardDetails().getPost().getRSA().getColour(), eighthCell.width);
	        	currY = eighthCell.y;
		    	endBlock(true);
	    	};
	    	cell8 = currY;
	    	
	    	currY = 0;
        	if (cell1 > cell2) {
        		currY = cell1;
        	} else {
        		currY = cell2;
        	}
        	if (cell3 > currY) {
        		currY = cell3;
        	}
        	if (cell4 > currY) {
        		currY = cell4;
        	}
        	if (cell5 > currY) {
        		currY = cell5;
        	}
        	if (cell6 > currY) {
        		currY = cell6;
        	}
        	if (cell7 > currY) {
        		currY = cell7;
        	}
        	if (cell8 > currY) {
        		currY = cell8;
        	}
        	
    		firstCell.y = currY;
    		secondCell.y = currY;
    		thirdCell.y = currY;
    		forthCell.y = currY;
    		fifthCell.y = currY;
    		sixthCell.y = currY;
    		seventhCell.y = currY;
    		eighthCell.y = currY;
	    	
    	}
	}
}
