package com.aaa.ejb3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class Alarm {

	@PostLoad  //    ��
	public void alertPostLoad(Members m) {
	   System.out.println(m.getID() + ": post-loaded");
	}

	@PrePersist  //   ��
	public void alertPrePersist(Members m) {
		System.out.println(m.getID() + ": pre-persisted");
	}

	@PostPersist   //   ��
	public void alertPostPersist(Members m) {
		System.out.println(m.getID() + ": post-persisted");
	}

	@PreUpdate   //    ��
	public void alertPreUpdate(Members m) {
		System.out.println(m.getID() + ": pre-updated");
	}

	@PostUpdate   //    ��
	public void alertPostUpdate(Members m) {
		System.out.println(m.getID() + ": post-updated");
	}

	@PreRemove   //    ��
	public void alertPreRemove(Members m) {
		System.out.println(m.getID() + ": pre-removed");
	}

	@PostRemove   //    ��
	public void alertPostRemove(Members m) {
		System.out.println(m.getID() + ": post-removed");
	}
	 
	@PostConstruct   //  �� 
	public void alertPostConstruct(Members m) {
		System.out.println(m.getID() + ": post-constructed");
	}

	@PreDestroy   //   ��
	public void alertPreDestroy(Members m) {
		System.out.println(m.getID() + ": pre-destroyed");
	}
}
