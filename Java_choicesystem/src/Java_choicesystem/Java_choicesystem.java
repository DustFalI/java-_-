package Java_choicesystem;

import java.util.Scanner;

import Java_choicesystem.s_apply; 

class s_apply
{
//	存储信息
	private int s_name;
	private int c_number;
	private String apply_cds;
//	构造方法
	public s_apply(int s_name,int c_number,String apply_cds)
	{
		this.s_name = s_name;
		this.c_number = c_number;
		this.apply_cds = apply_cds;
	}
	public String getCds()
	{
		return apply_cds;
	}
	public int getName()
	{
		return s_name;
	}
	public int getNumber()
	{
		return c_number;
	}
}
public class Java_choicesystem  
{
	
	public static void main(String[] args) 
	{	
        Scanner scanner = new Scanner(System.in); 
//        新建数组
        s_apply[] applyarray = new s_apply[100];
        
        int applycount = 0;
//        程序入口
        enter: while(true)
        {
        	System.out.println("-------------------------------------------");  
	        System.out.println("选择客户端");  
	        System.out.println("1. 教师端"); 
	        System.out.println("2. 学生端");
	        System.out.println("3. 退出");  
	        System.out.println("请选择操作（1-3）: "); 
	//        选择用户
	        int log = scanner.nextInt();
	//        教师端与学生端分支
	        switch(log) 
	        {
	//        	第一个分支：教师端
	        	case 1:
	//        		教师端面板
	        		assess_t:while (true) 
	        		{
	        			System.out.println("-------------------------------------------");  
	                    System.out.println("教师端选课模块");  
	                    System.out.println("1. 查看申请列表");
	                    System.out.println("2. 审核");
	                    System.out.println("3. 退出");  
	                    System.out.println("请选择操作（1-3）: ");
	//                    接收输入信息
	                    int cho_choice = scanner.nextInt();
	//                    判定输入
	                    switch(cho_choice) 
	                    {
	//                    	面板下第一条分支 查看申请列表
	                    	case 1:
	                    		System.out.println("-------------------------------------------");  
	                    		System.out.println("申请列表");
	//                    		依次输出申请数组内的字符串
	                    		for(int choice_i=0;choice_i<applycount;choice_i++) 
	                    		{
//	                    			判定数组是否为空
	                    			if(applyarray[choice_i] != null)
	                    			{
	                    			System.out.println("学号：" + applyarray[choice_i].getName() + "课题编号：" + applyarray[choice_i].getNumber() + "状态：" + applyarray[choice_i].getCds());
	                    			}
	                    		}
	                    		
	                    		System.out.println("1.退出");
	//                    		接收判定退出
	                    		int out = scanner.nextInt();
	                    		if(out == 1) 
	                    		{
	                    		break;
	                    		}
	//                    	面板下第二条分支 查询/审批
	                    	case 2:
	                    		System.out.println("输入查询的学生学号");
//	                    		接收输入的数值
	                    		int search_t = scanner.nextInt();
	                    		int temp = -1;
	                    		int index_t_m = 0;
	                    		for(int choice_i=0;choice_i<applycount;choice_i++) {
	                    			if( applyarray[choice_i] != null) {
	                    				int s_number1 = applyarray[choice_i].getName();
	                    				if(s_number1 == search_t) {
	                    					temp = choice_i;
	                    					index_t_m = choice_i;
	                    				
	                    				}
	                    			}
	                    		}
	                    		
	                    		if(temp != -1) {
	                    			System.out.println("姓名" + applyarray[index_t_m].getName() + "编号" + applyarray[index_t_m].getNumber() + "状态：" + applyarray[index_t_m].getCds());
//	                    			询问是否同意
	                    			System.out.println("-------------------------------------------");  
    	                    		System.out.println("是否同意申请");
	                    			System.out.println("1. 同意");
	                    			System.out.println("2. 驳回");
	                    			System.out.println("3. 退出");
	                    			int assess_i = scanner.nextInt();
	                    			switch(assess_i)
	                    			{
	                    			case 1:
	                    				String modify_c1 = "已批准";
//        	                    		新数据覆盖原数据
        	                    		s_apply modify_apply = new s_apply(applyarray[index_t_m].getName(),applyarray[index_t_m].getNumber(),modify_c1);
        	                    		applyarray[index_t_m] = modify_apply;
        	                    		continue assess_t;
	                    			case 2:
	                    				String modify_c2 = "未批准";
//        	                    		新数据覆盖原数据
        	                    		s_apply modify_apply1 = new s_apply(applyarray[index_t_m].getName(),applyarray[index_t_m].getNumber(),modify_c2);
        	                    		applyarray[index_t_m] = modify_apply1;
        	                    		continue assess_t;
	                    			case 3:
	                    				continue assess_t;
        	                    		
	                    			default:
	                    				System.out.println("输入非选项，程序已退出");
	                    				continue assess_t;
	                    			}
	                    		}else {
	                    			System.out.println("-------------------------------------------");  
	                    			System.out.println("未找到指定记录");
	                    			continue assess_t;
	                    		}
	                    		
                    			
	//                    	面板下第三条分支 退出
	                    	case 3:
	                    		continue enter;
	                    	default:
                                System.err.println("无效的选择，请重新输入。");
	                    }
	        		}
	        		
	//        	第二个分支：学生端
	        	case 2:
	//        		学生端面板
	        		s_m:while (true) 
	        		{
	        			System.out.println("-------------------------------------------");  
	                    System.out.println("学生端选课模块");  
	                    System.out.println("1. 发布申请"); 
	                    System.out.println("2. 修改申请");
	                    System.out.println("3. 删除申请");
	                    System.out.println("4. 查看审核状态");
	                    System.out.println("5. 退出");  
	                    System.out.println("请选择操作（1-5）: ");  
	//                    接收输入信息
	                    int applychoice = scanner.nextInt();  
	//                    判定输入
	                    switch(applychoice) 
	                    {
	//                    	学生端:发布
	                    	case 1:
	//                    		输入数据
	                    		System.out.println("输入学号");
	                    		int s_name = scanner.nextInt();
	                    		scanner.nextLine();
	                    		System.out.println("输入要申请的课题编号");
	                    		int c_number = scanner.nextInt();
	                    		String non_cds = "未审核";
//	                    		新建数组
	                    		s_apply newapply = new s_apply(s_name,c_number,non_cds);
	                    		applyarray[applycount] = newapply;
//	                    		数组下标加一
	                    		applycount++;
	                    		System.out.println("添加成功");
//	                    		回到学生面板
	                    		continue s_m;
//	                    	学生端:修改
	                    	case 2:
//	                    		修改申请
	                    		System.out.println("输入学号");
	                    		int search_s_m = scanner.nextInt();
	                    		int index_s_m = 0;
//	                    		搜索匹配
	                    		for(int a_i=0;a_i<applycount;a_i++)
	                    		{
		                    		int s_name1 = applyarray[a_i].getName();
//		                    		判断该数组是否为空
	                    			if(s_name1 == (search_s_m))
	                    			{
	                    				System.out.println("姓名：" + applyarray[a_i].getName() + "课题编号：" + applyarray[a_i].getNumber());
	                    				index_s_m = a_i;
	                    				break;
	                    				
	                    			}
	                    		}
	                    		
	                    		System.out.println("输入您要修改的课题编号");
	                    		int modify_c = scanner.nextInt();
//	                    		新数据覆盖原数据
	                    		s_apply modify_apply = new s_apply(applyarray[index_s_m].getName(),modify_c,applyarray[index_s_m].getCds());
	                    		applyarray[index_s_m] = modify_apply;
//	                    		回到学生面板
	                    		continue s_m;
//	                    	学生端:删除
	                    	case 3:
	                    		System.out.println("输入学号");
	                    		int search_s_d = scanner.nextInt();
	                    		int index_s_d = 0;
//	                    		搜索匹配
	                    		for(int b_i=0;b_i<applycount;b_i++)
	                    		{
	                    			if(applyarray[b_i] != null)
	                    			{
		                    		int s_name1 = applyarray[b_i].getName();
	                    				if(s_name1 == (search_s_d))
	                    				{
	                    					System.out.println("姓名：" + applyarray[b_i].getName() + "选课编号：" + applyarray[b_i].getNumber());
	                    					System.out.println("-------------------------------------------");  
	                    					index_s_d = b_i;
	                    					break;
	                    				
	                    				}
	                    			}
	                    		}
//	                    		询问是否删除
	                    		System.out.println("1. 是否删除");
	                    		int i_d = scanner.nextInt();
	                    		if(i_d == 1)
	                    		{
	                    			applyarray[index_s_d] = null;
	                    		}
//	                    		回到学生面板
	                    		continue s_m;
//	                    		查看审核状态
	                    	case 4:
	                    		System.out.println("请输入您的学号");
//	                    		接收输入的数值
	                    		int search_t = scanner.nextInt();
	                    		int temp = -1;
	                    		int index_t_m = 0;
	                    		
	                    		for(int choice_i=0;choice_i<applycount;choice_i++) {
	                    			if(applyarray[choice_i] != null){
	                    				int s_number1 = applyarray[choice_i].getName();
	                    				if(s_number1 == search_t) {
	                    					temp = choice_i;
	                    					index_t_m = choice_i;
	                    				
	                    				}
	                    			}
	                    		}
	                    		
	                    		if(temp != -1) {
	                    			System.out.println("学号" + applyarray[index_t_m].getName() + "课题编号" + applyarray[index_t_m].getNumber() + "状态：" + applyarray[index_t_m].getCds());
//	                    			
	                    		}else {
	                    			System.out.println("-------------------------------------------");  
	                    			System.out.println("未找到指定记录");
	                    			continue s_m;
	                    		}
	                    		
	                    		System.out.println("1.退出");
    	                    	//接收判定退出
    	                    	int out = scanner.nextInt();
    	                    	if(out == 1) 
    	                    	{
    	                    		break;
    	                    	 }
	                    		
	//                    	学生端:退出
	                    	case 5:
//	                    		回到入口
	                    		continue enter;
	                    	default:
                                System.err.println("无效的选择，请重新输入。");
	                    }
	        		}
	//        	第三个分支：退出
	        	case 3:
//	        		程序退出
	        		System.exit(0);
	        	default:
	        		System.out.println("无效信息");
	        		continue enter;
	        }
        }
	        
        
	}
}
