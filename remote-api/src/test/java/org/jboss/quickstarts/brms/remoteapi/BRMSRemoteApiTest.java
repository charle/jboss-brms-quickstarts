/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the 
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.quickstarts.brms.remoteapi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.TaskSummary;
import org.kie.services.client.api.RemoteRestRuntimeFactory;
import org.kie.services.client.api.RemoteRuntimeEngineFactory;
import org.kie.services.client.api.command.RemoteRuntimeEngine;

/**
 * @author marcobattaglia
 * 
 */
public class BRMSRemoteApiTest extends JbpmJUnitBaseTestCase{

    private static StatelessKieSession kSession;

   

    @BeforeClass
    public static void setup() {
       
    }

    @Test
    public void testRemoteStart()  {
    	  // the serverRestUrl should contain a URL similar to "http://localhost:8080/jbpm-console/"
    	  URL url = null;
		try {
			url = new URL("http://localhost:8080/jbpm-console/");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  String user="salaboy";
    	  String password="salaboy";
    	  // Setup the factory class with the necessarry information to communicate with the REST services
    	  RemoteRuntimeEngineFactory restSessionFactory 
    	    = new RemoteRestRuntimeFactory("org.jbpm:HR:1.0", url, user, password);

    	  // Create KieSession and TaskService instances and use them
    	  RemoteRuntimeEngine engine = (RemoteRuntimeEngine) restSessionFactory.newRuntimeEngine();
    	  KieSession ksession = engine.getKieSession();
    	  TaskService taskService = engine.getTaskService();

    	  // Each opertion on a KieSession, TaskService or AuditLogService (client) instance 
    	  // sends a request for the operation to the server side and waits for the response
    	  // If something goes wrong on the server side, the client will throw an exception. 
    	  ProcessInstance processInstance 
    	    = ksession.startProcess("hiring");
    	  long procId = processInstance.getId();

    	  String taskUserId = user;
    	  taskService = engine.getTaskService();
    	  List<TaskSummary> tasks = taskService.getTasksAssignedAsPotentialOwner(user, "en-UK");
    	  for(TaskSummary task:tasks)    	{
    		  System.out.println("founded task: " + task.getName() +" for you!");
    	  }
    	  long taskId = -1;
//    	  
    	  assertProcessInstanceActive(procId, ksession);
    	  
    }

   

}
