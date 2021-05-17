package com.helena.client;


import com.helena.domain.Employee;
import com.helena.service.ManagementService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws NamingException {
        Properties jndiProperties = new Properties();

        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        System.out.println(jndiProperties);

        Context jndi = new InitialContext(jndiProperties);
        ManagementService service = (ManagementService) jndi.lookup("fantasticProject-1.0-SNAPSHOT-war/ServiceImplementation!com.helena.service.ManagementService");

        /*Employee emp1 = new Employee("Andreas","Green","Designer",2700);
        Employee emp2 = new Employee("Rikard","Blue","Tester",1800);
        Employee emp3 = new Employee("Ronald","Black","Programmer",2900);
        Employee emp4 = new Employee("Eric","Black","Manager",2000);

        service.registerEmployee(emp1);
        service.registerEmployee(emp2);
        service.registerEmployee(emp3);
        service.registerEmployee(emp4);*/

        List<Employee> employees = service.searchByLastname("Black");

        System.out.println(employees
        );

        List<Employee> employees2 = service.getAllEmployees();

        for (Employee employee : employees2) {
            System.out.println(employee);
        }
    }
}

