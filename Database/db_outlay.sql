# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     db_outlay
# Server version:               5.0.51b-community-nt
# Server OS:                    Win32
# Target compatibility:         ANSI SQL
# HeidiSQL version:             4.0
# Date/time:                    2018-11-19 22:35:55
# --------------------------------------------------------

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ANSI,NO_BACKSLASH_ESCAPES';*/
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;*/


#
# Database structure for database 'db_outlay'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ "db_outlay" /*!40100 DEFAULT CHARACTER SET latin1 */;

USE "db_outlay";


#
# Table structure for table 'tbl_admin'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_admin" (
  "admin_id" int(11) NOT NULL auto_increment,
  "admin_username" varchar(50) NOT NULL,
  "admin_pswd" varchar(50) NOT NULL,
  "admin_email" varchar(50) NOT NULL,
  PRIMARY KEY  ("admin_id")
) AUTO_INCREMENT=2;



#
# Dumping data for table 'tbl_admin'
#

LOCK TABLES "tbl_admin" WRITE;
/*!40000 ALTER TABLE "tbl_admin" DISABLE KEYS;*/
REPLACE INTO "tbl_admin" ("admin_id", "admin_username", "admin_pswd", "admin_email") VALUES
	(1,'Admin','Admin_1037','sreelakshmishaji101@gmail.com');
/*!40000 ALTER TABLE "tbl_admin" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_bank'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_bank" (
  "bank_id" int(11) NOT NULL auto_increment,
  "bank_name" varchar(50) NOT NULL,
  "place_id" int(11) NOT NULL,
  "bank_phn" varchar(50) NOT NULL,
  "bank_email" varchar(50) NOT NULL,
  "bank_link" varchar(50) NOT NULL,
  "bank_discrptn" varchar(50) NOT NULL,
  PRIMARY KEY  ("bank_id")
) AUTO_INCREMENT=9;



#
# Dumping data for table 'tbl_bank'
#

LOCK TABLES "tbl_bank" WRITE;
/*!40000 ALTER TABLE "tbl_bank" DISABLE KEYS;*/
REPLACE INTO "tbl_bank" ("bank_id", "bank_name", "place_id", "bank_phn", "bank_email", "bank_link", "bank_discrptn") VALUES
	(5,' State Bank of India   ',6,'0486 234546','sbi.08652@sbi.co.in  ','https://www.sbi.co.in','Located in Aramana complex');
REPLACE INTO "tbl_bank" ("bank_id", "bank_name", "place_id", "bank_phn", "bank_email", "bank_link", "bank_discrptn") VALUES
	(6,' sib ',5,'9667854322',' sib@gmail.com ','http://hksjkdjkjjsduik','near nss building');
REPLACE INTO "tbl_bank" ("bank_id", "bank_name", "place_id", "bank_phn", "bank_email", "bank_link", "bank_discrptn") VALUES
	(7,' Federal Bank',19,'9876789654',' federal@gmail.com','https://federalloans.in','nss archade');
REPLACE INTO "tbl_bank" ("bank_id", "bank_name", "place_id", "bank_phn", "bank_email", "bank_link", "bank_discrptn") VALUES
	(8,' South Indian Bank',21,'6754321112',' southindian@gmail.com','https://southlloans.in','church jnctg');
/*!40000 ALTER TABLE "tbl_bank" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_budget'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_budget" (
  "budget_id" int(11) NOT NULL auto_increment,
  "budget_amt" int(11) NOT NULL,
  "person_id" int(11) NOT NULL,
  PRIMARY KEY  ("budget_id")
) AUTO_INCREMENT=26;



#
# Dumping data for table 'tbl_budget'
#

LOCK TABLES "tbl_budget" WRITE;
/*!40000 ALTER TABLE "tbl_budget" DISABLE KEYS;*/
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(1,12998,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(3,9792,17);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(4,7542,17);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(5,12269,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(6,11942,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(7,12779,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(8,8774,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(9,13871,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(10,10850,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(11,11796,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(12,6971,51);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(13,4738,51);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(14,11796,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(15,11905,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(16,12670,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(17,12670,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(18,11869,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(19,19442,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(20,10485,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(21,10049,16);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(22,30874,48);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(23,0,48);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(24,753,17);
REPLACE INTO "tbl_budget" ("budget_id", "budget_amt", "person_id") VALUES
	(25,9407,16);
/*!40000 ALTER TABLE "tbl_budget" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_company'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_company" (
  "company_id" int(50) NOT NULL auto_increment,
  "company_name" varchar(50) NOT NULL,
  "place_id" int(11) NOT NULL,
  "company_phn" varchar(50) NOT NULL,
  "company_mail" varchar(50) NOT NULL,
  "company_url" varchar(50) NOT NULL,
  "company_loc" varchar(50) NOT NULL,
  PRIMARY KEY  ("company_id")
) AUTO_INCREMENT=4;



#
# Dumping data for table 'tbl_company'
#

LOCK TABLES "tbl_company" WRITE;
/*!40000 ALTER TABLE "tbl_company" DISABLE KEYS;*/
REPLACE INTO "tbl_company" ("company_id", "company_name", "place_id", "company_phn", "company_mail", "company_url", "company_loc") VALUES
	(2,' LIC',6,'0485 223754',' lic@rediff.com','http://licmuvattupuzha','Madasseri building
P.O junction');
REPLACE INTO "tbl_company" ("company_id", "company_name", "place_id", "company_phn", "company_mail", "company_url", "company_loc") VALUES
	(3,'LIC',6,'56778954322','lic@rediff.com','http://licmuvattupuzha','vghn nj');
/*!40000 ALTER TABLE "tbl_company" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_debitcard'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_debitcard" (
  "card_id" int(10) unsigned NOT NULL auto_increment,
  "card_no" varchar(50) default NULL,
  "card_month" int(10) unsigned default NULL,
  "card_year" int(10) unsigned default NULL,
  "person_id" int(10) unsigned default NULL,
  PRIMARY KEY  ("card_id")
) AUTO_INCREMENT=4;



#
# Dumping data for table 'tbl_debitcard'
#

LOCK TABLES "tbl_debitcard" WRITE;
/*!40000 ALTER TABLE "tbl_debitcard" DISABLE KEYS;*/
REPLACE INTO "tbl_debitcard" ("card_id", "card_no", "card_month", "card_year", "person_id") VALUES
	('2','1234567891213456','4','24','16');
REPLACE INTO "tbl_debitcard" ("card_id", "card_no", "card_month", "card_year", "person_id") VALUES
	('3','9087654321654321','2','25','48');
/*!40000 ALTER TABLE "tbl_debitcard" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_dist'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_dist" (
  "dist_id" int(11) NOT NULL auto_increment,
  "dist_name" varchar(50) NOT NULL,
  "state_id" int(11) NOT NULL,
  PRIMARY KEY  ("dist_id")
) AUTO_INCREMENT=25;



#
# Dumping data for table 'tbl_dist'
#

LOCK TABLES "tbl_dist" WRITE;
/*!40000 ALTER TABLE "tbl_dist" DISABLE KEYS;*/
REPLACE INTO "tbl_dist" ("dist_id", "dist_name", "state_id") VALUES
	(1,'Ernakulam',1);
REPLACE INTO "tbl_dist" ("dist_id", "dist_name", "state_id") VALUES
	(2,'Kottayam',1);
REPLACE INTO "tbl_dist" ("dist_id", "dist_name", "state_id") VALUES
	(3,'Kollam',1);
REPLACE INTO "tbl_dist" ("dist_id", "dist_name", "state_id") VALUES
	(6,'Palakad',1);
REPLACE INTO "tbl_dist" ("dist_id", "dist_name", "state_id") VALUES
	(9,'Thiruvananthapuram',1);
REPLACE INTO "tbl_dist" ("dist_id", "dist_name", "state_id") VALUES
	(24,'Pathanamthitta',1);
/*!40000 ALTER TABLE "tbl_dist" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_electricitybill'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_electricitybill" (
  "ebill_id" int(10) unsigned NOT NULL auto_increment,
  "ebill_amount" varchar(50) default NULL,
  "ebill_duedate" varchar(50) default NULL,
  "ebill_status" int(10) unsigned default '0',
  "ebill_no" varchar(50) default NULL,
  "ebill_serviceno" varchar(50) default NULL,
  "person_id" int(11) NOT NULL,
  PRIMARY KEY  ("ebill_id")
) AUTO_INCREMENT=6;



#
# Dumping data for table 'tbl_electricitybill'
#

LOCK TABLES "tbl_electricitybill" WRITE;
/*!40000 ALTER TABLE "tbl_electricitybill" DISABLE KEYS;*/
REPLACE INTO "tbl_electricitybill" ("ebill_id", "ebill_amount", "ebill_duedate", "ebill_status", "ebill_no", "ebill_serviceno", "person_id") VALUES
	('1','1000','16-11-2018','1','KSEB1011','1234512345',16);
REPLACE INTO "tbl_electricitybill" ("ebill_id", "ebill_amount", "ebill_duedate", "ebill_status", "ebill_no", "ebill_serviceno", "person_id") VALUES
	('2','500','30-11-2018','0','KSEB1012','12312312345',48);
REPLACE INTO "tbl_electricitybill" ("ebill_id", "ebill_amount", "ebill_duedate", "ebill_status", "ebill_no", "ebill_serviceno", "person_id") VALUES
	('3','650','19-8-2018','0','KSEB1013','121212121212',50);
REPLACE INTO "tbl_electricitybill" ("ebill_id", "ebill_amount", "ebill_duedate", "ebill_status", "ebill_no", "ebill_serviceno", "person_id") VALUES
	('4','1500','30-10-2018','1','KSEB1014','1111122222',17);
REPLACE INTO "tbl_electricitybill" ("ebill_id", "ebill_amount", "ebill_duedate", "ebill_status", "ebill_no", "ebill_serviceno", "person_id") VALUES
	('5','550','30-11-2018','1','KSEB1016','3333333333',22);
/*!40000 ALTER TABLE "tbl_electricitybill" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_expenses'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_expenses" (
  "expense_id" int(11) NOT NULL auto_increment,
  "expense_date" varchar(50) NOT NULL,
  "expense_amt" float NOT NULL,
  "person_id" int(11) NOT NULL,
  "extype_id" int(11) NOT NULL,
  PRIMARY KEY  ("expense_id")
) AUTO_INCREMENT=66;



#
# Dumping data for table 'tbl_expenses'
#

LOCK TABLES "tbl_expenses" WRITE;
/*!40000 ALTER TABLE "tbl_expenses" DISABLE KEYS;*/
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(1,'2018-10-11','1000',16,5);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(2,'2018-10-11','500',48,5);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(3,'30/10/2018','300',16,6);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(4,'2018-9-27','170',16,2);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(5,'2018-9-27','300',16,6);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(6,'2018-10-13','1000',16,5);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(9,'2018-10-13','1500',17,5);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(10,'2018-10-18','1000',48,2);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(11,'2018-10-18','1000',48,2);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(12,'2018-10-16','1000',17,10);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(14,'17-Sep-18','768',16,13);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(15,'17-Sep-18','767.7',16,13);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(16,'Tue Oct 23 15:33:21 GMT+05:30 2018','210',16,14);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(17,'2018-10-23','210',16,14);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(18,'2018-10-23','210',16,14);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(19,'2018-05-05','5000',16,15);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(20,'2018-10-23','210',16,14);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(21,'2019-03-13,at,20:04','1000',16,16);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(22,'2018-10-30','1000',16,5);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(23,'2018-10-31','1000',53,9);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(24,'2018-1-3','500',53,2);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(25,'2018-1-10','100',53,6);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(26,'2018-1-18','200',53,7);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(27,'2018-1-25','2000',53,10);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(28,'2018-2-15','2000',53,2);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(29,'2018-2-23','2000',53,10);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(30,'2018-2-14','700',53,8);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(31,'2018-11-07','210',16,17);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(32,'22/10/18','1500',16,17);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(33,'22/10/18','1500',16,18);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(36,'11/10/18','1000',16,17);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(44,'2018-11-07','500',16,23);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(45,'2018-11-13','550',22,5);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(46,'2018-11-13','550',22,5);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(47,'2018-11-13','0',16,5);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(48,'2018-11-18','1000',16,5);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(49,'2018-1-11','1000',16,2);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(50,'2018-1-17','3000',16,10);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(51,'2018-2-15','3000',16,10);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(52,'2018-2-16','500',16,6);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(53,'2018-2-21','250',16,7);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(54,'2018-3-22','250',16,7);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(56,'2019-03-13','1000',16,24);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(58,'2019-11-17','1000',16,16);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(59,'2019-11-16','300',16,25);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(60,'2018-11-8','250',16,26);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(61,'2018-11-18','150',16,27);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(62,'2018-11-8','250',16,28);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(63,'2019-11-19','300',16,25);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(64,'2018-11-19','250',16,28);
REPLACE INTO "tbl_expenses" ("expense_id", "expense_date", "expense_amt", "person_id", "extype_id") VALUES
	(65,'2018-11-17','850',16,29);
/*!40000 ALTER TABLE "tbl_expenses" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_extype'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_extype" (
  "extype_id" int(50) NOT NULL auto_increment,
  "extype_name" varchar(250) NOT NULL,
  PRIMARY KEY  ("extype_id")
) AUTO_INCREMENT=30;



#
# Dumping data for table 'tbl_extype'
#

LOCK TABLES "tbl_extype" WRITE;
/*!40000 ALTER TABLE "tbl_extype" DISABLE KEYS;*/
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(2,'Food Expense');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(5,'Electricity Bill');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(6,'Travel Expense');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(7,'Dish TV Bill');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(8,'Mobile Recharge');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(9,'Others');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(10,'Chits');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(13,'IIT GATE ');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(14,'DTH IHH ');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(15,'FLIPCART ');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(16,'AMAZON ');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(18,'CAN ATM ');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(21,'City:Muvattupuzha');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(23,'Revathy collections');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(24,'SNAP DEAL ');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(25,'CRAFT VILLA ');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(26,'Book stall');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(27,'college fee');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(28,'silvina collections');
REPLACE INTO "tbl_extype" ("extype_id", "extype_name") VALUES
	(29,'City:Temple - Mangalathuthazham Rd, Koothattukulam, Kerala 686662, IndiaKoothattukulam');
/*!40000 ALTER TABLE "tbl_extype" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_income'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_income" (
  "income_id" int(11) NOT NULL auto_increment,
  "intype_id" int(50) NOT NULL,
  "income_date" varchar(50) NOT NULL,
  "income_amt" varchar(15) NOT NULL,
  "person_id" int(11) NOT NULL,
  PRIMARY KEY  ("income_id")
) AUTO_INCREMENT=34;



#
# Dumping data for table 'tbl_income'
#

LOCK TABLES "tbl_income" WRITE;
/*!40000 ALTER TABLE "tbl_income" DISABLE KEYS;*/
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(11,1,'1/81/2018','20000',16);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(12,2,'5/81/2018','2500',16);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(13,1,'1/91/2018','30000',48);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(14,4,'18/91/2018','10000',48);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(15,1,'2018-9-1','15000',17);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(16,2,'2018-9-4','300',17);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(17,3,'2018-9-20','500',17);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(18,1,'2018-9-30','12000',51);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(19,4,'2018-10-21','20000',48);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(20,1,'2018-10-10','20000',17);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(21,1,'2018-10-30','25000',53);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(22,1,'2018-1-1','25000',53);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(23,1,'2018-2-2','2500',53);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(24,5,'2018-2-2','5000',53);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(25,1,'2018-3-2','25000',53);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(26,1,'2018-4-5','25000',53);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(27,4,'2018-4-26','2500',53);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(28,1,'2018-5-1','25000',53);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(29,1,'2018-1-3','25000',16);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(30,1,'2018-2-1','2500',16);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(31,1,'2018-3-3','25000',16);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(32,2,'2018-3-8','1200',16);
REPLACE INTO "tbl_income" ("income_id", "intype_id", "income_date", "income_amt", "person_id") VALUES
	(33,1,'2018-11-2','25000',16);
/*!40000 ALTER TABLE "tbl_income" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_insurance'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_insurance" (
  "insurance_id" int(11) NOT NULL auto_increment,
  "insurance_name" varchar(50) NOT NULL,
  "insurance_amount" int(11) NOT NULL,
  "insurance_intrest" varchar(50) NOT NULL,
  "insurance_dis" varchar(50) NOT NULL,
  "insurance_duration" varchar(50) NOT NULL,
  "instype_id" int(11) NOT NULL,
  "company_id" int(11) NOT NULL,
  PRIMARY KEY  ("insurance_id")
) AUTO_INCREMENT=4;



#
# Dumping data for table 'tbl_insurance'
#

LOCK TABLES "tbl_insurance" WRITE;
/*!40000 ALTER TABLE "tbl_insurance" DISABLE KEYS;*/
REPLACE INTO "tbl_insurance" ("insurance_id", "insurance_name", "insurance_amount", "insurance_intrest", "insurance_dis", "insurance_duration", "instype_id", "company_id") VALUES
	(3,'gggg',50000,'5%','ghjjj','5',1,2);
/*!40000 ALTER TABLE "tbl_insurance" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_insurancetype'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_insurancetype" (
  "instype_id" int(11) NOT NULL auto_increment,
  "instype_name" varchar(50) NOT NULL,
  PRIMARY KEY  ("instype_id")
) AUTO_INCREMENT=4;



#
# Dumping data for table 'tbl_insurancetype'
#

LOCK TABLES "tbl_insurancetype" WRITE;
/*!40000 ALTER TABLE "tbl_insurancetype" DISABLE KEYS;*/
REPLACE INTO "tbl_insurancetype" ("instype_id", "instype_name") VALUES
	(1,'Medical Insurance');
REPLACE INTO "tbl_insurancetype" ("instype_id", "instype_name") VALUES
	(3,'Health Insurance');
/*!40000 ALTER TABLE "tbl_insurancetype" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_intype'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_intype" (
  "intype_id" int(11) NOT NULL auto_increment,
  "intype_name" varchar(50) NOT NULL,
  PRIMARY KEY  ("intype_id")
) AUTO_INCREMENT=7;



#
# Dumping data for table 'tbl_intype'
#

LOCK TABLES "tbl_intype" WRITE;
/*!40000 ALTER TABLE "tbl_intype" DISABLE KEYS;*/
REPLACE INTO "tbl_intype" ("intype_id", "intype_name") VALUES
	(1,'Salary');
REPLACE INTO "tbl_intype" ("intype_id", "intype_name") VALUES
	(2,'Pocket Money');
REPLACE INTO "tbl_intype" ("intype_id", "intype_name") VALUES
	(3,'Others');
REPLACE INTO "tbl_intype" ("intype_id", "intype_name") VALUES
	(4,'Household incomes');
REPLACE INTO "tbl_intype" ("intype_id", "intype_name") VALUES
	(5,'Agricultural income');
/*!40000 ALTER TABLE "tbl_intype" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_loan'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_loan" (
  "loan_id" int(11) NOT NULL auto_increment,
  "loantype_id" int(11) NOT NULL,
  "loan_name" varchar(50) NOT NULL,
  "loan_intrest" varchar(50) NOT NULL,
  "loan_dis" varchar(50) NOT NULL,
  "loan_duration" int(11) NOT NULL,
  "loan_amount" int(11) NOT NULL,
  "bank_id" int(11) NOT NULL,
  PRIMARY KEY  ("loan_id")
) AUTO_INCREMENT=8;



#
# Dumping data for table 'tbl_loan'
#

LOCK TABLES "tbl_loan" WRITE;
/*!40000 ALTER TABLE "tbl_loan" DISABLE KEYS;*/
REPLACE INTO "tbl_loan" ("loan_id", "loantype_id", "loan_name", "loan_intrest", "loan_dis", "loan_duration", "loan_amount", "bank_id") VALUES
	(2,3,'Home ','15%','Available',3,1000000,5);
REPLACE INTO "tbl_loan" ("loan_id", "loantype_id", "loan_name", "loan_intrest", "loan_dis", "loan_duration", "loan_amount", "bank_id") VALUES
	(3,3,'Home','20%','dfgkjj',2,40000,7);
REPLACE INTO "tbl_loan" ("loan_id", "loantype_id", "loan_name", "loan_intrest", "loan_dis", "loan_duration", "loan_amount", "bank_id") VALUES
	(4,3,'Home','15%','hhhjjjj',2,50000,7);
REPLACE INTO "tbl_loan" ("loan_id", "loantype_id", "loan_name", "loan_intrest", "loan_dis", "loan_duration", "loan_amount", "bank_id") VALUES
	(5,4,'vehicle','19%','djg',3,60000,7);
REPLACE INTO "tbl_loan" ("loan_id", "loantype_id", "loan_name", "loan_intrest", "loan_dis", "loan_duration", "loan_amount", "bank_id") VALUES
	(6,4,'vehicle','30%','zdfsdg',4,90000,8);
REPLACE INTO "tbl_loan" ("loan_id", "loantype_id", "loan_name", "loan_intrest", "loan_dis", "loan_duration", "loan_amount", "bank_id") VALUES
	(7,3,'Home','35%','ddff',4,200000,8);
/*!40000 ALTER TABLE "tbl_loan" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_loantype'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_loantype" (
  "loantype_id" int(50) NOT NULL auto_increment,
  "loantype_name" varchar(50) NOT NULL,
  PRIMARY KEY  ("loantype_id")
) AUTO_INCREMENT=5;



#
# Dumping data for table 'tbl_loantype'
#

LOCK TABLES "tbl_loantype" WRITE;
/*!40000 ALTER TABLE "tbl_loantype" DISABLE KEYS;*/
REPLACE INTO "tbl_loantype" ("loantype_id", "loantype_name") VALUES
	(3,'Home Loan');
REPLACE INTO "tbl_loantype" ("loantype_id", "loantype_name") VALUES
	(4,'vehicle loan');
/*!40000 ALTER TABLE "tbl_loantype" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_notify'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_notify" (
  "notify_id" int(11) NOT NULL auto_increment,
  "notify_name" varchar(500) NOT NULL,
  "person_id" int(11) NOT NULL,
  "notify_date" varchar(50) NOT NULL,
  PRIMARY KEY  ("notify_id")
) AUTO_INCREMENT=63;



#
# Dumping data for table 'tbl_notify'
#

LOCK TABLES "tbl_notify" WRITE;
/*!40000 ALTER TABLE "tbl_notify" DISABLE KEYS;*/
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(1,'You have crossed your budject line.Be carefull.For more details check review.',17,'2018-10-22');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(2,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-10-30');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(3,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(4,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(5,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(6,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(7,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(8,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(9,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(10,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(11,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(12,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(13,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(14,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(15,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(16,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(17,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(18,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(19,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(20,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(21,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(22,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(23,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(24,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(25,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(26,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(27,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(28,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(29,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(30,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(31,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(32,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(33,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(34,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-07');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(35,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-10');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(36,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-10');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(37,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-10');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(38,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-10');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(39,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-10');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(40,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-10');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(41,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-10');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(42,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-10');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(43,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-12');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(44,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-12');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(45,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-12');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(46,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-12');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(47,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-12');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(48,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-18');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(49,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-18');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(50,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-18');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(51,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-18');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(52,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-18');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(53,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-18');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(54,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-18');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(55,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-18');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(56,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-18');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(57,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-18');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(58,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-19');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(59,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-19');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(60,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-19');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(61,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-19');
REPLACE INTO "tbl_notify" ("notify_id", "notify_name", "person_id", "notify_date") VALUES
	(62,'You have crossed your budject line.Be carefull.For more details check review.',16,'2018-11-19');
/*!40000 ALTER TABLE "tbl_notify" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_person'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_person" (
  "person_id" int(11) NOT NULL auto_increment,
  "person_name" varchar(50) NOT NULL,
  "person_gender" varchar(50) NOT NULL,
  "person_email" varchar(50) NOT NULL,
  "person_phn" varchar(50) NOT NULL,
  "person_hname" varchar(50) NOT NULL,
  "person_username" varchar(50) NOT NULL,
  "person_pswd" varchar(11) NOT NULL,
  "sync_id" int(11) NOT NULL default '0',
  PRIMARY KEY  ("person_id")
) AUTO_INCREMENT=58;



#
# Dumping data for table 'tbl_person'
#

LOCK TABLES "tbl_person" WRITE;
/*!40000 ALTER TABLE "tbl_person" DISABLE KEYS;*/
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(16,'sreelakshmii','female','sree@gmail.com','9887698678','Annappilly','sree123','1234',0);
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(17,'Mariya','Female','mariya@gmail.com','9887654566','kolloth','mariya','mariya1',0);
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(22,'Fousiya','Female','fousiyaka@gmail.com','9886543211','Kallinikattil','fousi15','fousi',0);
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(41,'Athira','Female','athi@gmail.com','9234567123','athihouse','athi','ath',0);
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(45,'Arathi','Female','arathi@gmail.com','9465870914','aryanivas','aa','12',0);
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(48,'Emiya','Female','emiya@gmail.com','9485800981','varanattill','emiya','emi',0);
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(49,'anu','Female','anu@gmail.com','9874569877','anuhouse','anu','an',0);
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(51,'Anna','Female','anna@gmail.com','9874560255','Annhouse','Ann','ann123',0);
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(52,'Aloke Sharma','Male','aloke@redif.com','9876543210','Sharma recidency','aloke','mealoke',0);
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(53,'Anupam','Male','anupam@gmail.com','9874578968','anupam nivas','anupam','anup',0);
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(55,'hima','Female','hima@gmail.com','9475817807','hinahoude','hina','hina',0);
REPLACE INTO "tbl_person" ("person_id", "person_name", "person_gender", "person_email", "person_phn", "person_hname", "person_username", "person_pswd", "sync_id") VALUES
	(57,'ann paul','Female','ann@gmail.com','9874563255','ann housr','ann','ann1',0);
/*!40000 ALTER TABLE "tbl_person" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_place'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_place" (
  "place_id" int(11) NOT NULL auto_increment,
  "place_name" varchar(50) NOT NULL,
  "place_pin" int(11) NOT NULL,
  "dist_id" int(11) NOT NULL,
  PRIMARY KEY  ("place_id")
) AUTO_INCREMENT=22;



#
# Dumping data for table 'tbl_place'
#

LOCK TABLES "tbl_place" WRITE;
/*!40000 ALTER TABLE "tbl_place" DISABLE KEYS;*/
REPLACE INTO "tbl_place" ("place_id", "place_name", "place_pin", "dist_id") VALUES
	(3,'Muvattupuzha',1,686673);
REPLACE INTO "tbl_place" ("place_id", "place_name", "place_pin", "dist_id") VALUES
	(5,'Puthuvely',686636,2);
REPLACE INTO "tbl_place" ("place_id", "place_name", "place_pin", "dist_id") VALUES
	(6,'Muvattupuzha',686673,1);
REPLACE INTO "tbl_place" ("place_id", "place_name", "place_pin", "dist_id") VALUES
	(15,'Sasthamkotta',690521,3);
REPLACE INTO "tbl_place" ("place_id", "place_name", "place_pin", "dist_id") VALUES
	(16,'Kothamangalam',686691,1);
REPLACE INTO "tbl_place" ("place_id", "place_name", "place_pin", "dist_id") VALUES
	(17,'Perumbavoor',683542,1);
REPLACE INTO "tbl_place" ("place_id", "place_name", "place_pin", "dist_id") VALUES
	(18,'Vazhakulam',686670,1);
REPLACE INTO "tbl_place" ("place_id", "place_name", "place_pin", "dist_id") VALUES
	(19,'Koothattukulam',686662,1);
REPLACE INTO "tbl_place" ("place_id", "place_name", "place_pin", "dist_id") VALUES
	(20,'Pala',686575,2);
REPLACE INTO "tbl_place" ("place_id", "place_name", "place_pin", "dist_id") VALUES
	(21,'Ramapuram',686576,2);
/*!40000 ALTER TABLE "tbl_place" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_recharge'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_recharge" (
  "recharge_id" int(11) NOT NULL auto_increment,
  "recharge_no" varchar(50) NOT NULL,
  "recharge_amt" int(50) NOT NULL,
  PRIMARY KEY  ("recharge_id")
) AUTO_INCREMENT=4;



#
# Dumping data for table 'tbl_recharge'
#

LOCK TABLES "tbl_recharge" WRITE;
/*!40000 ALTER TABLE "tbl_recharge" DISABLE KEYS;*/
REPLACE INTO "tbl_recharge" ("recharge_id", "recharge_no", "recharge_amt") VALUES
	(1,'584745888',100);
REPLACE INTO "tbl_recharge" ("recharge_id", "recharge_no", "recharge_amt") VALUES
	(2,'25369770555',25);
REPLACE INTO "tbl_recharge" ("recharge_id", "recharge_no", "recharge_amt") VALUES
	(3,'7859665585',17);
/*!40000 ALTER TABLE "tbl_recharge" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_state'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_state" (
  "state_id" int(50) NOT NULL auto_increment,
  "state_name" varchar(50) NOT NULL,
  PRIMARY KEY  ("state_id")
) AUTO_INCREMENT=78;



#
# Dumping data for table 'tbl_state'
#

LOCK TABLES "tbl_state" WRITE;
/*!40000 ALTER TABLE "tbl_state" DISABLE KEYS;*/
REPLACE INTO "tbl_state" ("state_id", "state_name") VALUES
	(1,'Kerala');
REPLACE INTO "tbl_state" ("state_id", "state_name") VALUES
	(2,'Tamil Nadu');
REPLACE INTO "tbl_state" ("state_id", "state_name") VALUES
	(3,'Andhra Pradesh');
REPLACE INTO "tbl_state" ("state_id", "state_name") VALUES
	(4,'Karnadaka');
REPLACE INTO "tbl_state" ("state_id", "state_name") VALUES
	(5,'Jammu and Kashmir');
REPLACE INTO "tbl_state" ("state_id", "state_name") VALUES
	(29,'Madhya Pradesh');
REPLACE INTO "tbl_state" ("state_id", "state_name") VALUES
	(74,'Maharashtra');
/*!40000 ALTER TABLE "tbl_state" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'tbl_sync'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_sync" (
  "sync_id" int(11) NOT NULL auto_increment,
  "person_id" int(11) NOT NULL,
  PRIMARY KEY  ("sync_id")
);



#
# Dumping data for table 'tbl_sync'
#

# No data found.



#
# Table structure for table 'tbl_waterbill'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "tbl_waterbill" (
  "wbill_id" tinyint(4) NOT NULL auto_increment,
  "wbill_amt" int(11) NOT NULL,
  "wbill_duedate" varchar(50) NOT NULL,
  "wbill_status" int(11) NOT NULL,
  "wbill_no" int(11) NOT NULL,
  "wbill_serviceno" varchar(50) NOT NULL,
  "person_id" int(11) NOT NULL,
  PRIMARY KEY  ("wbill_id")
) AUTO_INCREMENT=2;



#
# Dumping data for table 'tbl_waterbill'
#

LOCK TABLES "tbl_waterbill" WRITE;
/*!40000 ALTER TABLE "tbl_waterbill" DISABLE KEYS;*/
REPLACE INTO "tbl_waterbill" ("wbill_id", "wbill_amt", "wbill_duedate", "wbill_status", "wbill_no", "wbill_serviceno", "person_id") VALUES
	(1,300,'30-11-2018',0,1111,'1230981230',16);
/*!40000 ALTER TABLE "tbl_waterbill" ENABLE KEYS;*/
UNLOCK TABLES;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/
