package com.aaa.cf;

import java.net.URL;

import org.cloudfoundry.client.lib.CloudCredentials;
import org.cloudfoundry.client.lib.CloudFoundryClient;
import org.cloudfoundry.client.lib.domain.CloudApplication;
import org.cloudfoundry.client.lib.domain.CloudService;
import org.cloudfoundry.client.lib.domain.CloudSpace;

public class JavaClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		 CloudCredentials credentials = new CloudCredentials("gladiator67@naver.com", "111111111111");
		 CloudFoundryClient client = new CloudFoundryClient(credentials, new URL("https://api.run.pivotal.io"));

		 client.login();

		 System.out.println("===================================================");
	     System.out.println("Cloud Foundry Spaces :");
		 for (CloudSpace space : client.getSpaces()) {
			 System.out.println("   Space 이름 : " + space.getName() + 
					 ", Space Organization : " + space.getOrganization().getName());
		 }

		 System.out.println("===================================================");
		 System.out.println("Applications :");
		 for (CloudApplication application : client.getApplications()) {
			 System.out.println("   이름 : " + application.getName());
			 System.out.println("   상태 : " + application.getState());
			 System.out.println("  URI : " + application.getUris());
  
			 System.out.println("  Application 내부 서비스 :");
			 for(String str : application.getServices()) {
				 System.out.println("\t" + str);
			 }
		 }
		 
		 System.out.println("===================================================");
		 System.out.println("Services :");
		 for (CloudService service : client.getServices()) {
			 System.out.println("   Service 이름 : " +  service.getName() + ", Service 라벨 : " + service.getLabel());
		 }

		 client.logout();
	}

}
