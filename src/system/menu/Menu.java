package system.menu;

import java.util.Scanner;

import system.file.FileOperation;
import system.operation.AddDelModify;
import system.operation.QueryFunction;
import system.operation.SortFunction;
import system.operation.Statistic;

public class Menu {

	public static void main(String[] args) {
		
		mainMenu();
	}
	
	public static void mainMenu(){
		Scanner input = new Scanner(System.in);
		/*
		 * 系统主界面
		 */
		while(true)
		{
			System.out.println("****************************************");
			System.out.println("\t欢迎使用查询系统\n\n");
			System.out.println("\t1:添加学生信息");
			System.out.println("\t2:删除学生信息");
			System.out.println("\t3:修改学生信息");
			System.out.println("\t4:按照平均成绩的降序排列");
			System.out.println("\t5:按照姓名的升序排列");
			System.out.println("\t6:根据学号进行查询");
			System.out.println("\t7:根据姓名进行查询");
			System.out.println("\t8:根据学院进行查询");
			System.out.println("\t9:平均成绩统计");
			System.out.println("\t10:退出");
			System.out.println("****************************************");
			System.out.println("输入序号选择相应的功能：");
			
			FileOperation.readFile();
			int choice = input.nextInt();
			//Integer.parseInt(s)
			switch(choice)
			{
				case 1: AddDelModify.addStudent();
				break;
				
				case 2: AddDelModify.delStudent();
				break;
				
				case 3: AddDelModify.modifyStudent();
				break;
			
				case 4: SortFunction.descendByAverage();	
				break;
				
				case 5: SortFunction.ascendByName();	
				break;
				
				case 6: QueryFunction.queryById();
				break;
				
				case 7: QueryFunction.queryByName();
				break;
				
				case 8: QueryFunction.queryByAcademy();
				break;
				
				case 9: Statistic.statisticScore();
				break;
				
				case 10: 
					{
						input.close();
						exit();						
					}
				break;
				
			}
			
			/*
			 * 如何有修改，在退出时就写入修改
			 */
			if(FileOperation.getModifyFlag()) FileOperation.saveStudentInfo();
		}

	}
	public static void exit()
	{
		System.out.println("退出系统.........");
		System.exit(0);
	}
	
}
