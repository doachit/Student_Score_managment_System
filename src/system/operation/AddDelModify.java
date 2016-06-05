package system.operation;

import java.util.Scanner;

import system.file.FileOperation;

public final class AddDelModify {
	
	public static void addStudent()
	{
		String id;
		String name;
		String sex;
		String academy;
		float score1;
		float score2;
		float score3;
		System.out.println("添加学生：\n\n\n请输入学生信息:\n\n");
		
		
		
	}
	
	public static void delStudent()
	{
		String id,out;
		String match = "[0-9]+";
		Scanner input = new Scanner(System.in);
		System.out.println("删除学生： \n\n\n");
		while(true)
		{
			System.out.println("请输入待删除的学生学号：\n\n");
			while(true)
			{
				id = input.nextLine();
				if(id.matches(match)) break;
				else System.out.println("输入格式错误，请重新输入！");
			}
			
			for(int i = 0; i < FileOperation.getStudentNum(); i++)
			{
				if(id.equals(FileOperation.getStudent(i).getId()))
				{
					FileOperation.studentArray.remove(i);
					FileOperation.isModify = true;
				}
			}
			
			if (!FileOperation.isModify)
				System.out.println("没有相关信息！");
			System.out.println("退出？（Y/N）");
			
			out = input.nextLine();
			
			if(out.equals("Y") || out.equals("y")) 
			{
				System.out.println("退出删除页面.........\n\n\n");
				//input.close();
				break;
			}
		}
		
		
	}
	
	public static void modifyStudent()
	{
		System.out.println("修改学生信息：\n\n\n");
		
	}
}
