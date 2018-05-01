# centos repository를 base로 이용한다.
FROM centos:centos7 

#이미지를 생성한 사람의 정보를 표시한다.
MAINTAINER Joseph Hwang "gladitor67@naver.com"

# mariadb를 설치한다.
RUN yum install -y mariadb-server mariadb 
RUN mysql_install_db --user=mysql --ldata=/var/lib/mysql/ 
RUN sed -i '/\[mysqld\]/aport=3306' /etc/my.cnf 
# 한글이 표시되도록 character-set을 utf-8로 설정한다.
RUN sed -i '/\[mysqld\]/acharacter-set-server=utf8' /etc/my.cnf

# 테이블을 생성하기 위한 sql파일을 MariaDB 이미지에 포함시킨다.
ADD mariadb.sql /tmp/mariadb.sql

# mariadb를 생성할 스크립트 파일을 생성한다. 
RUN \ 
  echo "/usr/bin/mysqld_safe --basedir=/usr &" > /tmp/config && \ 
  echo "cat /var/log/mariadb/mariadb.log" >> /tmp/config && \ 
  echo "mysqladmin --silent --wait=30 ping || exit 1" >> /tmp/config && \ 
  echo "mysql -e 'CREATE DATABASE IF NOT EXISTS testdb;'" >> /tmp/config && \
  echo "mysql -e 'GRANT ALL PRIVILEGES ON *.* TO \"root\"@\"%\" IDENTIFIED BY \"passsword123\";'" >> /tmp/config && \ 
  echo "mysql -e 'FLUSH PRIVILEGES;'" >> /tmp/config && \
  echo "mysql -u root testdb < /tmp/mariadb.sql" >> /tmp/config && \
  bash /tmp/config && \ 
  rm -f /tmp/config 
 
# 저장 폴더를 이미지가 아닌 호스트에 지정한다.
VOLUME ["/var/lib/mysql"] 
 
# 명령이 실행될 폴더를 지정한다.
WORKDIR /data/mariadb 

# MariaDB의 port를 개방한다.
EXPOSE 3306 
 
CMD ["/usr/bin/mysqld_safe"]