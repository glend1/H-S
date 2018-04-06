package com.cogentautomation.model;

import java.io.Serializable;

import com.cogentautomation.model.enumerator.hrn.Avoidance;
import com.cogentautomation.model.enumerator.hrn.Exposure;
import com.cogentautomation.model.enumerator.hrn.Harm;
import com.cogentautomation.model.enumerator.hrn.Likelihood;
import com.cogentautomation.model.enumerator.hrn.RiskScore;

public class HRN  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Harm dph = null;
	private Likelihood lo = null;
	private Avoidance pa = null;
	private Exposure fe = null;
	private RiskScore rsa = null;
	private Double score = null;
	public Harm getDPH() {
		return dph;
	}
	public void setDPH(Harm d) {
		dph = d;
	}
	public Likelihood getLO() {
		return lo;
	}
	public void setLO(Likelihood l) {
		lo = l;
	}
	public Avoidance getPA() {
		return pa;
	}
	public void setPA(Avoidance p) {
		pa = p;
	}
	public Exposure getFE() {
		return fe;
	}
	public void setFE(Exposure f) {
		fe = f;
	}
	public RiskScore getRSA() {
		setScore();
		return rsa;
	}
	public void setRSA(Double score) {
		rsa = RiskScore.getRisk(score);
	}
	public Double getScore() {
		setScore();
		return score;
	}
	private void setScore() {
		Harm dph = getDPH();
		Likelihood lo = getLO();
		Avoidance pa = getPA();
		Exposure fe = getFE();
		if (dph != null && lo != null && pa != null && fe != null) {
			Double sc = dph.getValue() * lo.getValue() * pa.getValue() * fe.getValue();
			setRSA(sc);
			score = sc;
		}
	}
}
