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

	@PostLoad  //    ¨è
	public void alertPostLoad(Members m) {
	   System.out.println(m.getID() + ": post-loaded");
	}

	@PrePersist  //   ¨é
	public void alertPrePersist(Members m) {
		System.out.println(m.getID() + ": pre-persisted");
	}

	@PostPersist   //   ¨ê
	public void alertPostPersist(Members m) {
		System.out.println(m.getID() + ": post-persisted");
	}

	@PreUpdate   //    ¨ë
	public void alertPreUpdate(Members m) {
		System.out.println(m.getID() + ": pre-updated");
	}

	@PostUpdate   //    ¨ì
	public void alertPostUpdate(Members m) {
		System.out.println(m.getID() + ": post-updated");
	}

	@PreRemove   //    ¨í
	public void alertPreRemove(Members m) {
		System.out.println(m.getID() + ": pre-removed");
	}

	@PostRemove   //    ¨î
	public void alertPostRemove(Members m) {
		System.out.println(m.getID() + ": post-removed");
	}
	 
	@PostConstruct   //  ¨ï 
	public void alertPostConstruct(Members m) {
		System.out.println(m.getID() + ": post-constructed");
	}

	@PreDestroy   //   ¨ð
	public void alertPreDestroy(Members m) {
		System.out.println(m.getID() + ": pre-destroyed");
	}
}
