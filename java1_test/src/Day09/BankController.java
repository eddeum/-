package Day09;

import java.util.Random;

public class BankController {

	// 1. ���»���
	public String ���»���(String password, String owner, int bno) {
		
		String ano = null; //////////////////????
	
		while(true) {
			// ���¹�ȣ ����
			Random random = new Random();
			
			int ���� = random.nextInt(10000); // 0~9999����
			ano = String.format("%04d", ����);
			// �����ߺ�üũ
			boolean anocheck = false;
			for(Bank temp : Day09_����������α׷�_1.accountlist) {
				if(temp != null && temp.getAno().equals(ano)) {
					anocheck = true;
				} // if e
			} // for e
			if(anocheck == false) break;
		} // while e
		// ���༱��
		Bank temp = null;
		if(bno == 1) {temp = new KBBank(ano, password, owner, 0);}
		else if(bno == 2) {temp = new SinhanBank(ano, password, owner, 0);}
		else if(bno == 3) {temp = new HanaBank(ano, password, owner, 0);}
		// �迭�� ����
		int i = 0;
		for(Bank temp2 : Day09_����������α׷�_1.accountlist) {
			if(temp2 == null) {
				Day09_����������α׷�_1.accountlist[i] = temp;
				return ano;
			} // if e
			i++;
		} // for e
		return null;
	} // ���»��� e
	
	// 2. �Ա�
	public boolean �Ա�(String ano, int deposit) {
		
		int i = 0;
		for(Bank temp : Day09_����������α׷�_1.accountlist) {
			if(temp != null && temp.getAno().equals(ano)) {
				Day09_����������α׷�_1.accountlist[i].setBalance(temp.getBalance()+ deposit);
				return true;
			} // if e
			i++;
		} // for e
		return false;
	} // �Ա� e
	
	// 3. ���
	public int ���(String ano, String password, int withdraw) {
		
		int i = 0;
		for(Bank temp : Day09_����������α׷�_1.accountlist) {
			if(temp != null && temp.getAno().equals(ano) && temp.getPassword().equals(password)) {
				if(temp.getBalance() < withdraw) {
					return 1; // �ܾ׺���
				} // if e
				else {
					Day09_����������α׷�_1.accountlist[i].setBalance(temp.getBalance()-withdraw);
					return 2; // ��� ����
				} // else e
			} // if e	
			i++;
		} // for e
		return 3; // ������ ���� �ƴҰ��
	} // ��� e
	
	// 4. ��ü
	public int ��ü(String ano, String password, int transfer, String transferano) {
		
		int i = 0; // ���� ����
		for(Bank temp : Day09_����������α׷�_1.accountlist) {
			if(temp != null && temp.getAno().equals(ano) && temp.getPassword().equals(password)) {
				
				int j = 0; // ��ü ���� ����
				for(Bank temp2 : Day09_����������α׷�_1.accountlist) {
					if(temp2 != null && temp2.getAno().equals(transferano)) {
						
						if(temp.getBalance()<transfer) {
							return 1; // �ܾ׺���
						} // if e
						else {
							Day09_����������α׷�_1.accountlist[i].setBalance(temp.getBalance()-transfer);
							Day09_����������α׷�_1.accountlist[j].setBalance(temp2.getBalance()+transfer);
							return 2; // ��ü����
						} // else e
					} // if e
					j++;
				} // for e
				return 3; // ��ü���� ���� ������ �������
			} // if e
			i++;
		} // for e
		return 4; // ���ΰ��� ������ �������
	} // ��ü e
	
	// 5. �� ���¸��
	// 6. ����
} // ce
