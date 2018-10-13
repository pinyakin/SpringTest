package com.yet.spring.core.beans;

import java.text.DateFormat;
import java.util.Date;

public class Event {
  private int id;
  private String msg;
  private Date date;
  private DateFormat df;

  public String getMsg() {
    return msg;
  }

  public Event(Date date,DateFormat dateFormat) {
    this.date = date;
    this.df=dateFormat;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "Event{" +
        "id=" + id +
        ", msg='" + msg + '\'' +
        ", date=" + df.format(date) +
        '}';
  }
}
