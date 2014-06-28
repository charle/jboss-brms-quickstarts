helloworld-brms: A Basic BRMS example
======================================
Author: Rafael Benevides  
Level: Beginner  
Technologies: Drools, BRMS    
Summary: Shows how to use a KModule from a BRMS server  
Target Product: BRMS  
Source: <https://github.com/jboss-developer/jboss-brms-quickstarts/>  

What is it?
-----------

This project demonstrates how to use BRMS to manage and deploy modules that contain model classes and rules.

* The `HelloWorldBRMSTest` class creates 3 Sales object instances: `vipSale`, `regularSale`, and `badSale`.
* These Sales objects are passed to the `StatelessKieSession` class, which runs the rules against them to verify and apply discounts.

_Note:_ The Sale, Customer and CustomerType classes are defined on the following dependency: org.jboss.quickstarts.brms:helloworld-brms-kmodule:1.0.0. This dependency is a BRMS Kmodule that contains the model classes and the rules that were previously built. It is available on the the git repository: <https://github.com/jboss-developer/jboss-brms-repository.git>


The Maven dependency is available at the following Maven Repository: `http://[change].rhcloud.com/business-central/maven2/` 

This quickstart does not contain a user interface layer. 

System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or later, Maven 3.0 or later.

The application this project produces is designed to be run on BRMS 6

 
Configure Maven
---------------

If you have not yet done so, you must [Configure Maven](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/CONFIGURE_MAVEN.md#configure-maven-to-build-and-deploy-the-quickstarts) before testing the quickstarts.


Create and start Openshift BPMsuite Cartridge
-----------

TODO: prepare a cartridge changing url_filter in business-central.war/WEB-INF/classes in order to make maven repo accessible

Import the BRMS Repository
----------------------

If you have not yet done so, you must [Import the BRMS repository](../README.md#import-the-brms-repository) before testing the quickstart.


Deploy BRMS kmodule
-------------------

1. [Start the JBoss Server](#start-the-jboss-server) as instructed above.

2. Open a browser and access the following URL: <http://[change].rhcloud.com/business-central> 

2. Log in with the following credentials:

        Username:  bpm-admin
        Password:  _italic_ bpmadmin password generated during openshift BPMSuite cartridge installation

3. Choose menu option `Authoring` -> `Project Authoring`

4. Choose the following options under `Project Explorer`:

        Organizational Unit:  demo
        Repository Name:      jboss-brms-repository
        BRMS Kmodule:         helloworld-brms-kmodule

5. Next, click on `Tools` and `Project Editor`

6. In the tab on the right, click on `Build & Deploy`. 
   * It will prompt you with a message: "Also save possible changes to project?". Click `Yes`. 
   * You are prompted for a comment. Add a comment and click on `Save` button.

This deploys the `org.jboss.quickstarts.brms:helloworld-brms-kmodule:1.0.0` artifact to the BRMS Maven repository. You can verify the deployment choosing menu option `Deployment` --> `Artifact Repository`.


Run the Tests 
-------------

1. Open a command prompt and navigate to the root directory of this quickstart.
2. Type the following command to run the test goal with the following profile activated:

        mvn clean test -Penable-test

   The tests fail with compilation errors because the project does not have the necessary dependencies.

4. Now run the following command to run the test goal with the following profiles activated:

        mvn clean test -Penable-test,brms -DBPMSuiteOpenshift="http://[change].rhcloud.com/business-central/maven2/"

The `brms` profile enables the `http://[change].rhcloud.com/business-central/maven2/` repository and adds the `org.jboss.quickstarts.brms:helloworld-brms-kmodule:1.0.0` as a project dependency. 

Now the tests complete successfully.

Investigate the Console Output
----------------------------

When you run the tests, JUnit will present you test report summary:

    -------------------------------------------------------
     T E S T S
    -------------------------------------------------------
    Running org.jboss.quickstarts.brms.HelloWorldBRMSTest
    17:02:10.317 [main] INFO  o.d.c.k.b.impl.ClasspathKieProject - Found kmodule: jar:file:/Users/rafaelbenevides/.m2/repository/org/jboss/quickstarts/brms/helloworld-brms-kmodule/1.0.0/helloworld-brms-kmodule-1.0.0.jar!/META-INF/kmodule.xml
    17:02:10.322 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - KieModule URL type=jar url=/Users/rafaelbenevides/.m2/repository/org/jboss/quickstarts/brms/helloworld-brms-kmodule/1.0.0/helloworld-brms-kmodule-1.0.0.jar
    17:02:10.461 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - Found and used pom.properties META-INF/maven/org.jboss.quickstarts.brms/helloworld-brms-kmodule/pom.properties
    17:02:10.466 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - Discovered classpath module org.jboss.quickstarts.brms:helloworld-brms-kmodule:1.0.0
    17:02:10.469 [main] INFO  o.d.c.k.b.impl.KieRepositoryImpl - KieModule was added:ZipKieModule[ ReleaseId=org.jboss.quickstarts.brms:helloworld-brms-kmodule:1.0.0file=/Users/rafaelbenevides/.m2/repository/org/jboss/quickstarts/brms/helloworld-brms-kmodule/1.0.0/helloworld-brms-kmodule-1.0.0.jar]
    17:02:11.132 [main] DEBUG o.drools.core.reteoo.ReteooRuleBase - Starting Engine in PHREAK mode
    ** Testing VIP customer **
    VIP discount applied
    Sale approved
    ** Testing regular customer **
    Sale approved
    ** Testing BAD customer **
    Bad customer. Sale denied
    Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.548 sec
    
    Results :
    
    Tests run: 3, Failures: 0, Errors: 0, Skipped: 0


Test the Quickstart in JBoss Developer Studio or Eclipse
-------------------------------------

You can also start the server and deploy the quickstarts from Eclipse using JBoss tools. For more information, see [Use JBoss Developer Studio or Eclipse to Run the Quickstarts](../README.md#use-jboss-developer-studio-or-eclipse-to-run-the-quickstarts) 


Debug the Application
------------------------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following commands to pull them into your local repository. The IDE should then detect them.

        mvn dependency:sources
        mvn dependency:resolve -Dclassifier=javadoc

