package jp;

public class Account {
	// Account 클래스에 인스턴스 변수,디폴트 생성자 메소드,
	// 매개변수 생성자 메소드를 생성한다.
	// 인스턴스 변수를 생성한다.
	private String accountNum; // 계좌번호
	private String name; // 성함
	private String password; // 비밀번호
	private int accountBal; // 계좌잔고
	// 디폴트 생성자 메소드를 생성한다.
	public Account() {
		
	}
	// 매개변수 생성자 메소드
	public Account(String accountNum, String name, String password, int accountBal){
	this.accountNum = accountNum;
	this.name = name;
	this.password = password;
	this.accountBal = accountBal;
	}
	
	// 계좌 잔액을 조회합니다.
	public int getBalance() {
		return accountBal; // 인스턴스 변수
		// retrun this.balance; // this가 생략되어 있음.
	}
	// 비밀번호를 생성한다.
	public void setPassword(String password) {
		this.password = password;
	}
	// 비밀번호를 조회한다.
	public String getPassword() {
		return password;
	}
	// 입급하다.
	public void deposit(int deposit) {
		if(deposit <= 0) {
			System.out.println("금액을 정확히 입력해주세요.");
			return;
		}
		accountBal+=deposit;
	}
	// 출금하다.
	public void withdraw(int withdraw){
		if(withdraw>accountBal) {
			System.out.println("잔액이 부족합니다. 잔액을 확인해주세요");
			return;
		}
		if(withdraw <= 0){
			System.out.println("0원 및 미만은 출금할 수 없습니다");
			return;
		}
		accountBal -= withdraw;
	}
	// 고객 계좌 정보를 조회한다.
	public String getAccountInfo() {
		return " 계좌 번호 " + accountNum +
				" 성함" + name +
				" 비밀번호" + password +
				" 잔고" + accountBal;
	}
	//계좌 번호를 조회한다.
	public String getAccountNumber() {
		return accountNum;
	}

}
