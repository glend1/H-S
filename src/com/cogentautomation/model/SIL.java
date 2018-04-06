package com.cogentautomation.model;

import java.io.Serializable;

import com.cogentautomation.model.enumerator.sil.Architecture;
import com.cogentautomation.model.enumerator.sil.Equivalent;
import com.cogentautomation.model.enumerator.sil.Frequency;
import com.cogentautomation.model.enumerator.sil.Performance;
import com.cogentautomation.model.enumerator.sil.Probability;
import com.cogentautomation.model.enumerator.sil.Severity;

public class SIL implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Severity s = null;
	private Frequency f = null;
	private Probability p = null;
	private Performance pl = null;
	private Equivalent sil = null;
	private Architecture architecture = null;
	public Severity getS() {
		return s;
	}
	public void setS(Severity silS) {
		s = silS;
	}
	public Frequency getF() {
		return f;
	}
	public void setF(Frequency silF) {
		f = silF;
	}
	public Probability getP() {
		return p;
	}
	public void setP(Probability silP) {
		p = silP;
	}
	public Performance getPL() {
		return pl;
	}
	public void setPL(Performance p) {
		pl = p;
	}
	public Equivalent getSIL() {
		return sil;
	}
	public void setSIL(Equivalent e) {
		sil = e;
	}
	public Architecture getArchitecture() {
		return architecture;
	}
	public void setArchitecture(Architecture a) {
		architecture = a;
	}
}
