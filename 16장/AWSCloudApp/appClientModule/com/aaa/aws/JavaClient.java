package com.aaa.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.elasticbeanstalk.AWSElasticBeanstalk;
import com.amazonaws.services.elasticbeanstalk.AWSElasticBeanstalkClientBuilder;
import com.amazonaws.services.elasticbeanstalk.model.ApplicationDescription;
import com.amazonaws.services.elasticbeanstalk.model.DescribeApplicationsResult;
import com.amazonaws.services.elasticbeanstalk.model.DescribeEnvironmentsResult;
import com.amazonaws.services.elasticbeanstalk.model.EnvironmentDescription;
import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.AmazonRDSClientBuilder;
import com.amazonaws.services.rds.model.DBInstance;
import com.amazonaws.services.rds.model.DescribeDBInstancesResult;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

public class JavaClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AWSCredentials credentials = null;
			
		try {
			credentials = new ProfileCredentialsProvider().getCredentials();
		} catch (Exception e) {
			e.getMessage();
		}

		// AmazonEC2�� ���� Ŭ���̾�Ʈ�� �����Ѵ�.
		AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard()
	            .withCredentials(new AWSStaticCredentialsProvider(credentials))
	            .withRegion(Regions.AP_NORTHEAST_2)
	            .build();

		DescribeInstancesResult dir = ec2.describeInstances();
		for (Reservation resr : dir.getReservations()) {
			for (Instance inst : resr.getInstances()) {
				System.out.println("AWS EC2 �ν��Ͻ� �Ƹ� : " + inst.getTags().get(0));
				System.out.println("\t�ν��Ͻ� ID : " + inst.getInstanceId());
				System.out.println("\t�ν��Ͻ� Type : " + inst.getInstanceType());
				System.out.println("\t�ν��Ͻ� PublicDNS : " + inst.getPublicDnsName()); 
				System.out.println("\t�ν��Ͻ� Hypervisor :" + inst.getHypervisor());
				System.out.println("\t�ν��Ͻ� Ŷ�� : " + inst.getKeyName());
			}
		}
	        
		System.out.println("====================================================");
	    
		// Amazon S3�� ���� Ŭ���̾�Ʈ�� �����Ѵ�.
		AmazonS3 s3 = AmazonS3ClientBuilder.standard()
	            .withCredentials(new AWSStaticCredentialsProvider(credentials))
	            .withRegion(Regions.AP_NORTHEAST_2)
	            .build(); 
			         
		for (Bucket bucket : s3.listBuckets()) { 
			System.out.println("AWS S3 ����� �̸� : " + bucket.getName()); 
	        System.out.println("\tAWS S3 ������ : " + bucket.getOwner());
	        System.out.println("\tAWS S3 ������ : " + bucket.getCreationDate());
	     } 
	        
		System.out.println("====================================================");
	    
		// Amazon RDS�� ���� Ŭ���̾�Ʈ�� �����Ѵ�.
		AmazonRDS rds = AmazonRDSClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.AP_NORTHEAST_2)
				.build();
		
		DescribeDBInstancesResult dbir = rds.describeDBInstances();
		for (DBInstance dbi : dbir.getDBInstances()) {
			System.out.println("AWS RDS �����ͺ��̽� �̸� : " + dbi.getDBName());
	        System.out.println("\t�����ͺ��̽� ���� : " + dbi.getEngine());
	        System.out.println("\t�����ͺ��̽� ����� : " + dbi.getMasterUsername());
	        System.out.println("\t�����ͺ��̽� �ν��Ͻ� ���� : " + dbi.getDBInstanceStatus());
	        System.out.println("\t�����ͺ��̽� ���� URL : " + dbi.getEndpoint());
		}
	        
		System.out.println("====================================================");
	    
		// Amazon Elastic Beanstalk�� ���� Ŭ���̾�Ʈ�� �����Ѵ�.
		AWSElasticBeanstalk ebt = AWSElasticBeanstalkClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.AP_NORTHEAST_2)
				.build();
			        
		System.out.println("AWS ElasticBean : ");
		DescribeApplicationsResult dar =  ebt.describeApplications();
		for (ApplicationDescription ad : dar.getApplications()) {
			System.out.println("\tApplication �̸� : " + ad.getApplicationName() + ", �������� : " + ad.getDateCreated());
		}
	        
		DescribeEnvironmentsResult der =  ebt.describeEnvironments();
		for (EnvironmentDescription ed : der.getEnvironments()) {
			System.out.println("\tEnvironment �̸� : " + ed.getEnvironmentName() + ", ���� : " + ed.getStatus());
		}
	}

}
