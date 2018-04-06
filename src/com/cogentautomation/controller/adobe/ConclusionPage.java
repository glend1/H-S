package com.cogentautomation.controller.adobe;

import java.awt.Dimension;

import org.pdfclown.documents.Document;
import org.pdfclown.documents.PageFormat.OrientationEnum;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;

import com.cogentautomation.model.CustomImage;
import com.cogentautomation.model.Data;

public class ConclusionPage extends GenericAdobe {
	public ConclusionPage(Data data, Document document) {
		super(data, document);
	}

	public void make() {
		newPage(OrientationEnum.Portrait);
        if (nullCheck(data.getConclusion().getConclusion())) {
        	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	        setFont(true, 12);
	        blockComposer.showText("Conclusion");
	        setFont(false, 12);
	        blockComposer.showBreak(paragraphBreak);
	        blockComposer.showText(data.getConclusion().getConclusion());
	        endBlock(true);
        };
         
        newBlock(XAlignmentEnum.Center, YAlignmentEnum.Top);
        setFont(true, 12);
        for (CustomImage ii : data.getConclusion().getImages()) {
        	showImage(new Dimension(100, 100), ii);
        	blockComposer.showText("   ");
        }
        endBlock(true);
	}
}
