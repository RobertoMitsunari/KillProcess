package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessController {

	public void listProcess(String os) {
		Process process;
		String command = "";
		if (os.equals("Windows 10")) {
			command = "Tasklist /fo table";
		} else if (os.equals("Linux")) {
			command = "ps aux";
		}
		try {
			process = Runtime.getRuntime().exec(command);
			InputStream input = process.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader bufferReader = new BufferedReader(reader);
			String line = bufferReader.readLine();
			while (line != null) {
				System.out.println(line);
				line = bufferReader.readLine();
			}

			bufferReader.close();
			reader.close();
			input.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void callProcess(String command) {
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			if (e.getMessage().contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(command);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					System.err.println(e1.getMessage());
				}
			} else {
				System.err.println(e.toString());
			}

		}

	}

	public void killProcess(String param, String os) {

		String cmdPid = "";
		String cmdNome = "";

		if (os.equals("Windows 10")) {
			cmdPid = "TASKKILL /PID ";
			cmdNome = "TASKKILL /IM ";
		} else if (os.equals("Linux")) {
			cmdPid = "kill ";
			cmdNome = "pkill ";
		}

		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
		} catch (NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);

		}
		callProcess(buffer.toString());
	}

}
