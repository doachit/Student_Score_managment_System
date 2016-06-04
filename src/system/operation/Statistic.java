package system.operation;

import java.util.Scanner;

import system.file.FileOperation;

public final class Statistic {
	/*
	 * 学生成绩统计函数
	 */
	public static void statisticScore()
	{
		
		System.out.println("\n\n统计平均成绩情况如下：");
		int statistic[] = {0,0,0,0,0};
		int count;
		for(int i = 0; i < FileOperation.getStudentNum(); i++)
		{
			count = statisticNum(FileOperation.getStudent(i).getScoreAverage());
			if(count != -1)
			{
				statistic[count]++;
			}
		}
		
		System.out.println("\t分段\t人数\t图形");
		System.out.println("\t<60\t" + statistic[0] + "\t"   + putGraph(statistic[0]));
		System.out.println("\t60-69\t" + statistic[1] + "\t" + putGraph(statistic[1]));
		System.out.println("\t70-79\t" + statistic[2] + "\t" + putGraph(statistic[2]));
		System.out.println("\t80-89\t" + statistic[3] + "\t" + putGraph(statistic[3]));
		System.out.println("\t>90\t" + statistic[4] + "\t"   + putGraph(statistic[4]));
	
		
		System.out.println("\n\n按回车键退出.........");
		new Scanner(System.in).nextLine();
	}
	/*
	 * 统计分数段学生数目
	 */
	public static int statisticNum(float score)
	{
		if(score < 60) return 0;
		if(score >= 60 && score < 70) return 1;
		if(score >= 70 && score < 80) return 2;
		if(score >= 80 && score < 90) return 3;
		if(score >= 90) return 4;
		
		return -1;//error
	}
	/*
	 * 生成统计图*
	 */
	public static String putGraph(int num)
	{
		StringBuffer outBuffer = new StringBuffer();
		outBuffer.setLength(0);
		for (int i = 0; i < num * 100 / FileOperation.getStudentNum() / 2; i++) 
		{
			outBuffer.append("*");
		}
		return outBuffer.toString();
	}

		

}
