import java.util.Scanner;

public class BankApp {
  Account[] acc =new Account[1000];    //멤버변수
  Scanner sc =new Scanner(System.in);  //멤버변수 / 참조형 기본값 null
  
  void info() {
	  System.out.println("---------------------------------");
	  System.out.println("1.계좌생성 2.계좌목록 3.예금 4.출금 5.종료");
	  System.out.println("---------------------------------");
	  System.out.print("선택 : ");
  }
  
    //계좌생성기능
  void createAccount() {
	  System.out.println("----------");
	  System.out.println("계좌 생성 메뉴");
	  System.out.println("----------");
	  
	  System.out.println("계좌번호 : ");
	  String ano = sc.next();
	  
	  if(findAccount(ano) != null) {
		  System.out.println("이미 계좌가 존재합니다");
		  return;
	  }
	  
	  System.out.println("계좌주명 : ");
	  String owner = sc.next();
	  
	  System.out.println("초기입금액 : ");
	  int balance = sc.nextInt();
	  
	  System.out.println("이자율 입력 : ");
	  double rate = sc.nextDouble();
	  
	
	  
	  Account account = new Account(ano,owner,balance,rate);
	  //
	  account.rateCal();
	  
	  for(int i=0;i<acc.length;i++) {
		  if(acc[i] == null) {
			  acc[i] = account;
			  System.out.println("계좌가 생성되었습니다.");
			  break;
		  }
	
	  }
	  
  }
  
  //계좌목록보기기능
  void accountList() {
	  System.out.println("-------------");
	  System.out.println("계좌 목록 보기 메뉴");
	  System.out.println("-------------");
	  //
	  System.out.println("계좌번호  계좌주   입금액    이자율   출금가능액");
	  
	  for(int i=0;i<acc.length;i++) {
		  if(acc[i] == null) {
			  break;
		  }
		  //
		  System.out.println(acc[i].getAno() + "   " +acc[i].get0wner() + "   " + acc[i].getBalance() +"   "+acc[i].getRate() +"%   " +acc[i].getAmount());
	  }
	  
  }
  
   //예금 기능 
   void deposit() {
	   System.out.println("-------------");
	   System.out.println("예금 기능메뉴");
	   System.out.println("-------------");
	   
	   System.out.println("계좌번호 : ");
	   String ano = sc.next();
	   
	   System.out.println("예금액 : ");
	   int balance = sc.nextInt();
	   
	   //완성기능
	   Account account =findAccount(ano);
	   
	   if(account == null) {
		   System.out.println("계좌번호가 존재하지않습니다.");
		   return;  //void문에 조건문에 return을 쓰면 강제종료
	   }
	   
	   account.setBalance(account.getBalance() + balance);
	   System.out.println("예금 처리가 정상적으로 되었습니다.");
                 
	   
   }
   
   
   //출금 기능
   void withdraw() {
	   System.out.println("-------------");
	   System.out.println("출금 기능메뉴");
	   System.out.println("-------------");
	   
	   System.out.println("계좌번호: ");
	   String ano=sc.next();
	   
	   System.out.println("출금액: ");
	   int balance = sc.nextInt();
	   
	   Account account = findAccount(ano);
	   
	   if(account == null) {
		   System.out.println("계좌번호가 존재하지않습니다.");
		   return;
	   }
	   
	   if(account.getBalance()< balance) {
		   System.out.println("예금액이 부족합니다.");
		   return;
	   }
	   
	   account.setBalance(account.getBalance() - balance);
	   System.out.println("출금 처리가 정상적으로 되었습니다.");
	   
   }
   
   

   Account findAccount(String ano) {
	
	   Account account = null;
	   
	   for(int i=0;i<acc.length;i++) {
		if(acc[i] !=null) {
			 if(acc[i].ano.equals(ano)) { //문자열을  비교할떄는 equals라는 메소드를 사용해야함 
			   account = acc[i];
			   break;
			}
		}
	}
	   return account;
	   
   }
   
   
//동일한 동작을 하는걸 메소드로만들어서 필요할때 가져다씀
//타입이 동일하면 배열을 사용하면 편하다 -객체배열
}
//930 2.3.4