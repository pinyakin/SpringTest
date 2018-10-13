package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  private Client client;
  private EventLogger eventLogger;

  public App(Client client, EventLogger eventLogger) {
    this.client = client;
    this.eventLogger = eventLogger;
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    App app = (App) context.getBean("App");
    app.logEvent((Event) context.getBean("event"));

    context.close();
  }

  private void logEvent(Event event) {
    event.setMsg(event.getMsg().replaceAll(String.valueOf(client.getId()), client.getFullName()));
    eventLogger.logEvent(event);
  }
}
