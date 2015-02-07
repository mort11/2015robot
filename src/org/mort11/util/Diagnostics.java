package org.mort11.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import edu.wpi.first.wpilibj.DriverStation;

public class Diagnostics {

	public void writeLogs() throws FileNotFoundException,
			UnsupportedEncodingException {

		DriverStation ds = DriverStation.getInstance();
		Calendar calendar = Calendar.getInstance();
		int currentHour = calendar.get(Calendar.HOUR);
		int currentMin = calendar.get(Calendar.MINUTE);

		int matchNumber = 0;
		int numberOfWheelSlips = 0;
		int avgBattVoltage = 0;
		String errors = null;
		boolean brownedOut = ds.isBrownedOut();

		PrintWriter writer = new PrintWriter("log-" + currentHour + "-"
				+ currentMin + ".txt", "UTF-8");

		writer.println("================");
		writer.println("MORT - Match Log");
		writer.println("================");
		writer.println();
		writer.println("Match Number: " + matchNumber);
		writer.println();
		writer.println("Average Battery Voltage: " + avgBattVoltage);
		writer.println();
		writer.println("# of times wheels slipped: " + numberOfWheelSlips);
		writer.println();
		writer.println("Browned out?: " + brownedOut);
		writer.println();
		writer.println("Errors: \n" + errors);

		writer.close();
	}
}
