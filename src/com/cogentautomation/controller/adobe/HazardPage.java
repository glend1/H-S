package com.cogentautomation.controller.adobe;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import org.pdfclown.documents.Document;
import org.pdfclown.documents.PageFormat.OrientationEnum;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;

import com.cogentautomation.model.Data;
import com.cogentautomation.model.enumerator.hazard.GenericHazard;

public class HazardPage extends GenericAdobe {
	public HazardPage(Data data, Document document) {
		super(data, document);
	}

	public void make(GenericHazard gh) {
		newPage(OrientationEnum.Landscape);
		
		double w = (pageSize.getWidth() - Margin_X * 2) / 3;
		
		Double firstBlock = new Rectangle2D.Double(Margin_X, Margin_Y, w - 10, pageSize.getHeight() - Margin_Y * 2);
		Double secondBlock = new Rectangle2D.Double(Margin_X + w, Margin_Y, w - 10, pageSize.getHeight() - Margin_Y * 2);
		Double thirdBlock = new Rectangle2D.Double(Margin_X + (w * 2), Margin_Y, w, pageSize.getHeight() - Margin_Y * 2);
		
		currY = 0;
    	if (nullCheck(gh.getHazardDetails().getName())) {
    		newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, firstBlock);
        	setFont(false, 12);
        	
        	blockComposer.showText(gh.getHazardDetails().getName());
        	
        	endBlock(true);
        	firstBlock.y = Margin_Y + currY;
    	};
    	newBlock(XAlignmentEnum.Center, YAlignmentEnum.Top, firstBlock);
    	setFont(false, 12);
    	
    	showImage(new Dimension((int) firstBlock.width, 200), gh.getHazardDetails().getImage());
    	
    	endBlock(true);
    	firstBlock.y = Margin_Y + currY;
    	if (nullCheck(gh.getHazardDetails().getHazardDanger())) {
        	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, firstBlock);
        	setFont(false, 12);
        	
        	blockComposer.showText("Is there an immediate danger from this hazard?");
        	blockComposer.showBreak(newLineBreak);
        	if (gh.getHazardDetails().getHazardDanger()) {
        		blockComposer.showText(gh.getHazardDetails().getHazardDangerDescription());
        	} else {
        		blockComposer.showText("No");
        	};
        	
        	endBlock(true);
    	};
    	double currFirst = currY;
    	currY = 0;
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, secondBlock);
    	setFont(false, 12);
    	
    	if (nullCheck(gh.getHazardDetails().getMode())) {
        	blockComposer.showText(gh.getHazardDetails().getMode().toString());
        	blockComposer.showBreak(lineBreak);
    	};
    	blockComposer.showText("Pre-Measures HRN Score");
    	
    	endBlock(true);
    	secondBlock.y = Margin_Y + currY;
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, secondBlock);
    	setFont(false, 12);
    	
    	blockComposer.showText("DPH");
    	blockComposer.showBreak(newLineBreak);
    	if (nullCheck(gh.getHazardDetails().getPre().getDPH())) {
    		blockComposer.showText(gh.getHazardDetails().getPre().getDPH().getValue().toString());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, secondBlock);
    	setFont(false, 12);
    	
    	blockComposer.showBreak(new Dimension(32, 0));
    	blockComposer.showText("LO");
    	blockComposer.showBreak(new Dimension(32, 2));
    	if (nullCheck(gh.getHazardDetails().getPre().getLO())) {
    		blockComposer.showText(gh.getHazardDetails().getPre().getLO().getValue().toString());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, secondBlock);
    	setFont(false, 12);
    	
    	blockComposer.showBreak(new Dimension(32*2, 0));
    	blockComposer.showText("PA");
    	blockComposer.showBreak(new Dimension(32*2, 2));
    	if (nullCheck(gh.getHazardDetails().getPre().getPA())) {
    		blockComposer.showText(gh.getHazardDetails().getPre().getPA().getValue().toString());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, secondBlock);
    	setFont(false, 12);
    	
    	blockComposer.showBreak(new Dimension(32*3, 0));
    	blockComposer.showText("FE");
    	blockComposer.showBreak(new Dimension(32*3, 2));
    	if (nullCheck(gh.getHazardDetails().getPre().getFE())) {
    		blockComposer.showText(gh.getHazardDetails().getPre().getFE().getValue().toString());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, secondBlock);
    	setFont(false, 12);
    	
    	blockComposer.showBreak(new Dimension(32*4, 0));
    	blockComposer.showText("Initial RSA");
    	blockComposer.showBreak(new Dimension(32*4, 2));
    	if (nullCheck(gh.getHazardDetails().getPre().getScore())) {
    		blockComposer.showText(gh.getHazardDetails().getPre().getScore().toString());
    	};
    	
    	endBlock(true);
    	secondBlock.y = Margin_Y + currY;
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, secondBlock);
    	setFont(false, 12);
    	
    	if (nullCheck(gh.getType())) {
        	blockComposer.showText("Hazard Type");
        	blockComposer.showBreak(newLineBreak);
        	blockComposer.showText(gh.getType().toString());
        	blockComposer.showBreak(lineBreak);
    	};
    	if (nullCheck(gh.getOrigin())) {
        	blockComposer.showText("Hazard Target");
        	blockComposer.showBreak(newLineBreak);
        	blockComposer.showText(gh.getOrigin().toString());
        	blockComposer.showBreak(lineBreak);
    	};
    	if (nullCheck(gh.getConsequence())) {
        	blockComposer.showText("Hazard Description");
        	blockComposer.showBreak(newLineBreak);
        	blockComposer.showText(gh.getConsequence().toString());
        	blockComposer.showBreak(lineBreak);
    	};
    	if (nullCheck(gh.getHazardDetails().getHazardExplanation())) {
        	blockComposer.showText("Hazard Explanation");
        	blockComposer.showBreak(newLineBreak);
        	blockComposer.showText(gh.getHazardDetails().getHazardExplanation());
    	};
    	
    	endBlock(true);
    	double currSecond = currY;
    	currY = 0;
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);
    	
    	if (nullCheck(gh.getHazardDetails().getTask())) {
        	blockComposer.showText(gh.getHazardDetails().getTask().toString());
        	blockComposer.showBreak(lineBreak);
    	};
    	blockComposer.showText("Post-Measures HRN Score");
    	
    	endBlock(true);
    	thirdBlock.y = Margin_Y + currY;
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);
    	
    	blockComposer.showText("DPH");
    	blockComposer.showBreak(newLineBreak);
    	if (nullCheck(gh.getHazardDetails().getPost().getDPH())) {
    		blockComposer.showText(gh.getHazardDetails().getPost().getDPH().getValue().toString());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);
    	
    	blockComposer.showBreak(new Dimension(32, 0));
    	blockComposer.showText("LO");
    	blockComposer.showBreak(new Dimension(32, 2));
    	if (nullCheck(gh.getHazardDetails().getPost().getLO())) {
    		blockComposer.showText(gh.getHazardDetails().getPost().getLO().getValue().toString());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);
    	
    	blockComposer.showBreak(new Dimension(32*2, 0));
    	blockComposer.showText("PA");
    	blockComposer.showBreak(new Dimension(32*2, 2));
    	if (nullCheck(gh.getHazardDetails().getPost().getPA())) {
    		blockComposer.showText(gh.getHazardDetails().getPost().getPA().getValue().toString());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);
    	
    	blockComposer.showBreak(new Dimension(32*3, 0));
    	blockComposer.showText("FE");
    	blockComposer.showBreak(new Dimension(32*3, 2));
    	if (nullCheck(gh.getHazardDetails().getPost().getFE())) {
    		blockComposer.showText(gh.getHazardDetails().getPost().getFE().getValue().toString());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);
    	
    	blockComposer.showBreak(new Dimension(32*4, 0));
    	blockComposer.showText("Residual RSA");
    	blockComposer.showBreak(new Dimension(32*4, 2));
    	if (nullCheck(gh.getHazardDetails().getPost().getScore())) {
    		blockComposer.showText(gh.getHazardDetails().getPost().getScore().toString());
    	};
    	
    	endBlock(true);
    	thirdBlock.y = Margin_Y + currY;
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);
    	
    	blockComposer.showText("S");
    	blockComposer.showBreak(newLineBreak);
    	if (nullCheck(gh.getHazardDetails().getSil().getS())) {
    		blockComposer.showText(gh.getHazardDetails().getSil().getS().getPrint());
    		blockComposer.showBreak(newLineBreak);
    	};
    	if (nullCheck(gh.getHazardDetails().getSil().getArchitecture())) {
    		blockComposer.showText("Architecture    " + gh.getHazardDetails().getSil().getArchitecture().toString());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);
    	
    	blockComposer.showBreak(new Dimension(32, 0));
    	blockComposer.showText("F");
    	blockComposer.showBreak(new Dimension(32, 2));
    	if (nullCheck(gh.getHazardDetails().getSil().getF())) {
    		blockComposer.showText(gh.getHazardDetails().getSil().getF().getPrint());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);

    	blockComposer.showBreak(new Dimension(32*2, 0));
    	blockComposer.showText("P");
    	blockComposer.showBreak(new Dimension(32*2, 2));
    	if (nullCheck(gh.getHazardDetails().getSil().getP())) {
    		blockComposer.showText(gh.getHazardDetails().getSil().getP().getPrint());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);

    	blockComposer.showBreak(new Dimension(32*3, 0));
    	blockComposer.showText("PL'r'");
    	blockComposer.showBreak(new Dimension(32*3, 2));
    	if (nullCheck(gh.getHazardDetails().getSil().getPL())) {
    		blockComposer.showText(gh.getHazardDetails().getSil().getPL().toString());
    	};
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);

    	blockComposer.showBreak(new Dimension(32*4, 0));
    	blockComposer.showText("SIL Equivalent");
    	blockComposer.showBreak(new Dimension(32*4, 2));
    	if (nullCheck(gh.getHazardDetails().getSil().getSIL())) {
        	blockComposer.showText(gh.getHazardDetails().getSil().getSIL().toString());
        	blockComposer.showBreak(lineBreak);
    	};
    	
    	endBlock(true);
    	thirdBlock.y = Margin_Y + currY;
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);

    	if (nullCheck(gh.getHazardDetails().getUpgrade())) {
        	blockComposer.showText("Safety Function Upgrade Required?");
        	blockComposer.showBreak(newLineBreak);
    	};
    	if (nullCheck(gh.getHazardDetails().getFunction())) {
        	blockComposer.showText("New Safety Function Required?");
        	blockComposer.showBreak(newLineBreak);
    	};
    	blockComposer.showText("ESPE Stop Time Testing Required?");
    	
    	endBlock(false);
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top, thirdBlock);
    	setFont(false, 12);
    	
    	if (nullCheck(gh.getHazardDetails().getUpgrade())) {
        	blockComposer.showBreak(new Dimension(175, 0));
        	if (gh.getHazardDetails().getUpgrade()) {
        		blockComposer.showText("Yes");
        	} else {
        		blockComposer.showText("No");
        	};
    	};
    	if (nullCheck(gh.getHazardDetails().getFunction())) {
        	blockComposer.showBreak(new Dimension(175, 2));
        	if (gh.getHazardDetails().getFunction()) {
        		blockComposer.showText("Yes");
        	} else {
        		blockComposer.showText("No");
        	};
    	};
    	if (nullCheck(gh.getHazardDetails().getStopTime())) {
        	blockComposer.showBreak(new Dimension(175, 2));
        	if (gh.getHazardDetails().getStopTime()) {
        		blockComposer.showText("Yes");
        	} else {
        		blockComposer.showText("No");
        	};
    	};
        if (nullCheck(gh.getHazardDetails().getReductionMeasures())) {	
	        blockComposer.showBreak(lineBreak);
        	blockComposer.showText("Risk Reduction Measures");
        	blockComposer.showBreak(newLineBreak);
        	blockComposer.showText(gh.getHazardDetails().getReductionMeasures());
        };
    	
    	endBlock(true);
    	
    	double currThird = currY;
    	currY = 0;
    	if (currFirst > currSecond) {
    		currY = currFirst;
    	} else {
    		currY = currSecond;
    	}
    	if (currThird > currY) {
    		currY = currThird;
    	}
    	
    	newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
    	setFont(false, 12);
    	
    	if (nullCheck(gh.getHazardDetails().getPre().getRSA())) {
        	blockComposer.showText("Recommended Remediation Time    " + gh.getHazardDetails().getPre().getRSA().getLongDescription());
        	blockComposer.showBreak(lineBreak);
    	};
    	if (nullCheck(gh.getHazardDetails().getStandards())) {
        	blockComposer.showText("Applicable Standards");
        	blockComposer.showBreak(newLineBreak);
        	blockComposer.showText(gh.getHazardDetails().getStandards());
    	};
    	
    	endBlock(true);
	}
}
