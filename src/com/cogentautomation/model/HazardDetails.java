package com.cogentautomation.model;

import java.io.Serializable;

import javax.swing.ImageIcon;

import com.cogentautomation.model.enumerator.Mode;
import com.cogentautomation.model.enumerator.Task;

public class HazardDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = null;
	private Mode mode = null;
	private HRN pre = new HRN();
	private HRN post = new HRN();
	private SIL sil = new SIL();
	private boolean upgrade = false;
	private boolean function = false;
	private String hazardExplanation = null;
	private boolean hazardDanger = false;
	private String hazardDangerDescription = null;
	private boolean stopTime = false;
	private String reductionMeasures = null;
	private String standards = null;
	private CustomImage image = new CustomImage(null);
	private Task task = null;
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode m) {
		mode = m;
	}
	public boolean getUpgrade() {
		return upgrade;
	}
	public void setUpgrade(boolean u) {
		upgrade = u;
	}
	public boolean getFunction() {
		return function;
	}
	public void setFunction(boolean f) {
		function = f;
	}
	public String getHazardExplanation() {
		return hazardExplanation;
	}
	public void setHazardExplanation(String he) {
		hazardExplanation = he;
	}
	public boolean getHazardDanger() {
		return hazardDanger;
	}
	public void setHazardDanger(boolean hd) {
		hazardDanger = hd;
	}
	public String getHazardDangerDescription() {
		return hazardDangerDescription;
	}
	public void setHazardDangerDescription(String hdd) {
		hazardDangerDescription = hdd;
	}
	public boolean getStopTime() {
		return stopTime;
	}
	public void setStopTime(boolean st) {
		stopTime = st;
	}
	public String getReductionMeasures() {
		return reductionMeasures;
	}
	public void setReductionMeasures(String rm) {
		reductionMeasures = rm;
	}
	public String getStandards() {
		return standards;
	}
	public void setStandards(String s) {
		standards = s;
	}
	public HRN getPre() {
		return pre;
	}
	public HRN getPost() {
		return post;
	}
	public SIL getSil() {
		return sil;
	}
	public CustomImage getImage() {
		return image;
	}
	public void setImage(ImageIcon i) {
		image = new CustomImage(i);
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
}
