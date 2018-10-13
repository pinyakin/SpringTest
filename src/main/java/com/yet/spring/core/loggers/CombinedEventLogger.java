package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import java.util.Collection;

public class CombinedEventLogger implements EventLogger {

  private Collection<EventLogger> collectionLogger;

  public CombinedEventLogger(Collection<EventLogger> collectionLogger) {
    this.collectionLogger=collectionLogger;
  }

  @Override
  public void logEvent(Event event) {
    for(EventLogger logger:collectionLogger)
      logger.logEvent(event);

  }
}
