# Spring study.
## 코드로 배우는 Spring Web Project.

## PULL ERROR
 - git 모두 동기화 했는데도 에러 -> git stash 이후 PULL.

## Window <> MAC 상호 동기화.
 - Ojdbc 경로 때문에, 매번 설정해야했음. <P></P>
 - .gitignore 에 .project 추가하여 설정 미반영 되게끔 조치하면 됨.
 - .gitignore 에 .classpath 추가하여 설정 미반영 되게끔 조치하면 됨. -> ojdbc 등 경로 갖고있음.

##  ORACLE on OSX
 - OSX에 ORACLE 설치 : DOCKER 이용. <BR></BR>
  1) DOCKER 설치.
  2) TERMINAL : DOCKER LOGIN
  3) TERMINAL : docker run --name oracle11g -d -p 9090:9090 -p 1521:1521 -v ~/my/oracle/data:/u01/app/oracle sath89/oracle-xe-11g
     (sath89 대신 jaspeen 가능)
  4) SQLPLUS EXEC : DOCKER EXEC -IT ORACLE11G SQLPLUS
  5) SQL-DEVELOPER 실행 후 확인.
 - ORACLE LOCALE ERROR : 환경설정, 지역 "타지역으로 바꿨다가" 다시 대한민국으로 설정.
 - ORACLE PORT CHECK QUERY : select dbms_xdb.gethttpport() from dual;
 - ORACLE PORT EXCHANGE QUERY(Tomcat port와 충돌) : exec dbms_xdb.sethttpport(변경할포트번호);

## PROJECT ERROR
 - 대부분 ERROR는 오타.
 - org.springframework.beans.factory.BeanCreationException: 
 Error creating bean with name 'dataSource' defined in ServletContext resource [/WEB-INF/spring/root-context.xml]
  : properties, Deploy Assembly 에서 ojdbc.jar 확인.
 - 404 에러, 1. Tomcat에러 안나는지 확인. 2. Board/list.jsp -> 에러. Board/list -> 성공. [이유 모름..]
 - 세팅 변경 시 에러 : deploy assembly 에서 ojdbc.jar 경로/maven jar 잘 잡혀있는지 확인 할 것. 
 - java.util.concurrent.ExecutionException: org.apache.catalina.LifecycleException
  : 서버 우클릭 후 clean 재 진행.
 - Tomcat encountered : netstat -a -o -n 확인 후 taskkill /F /PID PID넘버 죽임
   	                  : 서버 우클릭 후 clean 후 재 진행
 - 

## ETC
 - CTRL + 클릭 : 따라가기
 - Tomcat -> 각 환경 Load -> 사용자 URL호출 -> 해당 URL Mapping 되어있는 Controller 호출 -> View 호출

## Log4j UnderLine Error
 - pom.xml 에서 logj4 search 후 <Exclusions> , <Scrop> 삭제하면 활성화됨.
 
## .gitignore 파일 적용하기.
 -  git rm -r --cached .
	git add .
	git commit -m "Apply .gitignore"

## TEST
 - <PRE><CODE> CODE TEST </CODE><PRE>
