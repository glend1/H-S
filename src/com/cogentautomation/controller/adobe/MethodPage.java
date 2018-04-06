package com.cogentautomation.controller.adobe;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import org.pdfclown.documents.Document;
import org.pdfclown.documents.PageFormat.OrientationEnum;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;

import com.cogentautomation.model.Data;

public class MethodPage extends GenericAdobe {
	public MethodPage(Data data, Document document) {
		super(data, document);
	}

	public void make() {
		newPage(OrientationEnum.Portrait);
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    
	    setFont(true, 12);

        blockComposer.showText("Method of Analysis");
        blockComposer.showBreak(paragraphBreak);
        
        setFont(false, 12);
        
        blockComposer.showText("The assessment was made by carrying out a visual inspection of the equipment, discussions with the operator(s), maintenance staff and production staff, and identifying the hazards the equipment presents. The assessment was further carried out using the following principles:");
        blockComposer.showBreak(lineBreak);
        
        logo = new ImageIcon(getClass().getResource("/com/cogentautomation/moa.jpg"));
		showImage(new Dimension(496, 539), logo);
        
        blockComposer.showBreak(paragraphBreak);
        blockComposer.showText("Every attempt has been made to evaluate the risks associated with each hazard identified on the equipment however, it may not have been possible to quantify the risks with all the hazards associated with the equipment. Where this has not been possible, the hazards are assessed in relation to their conformance with the appropriate legislation, regulations and IEC, ISO and EN standards.");
        
        endBlock(true);
        newPage(OrientationEnum.Portrait);
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);

        blockComposer.showBreak(indentBreak);
        blockComposer.showText("Human error and deliberate or willful misuse of the equipment in respect of incorrect feeding of the raw materials , incorrect use of materials and the operator’s ability to operate the equipment correctly are not considered to be under the scope of this report. Only clearly foreseeable and reasonably foreseeable misuse of the equipment has been considered however, where an operator training issue arises or is found this will be identified in the conclusion of this report.");
        blockComposer.showBreak(paragraphBreak);
        blockComposer.showText("In order to identify, estimate and reduce the risks from the hazards present on the equipment, a ‘Risk Score Analysis’ (RSA) number system has been used. This methodology utilises an evaluation of the following factors:");
        
        blockComposer.showBreak(paragraphBreak);
        blockComposer.showText("Degree of Possible Harm (DPH)");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("Likelihood of Occurrence of a Hazardous Event (LO)");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("Possibility of Avoidance (PA)");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("Frequency of Exposure (FE)");
        
        blockComposer.showBreak(lineBreak);
        blockComposer.showText("A ‘Risk Score Analysis’ number is then calculated from the following formula:");
        
        endBlock(true);
        newBlock(XAlignmentEnum.Center, YAlignmentEnum.Top);
        setFont(true, 12);
        
        blockComposer.showText("RSA = DPH x LO x PA x FE");
        
        endBlock(true);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(true, 12);
        
        blockComposer.showText("Degree of Possible Harm (DPH)");
        
        endBlock(true);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("0.25");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("0.5");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("3");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("5");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("8");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("11");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("15");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("25");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("40");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("65");
        
        endBlock(false);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Scratch or bruise");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Laceration, Mild ill health effect, minor burn");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Break of a minor bone (finger or toe), or minor temporary illness");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Break of a major bone (leg or arm and above), or major permanent illness");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Loss of 1 or 2 fingers / toes or major burns");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Amputation of 1 hand, arm or leg, loss of 1 eye, or partial hearing loss");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Amputation of 2 hands arms or legs, total loss of both eyes, or total hearing loss.");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Critical injuries or permanent condition or illness");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Single fatality");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Multiple fatalities"); 
        
        endBlock(true);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(true, 12);
        
        blockComposer.showText("Likelihood of Occurrence (LO)");

        endBlock(true);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("0.5");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("1.25");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("2.5");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("4");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("5");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("6");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("7");
        
        endBlock(false);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Almost impossible");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Unlikely or possible in extreme circumstances");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Possible but unusual");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Probable");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Even chance, it could happen");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Likely, only to be expected");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Certain, no doubt it will happen");
       
        endBlock(true);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(true, 12);
        
        blockComposer.showText("Probability of Avoidance (PA)");

        endBlock(true);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("0.75");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("2.5");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("5");
        
        endBlock(false);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Possible");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Possible under certain circumstances");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Not possible");
        
        endBlock(true);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(true, 12);
        
        blockComposer.showText("Frequency of Exposure (FE)");

        endBlock(true);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("0.5");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("1");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("2");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("3");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("4");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("5");
        
        endBlock(false);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Annually");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Monthly");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Weekly");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Daily");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Hourly");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Constantly");        
        
        endBlock(true);
        newPage(OrientationEnum.Portrait);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(true, 12);
        
        blockComposer.showText("Calculated RSA Number Evaluation:");

        endBlock(true);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("0 to 10");  
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("11 to 20");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("21 to 45");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("46 to 160");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("161 to 300");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("301 to 500");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("501 to 1000");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("Greater than 1000");
        
        endBlock(false);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        tBreak = new Dimension(indentBreak.width * 5, indentBreak.height);
        
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Negligible");  
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Very Low Risk");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Low Risk");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Significant");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("High");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Very High");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Extreme");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Unacceptable");
        
        endBlock(true);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(true, 12);
        
        blockComposer.showText("Calculated Recommended Remediation Time Frame Against RSA Number:");
        
        endBlock(true);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("0 to 10");  
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("11 to 20");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("21 to 45");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("46 to 160");
        blockComposer.showBreak(indentBreak);
        blockComposer.showText("161 to 300");
        blockComposer.showBreak(newLineSpacer);        
        blockComposer.showText("301 to 500");
        blockComposer.showBreak(newLineSpacer);
        blockComposer.showText("501 to 1000");
        blockComposer.showBreak(newLineSpacer);
        blockComposer.showText("Greater than 1000");
        
        endBlock(false);
        newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
        setFont(false, 12);
        
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Accept the risk.");  
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Address and remediate within 8 months.");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Address and remediate within 4 months.");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Address and remediate within 1 months.");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Address and remediate within 2 weeks - Consider the use of a temporary");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("measure until remediation is carried out.");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Address and remediate within 3 days - Use temporary measures until");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("remediation is carried out");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Address and remediate within 1 day - Mitigate the risk from an immediate");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("hazard.");
        blockComposer.showBreak(tBreak);
        blockComposer.showText("Address the remediated immediately.");

        endBlock(true);
	}
}
