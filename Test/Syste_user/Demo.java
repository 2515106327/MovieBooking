package Syste_user;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		 /* 程序输入若干互不相同的数字 */
        System.out.println("程序输入若干互不相同的小球颜色,例：黑,白,红");
        Scanner mScanner = new Scanner(System.in);
        String[] input_arr = mScanner.next().split("[,]");
        mScanner.close();
        aa: for (int i = 0, j = 0; i < Math.pow(input_arr.length, input_arr.length); i++) {
            String str = String.format("%0" + input_arr.length + "d", Long.parseLong(Integer.toString(i, input_arr.length)));
            for (j = 0; j < str.length(); j++) {
                if (str.replace(str.charAt(j) + "", "").length() != str.length() - 1) {
                    continue aa;
                }
            }
            /* 经过排列组合能产生多种不同的数值， */
            for (j = 0; j < input_arr.length; j++) {
                System.out.print(input_arr[Integer.parseInt(str.charAt(j) + "")]+(j==input_arr.length-1?"\n":" "));
            }
        }
	}

}
