package jp;

import java.util.Scanner;

public class AccountService {
	// 배열을 선언해준다.
	private static Account[] accounts = new Account[100];
	private static int index = 0;
	
	// 계좌 확인
	public static int retrieveIndexByAccountNumber(String accountNum) {
		for(int i = 0; i < index; i++) {
			if(accounts[i].getAccountNumber().equals(accountNum)) {
				return i;
			}
		}
		return -1;
	}
	// 계좌 개설하다.
	public static void createAccount() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("계좌번호 : ");
		String accountNum = scan.nextLine();
		
		System.out.print("비밀번호 : ");
		String name = scan.nextLine();
		
		System.out.print("성함 : ");
		String password = scan.nextLine();
		
		System.out.print("계좌 금액 : ");
		int accountBal = scan.nextInt();
		
		accounts[index] = new Account(accountNum,password,name,accountBal);
		index++;
		
		System.out.println("계좌가 생성되었습니다.");
		
	}
	
	// 계좌 잔액 조회.
	public static void retreiveBalance(){
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호를 입력해주세요.");
		String accountNum = scan.nextLine();
		
		int index = retrieveIndexByAccountNumber(accountNum);
		if(index != -1){
			System.out.printf("계좌 잔액 = %d%n",accounts[index].getBalance());
		}else {
			System.out.println("생성되지 않은 계좌번호입니다.");
		}
	}
	
	// 입금
	public static void checkIn(){
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호를 입력해주세요.");
		String accountNum = scan.nextLine();
		
		System.out.print("입금액 : ");
		int amount = scan.nextInt();
		
		int index = retrieveIndexByAccountNumber(accountNum);
		if(index != -1){
			accounts[index].deposit(amount);
		}else {
			System.out.print("생성되지 않은 계좌번호입니다.");
		}
	}
	
	// 출금
	public static void checkOut(){
        Scanner scan = new Scanner(System.in);
 
        System.out.print("계좌번호를 입력해주세요.");
        String accountNum = scan.nextLine();
        System.out.print("비밀번호를 입력해주세요.");
        String password = scan.nextLine();
        System.out.print("출금할 금액 : ");
        int amount = scan.nextInt();       
 
        int index = retrieveIndexByAccountNumber(accountNum);
        if(index == -1){
            System.out.println("없는 계좌번호입니다.");
        }else{
            if(!accounts[index].getPassword().equals(password)){
                System.out.println("비밀번호가 일치하지 않습니다.");
                return;
            }
            accounts[index].withdraw(amount);
            System.out.printf("%d 원이 인출되었습니다.%n", amount);
        }
    }	
		// 전체 계좌를 조회한다.
		public static void retrieveAcoountList(){
			for(int i=0; i<index; i++) {
				System.out.printf("%s%n",accounts[i].getAccountInfo());
			}
		}
		
		public static void main(String[] args){
			Account[] acc = new Account[10];
			Scanner scan = new Scanner(System.in);
			boolean isExit = false;
			
			do {
				System.out.println("[ 은행 입출금 관리 시스템 ]");
	            System.out.println("1. 계좌 생성");
	            System.out.println("2. 계좌 잔액조회");
	            System.out.println("3. 계좌 입금");
	            System.out.println("4. 계좌 출금");
	            System.out.println("5. 전체 계좌조회");
	            System.out.println("6. 종료");
	            System.out.print("항목을 선택해주세요.");
	            
	            int menu = scan.nextInt();
	            switch(menu) {
	            case 1 :
	            	System.out.println("계좌를 생성합니다.");
	            	createAccount();
	            	break;
	            case 2 :
	            	System.out.println("계좌 잔액조회");
	            	retreiveBalance();
	            	break;
	            case 3 :
	            	System.out.println("");
	            	checkIn();
	            	break;
	            case 4 :
	            	System.out.println("출금할 금액을 선택하세요.");
	            	checkOut();
	            	break;
	            case 5 :
	            	System.out.println("전체 계좌조회");
	            	retrieveAcoountList();
	            	break;
	            case 6 :
	            	isExit = true;
	            	System.out.println("이용해 주셔서 감사합니다.");
	            	break;
	            default:
	            	System.out.println("다시 한번 입력해주세요.");
	            }
	            
				}while(!isExit);
			
			
		}
}

