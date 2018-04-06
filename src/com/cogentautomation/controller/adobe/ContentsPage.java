package com.cogentautomation.controller.adobe;

import java.awt.Dimension;
import java.util.ArrayList;

import org.pdfclown.documents.Document;
import org.pdfclown.documents.PageFormat.OrientationEnum;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;

import com.cogentautomation.model.Data;
import com.cogentautomation.model.Zone;
import com.cogentautomation.model.enumerator.hazard.GenericHazard;

public class ContentsPage extends GenericAdobe {
	public ContentsPage(Data data, Document document) {
		super(data, document);
	}

	public void make(ArrayList<GenericHazard> hazardList) {
		
		int i = (int) (3 + Math.ceil((hazardList.size() + 12)) / 32);
		int j = 0;
		
		newPage(OrientationEnum.Portrait);
		
		newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
        blockComposer.showText("Motivation");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showText(Integer.toString(i));
	    endBlock(true);
	    j++;
	    
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
        blockComposer.showText("Client");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showText(Integer.toString(i));
	    endBlock(true);
	    j++;
	    
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
        blockComposer.showText("Assessor");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showText(Integer.toString(i));
	    endBlock(true);
	    j++;
	    
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
        blockComposer.showText("Reviewer");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showText(Integer.toString(i));
	    endBlock(true);
	    j++;
	    
	    i++;

	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
        blockComposer.showText("Machine");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showText(Integer.toString(i));
	    endBlock(true);
	    j++;
	    
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showBreak(new Dimension(24, 0));
        blockComposer.showText("Machine Description");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showText(Integer.toString(i));
	    endBlock(true);
	    j++;
	    
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showBreak(new Dimension(24, 0));
        blockComposer.showText("Certification");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showText(Integer.toString(i));
	    endBlock(true);
	    j++;
	    
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showBreak(new Dimension(24, 0));
        blockComposer.showText("Control System Description");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showText(Integer.toString(i));
	    endBlock(true);
	    j++;
	    
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showBreak(new Dimension(24, 0));
        blockComposer.showText("Machine Limits");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showText(Integer.toString(i));
	    endBlock(true);
	    j++;
	    
	    i++;
	    
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    setFont(false, 12);
        blockComposer.showText("Method of Analysis");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
	    setFont(false, 12);
	    blockComposer.showText(Integer.toString(i));
	    endBlock(true);
	    j++;
	    
	    i += 2; //this is actually 3, 2 is used for the loop
	    
        for (Zone zone : data.getMachines().getMachine().getZones().getZones()) {
        	
        	i++;
	    
		    dynamicPage(j);
        	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
		    setFont(false, 12);
	        blockComposer.showText(zone.getName());
	        endBlock(false);
	        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
		    setFont(false, 12);
		    blockComposer.showText(Integer.toString(i));
		    endBlock(true);
		    j++;
		    
		    for (GenericHazard gh : zone.getHazards().getHazards()) {
		    	
		    	i++;
		    
		    	dynamicPage(j);
		    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
			    setFont(false, 12);
			    blockComposer.showBreak(new Dimension(24, 0));
		        blockComposer.showText(gh.getHazardDetails().getName());
		        endBlock(false);
		        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
			    setFont(false, 12);
			    blockComposer.showText(Integer.toString(i));
			    endBlock(true);
			    j++;
			    
		    }
		    
        }
        
        
        i++;
		    
	    dynamicPage(j);
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        blockComposer.showText("Summary");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
        setFont(false, 12);
        blockComposer.showText(Integer.toString(i));
        endBlock(true);
        j++;
        
        //TEST THIS
        i += (Math.ceil((float)hazardList.size() / (float)summaryItems));
        
        dynamicPage(j);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        blockComposer.showText("Conclusion");
        endBlock(false);
        newBlock(XAlignmentEnum.Right, YAlignmentEnum.Top);
        setFont(false, 12);
        blockComposer.showText(Integer.toString(i));
        endBlock(true);
        j++;
         
	}
	
	private void dynamicPage(int i) {
		if ((i % 32) == 0) {
			newPage(OrientationEnum.Portrait);
		}
	}
}
