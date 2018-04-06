package com.cogentautomation.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.swing.ImageIcon;

public class Machine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = null;
	private String description = null;
	private String longDescription = null;
	private String type = null;
	private String manufacturer = null;
	private String serial = null;
	private LocalDate built = null;
	private String certification = null;
	private CustomImage image = new CustomImage(null);
	//private String controlDescription = null;
	private String limits = null;
	private String location = null;
	private String model = null;
	private String modifications = null;
	private String energySources = null;
	private String energyRatings = null;
	private String safetyMeasures = null;
	private Integer operatorCount = 0;
	private Integer shiftCount = 0;
	private Integer monthlyHours = 0;
	private String operatingManuals = null;
	private String operatingProcedures = null;
	private String trainingRecords = null;
	private String warningSigns = null;
	private String rawMaterials = null;
	private String maintenanceManual = null;
	private String maintenanceTrainingRecord = null;
	private String untrainedAccess = null;
	private Zones zones = new Zones();
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getModifications() {
		return modifications;
	}
	public void setModifications(String modifications) {
		this.modifications = modifications;
	}
	public String getEnergySources() {
		return energySources;
	}
	public void setEnergySources(String energySources) {
		this.energySources = energySources;
	}
	public String getEnergyRatings() {
		return energyRatings;
	}
	public void setEnergyRatings(String energyRatings) {
		this.energyRatings = energyRatings;
	}
	public String getSafetyMeasures() {
		return safetyMeasures;
	}
	public void setSafetyMeasures(String safetyMeasures) {
		this.safetyMeasures = safetyMeasures;
	}
	public Integer getOperatorCount() {
		return operatorCount;
	}
	public void setOperatorCount(Integer operatorCount) {
		this.operatorCount = operatorCount;
	}
	public Integer getShiftCount() {
		return shiftCount;
	}
	public void setShiftCount(Integer shiftCount) {
		this.shiftCount = shiftCount;
	}
	public Integer getMonthlyHours() {
		return monthlyHours;
	}
	public void setMonthlyHours(Integer monthlyHours) {
		this.monthlyHours = monthlyHours;
	}
	public String getOperatingManuals() {
		return operatingManuals;
	}
	public void setOperatingManuals(String operatingManuals) {
		this.operatingManuals = operatingManuals;
	}
	public String getOperatingProcedures() {
		return operatingProcedures;
	}
	public void setOperatingProcedures(String operatingProcedures) {
		this.operatingProcedures = operatingProcedures;
	}
	public String getTrainingRecords() {
		return trainingRecords;
	}
	public void setTrainingRecords(String trainingRecords) {
		this.trainingRecords = trainingRecords;
	}
	public String getWarningSigns() {
		return warningSigns;
	}
	public void setWarningSigns(String warningSigns) {
		this.warningSigns = warningSigns;
	}
	public String getRawMaterials() {
		return rawMaterials;
	}
	public void setRawMaterials(String rawMaterials) {
		this.rawMaterials = rawMaterials;
	}
	public String getMaintenanceManual() {
		return maintenanceManual;
	}
	public void setMaintenanceManual(String maintenanceManual) {
		this.maintenanceManual = maintenanceManual;
	}
	public String getMaintenanceTrainingRecord() {
		return maintenanceTrainingRecord;
	}
	public void setMaintenanceTrainingRecord(String maintenanceTrainingRecord) {
		this.maintenanceTrainingRecord = maintenanceTrainingRecord;
	}
	public String getUntrainedAccess() {
		return untrainedAccess;
	}
	public void setUntrainedAccess(String untrainedAccess) {
		this.untrainedAccess = untrainedAccess;
	}
	public void setBuilt(LocalDate built) {
		this.built = built;
	}
	public void setZones(Zones zones) {
		this.zones = zones;
	}
	public Zones getZones() {
		return zones;
	}
	public CustomImage getImage() {
		return image;
	}
	public void setImage(ImageIcon i) {
		image = new CustomImage(i);
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String d) {
		description = d;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String ld) {
		longDescription = ld;
	}
	public String getType() {
		return type;
	}
	public void setType(String t) {
		type = t;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String m) {
		manufacturer = m;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String s) {
		serial = s;
	}
	public LocalDate getBuilt() {
		return built;
	}
	public void setCalendar(LocalDate b) {
		built = b;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String c) {
		certification = c;
	}
	/*public String getControlDescription() {
		return controlDescription;
	}
	public void setControlDescription(String cd) {
		controlDescription = cd;
	}*/
	public String getLimits() {
		return limits;
	}
	public void setLimits(String l) {
		limits = l;
	}
	public String toString() {
		return "Machine";
	}
}
