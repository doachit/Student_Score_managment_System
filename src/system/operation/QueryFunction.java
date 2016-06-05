package system.operation;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import system.file.FileOperation;
import system.object.Student;

public final class QueryFunction {
	public static int num = FileOperation.getStudentNum();
	private static String matchEnd = "-1";
	/*
	 * 按照姓名进行查询
	 */
	public static void queryByName()
	{
		int count;
		String queryName;
		ArrayList<Integer> nameNum = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		String matchString = "[a-z]*";
		while(true)
		{
			while(true)
			{
				System.out.println("\n\n请输入学生姓名进行查询：(输入-1退出) ");
				queryName = input.nextLine();
				
				if(queryName.matches(matchString)) break;
				else
				{
					if(queryName.matches(matchEnd)) break;
				}

			};
			
			if(queryName.equals("-1"))
			{
				System.out.println("退出该模块..............\n");
				break;
			}
			
			for (count = 0; count < num; count++) 
			{
				if(queryName.equals(FileOperation.getStudent(count).getName()))
				{
					nameNum.add(new Integer(count));
				}
			}

			if(nameNum.size() != 0)
			{
				System.out.println("\n\n找到"+ nameNum.size() +"条相关记录，如下：");
				System.out.println("\t**************************************************************");
				System.out.println("\t学号\t姓名\t性别\t学院\t科目一\t科目二\t科目三\t平均分");
				for(int i = 0; i < nameNum.size(); i++)
				{
					showOneStudentInfo(FileOperation.getStudent(nameNum.get(i).intValue()));
				}

				System.out.println("\n\n\n");
				nameNum.clear();
			}
			else
			{
				System.out.println("没有找到相关记录！\n\n\n");
			}

		}
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
				System.out.println("\n\n请输入学号进行查询：(输入-1退出) ");
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
				if(queryId.equals(FileOperation.getStudent(count).getId()))
				{
					break;
				}
			}
			if(count != num)
			{
				System.out.println("\n\n找到相关记录，如下：");
				System.out.println("\t**************************************************************");
				System.out.println("\t学号\t姓名\t性别\t学院\t科目一\t科目二\t科目三\t平均分");
				showOneStudentInfo(FileOperation.getStudent(count));
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
				System.out.println("\n\n分别有 A-G 7个学院，请输入学院名称进行查询：(输入-1退出)");
				queryAcademy = input.next();
				if(queryAcademy.matches(matchString)) break;
				else 
				{
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
				if(queryAcademy.equals(FileOperation.getStudent(count).getAcademy()))
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
				System.out.println("\n\n找到"+studentId.size()+"条相关记录，如下：");
				System.out.println("\t**************************************************************");
				System.out.println("\t学号\t姓名\t性别\t学院\t科目一\t科目二\t科目三\t平均分");
				for(int i = 0; i < studentId.size(); i++)
				{
					showOneStudentInfo(FileOperation.getStudent(studentId.get(i).intValue()));
				}
				studentId.clear();
				System.out.println("\n\n\n");
			}
			
			
		}
	}
	
	public static void showOneStudentInfo(Student student)
	{
		student.getOneStudentInfo();
	}
	
	public static void showAllStudentInfo()
	{
		for (int i = 0; i < FileOperation.getStudentNum(); i++) {
			showOneStudentInfo(FileOperation.getStudent(i));
		}
	}

}
