package com.cogentautomation.controller.adobe;

import org.pdfclown.documents.Document;
import org.pdfclown.documents.PageFormat.OrientationEnum;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;

import com.cogentautomation.model.Data;
import com.cogentautomation.model.Person;
import com.cogentautomation.model.enumerator.Role;

public class IntroPage extends GenericAdobe {
	public IntroPage(Data data, Document document) {
		super(data, document);
	}

	public void make() {
		newPage(OrientationEnum.Portrait);
	    newBlock(XAlignmentEnum.Left, YAlignmentEnum.Top);
	    
	    if (nullCheck(data.getMotivation())) {
		    setFont(true, 12);
		    
		    blockComposer.showText("Motivation");
		    setFont(false, 12);
		    
		    blockComposer.showBreak(paragraphBreak);
		    blockComposer.showText(data.getMotivation());
		    blockComposer.showBreak(lineBreak);
	    }
	    
	    setFont(true, 12);
	    
	    blockComposer.showText("Client");
	    setFont(false, 12);
	    
	    blockComposer.showBreak(lineBreak);
	    
	    if (nullCheck(data.getClient().getName())) {
		    blockComposer.showText(data.getClient().getName());
		    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(data.getClient().getAddress1())) {
		    blockComposer.showText(data.getClient().getAddress1());
		    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(data.getClient().getAddress2())) {
		    blockComposer.showText(data.getClient().getAddress2());
		    blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(data.getClient().getTown())) {
		    blockComposer.showText(data.getClient().getTown());
		    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(data.getClient().getCounty())) {
		    blockComposer.showText(data.getClient().getCounty());
		    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(data.getClient().getPostCode())) {
		    blockComposer.showText(data.getClient().getPostCode());
		    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(data.getClient().getPhone())) {
		    blockComposer.showText(data.getClient().getPhone());
		    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(data.getClient().getEMail())) {
	    	blockComposer.showText(data.getClient().getEMail());
	    };
	    
	    blockComposer.showBreak(lineBreak);
	    
	    Person person = data.getPeople().getRole(Role.CLIENT);
	    String personStr = "";
	    if (nullCheck(person.getName())) {
	    	personStr += person.getName();
	    };
	    if (nullCheck(person.getName()) && nullCheck(person.getJobRole())) {
	    	personStr += " ";
	    };
	    if (nullCheck(person.getJobRole())) {
	    	personStr += person.getJobRole();
	    };
	    if (!personStr.isEmpty()) {
		    blockComposer.showText(personStr);
		    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(person.getAddress1())) {
	    	blockComposer.showText(person.getAddress1());
	    	blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(person.getAddress2())) {
			    blockComposer.showText(person.getAddress2());
			    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(person.getTown())) {
	    	blockComposer.showText(person.getTown());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getCounty())) {
	    	blockComposer.showText(person.getCounty());
	    	blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(person.getPostCode())) {
	    	blockComposer.showText(person.getPostCode());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getPhone())) {
	    	blockComposer.showText(person.getPhone());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getEMail())) {
	    	blockComposer.showText(person.getEMail());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getDate())) {
	    	blockComposer.showText("Issue Date: " + person.getDate().toString());	    	
	    }
	    
	    blockComposer.showBreak(lineBreak);
	    
	    person = data.getPeople().getRole(Role.ASSESSOR);
	    
	    setFont(true, 12);
	    
	    blockComposer.showText("Assessor");
	    setFont(false, 12);
	    
	    blockComposer.showBreak(lineBreak);
	    personStr = "";
	    if (nullCheck(person.getName())) {
	    	personStr += person.getName();
	    };
	    if (nullCheck(person.getName()) && nullCheck(person.getJobRole())) {
	    	personStr += " ";
	    };
	    if (nullCheck(person.getJobRole())) {
	    	personStr += person.getJobRole();
	    };
	    if (!personStr.isEmpty()) {
		    blockComposer.showText(personStr);
		    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(person.getAddress1())) {
	    	blockComposer.showText(person.getAddress1());
	    	blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(person.getAddress2())) {
			    blockComposer.showText(person.getAddress2());
			    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(person.getTown())) {
	    	blockComposer.showText(person.getTown());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getCounty())) {
	    	blockComposer.showText(person.getCounty());
	    	blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(person.getPostCode())) {
	    	blockComposer.showText(person.getPostCode());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getPhone())) {
	    	blockComposer.showText(person.getPhone());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getEMail())) {
	    	blockComposer.showText(person.getEMail());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getDate())) {
	    	blockComposer.showText("Assessment Date: " + person.getDate().toString());	    	
	    }
	    
	    blockComposer.showBreak(lineBreak);
	    
	    person = data.getPeople().getRole(Role.REVIEWER);
	    setFont(true, 12);
	    
	    blockComposer.showText("Reviewer");
	    
	    blockComposer.showBreak(lineBreak);
	    setFont(false, 12);
	    
	    personStr = "";
	    if (nullCheck(person.getName())) {
	    	personStr += person.getName();
	    };
	    if (nullCheck(person.getName()) && nullCheck(person.getJobRole())) {
	    	personStr += " ";
	    };
	    if (nullCheck(person.getJobRole())) {
	    	personStr += person.getJobRole();
	    };
	    if (!personStr.isEmpty()) {
		    blockComposer.showText(personStr);
		    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(person.getAddress1())) {
	    	blockComposer.showText(person.getAddress1());
	    	blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(person.getAddress2())) {
			    blockComposer.showText(person.getAddress2());
			    blockComposer.showBreak(newLineBreak);
	    };
	    if (nullCheck(person.getTown())) {
	    	blockComposer.showText(person.getTown());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getCounty())) {
	    	blockComposer.showText(person.getCounty());
	    	blockComposer.showBreak(newLineBreak);
	    }
	    if (nullCheck(person.getPostCode())) {
	    	blockComposer.showText(person.getPostCode());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getPhone())) {
	    	blockComposer.showText(person.getPhone());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getEMail())) {
	    	blockComposer.showText(person.getEMail());
	    	blockComposer.showBreak(newLineBreak);	    	
	    }
	    if (nullCheck(person.getDate())) {
	    	blockComposer.showText("Review Date: " + person.getDate().toString());	    	
	    }
	    
	    endBlock(true);
	}
}
