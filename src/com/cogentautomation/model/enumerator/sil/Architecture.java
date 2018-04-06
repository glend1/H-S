package com.cogentautomation.model.enumerator.sil;

import java.io.Serializable;
import java.util.ArrayList;

public enum Architecture implements Serializable {
	CATEGORYb, CATEGORY1, CATEGORY2, CATEGORY3, CATEGORY4;
	
	public static Architecture[] getValues(Performance perf) {
		ArrayList<Architecture> categories = new ArrayList<Architecture>();
		switch (perf) {
			case PLa:
				categories.add(CATEGORYb);
				categories.add(CATEGORY2);
				break;
			case PLb:
				categories.add(CATEGORYb);
				categories.add(CATEGORY2);
				categories.add(CATEGORY3);
				break;
			case PLc:
				categories.add(CATEGORY1);
				categories.add(CATEGORY2);
				categories.add(CATEGORY3);
				break;
			case PLd:
				categories.add(CATEGORY2);
				categories.add(CATEGORY3);
				break;
			case PLe:
				categories.add(CATEGORY4);
				break;
		}
		return categories.toArray(new Architecture[categories.size()]);
	}
}
