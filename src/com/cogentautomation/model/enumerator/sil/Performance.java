package com.cogentautomation.model.enumerator.sil;

import java.io.Serializable;

public enum Performance implements Serializable {
	PLa, PLb, PLc, PLd, PLe;
	
	public static Performance getPerformance(Severity sev, Frequency freq, Probability prob) {
		switch (sev) {
			case S1:
				switch (freq) {
					case F1:
						switch (prob) {
							case P1:
								return PLa;
							case P2:
								return PLb;
							default:
								return null;
						}
					case F2:
						switch (prob) {
							case P1:
								return PLb;
							case P2:
								return PLc;
							default:
								return null;
						}
					default:
						return null;
				}
			case S2:
				switch (freq) {
					case F1:
						switch (prob) {
							case P1:
								return PLc;
							case P2:
								return PLd;
							default:
								return null;
						}
					case F2:
						switch (prob) {
							case P1:
								return PLd;
							case P2:
								return PLe;
							default:
								return null;
						}
					default:
						return null;
				}
			default:
				return null;
		}
	}
}