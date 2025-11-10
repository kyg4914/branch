package controller;

import java.util.ArrayList;

import model.PhoneDAO;
import model.PhoneVO;
import view.PhoneView;

public class PhoneController {

	public void run() {
	
		PhoneView view = new PhoneView();
		PhoneDAO dao = new PhoneDAO();

		while (true) {
			int choice = view.showMenu();

			if (choice == 1) {
				// 전화 번호 추가
				PhoneVO pvo = view.showAdd();
				
				int row= dao.insertPhoneNum(pvo);
				
				view.statusAddResult(row);

			} else if (choice == 2) {
				
				ArrayList<PhoneVO> list = dao.selectAll();
				//System.out.println("test: "+list.get(0).getName());
				
				view.statusAll(list);

			}else if(choice ==3) {
				//이름, 번호를 입력 받아서 삭제 
				PhoneVO pvo = view.showDelete();
				
				int row = dao.deleteNum(pvo);
				
				view.statusDelete(row);
				
			}
		}

	}

}
