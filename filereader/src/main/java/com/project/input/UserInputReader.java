package com.project.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.project.common.Constants;

public class UserInputReader {

	public static String readCommands() {
		String filePath = "";
		System.out.println(Constants.USER_ASK);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			String line = reader.readLine();
			if (line.length() > 0) {
				filePath = line;
			}
		} catch (IOException e) {
			System.out.println(Constants.COULD_NOT_PROCESS_INPUT);
		}

		return filePath;

	}

}
