package com.aaa.ejb3;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful(passivationCapable=false)   //  <== ①
public class CartBean implements ICartPort {
	
    String customerId;
    List<String> contents;

	@Override
	public void initialize(String personId) throws Exception {
	   // TODO Auto-generated method stub
	   if (personId == null) {
              throw new Exception("사용자 id을 입력해야 합니다.");
           } else {
              customerId = personId;
           } 
           contents = new ArrayList<>();
	}

	@Override
	public void addBook(String title) {
		// TODO Auto-generated method stub
		contents.add(title);
	}

	@Override
	public void removeBook(String title) throws Exception {
		// TODO Auto-generated method stub
		boolean result = contents.remove(title);
        if (result == false) {
            throw new Exception("\"" + title + " 이 cart에 없습니다.");
        }
	}

	@Override
	public List<String> getContents() {
		// TODO Auto-generated method stub
		return contents;
	}

	@Remove  // <== ②
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		contents = null;
	}
}
