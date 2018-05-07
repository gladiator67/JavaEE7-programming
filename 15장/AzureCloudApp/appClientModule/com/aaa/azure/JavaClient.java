package com.aaa.azure;

import java.io.File;
import java.util.List;

import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.compute.VirtualMachine;
import com.microsoft.azure.management.keyvault.Vault;
import com.microsoft.azure.management.network.NetworkInterface;
import com.microsoft.azure.management.network.PublicIPAddress;
import com.microsoft.azure.management.resources.Deployment;
import com.microsoft.azure.management.resources.ResourceGroup;
import com.microsoft.rest.LogLevel;

public class JavaClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        //=============================================================
        // Authenticate

        final File credFile = new File("C:\\azure\\sp-51ce3bcb-8025-4d4f-8a45-6de5721bde33_20180428180754.azureauth");
        
        Azure azure = Azure.configure()
        			.withLogLevel(LogLevel.BASIC)
				    .authenticate(credFile)
				    .withDefaultSubscription();

        //Print selected subscription
       System.out.println("Azure 구독 ID : " + azure.subscriptionId());
       
       System.out.println("===================================================");
       System.out.println("가상머신 관리");
       
       List<VirtualMachine> vmList = azure.virtualMachines().list();
       for(VirtualMachine vm : vmList) {
    	   System.out.println("   가상머신 컴퓨팅 이름 : " + vm.computerName() + ",\n   가상머신 이름 : " + vm.name()
    	   						+ " ,\n   가상머신 ID : " + vm.id() + ",\n  Region 이름 : " + vm.regionName() ); 
    	   System.out.println("\n");
       }
       
       System.out.println("===================================================");
       System.out.println("Azure 배포 관리");
       
       List<Deployment> deployList = azure.deployments().list();
       for(Deployment deploy : deployList) {
    	   System.out.println("   배포 이름 : " + deploy.name() + ",\n   배포 관리 상태 : "  + deploy.provisioningState()
    	   						+ ",\n   배포 출력물 : " + deploy.outputs());
    	   System.out.println("\n");
       }
       
       System.out.println("===================================================");
       System.out.println("네트워크 인터페이스 관리");
       
       List<NetworkInterface> netInterList = azure.networkInterfaces().list();
       for(NetworkInterface netI : netInterList) {
    	   System.out.println("   네트워크 인터페이스 이름 : " + netI.name() + ",\n   네트워크 인터페이스 지역 이름 : " + netI.regionName()
    	   						+ ",\n   네트워크 설정 : "+ netI.ipConfigurations());
    	   System.out.println("\n");
       }
       
       System.out.println("===================================================");
       System.out.println("공공 네트워크 관리");

       List<PublicIPAddress> pIPAddrList = azure.publicIPAddresses().list();
       for(PublicIPAddress pIp : pIPAddrList) {
    	   System.out.println("   공공 IP 주소 이름 : " + pIp.name() + ",\n   공공 IP 주소 : " + pIp.ipAddress() 
    	   						+ ",\n   공공 IP 주소의 리소스 그룹 명 : " + pIp.resourceGroupName());
    	   System.out.println("\n");
       }
       
       System.out.println("===================================================");
       System.out.println("보안 관리");
       
       
       List<Vault> vaultList = azure.vaults().listByResourceGroup("JOSEPHRESOURCEGROUP");
       for(Vault vault : vaultList) {
    	   System.out.println("   해당 보안 정책 이름 : " + vault.name() + ",\n  tenant ID : " + vault.tenantId() 
    	   						+ ",\n   보안 지역 이름 : " + vault.regionName() + ",\n   보안 키 : " + vault.key());
    	   System.out.println("\n");
       }
       
       System.out.println("===================================================");
       System.out.println("리소스 관리");
       
       
       List<ResourceGroup> rscList = azure.resourceGroups().list();
       for(ResourceGroup rsc : rscList) {
    	   System.out.println("   리소스 이름 : " + rsc.name() + ",\n  리소스 타입 : " + rsc.type() 
    	   						+ ",\n   리소스 관리 상태 : " + rsc.provisioningState() + ",\n   리소스 키 : " + rsc.key());
    	   System.out.println("\n");
       }
	}

}
