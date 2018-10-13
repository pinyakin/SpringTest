package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class FileEventLogger implements EventLogger {

  private String fileName;

  private File file;

  public FileEventLogger(String fileName) {
    this.fileName = fileName;
  }

  public FileEventLogger() {

  }

  public void logEvent(Event event) {
    try {
      FileUtils.writeStringToFile(file, event.getMsg(), "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void init() throws IOException {
    this.file = new File(fileName);
  }
}
