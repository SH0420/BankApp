
public class Account {
    String ano; //���¹�ȣ
    String owner;
    int balance;//�����ܾ�
    double rate;//����
	
    int amount; //��� ���ɾ�
    
    
    public Account(String ano, String owner, int balance, double rate) { //������ source ->GCuF->�����ڻ������� 
	
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		this.rate = rate;
	}
    
    String getAno() {
    	return ano;
    }
    
    void setAno(String ano) {
    	this.ano = ano;
    }
    
    String get0wner() {
    	return owner;
    }
    
    void setOwner(String owner) {
    	this.owner= owner;
    }
    
    int getBalance() {
    	return balance;
    }
    
    void setBalance(int balance) {
    	this.balance = balance;
    }
    
    double getRate() {
    	return rate;
    }
    
    void setRate(double rate) {
    	this.rate =rate;
    }
    
    //
    int getAmount() {
    	return amount;
    }
    //
    void setAmount(int amount) {
    	this.amount = amount;
    }
    //
    void rateCal() {
    	this.amount = balance + (int)(balance * getRate()/100);
    }
    
}
//930 2.3