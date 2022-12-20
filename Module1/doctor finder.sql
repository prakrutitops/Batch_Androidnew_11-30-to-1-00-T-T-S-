/*
SQLyog Community v10.3 
MySQL - 5.5.47 : Database - doctor finder
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`doctor finder` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `doctor finder`;

/*Table structure for table `appoinment` */

DROP TABLE IF EXISTS `appoinment`;

CREATE TABLE `appoinment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DrName` varchar(50) DEFAULT NULL,
  `DrSpeciality` varchar(50) DEFAULT NULL,
  `AppoinmentDate` varchar(100) DEFAULT NULL,
  `AppoinmentTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

/*Data for the table `appoinment` */

insert  into `appoinment`(`id`,`DrName`,`DrSpeciality`,`AppoinmentDate`,`AppoinmentTime`) values (3,'Dr.BCD JOY','','2016-04-09','1 PM TO 3 PM'),(4,'Dr.DEF TOY ','','','9 AM TO 11 AM'),(5,'','','',''),(6,'','','',''),(7,'Dr.DEF TOY ','','',''),(8,'','','',''),(9,'','','',''),(18,'','','',''),(19,'','','',''),(20,'','','',''),(21,'','','',''),(26,'','','',''),(27,'','','',''),(28,'','','',''),(29,'','','',''),(30,'Dr.Piyush Ruparel','','',''),(31,'Dr.Piyush Ruparel','','',''),(32,'Dr.Piyush Ruparel','','',''),(33,'Dr.JKL GHJ','','',''),(34,'Dr.Piyush Ruparel','','2016-04-25','9 AM TO 11 AM'),(35,'Dr.Piyush Ruparel','','2016-04-26','9 AM TO 11 AM'),(36,'Dr.Piyush Ruparel','','2016-04-26','9 AM TO 11 AM'),(37,'Dr.Piyush Ruparel','','2016-04-26',''),(38,'Dr.Rajesh Nalkanthiya','','',''),(39,'Dr.Rajesh Nalkanthiya','','',''),(40,'Dr.FGH UIO','','08/02/2017','11 AM TO 1 PM'),(41,'Dr.RST TSR','','08/02/2017','11 AM TO 1 PM'),(42,'Dr.DEF TOY ','','08/02/2017','11 AM TO 1 PM'),(43,'Dr.BCD JOY','','19-03-2017','9 AM TO 11 AM');

/*Table structure for table `doctors` */

DROP TABLE IF EXISTS `doctors`;

CREATE TABLE `doctors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Speciality` varchar(100) DEFAULT NULL,
  `Location` varchar(100) DEFAULT NULL,
  `Dr_Name` varchar(50) DEFAULT NULL,
  `ContactNo` varchar(20) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

/*Data for the table `doctors` */

insert  into `doctors`(`id`,`Speciality`,`Location`,`Dr_Name`,`ContactNo`,`Email`,`Address`,`Image`) values (2,'Allergist','Ambawadi','Dr.BCD JOY','999999999','bcd@gmail.com','Vadaj','IMG_0490.JPG'),(3,'Anesthesiologist','Asarwa','Dr.CDE LOY','9999999992','cde@gmail.com','Vasana1\r\n','IMG_1362.JPG'),(4,'Cardiologist','Astodia','Dr.DEF TOY ','9999999993','def@gmail.com','University Area',NULL),(5,'Dentist','Bopal','Dr.EFG POY','9999999994','efg@gmail.com','Sanand',NULL),(6,'Dermatologist','Bapu Nagar','Dr.FGH UIO','9999999995','fgh@gmail.com','Shahpur',NULL),(7,'Endocrinologis','C.G. Road','Dr.GHI HYP','9999999996','ghi@gmail.com','Shahibaug',NULL),(8,'Epidemiologist','Dani Limbada','Dr.HIJ NHT','9999999997','hij@gmail.com','Sabarmati',NULL),(9,'Gynecologist','Dariapur','Dr.IJK BHU','9999999998','ijk@gmail.com','Sarangpur Darwaza',NULL),(10,'Immunologist','Ellis Bridge','Dr.JKL GHJ','9999999999','jkl@gmail.com','Satellite Area',NULL),(11,'Infectious Disease Specialist','Ghatlodia','Dr.PHY RQW','9999999910','aiq@gmail.com','Ghatlodia',NULL),(12,'Internal Medicine Specialist','Gulbai Tekra','Dr.QWE RTY','9999999911','qwe@gmail.com','Gulbai Tekra',NULL),(13,'Medical Geneticist','Gita Mandir Road','Dr.LMN JKL','9999999912','lmn@gmail.com','Gita Mandir Road',NULL),(14,'Microbiologist','Jamalpur','Dr.OPQ POQ','9999999913','opq@gmail.com','Jamalpur',NULL),(15,'Neonatologist','Khokra Mehmedabad','Dr.RST TSR','9999999914','rst@gmail.com','Khokra Mehmedabad',NULL),(16,'Neurologist','Kankaria','Dr.UVW VWU','9999999915','uvw@gmail.com','Kankaria',NULL),(17,'Neurosurgeon','Kalupur','Dr.XYZ ZYX','9999999916','xyz@gmail.com','Kalupur',NULL),(18,'Obstetrician','Kadia','Dr.ABCD','9999999917','abcd@gmail.com','Kadia',NULL),(19,'Oncologist','Lal Darwaza','Dr.BCDE','9999999918','bcde@gmail.com','Lal Darwaza',NULL),(20,'Orthopedic Surgeon','Maninagar','Dr.CDEF','9999999919','cdef@gmail.com','Maninagar',NULL),(21,'ENT Specialist','Meghani Nagar','Dr.DEFG','9999999920','defg@gmail.com','Meghani Nagar',NULL),(22,'Pediatrician','Mithakhali Six Roads','Dr.EFGH','9999999921','efgh@gmail.com','Mithakhali Six Roads',NULL),(23,'Physiologist','Mem Nagar','Dr.FGHI','9999999922','fghi@gmail.com','Mem Nagar',NULL),(24,'Plastic Surgeon','Navrangpura','Dr.GHIJ','9999999923','ghij@gmail.com','Navrangpura',NULL),(25,'Podiatrist','Naranpura','Dr.HIJK','9999999924','hijk@gmail.com','Naranpura',NULL),(26,'Psychiatrist','Naroda','Dr.IJKL','9999999925','ijkl@gmail.com','Naroda',NULL),(27,'Radiologist','Narol','Dr.JKLM','9999999926','jklm@gmail.com','Narol',NULL),(28,'Rheumatologist','Odhav','Dr.KLMN','9999999927','kmln@gmail.com','Odhav',NULL),(29,'Surgeon','Prahlad Nagar','Dr.LMNO','9999999928','lmno@gmail.com','Prahlad Nagar',NULL),(33,'ENT Specialist','Vastrapur','Dr. Piyush Ruparel','9879519203','piyush.ruparel@yahoo.com','Nothing123','IMG_1383.JPG');

/*Table structure for table `doctorspeciality` */

DROP TABLE IF EXISTS `doctorspeciality`;

CREATE TABLE `doctorspeciality` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DrSpeciality` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `AboutSpeciality` varchar(20000) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

/*Data for the table `doctorspeciality` */

insert  into `doctorspeciality`(`id`,`DrSpeciality`,`AboutSpeciality`) values (1,'Audiologist','Audiology is a licensed health-care profession. Audiologists diagnose, treat, and manage hearing loss and balance disorders for adults and children. Treatment for hearing loss typically involves.'),(2,'Allergist','An allergist/immunologist is a physician who has specialized training and accreditation to evaluate, diagnose and treat individuals with allergies, asthma and other disorders of the immune system.'),(3,'Anesthesiologist','In general, an anesthesiologist is a medical doctor who cares for a patient before, during and immediately following a surgical or medical procedure by administering appropriate anesthesia.'),(4,'Cardiologist','A cardiologist is a physician who is certified to treat problems of the cardiovascular systemâthe heart, arteries, and veins. Cardiology is classified as an internal medicine subspecialty.'),(5,'Dentist','A dentist, also known in the U.S. as a dental surgeon, is a surgeon who specializes in dentistryâthe diagnosis, prevention, and treatment of diseases and conditions of the oral cavity.'),(6,'Dermatologist','Dermatology is the branch of medicine dealing with the skin, nails, hair and its diseases.It is a specialty with both medical It is a specialty with both medical and surgical aspects.'),(7,'Endocrinologis','Endocrinologists are specially trained physicians who diagnose diseases related to the glands. The diseases they are trained to treat often affect other parts of the body beyond glands.'),(8,'Epidemiologist','Epidemiology is the study and analysis of the patterns, causes, and effects of health and disease conditions in defined populations. It is the cornerstone of public health, and shapes policy.'),(9,'Gynecologist','A gynecologist is a surgeon and usually a Medical Doctor who specializes in diseases of the female genital tract and women\'s health. This means diseases of the uterus, fallopian tubes and vulva. '),(10,'Immunologist','Immunologists are scientists or clinicians who specialise in the field of Immunology. Immunology is a very broad branch of the biological sciences and is defined as the study of an organism\'s.'),(11,'Infectious Disease Specialist','Infectious diseases specialists have extensive training in all kinds of infections show.'),(12,'Internal Medicine Specialist','Internal medicine specialists are experts in diagnosis and managing the care of patients.'),(13,'Medical Geneticist','Medical genetics is the branch of medicine that involves the diagnosis and management of hereditary disorders. Medical genetics differs from human genetics in that human genetics is a field of.'),(14,'Microbiologist','A microbiologist is a scientist who studies microscopic life forms and processes or works in the field of microbiology. Microbiologists investigate the growth and characteristics of microscopic.'),(15,'Neonatologist','Neonatology is a subspecialty of pediatrics that consists of the medical care of newborn infants, especially the ill or premature newborn infant. It is a hospital-based specialty, and is usually.'),(16,'Neurologist','A neurologist is a medical doctor or osteopath who has trained in the diagnosis and treatment of nervous system disorders, including diseases of the brain, spinal cord, nerves and muscles.'),(17,'Neurosurgeon','A neurosurgeon is a physician who specializes in the diagnosis and surgical treatment of disorders of the central and peripheral nervous system including congenital anomalies, trauma, tumors.'),(18,'Obstetrician','An obstetrician/gynecologist is a physician specialist who provides medical and surgical care to women and has particular expertise in pregnancy, childbirth, and disorders of the reproductive system.'),(19,'Oncologist','An oncologist is a doctor who specializes in treating people with cancer. The three main types of oncologists are medical, surgical, and radiation oncologists. These different types of oncologists.'),(20,'Orthopedic Surgeon','Orthopaedic surgery or orthopaedics is the branch of surgery concerned with conditions involving the musculoskeletal.'),(21,'ENT Specialist','Otolaryngology is the oldest medical specialty in the United States. Otolaryngologists are physicians trained in the medical and surgical management and treatment of patients with diseases and.'),(22,'Pediatrician','A pediatrician is medical doctor who manages the physical, behavioral, and mental health of children from birth until age 21. A pediatrician is trained to diagnose and treat a broad range of.'),(23,'Physiologist','Physiology is the study of life, specifically, how cells, tissues, and organisms function. Physiologists are constantly trying to answer key questions in areas ranging from the functions of single.'),(24,'Plastic Surgeon','Plastic surgeons are medical doctors who reconstruct and improve the physical appearances of patients by performing cosmetic or reconstructive surgery. Plastic surgeons must complete extensive.'),(25,'Podiatrist','A podiatrist is a doctor of podiatric medicine (DPM), also known as a podiatric physician or surgeon. Podiatrists diagnose and treat conditions of the foot, ankle, and related structures of the leg.'),(26,'Psychiatrist','A psychiatrist is a physician who specializes in psychiatry, which is to say in the diagnosis and treatment of mental disorders. Psychiatrists are medical doctors, unlike psychologists, and must mid.'),(27,'Radiologist','A radiologist is a specialist medical doctor who has had specific postgraduate training in performing and interpreting diagnostic imaging tests and interventional procedures or treatments that involve.'),(28,'Rheumatologist','A rheumatologist is an internist or pediatrician, who received further training in the diagnosis and treatment of musculoskeletal disease and systemic autoimmune conditions. '),(29,'Surgeon','Surgeons operate on patients to treat injuries, such as broken bones; diseases, such as cancerous tumors; and deformities, such as cleft palates.There are two types of physicians degrees: M.D. and D.O.');

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_drname` varchar(250) DEFAULT NULL,
  `f_drspeciality` varchar(250) DEFAULT NULL,
  `f_message` varchar(5000) DEFAULT NULL,
  `f_username` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `feedback` */

insert  into `feedback`(`f_id`,`f_drname`,`f_drspeciality`,`f_message`,`f_username`) values (1,'Dr. Piyush Ruparel','ENT Specialist','Hello World','palak patel'),(2,'Dr.CDE LOY','Anesthesiologist','Nice Treatment','shreya patel'),(3,'Dr.RST TSR','Neonatologist','Good Treatment As Per The Costing','Rahul Sanghavi'),(4,'Dr.FGH UIO','Dermatologist','asdfasdfasdfasf','Rahul Sanghavi');

/*Table structure for table `user_regi` */

DROP TABLE IF EXISTS `user_regi`;

CREATE TABLE `user_regi` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_fname` varchar(30) DEFAULT NULL,
  `u_lname` varchar(30) DEFAULT NULL,
  `u_email` varchar(50) DEFAULT NULL,
  `u_phno` varchar(12) DEFAULT NULL,
  `u_pwd` varchar(40) DEFAULT NULL,
  `u_cpwd` varchar(40) DEFAULT NULL,
  `u_gen` varchar(7) DEFAULT NULL,
  `u_date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `user_regi` */

insert  into `user_regi`(`u_id`,`u_fname`,`u_lname`,`u_email`,`u_phno`,`u_pwd`,`u_cpwd`,`u_gen`,`u_date`) values (10,'palak','patel','palak@gmail.com','1234567890','321321','321321','FeMale','2017-03-08'),(11,'shreya','patel','shreya@gmail.com','1234567890','123123','123123','FeMale','2017-03-08'),(12,'Rahul','Sanghavi','rahul.sanghavi.mca@gmail.com','9016545414','0903','0903','Male','2017-03-09');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
