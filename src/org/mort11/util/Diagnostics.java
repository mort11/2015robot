package org.mort11.util;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import edu.wpi.first.wpilibj.DriverStation;

public class Diagnostics {

	// Enabled or not?
	private boolean enabled = true;

	private Calendar calendar = Calendar.getInstance();
	private int currentHour = calendar.get(Calendar.HOUR);
	private int currentMin = calendar.get(Calendar.MINUTE);
	private String log;

	public void writeLogs(PrintStream logfile) throws IOException {
		log = logfile.toString();
		writeConsoleLogs(log);
	}

	private void writeMatchLogs() throws FileNotFoundException,
			UnsupportedEncodingException {
		if (enabled) {
			DriverStation ds = DriverStation.getInstance();

			int matchNumber = 0;
			int avgBattVoltage = 0;
			boolean brownedOut = ds.isBrownedOut();

			PrintWriter writer = new PrintWriter("MATCHlog-" + currentHour
					+ "-" + currentMin + ".txt", "UTF-8");

			writer.println("================");
			writer.println("MORT - Match Log");
			writer.println("================");
			writer.println();
			writer.println("Match Number: " + matchNumber);
			writer.println();
			writer.println("Average Battery Voltage: " + avgBattVoltage);
			writer.println();
			writer.println("Browned out?: " + brownedOut);
			writer.println();
			writer.println("Boo... There's not much else logged here :(");

			writer.close();
		}
	}

	private void writeConsoleLogsHeader() throws FileNotFoundException,
			UnsupportedEncodingException {
		if (enabled) {
			PrintWriter writer = new PrintWriter("CONSOLElog-" + currentHour
					+ ".txt", "UTF-8");

			// Write File header
			writer.println("================");
			writer.println("MORT - Console Log");
			writer.println("================");
			writer.println();
			writer.println("Begin Logfile:");

			writer.close();
		}
	}

	private void writeConsoleLogs(String log) throws IOException {
		if (enabled) {

			writeConsoleLogsHeader();

			PrintWriter writer = new PrintWriter(new FileWriter("CONSOLElog-"
					+ currentHour + ".txt", true));

			writer.println();
			writer.println(log);
			writer.close();
		}
	}
}
