import java.util.Scanner;

public class BankApp {
  Account[] acc =new Account[1000];    //�������
  Scanner sc =new Scanner(System.in);  //������� / ������ �⺻�� null
  
  void info() {
	  System.out.println("---------------------------------");
	  System.out.println("1.���»��� 2.���¸�� 3.���� 4.��� 5.����");
	  System.out.println("---------------------------------");
	  System.out.print("���� : ");
  }
  
    //���»������
  void createAccount() {
	  System.out.println("----------");
	  System.out.println("���� ���� �޴�");
	  System.out.println("----------");
	  
	  System.out.println("���¹�ȣ : ");
	  String ano = sc.next();
	  
	  if(findAccount(ano) != null) {
		  System.out.println("�̹� ���°� �����մϴ�");
		  return;
	  }
	  
	  System.out.println("�����ָ� : ");
	  String owner = sc.next();
	  
	  System.out.println("�ʱ��Աݾ� : ");
	  int balance = sc.nextInt();
	  
	  System.out.println("������ �Է� : ");
	  double rate = sc.nextDouble();
	  
	
	  
	  Account account = new Account(ano,owner,balance,rate);
	  //
	  account.rateCal();
	  
	  for(int i=0;i<acc.length;i++) {
		  if(acc[i] == null) {
			  acc[i] = account;
			  System.out.println("���°� �����Ǿ����ϴ�.");
			  break;
		  }
	
	  }
	  
  }
  
  //���¸�Ϻ�����
  void accountList() {
	  System.out.println("-------------");
	  System.out.println("���� ��� ���� �޴�");
	  System.out.println("-------------");
	  //
	  System.out.println("���¹�ȣ  ������   �Աݾ�    ������   ��ݰ��ɾ�");
	  
	  for(int i=0;i<acc.length;i++) {
		  if(acc[i] == null) {
			  break;
		  }
		  //
		  System.out.println(acc[i].getAno() + "   " +acc[i].get0wner() + "   " + acc[i].getBalance() +"   "+acc[i].getRate() +"%   " +acc[i].getAmount());
	  }
	  
  }
  
   //���� ��� 
   void deposit() {
	   System.out.println("-------------");
	   System.out.println("���� ��ɸ޴�");
	   System.out.println("-------------");
	   
	   System.out.println("���¹�ȣ : ");
	   String ano = sc.next();
	   
	   System.out.println("���ݾ� : ");
	   int balance = sc.nextInt();
	   
	   //�ϼ����
	   Account account =findAccount(ano);
	   
	   if(account == null) {
		   System.out.println("���¹�ȣ�� ���������ʽ��ϴ�.");
		   return;  //void���� ���ǹ��� return�� ���� ��������
	   }
	   
	   account.setBalance(account.getBalance() + balance);
	   System.out.println("���� ó���� ���������� �Ǿ����ϴ�.");
                 
	   
   }
   
   
   //��� ���
   void withdraw() {
	   System.out.println("-------------");
	   System.out.println("��� ��ɸ޴�");
	   System.out.println("-------------");
	   
	   System.out.println("���¹�ȣ: ");
	   String ano=sc.next();
	   
	   System.out.println("��ݾ�: ");
	   int balance = sc.nextInt();
	   
	   Account account = findAccount(ano);
	   
	   if(account == null) {
		   System.out.println("���¹�ȣ�� ���������ʽ��ϴ�.");
		   return;
	   }
	   
	   if(account.getBalance()< balance) {
		   System.out.println("���ݾ��� �����մϴ�.");
		   return;
	   }
	   
	   account.setBalance(account.getBalance() - balance);
	   System.out.println("��� ó���� ���������� �Ǿ����ϴ�.");
	   
   }
   
   

   Account findAccount(String ano) {
	
	   Account account = null;
	   
	   for(int i=0;i<acc.length;i++) {
		if(acc[i] !=null) {
			 if(acc[i].ano.equals(ano)) { //���ڿ���  ���ҋ��� equals��� �޼ҵ带 ����ؾ��� 
			   account = acc[i];
			   break;
			}
		}
	}
	   return account;
	   
   }
   
   
//������ ������ �ϴ°� �޼ҵ�θ��� �ʿ��Ҷ� �����پ�
//Ÿ���� �����ϸ� �迭�� ����ϸ� ���ϴ� -��ü�迭
}
//930 2.3.4