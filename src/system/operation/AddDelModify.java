package system.operation;

import java.util.Scanner;

import system.file.FileOperation;
import system.object.Student;

public final class AddDelModify {
	
	public static void addStudent()
	{
		String id;
		String name;
		String sex;
		String academy;
		String score1;
		String score2;
		String score3;
		String quiet;
		Scanner add = new Scanner(System.in);
		while(true)
		{
			System.out.println("添加学生:\n\n\n请输入学生信息:\n\n");
			System.out.println("请输入学号:\n\n");
			id = add.nextLine();
			System.out.println("请输入姓名:\n\n");
			name = add.nextLine();
			System.out.println("请输入性别:\n\n");
			sex = add.nextLine();
			System.out.println("请输入学院:\n\n");
			academy = add.nextLine();
			System.out.println("请输入科目一分数:\n\n");
			score1 = add.nextLine();
			System.out.println("请输入科目一分数:\n\n");
			score2 = add.nextLine();
			System.out.println("请输入科目一分数:\n\n");
			score3 = add.nextLine();
			
			FileOperation.studentArray.add(new Student(
					id,
					name,
					sex,
					academy,
					Float.parseFloat(score1),
					Float.parseFloat(score2),
					Float.parseFloat(score3)					
					));
			FileOperation.isModify = true;
			
			System.out.println("退出？（Y/N）");
			quiet = add.nextLine();
			if(quiet.equals("y") || quiet.equals("Y")) break;
		};		
	}
	
	public static void delStudent()
	{
		String id;
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
			};
			
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
			
			id = input.nextLine();
			
			if(id.equals("Y") || id.equals("y")) 
			{
				System.out.println("退出删除页面.........\n\n\n");
				//input.close();
				break;
			}
		};
		
		
	}
	
	public static void modifyStudent()
	{
		System.out.println("修改学生信息：\n\n\n");
		String id;
		String name;
		String sex;
		String academy;
		String score1;
		String score2;
		String score3;
		String quiet;
		int modifyIndex = 0;
		Scanner modify = new Scanner(System.in);
		while(true)
		{
			System.out.println("请输入待修改学生的学号:\n\n");
			while(true)
			{
				id = modify.nextLine();
				for(int i = 0; i < FileOperation.getStudentNum(); i++)
				{
					if(id.equals(FileOperation.getStudent(i).getId()))
					{
						modifyIndex = i;
						break;
					}
				}
				
				if(id.equals(FileOperation.getStudent(modifyIndex).getId()))
				{
					break;
				}
				else
				{
					System.out.println("没有该学生的信息，请重新输入！\n\n");
				}
			}
			
			System.out.println("请输入姓名:\n\n");
			name = modify.nextLine();
			System.out.println("请输入性别:\n\n");
			sex = modify.nextLine();
			System.out.println("请输入学院:\n\n");
			academy = modify.nextLine();
			System.out.println("请输入科目一分数:\n\n");
			score1 = modify.nextLine();
			System.out.println("请输入科目一分数:\n\n");
			score2 = modify.nextLine();
			System.out.println("请输入科目一分数:\n\n");
			score3 = modify.nextLine();
			
			FileOperation.studentArray.get(modifyIndex).setStudentInfo(
					id,
					name,
					sex,
					academy,
					Float.parseFloat(score1),
					Float.parseFloat(score2),
					Float.parseFloat(score3)					
					);
			FileOperation.isModify = true;
			
			System.out.println("退出？（Y/N）");
			quiet = modify.nextLine();
			if(quiet.equals("y") || quiet.equals("Y")) break;
		};
	}
}
