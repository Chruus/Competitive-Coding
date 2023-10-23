//Christopher Petty

import java.util.*;
import java.io.*;

public class Recursion {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("recursion.dat"));
		int numOfFunctions = input.nextInt();
		int numOfCalls = input.nextInt();
		input.nextLine();
		ArrayList<Function> functions = new ArrayList<Function>();

		for (int i = 0; i < numOfFunctions; i++) {
			String line = input.nextLine();
			functions.add(getFunctionFromLine(line));
		}

		for (Function f : functions)
			System.out.println(f);
	}

	public static Function getFunctionFromLine(String line) {
		String name = line.substring(0, line.indexOf("(x)"));
		String endCase = line.substring(line.indexOf("if(") + 3, line.indexOf(") return"));
		String baseCase = line.substring(line.indexOf("return ") + 7, line.indexOf("; else"));
		String recursiveCase = line.substring(line.indexOf("(x", line.indexOf(baseCase) + 1), line.indexOf("}"));
		return new Function(name, endCase, baseCase, recursiveCase);
	}
}

class Function {

	String name, endCase, baseCase, recursiveCase;
	

	Function(String name, String endCase, String baseCase, String recursiveCase) {
		this.name = name;
		this.endCase = endCase;
		this.baseCase = baseCase;
		this.recursiveCase = recursiveCase;

	}

	int call(int x) {
		if (endCase.indexOf("=") > -1) {
			if (x == Integer.parseInt(endCase.substring(endCase.indexOf("=") + 1)))
				return Integer.parseInt(baseCase);
		}
		if (endCase.indexOf(">") > -1) {
			if (x > Integer.parseInt(endCase.substring(endCase.indexOf(">") + 1)))
				return Integer.parseInt(baseCase);
		}
		if (endCase.indexOf("<") > -1) {
			if (x == Integer.parseInt(endCase.substring(endCase.indexOf("<") + 1)))
				return Integer.parseInt(baseCase);
		}

		return -1;
	}

	public String toString() {
		return "name = " + name + ", endCase = " + endCase + ", baseCase = " + baseCase + ", recursiveCase = "
				+ recursiveCase;
	}
}