Bacwardchaining: Bacwardchaining Basic DRL example
======================================
Author: Marco Battaglia  
Level: Beginner  
Technologies: Drools  
Summary: Shows how to use Drools 6  
Target Product: BRMS  
Source: <https://github.com/jboss-developer/jboss-brms-quickstarts/>  

What is it? A bacwardchaining example 
-----------

README TO DO

Investigate the Console Output
----------------------------

When you run the tests, JUnit will present you test report summary:
    
    -------------------------------------------------------
     T E S T S
    -------------------------------------------------------
    Running org.jboss.quickstarts.brms.backwardchaining.BackwardchainingTest
    14:52:10.593 [main] INFO  o.d.c.k.b.impl.ClasspathKieProject - Found kmodule: file:/home/marco/workspaceJB8/jboss-brms-quickstarts/backwardchaining/target/classes/META-INF/kmodule.xml
    14:52:10.597 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - KieModule URL type=file url=/home/marco/workspaceJB8/jboss-brms-quickstarts/backwardchaining/target/classes
    14:52:10.693 [main] WARN  o.d.c.k.b.impl.ClasspathKieProject - Unable to load pom.properties tried recursing down from/home/marco/workspaceJB8/jboss-brms-quickstarts/backwardchaining/target/classes
    null
    14:52:10.702 [main] INFO  o.d.c.k.b.impl.ClasspathKieProject - Recursed up folders,  found and used pom.xml /home/marco/workspaceJB8/jboss-brms-quickstarts/backwardchaining/pom.xml
    14:52:10.704 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - Discovered classpath module org.jboss.quickstarts.brms:backwardchaining:6.1.0-build-SNAPSHOT
    14:52:10.708 [main] INFO  o.d.c.k.b.impl.KieRepositoryImpl - KieModule was added:FileKieModule[ ReleaseId=org.jboss.quickstarts.brms:backwardchaining:6.1.0-build-SNAPSHOTfile=/home/marco/workspaceJB8/jboss-brms-quickstarts/backwardchaining/target/classes]
    14:52:11.651 [main] DEBUG o.drools.core.reteoo.ReteooRuleBase - Starting Engine in PHREAK mode
    go1
    -> Office is contained in House  
     office is in the house
    ---
    go2
    -> Draw is contained in Desk  
     -> Draw is in Desk that is contained in Office  
     -> Draw is in Office that is contained in House  
     Draw is in the house
    ---
    go3
    ---
    -> Key is contained in Draw  
     -> Key is in Draw that is contained in Desk  
     -> Key is in Desk that is contained in Office  
     Draw is in the office
    ---
    go5
    -> Key is contained in Draw  
     -> Key is in Draw that is contained in Desk  
     -> Computer is contained in Desk  
     -> Draw is contained in Desk  
     -> Key is contained in Draw  
     -> Computer is in Desk that is contained in Office  
     -> Draw is in Desk that is contained in Office  
     -> Key is in Draw that is contained in Desk  
     -> Key is in Desk that is contained in Office  
     -> Desk is contained in Office  
     -> Chair is contained in Office  
     -> Knife is contained in Kitchen  
     -> Cheese is contained in Kitchen  
     -> Computer is contained in Desk  
     -> Draw is contained in Desk  
     -> Key is contained in Draw  
     -> Desk is in Office that is contained in House  
     -> Chair is in Office that is contained in House  
     -> Knife is in Kitchen that is contained in House  
     -> Cheese is in Kitchen that is contained in House  
     -> Computer is in Desk that is contained in Office  
     -> Draw is in Desk that is contained in Office  
     -> Key is in Draw that is contained in Desk  
     -> Computer is in Office that is contained in House  
     -> Draw is in Office that is contained in House  
     -> Key is in Desk that is contained in Office  
     -> Key is in Office that is contained in House  
     -> Office is contained in House  
     -> Computer is contained in Desk  
     -> Knife is contained in Kitchen  
     -> Cheese is contained in Kitchen  
     -> Kitchen is contained in House  
     -> Key is contained in Draw  
     -> Draw is contained in Desk  
     -> Desk is contained in Office  
     -> Chair is contained in Office  
     thing Office is in the location House
    thing Computer is in the location Desk
    thing Knife is in the location Kitchen
    thing Cheese is in the location Kitchen
    thing Kitchen is in the location House
    thing Key is in the location Draw
    thing Draw is in the location Desk
    thing Desk is in the location Office
    thing Chair is in the location Office
    thing Desk is in the location House
    thing Chair is in the location House
    thing Knife is in the location House
    thing Cheese is in the location House
    thing Computer is in the location Office
    thing Draw is in the location Office
    thing Key is in the location Desk
    thing Computer is in the location House
    thing Draw is in the location House
    thing Key is in the location Office
    thing Key is in the location House
    ---
    ---
    Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.561 sec
    
    
