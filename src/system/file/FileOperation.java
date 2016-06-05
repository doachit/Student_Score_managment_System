package system.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import system.object.Student;

public class FileOperation {
	public static ArrayList<Student> studentArray = new ArrayList<Student>();
	public static boolean isModify = false;
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
		studentArray.clear();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
		
			while((dataLineString = reader.readLine()) != null)
			{
				//System.out.println(dataLineString);
				arr = dataLineString.split("\\s+");
				
				/*
				 * 初始化对象
				 */

				studentArray.add(new Student(
						arr[0],
						arr[1],
						arr[2],
						arr[3],
						Float.parseFloat(arr[4]),
						Float.parseFloat(arr[5]),
						Float.parseFloat(arr[6])
						));	
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void saveStudentInfo()
	{
		isModify = false;
		try {
			FileWriter writer = new FileWriter(new File("data.txt"));
			for(int i = 0; i < getStudentNum(); i++)
			{
				writer.write(studentArray.get(i).writeOneStudentInfo());
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getStudentNum()
	{
		return studentArray.size();
	}
	
	public static Student getStudent(int index)
	{
		return studentArray.get(index);
	}
	
	public static boolean getModifyFlag()
	{
		return isModify;
				
	}
}
