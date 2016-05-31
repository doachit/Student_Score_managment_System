package system.operation;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import system.file.FileOperation;

public final class QueryFunction {
	public static int num = FileOperation.getStudentNum();
	private static String matchEnd = "-?1?";
	/*
	 * 按照姓名进行查询
	 */
	public static void queryByName()
	{
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
		String matchNum = "-?[0-9]+";
		
		while(true)
		{			
			while(true)
			{
				System.out.println("请输入学号进行查询：");
				queryId = input.nextLine();
				
				if(queryId.matches(matchNum))
				{
					break;				
				}
				else 
				{
					System.out.println("输入格式错误，请重新输入：\n");
				}
			}
			if(queryId.equals("-1"))
			{
				System.out.println("退出该模块.........\n");
				break;
			}
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

		}
	}
	/*
	 * 按照学院进行查询
	 */
	public static void  queryByAcademy()
	{
		int count;
		String queryAcademy;
		ArrayList<Integer> studentId = new ArrayList<Integer>();
		String matchString = "[A-G]";
		Scanner input = new Scanner(System.in);
		while(true)
		{
			while(true)
			{
				System.out.println("分别有 A-G 7个学院，请输入学院名称进行查询：");
				queryAcademy = input.next();
				if(queryAcademy.matches(matchString)) break;
				else {
					if(queryAcademy.matches(matchEnd)) break;
					System.out.println("没有该学院，请重新输入！");
				}
			};
			
			if(queryAcademy.equals("-1"))
			{
				System.out.println("退出该模块..........\n");
				break;
			}
			
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
			
			
		}
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
	public static void showAllStudentInfo()
	{
		for (int i = 0; i < FileOperation.getStudentNum(); i++) {
			showOneStudentInfo(i);
		}
	}

}
