package ObjectRepository;

import java.util.Calendar;
import java.util.TimeZone;

import testingFiles.Constant;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String strEndDate = Constant.GetDateAndformat1(6);
        // String[] arrayEndDate = strEndDate.split("/");
			
			
			Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
			int day = calendar.get(Calendar.DATE + 2);
			System.out.println(day);
			
	}
}
