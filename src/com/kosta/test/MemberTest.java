package com.kosta.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.kosta.dao.MemberDAO;
import com.kosta.dto.MemberDTO;

/*
 * 1. DB����
 * 2. preparedStatement�� �̿��Ͽ� insert, update, delete => executeUpdate
 * 							  select => executeQuery
 * 3. executeUpdate => row �� �޾Ƽ� Ȯ��
 *    executeQuery => ResultSet�� �̿��Ͽ� �޾Ƽ� ���
 * 4. close
 */

public class MemberTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MemberDAO dao = new MemberDAO();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("======================================");
			System.out.println("1.�Է� |2.����|3.����|4.��ȸ|5.��ü����|6.����");
			System.out.println("======================================");
			System.out.print("����> ");
		
			String choice = sc.nextLine();
			
			//insert
			if (choice.equals("1")) {
				while(true) {
					System.out.print("���̵� �Է��ϼ���: ");
					String mid = sc.nextLine();
					
					if(dao.isCheck(mid)) {
						System.out.println("�����ϴ� ���̵��Դϴ�.");
						
					} else {
						System.out.print("�н����带 �Է��ϼ���: ");
						String mpwd = sc.nextLine();
						
						System.out.print("�̸��� �Է��ϼ���: ");
						String mname = sc.nextLine();
						
						System.out.print("�̸����� �Է��ϼ���: ");
						String memail = sc.nextLine();
						
						int result = dao.insert(mid, mpwd, mname, memail);
						if (result >= 1)
							System.out.println("�߰� �Ϸ�");
						else
							System.out.println("�߰� ����");
					} 
					
					System.out.print("\n��� �Է��ұ��? ");
	
					String yn = sc.nextLine();
					if(yn.equalsIgnoreCase("n"))
						break;
				}
				
			//update
			} else if (choice.equals("2")) {
				while(true) {
					System.out.print("������ ���̵� �Է��ϼ���: ");
					String mid = sc.nextLine();
					
					if(dao.isCheck(mid)) {
						System.out.print("������ �н����带 �Է��ϼ���: ");
						String mpwd = sc.nextLine();
						
						System.out.print("������ �̸����� �Է��ϼ���: ");
						String memail = sc.nextLine();
						
						int result = dao.update(mid, mpwd, memail);
						if(result >= 1)
							System.out.println("���� �Ϸ�");
						else
							System.out.println("���� ����");
						
					} else
						System.out.println("�������� �ʴ� ���̵��Դϴ�.");
					
					System.out.print("\n��� �����ұ��? ");
	
					String yn = sc.nextLine();
					if(yn.equalsIgnoreCase("n"))
						break;
				}
				
			//delete
			} else if (choice.equals("3")) {
				while(true) {
					System.out.print("������ ���̵� �Է��ϼ���: ");
					String mid = sc.nextLine();
					
					if(dao.isCheck(mid)) {
						int result = dao.delete(mid);
						if(result >= 1)
							System.out.println("���� �Ϸ�");
						else
							System.out.println("���� ����");
						
					} else
						System.out.println("�������� �ʴ� ���̵��Դϴ�.");
					
					System.out.print("\n��� �����ұ��? ");
	
					String yn = sc.nextLine();
					if(yn.equalsIgnoreCase("n"))
						break;
				}
				
			//select	
			} else if (choice.equals("4")) {
				while(true) {
					System.out.print("��ȸ�� ���̵� �Է��ϼ���: ");
					String mid = sc.nextLine();
					
					if(dao.isCheck(mid)) {
						System.out.println("-------------------------------------------------------------------");
						System.out.println("��ȣ\t���̵�\t�н�����\t�̸�\t�̸���\t\t��������");
						System.out.println("-------------------------------------------------------------------");
						
						dao.select(mid);
						
					} else
						System.out.println("�������� �ʴ� ���̵��Դϴ�.");
					
					System.out.print("\n��� ��ȸ�ұ��? ");
	
					String yn = sc.nextLine();
					if(yn.equalsIgnoreCase("n"))
						break;
				}
				
			//select all
			} else if (choice.equals("5")) {
				while(true) {
					ArrayList<MemberDTO> list = dao.getAll();
					
					System.out.println("-------------------------------------------------------------------");
					System.out.println("��ȣ\t���̵�\t�н�����\t�̸�\t�̸���\t\t��������");
					System.out.println("-------------------------------------------------------------------");
	
					for(MemberDTO item:list) {
						System.out.println(item.getMno() + "\t" + item.getMid() + "\t" + item.getMpwd() + "\t" 
											+ item.getMname() + "\t" + item.getMemail() + "\t" + item.getMdate());
					}
					
					break;
				}
				
			} else if (choice.equals("6")) {
				System.out.println("���α׷� ����");
				break;
				
			} else
				System.out.println("����� �߸� �Է��߽��ϴ�.");
		
		} //end while
		
	} //end main

}// end class
