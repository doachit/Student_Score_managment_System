package system.menu;

import java.util.Scanner;

import system.file.FileOperation;
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
			System.out.println("\t1:按照平均成绩的降序排列");
			System.out.println("\t2:按照姓名的升序排列");
			System.out.println("\t3:根据学号进行查询");
			System.out.println("\t4:根据姓名进行查询");
			System.out.println("\t5:根据学院进行查询");
			System.out.println("\t6:平均成绩统计");
			System.out.println("\t7:退出");
			System.out.println("****************************************");
			System.out.println("输入序号选择相应的功能：");
			
			FileOperation.readFile();
			int choice = input.nextInt();
			//Integer.parseInt(s)
			switch(choice)
			{
				case 1: SortFunction.descendByAverage();	
				break;
				
				case 2: SortFunction.ascendByName();	
				break;
				
				case 3: QueryFunction.queryById();
				break;
				
				case 4: QueryFunction.queryByName();//
				break;
				
				case 5: QueryFunction.queryByAcademy();
				break;
				
				case 6: Statistic.statisticScore();
				break;
				
				case 7: exit();break;
			}
		}

	}
	public static void exit()
	{
		System.out.println("退出系统.........");
		System.exit(0);
	}
	
}
