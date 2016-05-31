package system.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.chrono.JapaneseChronology;

import system.object.Student;

public class FileOperation {
	public static Student student[] = new Student[100];
	private static int studentNum = 0;
	/*
	 * 读取数据文件
	 */
	public static void readFile( )
	{
		String dataLineString;
		/*
		 * 总共有7行
		 */
		String arr[] = null;
		studentNum = 0;

		try {
		BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
		
			while((dataLineString = reader.readLine()) != null)
			{
				
				arr = dataLineString.split("\\s+");
				//System.out.println(java.util.Arrays.toString(arr));
				student[studentNum] = new Student();
				
				/*
				 * 初始化对象
				 */
				student[studentNum].setId(arr[0]);
				student[studentNum].setName(arr[1]);										
				student[studentNum].setSex(arr[2]);				
				student[studentNum].setAcademy(arr[3]);								
				student[studentNum].setScore1(Float.parseFloat(arr[4]));						
				student[studentNum].setScore2(Float.parseFloat(arr[5]));									
				student[studentNum].setScore3(Float.parseFloat(arr[6]));
				student[studentNum].setScoreAverage();
				studentNum++;
	
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int getStudentNum()
	{
		return studentNum;
	}
}
