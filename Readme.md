# Spring study.
## 코드로 배우는 Spring Web Project.

## PULL ERROR
 - git 모두 동기화 했는데도 에러 -> git stash 이후 PULL.

## Window <> MAC 상호 동기화.
 - Ojdbc 경로 때문에, 매번 설정해야했음. <P></P>
 - .gitignore 에 .project 추가하여 설정 미반영 되게끔 조치하면 됨.

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

## ETC
 - CTRL + 클릭 : 따라가기

## Log4j UnderLine Error
 - pom.xml 에서 logj4 search 후 <Exclusions> , <Scrop> 삭제하면 활성화됨.

## TEST
 - <PRE><CODE> CODE TEST </CODE><PRE>
