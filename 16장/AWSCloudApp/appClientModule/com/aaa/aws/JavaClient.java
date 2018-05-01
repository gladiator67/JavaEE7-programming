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

		// AmazonEC2에 대한 클라이언트를 생성한다.
		AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard()
	            .withCredentials(new AWSStaticCredentialsProvider(credentials))
	            .withRegion(Regions.AP_NORTHEAST_2)
	            .build();

		DescribeInstancesResult dir = ec2.describeInstances();
		for (Reservation resr : dir.getReservations()) {
			for (Instance inst : resr.getInstances()) {
				System.out.println("AWS EC2 인스턴스 아름 : " + inst.getTags().get(0));
				System.out.println("\t인스턴스 ID : " + inst.getInstanceId());
				System.out.println("\t인스턴스 Type : " + inst.getInstanceType());
				System.out.println("\t인스턴스 PublicDNS : " + inst.getPublicDnsName()); 
				System.out.println("\t인스턴스 Hypervisor :" + inst.getHypervisor());
				System.out.println("\t인스턴스 킷값 : " + inst.getKeyName());
			}
		}
	        
		System.out.println("====================================================");
	    
		// Amazon S3에 대한 클라이언트를 생성한다.
		AmazonS3 s3 = AmazonS3ClientBuilder.standard()
	            .withCredentials(new AWSStaticCredentialsProvider(credentials))
	            .withRegion(Regions.AP_NORTHEAST_2)
	            .build(); 
			         
		for (Bucket bucket : s3.listBuckets()) { 
			System.out.println("AWS S3 저장소 이름 : " + bucket.getName()); 
	        System.out.println("\tAWS S3 소유자 : " + bucket.getOwner());
	        System.out.println("\tAWS S3 생성일 : " + bucket.getCreationDate());
	     } 
	        
		System.out.println("====================================================");
	    
		// Amazon RDS에 대한 클라이언트를 생성한다.
		AmazonRDS rds = AmazonRDSClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.AP_NORTHEAST_2)
				.build();
		
		DescribeDBInstancesResult dbir = rds.describeDBInstances();
		for (DBInstance dbi : dbir.getDBInstances()) {
			System.out.println("AWS RDS 데이터베이스 이름 : " + dbi.getDBName());
	        System.out.println("\t데이터베이스 엔진 : " + dbi.getEngine());
	        System.out.println("\t데이터베이스 사용자 : " + dbi.getMasterUsername());
	        System.out.println("\t데이터베이스 인스턴스 상태 : " + dbi.getDBInstanceStatus());
	        System.out.println("\t데이터베이스 끝단 URL : " + dbi.getEndpoint());
		}
	        
		System.out.println("====================================================");
	    
		// Amazon Elastic Beanstalk에 대한 클라이언트를 생성한다.
		AWSElasticBeanstalk ebt = AWSElasticBeanstalkClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.AP_NORTHEAST_2)
				.build();
			        
		System.out.println("AWS ElasticBean : ");
		DescribeApplicationsResult dar =  ebt.describeApplications();
		for (ApplicationDescription ad : dar.getApplications()) {
			System.out.println("\tApplication 이름 : " + ad.getApplicationName() + ", 생성일자 : " + ad.getDateCreated());
		}
	        
		DescribeEnvironmentsResult der =  ebt.describeEnvironments();
		for (EnvironmentDescription ed : der.getEnvironments()) {
			System.out.println("\tEnvironment 이름 : " + ed.getEnvironmentName() + ", 상태 : " + ed.getStatus());
		}
	}

}
