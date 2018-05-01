# jboss/Wildfly repository를 이용한다.
FROM jboss/wildfly

# 이미지를 생성한 사랍의 정보를 표시한다.
MAINTAINER Joseph Hwang "gladitor67@naver.com“

# WILDFLY_HOME과 WILDFLY_VERSION의 값을 지정한다.
ENV WILDFLY_VERSION 11.0.0.Final
ENV WILDFLY_HOME /opt/jboss/wildfly

# Wildfly를 내려받아 압축을 풀고 WILDFLY_HOME에 설치한다.
RUN cd $HOME \ 
    && curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.zip \ 
    && unzip wildfly-$WILDFLY_VERSION.zip \ 
    && mv $HOME/wildfly-$WILDFLY_VERSION $WILDFLY_HOME \ 
    && rm wildfly-$WILDFLY_VERSION.zip

# 설치된 Wildfly에 MariaDB와 연동할 폴더와 module.xml과 jdbc.jar 파일을 docker의 이미지에 포함시킨다.
RUN mkdir -p $WILDFLY_HOME/modules/system/layers/base/org/mariadb/main
ADD module.xml $WILDFLY_HOME/modules/system/layers/base/org/mariadb/main/
ADD mariadb-java-client-2.2.3.jar $WILDFLY_HOME/modules/system/layers/base/org/mariadb/main/
ADD standalone.xml $WILDFLY_HOME/standalone/configuration/

# 배포할 war 폴더와 deployed 파일을 Wildfly의 deployments 폴더에 포함시킨다.
ADD Test.war $WILDFLY_HOME/standalone/deployments/Test.war
ADD Test.war.deployed $WILDFLY_HOME/standalone/deployments/

# 저장 폴더를 이미지가 아닌 호스트에 지정한다.
VOLUME ["/var/lib/wildfly"] 

# 명령이 실행될 폴더를 지정한다.
WORKDIR /data/wildfly 

# Wildfly의 Port를 지정한다.
EXPOSE 8080

# Wildfly를 실행한다.
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]