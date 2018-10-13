package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.beans.EventType;
import com.yet.spring.core.loggers.EventLogger;
import java.util.Map;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  private Client client;
  private EventLogger defaultLogger;

  private Map<EventType, EventLogger> map;

  public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> map) {
    this.client = client;
    this.defaultLogger = eventLogger;
    this.map = map;
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    App app = (App) context.getBean("app");

    app.logEvent((Event) context.getBean("event"), EventType.INFO, "Event for 1" );
    app.logEvent((Event) context.getBean("event"), EventType.ERROR, "Warning for 1" );
    app.logEvent((Event) context.getBean("event"), null, "Something for 1" );

    context.close();
  }

  private void logEvent(Event event, EventType type, String msg) {
    EventLogger logger=map.get(type);
    if(logger==null)
      logger=defaultLogger;

    event.setMsg(msg.replaceAll(String.valueOf(client.getId()), client.getFullName()));
    logger.logEvent(event);
  }
}
