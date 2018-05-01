package com.aaa.openshift;

import java.util.List;

import com.openshift.restclient.ClientBuilder;
import com.openshift.restclient.IClient;
import com.openshift.restclient.ResourceKind;
import com.openshift.restclient.api.models.IEndpoints;
import com.openshift.restclient.model.IBuild;
import com.openshift.restclient.model.IPod;
import com.openshift.restclient.model.IProject;
import com.openshift.restclient.model.IService;

public class JavaClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IClient client = new ClientBuilder("https://api.starter-us-west-1.openshift.com")
				.withUserName("gladiator67@naver.com")
				.withPassword("password123")
				.build();
		   client.getAuthorizationContext().setToken("L-Zaag97ve79aBvXfvv4DLx2AawcUOwcVbmm6Rd5BLI");
		System.out.println("=======================================================================");
		System.out.println("Ŭ���̾�Ʈ Openshift�� API ���� : " + client.getOpenShiftAPIVersion() + ", Openshift ������ ���� : " + client.getServerReadyStatus());
		
		
		System.out.println("\n========================Openshift Project====================================");
		IProject project = (IProject)client.getResourceFactory().stub(ResourceKind.PROJECT, "josephopenshiftproject");
		System.out.println("Openshift API ���� : " + project.getApiVersion() 
				+", ������Ʈ namespace : " + project.getNamespace() + ", ������Ʈ �̸� : " + project.getName());	
		
		
		System.out.println("\n========================Openshift Pods==============================");
		List<IPod> pods = client.list(ResourceKind.POD, "josephopenshiftproject");
		//IPod pod = (IPod) pods.stream().filter(p->p.getName().startsWith("docker-registry")).findFirst().orElse(null);
		for(IPod pod : pods) {
			System.out.println(pod.getName());
			System.out.println("Pod Host : " + pod.getHost() + ", Pod Namespace : " + pod.getNamespace() 
					+ " ,Pod ���� �ð� :" + pod.getCreationTimeStamp());
			System.out.println("Pod ���� : " + pod.getStatus() + "\n" + pod.toJson());
		}
		
		System.out.println("\n========================Openshift Services==============================");
		List<IService> services = client.list(ResourceKind.SERVICE, "josephopenshiftproject");
		for(IService service : services) {
			System.out.println(service.getName());
			System.out.println("���� �ڿ� ���� : " + service.getResourceVersion() + 
					", ���� ���� : " + service.getKind() + ", ����  ��Ʈ : " + service.getPort());
			System.out.println(service.toJson());
		}
		
		System.out.println("\n========================Openshift Builds==============================");
		List<IBuild> builds = client.list(ResourceKind.BUILD, "josephopenshiftproject");
		for(IBuild build : builds) {
			System.out.println(build.getName());
			System.out.println("���� Push ���� : " + build.getPushSecret() + 
					", ���� ���� : " + build.getBuildStrategy() + ", ���� �޼��� : " + build.getMessage());
			System.out.println(build.toJson());
		}
		
		System.out.println("\n========================Openshift Endpoints==============================");
		List<IEndpoints> endpoints = client.list(ResourceKind.ENDPOINTS, "josephopenshiftproject");
		for(IEndpoints endpoint : endpoints) {
			System.out.println("������ �̸��� Json Ÿ�� �Ӽ� : " + endpoint.getName() + "\n" + endpoint.toJson());
		}
		
	}

}
