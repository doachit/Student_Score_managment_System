package system.operation;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import system.file.FileOperation;

public final class QueryFunction {
	public static int num = FileOperation.getStudentNum();
	/*
	 * 按照姓名进行查询
	 */
	public static void queryByName()
	{
		//int num = FileOperation.getStudentNum();
		int count;
		String queryName;
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("请输入学生姓名进行查询：");
			queryName = input.next();
			
			for (count = 0; count < num; count++) 
			{
				if(queryName.equals(FileOperation.student[count].getName()))
				{
					break;
				}
			}
			if(count != num)
			{
				System.out.println("找到相关记录，如下：");
				System.out.println("*********************************************");
				System.out.println("\t学号\t姓名\t性别\t学院\t科目一\t科目二\t科目三\t平均分");
				showOneStudentInfo(count);
				System.out.println("\n\n\n");
			}
			else
			{
				System.out.println("没有找到相关记录！\n\n\n");
			}

		}while(true);
	}
	
	/*
	 * 按照学号进行查询
	 */
	public static void queryById()
	{
		int count;
		String queryId;
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("学号的范围在1001-1050之间，请输入学号进行查询：");
			queryId = input.next();
			
			for (count = 0; count < num; count++) 
			{
				if(queryId.equals(FileOperation.student[count].getId()))
				{
					break;
				}
			}
			if(count != num)
			{
				System.out.println("找到相关记录，如下：");
				System.out.println("*********************************************");
				System.out.println("\t学号\t姓名\t性别\t学院\t科目一\t科目二\t科目三\t平均分");
				showOneStudentInfo(count);
				System.out.println("\n\n\n");
			}
			else
			{
				System.out.println("没有找到相关记录！\n\n\n");
			}

		}while(true);
	}
	/*
	 * 按照学院进行查询
	 */
	public static void  queryByAcademy()
	{
		int count;
		String queryAcademy;
		ArrayList<Integer> studentId = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("分别有 A-G 7个学院，请输入学院名称进行查询：");
			queryAcademy = input.next();
			
			for (count = 0; count < num; count++) 
			{
				if(queryAcademy.equals(FileOperation.student[count].getAcademy()))
				{
					studentId.add(new Integer(count));
				}
			}
			if(studentId.isEmpty())
			{
				System.out.println("没有找到相关记录！\n\n\n");
			}
			else
			{
				System.out.println("找到相关记录，如下：");
				System.out.println("*********************************************");
				System.out.println("\t学号\t姓名\t性别\t学院\t科目一\t科目二\t科目三\t平均分");
				for(int i = 0; i < studentId.size(); i++)
				{
					showOneStudentInfo(studentId.get(i).intValue());
				}
				studentId.clear();
				System.out.println("\n\n\n");
			}
			
			
		}while(true);
	}
	
	public static void showOneStudentInfo(int num)
	{
		System.out.println("\t" +
				FileOperation.student[num].getId() 		+ "\t" +
				FileOperation.student[num].getName()  	+ "\t" +
				FileOperation.student[num].getSex() 		+ "\t" +
				FileOperation.student[num].getAcademy() 	+ "\t" +
				FileOperation.student[num].getScore1() 	+ "\t" +
				FileOperation.student[num].getScore2()	+ "\t" +
				FileOperation.student[num].getScore3() 	+ "\t" +
				FileOperation.student[num].getScoreAverage() 
							);
		
	}

}
