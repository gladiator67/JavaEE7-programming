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
		System.out.println("클라이언트 Openshift의 API 버전 : " + client.getOpenShiftAPIVersion() + ", Openshift 서버의 상태 : " + client.getServerReadyStatus());
		
		
		System.out.println("\n========================Openshift Project====================================");
		IProject project = (IProject)client.getResourceFactory().stub(ResourceKind.PROJECT, "josephopenshiftproject");
		System.out.println("Openshift API 버전 : " + project.getApiVersion() 
				+", 프로젝트 namespace : " + project.getNamespace() + ", 프로젝트 이름 : " + project.getName());	
		
		
		System.out.println("\n========================Openshift Pods==============================");
		List<IPod> pods = client.list(ResourceKind.POD, "josephopenshiftproject");
		//IPod pod = (IPod) pods.stream().filter(p->p.getName().startsWith("docker-registry")).findFirst().orElse(null);
		for(IPod pod : pods) {
			System.out.println(pod.getName());
			System.out.println("Pod Host : " + pod.getHost() + ", Pod Namespace : " + pod.getNamespace() 
					+ " ,Pod 생성 시간 :" + pod.getCreationTimeStamp());
			System.out.println("Pod 상태 : " + pod.getStatus() + "\n" + pod.toJson());
		}
		
		System.out.println("\n========================Openshift Services==============================");
		List<IService> services = client.list(ResourceKind.SERVICE, "josephopenshiftproject");
		for(IService service : services) {
			System.out.println(service.getName());
			System.out.println("서비스 자원 버전 : " + service.getResourceVersion() + 
					", 서비스 종류 : " + service.getKind() + ", 서비스  포트 : " + service.getPort());
			System.out.println(service.toJson());
		}
		
		System.out.println("\n========================Openshift Builds==============================");
		List<IBuild> builds = client.list(ResourceKind.BUILD, "josephopenshiftproject");
		for(IBuild build : builds) {
			System.out.println(build.getName());
			System.out.println("빌드 Push 보안 : " + build.getPushSecret() + 
					", 빌드 전략 : " + build.getBuildStrategy() + ", 빌드 메세지 : " + build.getMessage());
			System.out.println(build.toJson());
		}
		
		System.out.println("\n========================Openshift Endpoints==============================");
		List<IEndpoints> endpoints = client.list(ResourceKind.ENDPOINTS, "josephopenshiftproject");
		for(IEndpoints endpoint : endpoints) {
			System.out.println("띁단의 이름과 Json 타입 속성 : " + endpoint.getName() + "\n" + endpoint.toJson());
		}
		
	}

}
