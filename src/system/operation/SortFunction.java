package system.operation;

import java.util.Scanner;

import system.file.FileOperation;
import system.object.Student;



public final class SortFunction {
	/*
	 * 按照平均成绩降序排列
	 */
	public static void descendByAverage()
	{
		int [] arrayList = new int[FileOperation.getStudentNum()];
		int temp = 0;
		System.out.println("按照平均成绩降序排列为：\n\n");
		
		for(int i = 0; i < arrayList.length; i++)
			arrayList[i]  = i;
		/*
		 * 对平均成绩进行冒泡排序
		 */
		for(int i = 0; i < arrayList.length - 1; i++)
		{
			for(int j = 0; j < arrayList.length - 1 - i; j++)
			{
				if(FileOperation.student[arrayList[j]].getScoreAverage() > 
				   FileOperation.student[arrayList[j+1]].getScoreAverage())
				{
					temp = arrayList[j];
					arrayList[j] = arrayList[j + 1];
					arrayList[j + 1] = temp;
				}
			}
		}
		
		System.out.println("\t学号\t姓名\t性别\t学院\t科目一\t科目二\t科目三\t平均分");
		for(int i = arrayList.length - 1; i >= 0 ; i--)
			QueryFunction.showOneStudentInfo(arrayList[i]);
		
		System.out.println("按下回车键退出..........\n\n");
		new Scanner(System.in).nextLine();
		

	}
	
	/*
	 * 按照姓名升序排列
	 */
	public static void ascendByName()
	{
		System.out.println("按照姓名升序排列为: \n");
	}
}
