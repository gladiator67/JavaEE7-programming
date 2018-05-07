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

        final File credFile = new File("C:\\Cloud_Backup\\azure\\sp-51ce3bcb-8052-4d4f-8a45-6de5551bde33_20180428180754.azureauth");
        
        Azure azure = Azure.configure()
        			.withLogLevel(LogLevel.BASIC)
				    .authenticate(credFile)
				    .withDefaultSubscription();

        //Print selected subscription
       System.out.println("Azure ���� ID : " + azure.subscriptionId());
       
       System.out.println("===================================================");
       System.out.println("����ӽ� ����");
       
       List<VirtualMachine> vmList = azure.virtualMachines().list();
       for(VirtualMachine vm : vmList) {
    	   System.out.println("   ����ӽ� ��ǻ�� �̸� : " + vm.computerName() + ",\n   ����ӽ� �̸� : " + vm.name()
    	   						+ " ,\n   ����ӽ� ID : " + vm.id() + ",\n  Region �̸� : " + vm.regionName() ); 
    	   System.out.println("\n");
       }
       
       System.out.println("===================================================");
       System.out.println("Azure ���� ����");
       
       List<Deployment> deployList = azure.deployments().list();
       for(Deployment deploy : deployList) {
    	   System.out.println("   ���� �̸� : " + deploy.name() + ",\n   ���� ���� ���� : "  + deploy.provisioningState()
    	   						+ ",\n   ���� ��¹� : " + deploy.outputs());
    	   System.out.println("\n");
       }
       
       System.out.println("===================================================");
       System.out.println("��Ʈ��ũ �������̽� ����");
       
       List<NetworkInterface> netInterList = azure.networkInterfaces().list();
       for(NetworkInterface netI : netInterList) {
    	   System.out.println("   ��Ʈ��ũ �������̽� �̸� : " + netI.name() + ",\n   ��Ʈ��ũ �������̽� ���� �̸� : " + netI.regionName()
    	   						+ ",\n   ��Ʈ��ũ ���� : "+ netI.ipConfigurations());
    	   System.out.println("\n");
       }
       
       System.out.println("===================================================");
       System.out.println("���� ��Ʈ��ũ ����");

       List<PublicIPAddress> pIPAddrList = azure.publicIPAddresses().list();
       for(PublicIPAddress pIp : pIPAddrList) {
    	   System.out.println("   ���� IP �ּ� �̸� : " + pIp.name() + ",\n   ���� IP �ּ� : " + pIp.ipAddress() 
    	   						+ ",\n   ���� IP �ּ��� ���ҽ� �׷� �� : " + pIp.resourceGroupName());
    	   System.out.println("\n");
       }
       
       System.out.println("===================================================");
       System.out.println("���� ����");
       
       
       List<Vault> vaultList = azure.vaults().listByResourceGroup("JOSEPHRESOURCEGROUP");
       for(Vault vault : vaultList) {
    	   System.out.println("   �ش� ���� ��å �̸� : " + vault.name() + ",\n  tenant ID : " + vault.tenantId() 
    	   						+ ",\n   ���� ���� �̸� : " + vault.regionName() + ",\n   ���� Ű : " + vault.key());
    	   System.out.println("\n");
       }
       
       System.out.println("===================================================");
       System.out.println("���ҽ� ����");
       
       
       List<ResourceGroup> rscList = azure.resourceGroups().list();
       for(ResourceGroup rsc : rscList) {
    	   System.out.println("   ���ҽ� �̸� : " + rsc.name() + ",\n  ���ҽ� Ÿ�� : " + rsc.type() 
    	   						+ ",\n   ���ҽ� ���� ���� : " + rsc.provisioningState() + ",\n   ���ҽ� Ű : " + rsc.key());
    	   System.out.println("\n");
       }
	}

}
