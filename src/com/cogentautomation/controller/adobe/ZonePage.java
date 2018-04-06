package com.cogentautomation.controller.adobe;

import java.awt.Dimension;

import org.pdfclown.documents.Document;
import org.pdfclown.documents.PageFormat.OrientationEnum;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;

import com.cogentautomation.model.Data;
import com.cogentautomation.model.Zone;

public class ZonePage extends GenericAdobe {
	public ZonePage(Data data, Document document) {
		super(data, document);
	}

	public void make(Zone zone) {
    	newPage(OrientationEnum.Portrait);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
    	setFont(false, 12);
    	
    	if (nullCheck(zone.getName())) {
        	setFont(true, 12);
        	
        	blockComposer.showText(zone.getName());
        	
        	setFont(false, 12);
            
            blockComposer.showBreak(lineBreak);
    	};
    	if (nullCheck(zone.getDescription())) {
    	    blockComposer.showText(zone.getDescription());
    	    blockComposer.showBreak(lineBreak);
    	}
    	
    	endBlock(true);
    	
	    newBlock(XAlignmentEnum.Center, YAlignmentEnum.Top);
	    
	    setFont(false, 12);
	    
	    showImage(new Dimension(avWidth, 150), zone.getImage());
	    
	    endBlock(true);
	}
}
