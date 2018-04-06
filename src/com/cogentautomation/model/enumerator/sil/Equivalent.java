package com.cogentautomation.model.enumerator.sil;

import java.io.Serializable;

public enum Equivalent implements Serializable {
	NA, SIL1, SIL2, SIL3;
	
	public static Equivalent getEquivalent(Severity sev, Frequency freq, Probability prob) {
		switch (sev) {
			case S1:
				switch (freq) {
					case F1:
						switch (prob) {
							case P1:
								return NA;
							case P2:
								return SIL1;
							default:
								return null;
						}
					case F2:
						return SIL1;
					default:
						return null;
				}
			case S2:
				switch (freq) {
					case F1:
						switch (prob) {
							case P1:
								return SIL1;
							case P2:
								return SIL2;
							default:
								return null;
						}
					case F2:
						switch (prob) {
							case P1:
								return SIL2;
							case P2:
								return SIL3;
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
