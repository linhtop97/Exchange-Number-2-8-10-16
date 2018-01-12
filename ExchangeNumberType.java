import java.util.Stack;

public class ExchangeNumberType {

	public static void main(String[] args) {
		String x = exchangeNumber("101000010", 2, 16);
		System.out.println("x = " + x);
	}

	public static String exchangeNumber(String number, int fromType, int toType) {
		if (fromType == toType)
			return number;
		switch (toType) {
		case 10:
			return convertToDecimal(number, fromType);
		default:
			String s = convertToDecimal(number, fromType);
			return convertToBinary_Octal_Hexadecimal_Type(Integer.parseInt(s), toType);
		}

	}

	public static String convertToDecimal(String number, int fromType) {
		if (fromType == 10)
			return number;
		int x = 0;
		int j = 0;
		char[] arr = number.toCharArray();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (fromType == 16) {
				if (arr[i] == 'A' || arr[i] == 'B' || arr[i] == 'C' || arr[i] == 'D' || arr[i] == 'E'
						|| arr[i] == 'F') {
					x += (int) Math.pow(fromType, j) * (arr[i] - '0' - 7);
				} else {
					x += (int) Math.pow(fromType, j) * (arr[i] - '0');
				}
			} else {
				x += (int) Math.pow(fromType, j) * (arr[i] - '0');
			}
			j++;
		}
		return String.valueOf(x);
	}

	public static String convertToBinary_Octal_Hexadecimal_Type(int number, int toType) {
		if (number < toType)
			return String.valueOf(number);
		Stack<String> stack = new Stack<>();
		while (true) {
			switch (number % toType) {
			case 10:
				stack.push("A");
				break;
			case 11:
				stack.push("B");
				break;
			case 12:
				stack.push("C");
				break;
			case 13:
				stack.push("D");
				break;
			case 14:
				stack.push("E");
				break;
			case 15:
				stack.push("F");
				break;
			default:
				stack.push(String.valueOf(number % toType));
				break;
			}
			number = number / toType;
			if (number < toType) {
				switch (number) {
				case 10:
					stack.push("A");
					break;
				case 11:
					stack.push("B");
					break;
				case 12:
					stack.push("C");
					break;
				case 13:
					stack.push("D");
					break;
				case 14:
					stack.push("E");
					break;
				case 15:
					stack.push("F");
					break;
				default:
					stack.push(String.valueOf(number));
					break;
				}
				break;
			}

		}
		StringBuilder string = new StringBuilder();
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			string.append(stack.pop());
		}
		return string.toString();

	}

}
