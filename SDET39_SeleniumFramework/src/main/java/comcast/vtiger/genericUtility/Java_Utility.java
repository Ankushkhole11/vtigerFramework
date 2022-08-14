package comcast.vtiger.genericUtility;

import java.util.Random;

public class Java_Utility {
	
	public int getRandomNum()
	{
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}

}
