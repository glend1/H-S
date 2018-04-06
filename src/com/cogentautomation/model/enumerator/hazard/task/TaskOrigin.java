package com.cogentautomation.model.enumerator.hazard.task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cogentautomation.model.enumerator.hazard.generic.GenericOrigin;


public enum TaskOrigin implements GenericOrigin, Serializable {
	UNPACKING(Arrays.asList(TaskType.TRANSPORT), "Unpacking"),
	
	PREPERATION(Arrays.asList(TaskType.ASSEMBLY), "Preperations for Installation"),
	ASSEMBLY(Arrays.asList(TaskType.ASSEMBLY), "Assembly of the Machine"),
	FIXING(Arrays.asList(TaskType.ASSEMBLY), "Fixing, Anchoring"),
	CONNECTINGENERGYSUPPLY(Arrays.asList(TaskType.ASSEMBLY), "Connection to Energy Supply"),
	DISPOSALSYSTEM(Arrays.asList(TaskType.ASSEMBLY), "Connecting to Disposal System"),
	MACHINEADJUSTMENT(Arrays.asList(TaskType.ASSEMBLY), "Adjustment of the Machine and its Components"),
	FENCING(Arrays.asList(TaskType.ASSEMBLY), "Fencing"),
	FEEDING(Arrays.asList(TaskType.ASSEMBLY), "Feeding, Filing, Loading of Ancillary Fluids"),
	TESTING(Arrays.asList(TaskType.ASSEMBLY), "Testing"),
	WITHOUTLOAD(Arrays.asList(TaskType.ASSEMBLY), "Running the Machine Without Load"),
	TRIALS(Arrays.asList(TaskType.ASSEMBLY), "Trials with Load or Maximum Load"),
	DEMONSTRATION(Arrays.asList(TaskType.ASSEMBLY), "Demonstration"),
	
	MOUNTING(Arrays.asList(TaskType.SETTING), "Mounting or Changing Tools, Tool-Setting"),
	DEVICEADJUSTMENT(Arrays.asList(TaskType.SETTING), "Adjustment and Setting of Protective Devices and Other Components"),
	FUNCTIONALPARAMETERADJUSTMENT(Arrays.asList(TaskType.SETTING), "Adjustment and Setting or Verification of "
			+ "Functional Parameters of the Machine"),
	VERIFICATION(Arrays.asList(TaskType.SETTING), "Program Verification"),
	FUNCTIONALTEST(Arrays.asList(TaskType.SETTING), "Functional Test, Trials"),
	
	MANUALLOADING(Arrays.asList(TaskType.OPERATION), "Manual Loading/Unloading"),
	MANUALCONTROLS(Arrays.asList(TaskType.OPERATION), "Operating Manual Controls"),
	DRIVING(Arrays.asList(TaskType.OPERATION), "Driving the Machine"),
	MINORADJUSTMENT(Arrays.asList(TaskType.OPERATION), "Minor Adjustment of Functional Parameters of the Machine"),
	MINORINTERVENTIONS(Arrays.asList(TaskType.OPERATION), "Minor Interventions during Operation"),
	RESTARTING(Arrays.asList(TaskType.OPERATION), "Restarting the Machine after Stopping/Interuption"),
	UNCLAMPING(Arrays.asList(TaskType.OPERATION), "Unclamping/Unfastening the Workpiece"),
	CONTROL(Arrays.asList(TaskType.OPERATION), "Control/Inspection"),
	SUPERVISION(Arrays.asList(TaskType.OPERATION), "Supervision"),
	
	CLEANING(Arrays.asList(TaskType.CLEANING), "Cleaning/Disinfection"),
	HOUSEKEEPING(Arrays.asList(TaskType.CLEANING), "Housekeeping"),
	LUBRICATION(Arrays.asList(TaskType.CLEANING), "Lubriction"),
	TOOLREPLACEMENT(Arrays.asList(TaskType.CLEANING), "Replacement of Tools"),
	PARTREPLACEMENT(Arrays.asList(TaskType.CLEANING), "Replacement of Worn or Damaged Parts"),
	RESTORINGFLUIDS(Arrays.asList(TaskType.CLEANING), "Restoring Fluid Levels"),
	
	FAULTFINDING(Arrays.asList(TaskType.FAULTFINDING), "Fault-finding"),
	CONTROLRECOVERY(Arrays.asList(TaskType.FAULTFINDING), "Recovery from Control and Protective Devices Failure"),
	JAMRECOVERY(Arrays.asList(TaskType.FAULTFINDING), "Recovering from Jam"),
	REPAIRING(Arrays.asList(TaskType.FAULTFINDING), "Repairing"),
	REPLACEMENT(Arrays.asList(TaskType.FAULTFINDING), "Replacement of Parts, Components, Devices of the Machine"),
	RESCUE(Arrays.asList(TaskType.FAULTFINDING), "Rescue of Trapped Person"),
	
	DISCONNECTINGENERGY(Arrays.asList(TaskType.DISMANTLING), "Disconnection and Energy Dissipation"),
	DISMANTLING(Arrays.asList(TaskType.DISMANTLING), "Dismantling"),
	
	LIFTING(Arrays.asList(TaskType.TRANSPORT, TaskType.DISMANTLING), "Lifting"),
	LOADING(Arrays.asList(TaskType.TRANSPORT, TaskType.DISMANTLING), "Loading"),
	PACKING(Arrays.asList(TaskType.TRANSPORT, TaskType.DISMANTLING), "Packing"),
	TRANSPORTATION(Arrays.asList(TaskType.TRANSPORT, TaskType.DISMANTLING), "Transportation"),
	UNLOADING(Arrays.asList(TaskType.TRANSPORT, TaskType.DISMANTLING), "Unloading"),
	FLUIDREMOVAL(Arrays.asList(TaskType.CLEANING, TaskType.DISMANTLING), "Removal and Disposal of Spent Fluids"),
	PARTVERIFICATION(Arrays.asList(TaskType.CLEANING, TaskType.FAULTFINDING), "Verfication of Parts, Components, Devices "
			+ "of the Machine"),
	RESETTING(Arrays.asList(TaskType.CLEANING, TaskType.FAULTFINDING), "Resetting"),
	ISOLATION(Arrays.asList(TaskType.CLEANING, TaskType.FAULTFINDING), "Isolation and Energy Dissipation"),
	REMOVAL(Arrays.asList(TaskType.CLEANING, TaskType.FAULTFINDING), "Dismantling/Removal of Parts, Components, Devices "
			+ "of the Machine"),
	ADJUSTMENT(Arrays.asList(TaskType.CLEANING, TaskType.FAULTFINDING), "Adjustment"),
	FINALVERIFICATION(Arrays.asList(TaskType.SETTING, TaskType.OPERATION), "Verfication of Final Product"),
	CLAMPING(Arrays.asList(TaskType.SETTING, TaskType.OPERATION), "Clamping/Fastening the Workpiece"),
	FILING(Arrays.asList(TaskType.SETTING, TaskType.OPERATION), "Feeding, Filing, Loading of Raw Material"),
	
	OTHER(Arrays.asList(TaskType.ASSEMBLY, TaskType.CLEANING, TaskType.DISMANTLING, TaskType.FAULTFINDING,
			TaskType.OPERATION, TaskType.SETTING, TaskType.TRANSPORT), "Other Tasks");
	
	private List<TaskType> types;
	private String value;
	
	public List<TaskType> getTypes() {
		return types;
	}

	public void setTypes(List<TaskType> types) {
		this.types = types;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	TaskOrigin (List<TaskType> types, String value) {
		setTypes(types);
		setValue(value);
	}
	
	@Override
	public String toString() {
		return getValue();
	}

	public static List<TaskOrigin> getValues(TaskType type) {
		ArrayList<TaskOrigin> ls = new ArrayList<TaskOrigin>();
		for (TaskOrigin origin: values()) {
			for (TaskType et: origin.getTypes()) {
				if (et == type) {
					ls.add(origin);
					break;
				}
			}
		}
		return ls;
	}
}
