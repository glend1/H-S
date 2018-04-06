package com.cogentautomation.controller.adobe;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.pdfclown.bytes.Buffer;
import org.pdfclown.documents.Document;
import org.pdfclown.documents.Page;
import org.pdfclown.documents.PageFormat;
import org.pdfclown.documents.PageFormat.OrientationEnum;
import org.pdfclown.documents.PageFormat.SizeEnum;
import org.pdfclown.documents.contents.composition.BlockComposer;
import org.pdfclown.documents.contents.composition.PrimitiveComposer;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;
import org.pdfclown.documents.contents.entities.Image;
import org.pdfclown.documents.contents.fonts.StandardType1Font;
import org.pdfclown.documents.contents.xObjects.XObject;

import com.cogentautomation.controller.ImageIconToBuffer;
import com.cogentautomation.controller.ImageResize;
import com.cogentautomation.model.CustomImage;
import com.cogentautomation.model.Data;
import com.cogentautomation.model.Zone;
import com.cogentautomation.model.enumerator.hazard.GenericHazard;
import com.cogentautomation.model.enumerator.hrn.ColourCode;

public class GenericAdobe {
	
	protected BlockComposer blockComposer;
	protected PrimitiveComposer composer;
	protected Double frame;
	protected Dimension2D pageSize;
	protected Page page;
	protected double currY;
	protected static final int Margin_X = 50;
	protected static final int Margin_Y = 50;
	protected Dimension indentBreak = new Dimension(24, 2); // Indentation (24pt) and top margin (8pt).
	protected Dimension newLineBreak = new Dimension(0, 2);
    protected Dimension paragraphBreak = new Dimension(24, 12);
    protected Dimension lineBreak = new Dimension(0, 12);
    protected Dimension tBreak = new Dimension(indentBreak.width * 3, indentBreak.height);
    protected Dimension newLineSpacer = new Dimension(paragraphBreak.width, paragraphBreak.height + indentBreak.height + 1);
    protected Image image;
    protected XObject imageXObject;
	protected int avWidth;
	protected Data data;
	protected Document document;
	protected ImageIcon logo;
	protected int summaryItems = 4;
	
	public GenericAdobe(Data data, Document document) {
		this.data = data;
		this.document = document;
	}
	
	public void write() {
		TitlePage titleP = new TitlePage(data, document);
		ContentsPage contentsP = new ContentsPage(data, document);
		IntroPage introP = new IntroPage(data, document);
		MachinePage machineP = new MachinePage(data, document);
		MethodPage methodP = new MethodPage(data, document);
		ZonePage zoneP = new ZonePage(data, document);
		HazardPage hazardP = new HazardPage(data, document);
		SummaryPage summaryP = new SummaryPage(data, document);
		ConclusionPage conclusionP = new ConclusionPage(data, document);
		
		ArrayList<GenericHazard> hazardList = new ArrayList<GenericHazard>();
		
		for (Zone zone : data.getMachines().getMachine().getZones().getZones()) {
        	for (GenericHazard gh : zone.getHazards().getHazards()) {
        		if (nullCheck(gh.getHazardDetails().getPre().getScore())) {
        			hazardList.add(gh);
        		};
        	}
        }
		
		titleP.make();
		contentsP.make(hazardList);
		introP.make();
		machineP.make();
		methodP.make();
        for (Zone zone : data.getMachines().getMachine().getZones().getZones()) {
        	zoneP.make(zone);
        	for (GenericHazard gh : zone.getHazards().getHazards()) {
        		hazardP.make(gh);
        	}
        }
		summaryP.make(hazardList);
		conclusionP.make();
	}
	
	protected void ColourCode(ColourCode colour, double size) {
		//logo = new ImageIcon(getClass().getResource("/com/cogentautomation/moa.jpg"));
		
		
		ImageIcon logo = null;
		if (colour == ColourCode.AMBER) {
			logo = new ImageIcon(getClass().getResource("/com/cogentautomation/amber.jpg"));
			//logo = getClass().getResource("/com/cogentautomation/amber.jpg").getPath();
		} else if (colour == ColourCode.GREEN) {
			logo = new ImageIcon(getClass().getResource("/com/cogentautomation/green.jpg"));
			//logo = getClass().getResource("/com/cogentautomation/green.jpg").getPath();
		} else if (colour == ColourCode.RED) {
			logo = new ImageIcon(getClass().getResource("/com/cogentautomation/red.jpg"));
			//logo = getClass().getResource("/com/cogentautomation/red.jpg").getPath();
		}
		Buffer buffer = ImageIconToBuffer.convert(logo);
		image = Image.get(buffer);
		
        imageXObject = image.toXObject(document);
        blockComposer.showXObject(imageXObject, new Dimension((int)size, (int)size));
		/*image = Image.get(logo);
		imageXObject = image.toXObject(document);
		blockComposer.showXObject(imageXObject, new Dimension((int)size, (int)size));*/
	}

	protected void setFont(boolean bold, int size) {
		composer.setFont(new StandardType1Font(document, StandardType1Font.FamilyEnum.Times, bold, false), size);
	}

	protected void newPage(OrientationEnum orientation) {
	  	page = new Page(document, PageFormat.getSize(SizeEnum.A4, orientation));
	   	document.getPages().add(page);
	   	pageSize = page.getSize();
	   	avWidth = (int)pageSize.getWidth() - Margin_X * 2;
	   	currY = 0;
	}
	
	protected void endBlock(boolean setY) {
		blockComposer.showBreak(lineBreak);
		if (setY) {
			currY += blockComposer.getBoundBox().getHeight();
		}
		blockComposer.end();
		composer.flush();
	}
	  
	protected void newBlock(XAlignmentEnum xAlign, YAlignmentEnum yAlign) {
		composer = new PrimitiveComposer(page);	    
		blockComposer = new BlockComposer(composer);
		composer.beginLocalState();
		frame = new Rectangle2D.Double(Margin_X, Margin_Y + currY, pageSize.getWidth() - Margin_X * 2, (pageSize.getHeight() - Margin_Y * 2) - currY);
		blockComposer.begin(frame,xAlign,yAlign);
		blockComposer.showBreak(lineBreak);
	}
	
	protected void newBlock(XAlignmentEnum xAlign, YAlignmentEnum yAlign, Double frame) {
		composer = new PrimitiveComposer(page);	    
		blockComposer = new BlockComposer(composer);
		composer.beginLocalState();
		blockComposer.begin(frame,xAlign,yAlign);
		blockComposer.showBreak(lineBreak);
	}
	
	/*protected String outputImage(ImageIcon img) {
		
		try {
			ImageIcon logo = ImageResize.resize(pageSize.getWidth() - Margin_X * 2, img);
			java.io.File originalImage = new java.io.File(data.getClient().getImage().toString());
			
			String str = outFile.getParent() + "\\images\\" + originalImage.getName();
			
			java.io.File newImage = new java.io.File(str);
			
			newImage.mkdirs();
			
			ImageIO.write(ImageIconToBuffer.toBufferedImage(logo), "jpg", newImage);
			return str;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	protected void showImage(Dimension dimension, ImageIcon icon) {
		
		if (icon.getIconWidth() > dimension.getWidth() || icon.getIconHeight() > dimension.getHeight()) {
			dimension = ImageResize.getDimensions(dimension, icon);
		} else {
			dimension = new Dimension(icon.getIconWidth(), icon.getIconHeight());
		}
		
		Buffer buffer = ImageIconToBuffer.convert(icon);
		image = Image.get(buffer);
		
        imageXObject = image.toXObject(document);
        blockComposer.showXObject(imageXObject, dimension);
	}
	
	protected void showImage(Dimension dimension, CustomImage icon) {
		if (icon.getImageBytes() != null) {
			if (icon.getWidth() > dimension.getWidth() || icon.getHeight() > dimension.getHeight()) {
				dimension = ImageResize.getDimensions(dimension, icon.getImage());
			} else {
				dimension = new Dimension(icon.getWidth(), icon.getHeight());
			}
			
			Buffer buffer = ImageIconToBuffer.toBuffer(icon.getImageBytes());
			image = Image.get(buffer);
			
	        imageXObject = image.toXObject(document);
	        blockComposer.showXObject(imageXObject, dimension);
		} 
	}
	
	public boolean nullCheck(Object obj) {
		if (obj == null) {
			return false;
		} else {
			String str = "";
			if (obj.getClass().getSimpleName().equalsIgnoreCase("string")) {
				str = (String)obj;
			} else {
				if (obj.toString() == null) {
					return false;
				} else {
					str = obj.toString();
				};
			};
			if (str.trim().isEmpty() == true) {
				return false;
			};
			if (str.trim().equals("")) {
				return false;
			};
		};
		return true;
	}
}
