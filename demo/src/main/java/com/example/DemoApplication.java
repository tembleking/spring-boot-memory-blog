package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.Graphics2Delegate;

import javax.management.*;
import java.lang.management.ManagementFactory;

@SpringBootApplication
@RestController
public class DemoApplication {

    private static Greeting greeting = new Greeting("Hello World!");

    @RequestMapping("/greeting")
    public Greeting greeting() {
        return greeting;
    }

    public static void main(String[] args) {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("app:greeting=HelloWorld");
            mBeanServer.registerMBean(DemoApplication.greeting, name);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        }
        SpringApplication.run(DemoApplication.class, args);
    }
}

class Greeting implements GreetingMBean {
    private String message;
    private int numberOfGreetings;

    Greeting() {
    }

    public Greeting(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        numberOfGreetings += 1;
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int getNumberOfGreetings() {
        return numberOfGreetings;
    }
}
