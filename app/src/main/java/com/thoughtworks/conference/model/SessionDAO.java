package com.thoughtworks.conference.model;

import com.orm.SugarRecord;

import java.util.Date;

public class SessionDAO extends SugarRecord {

  private Date startTime;
  private Date endTime;
  private String name;
  private String description;
  private Category category;
  private String location;

  public SessionDAO(){
  }

  public SessionDAO(String name, Date startTime, Date endTime, String description, String location, Category category){
    this.name = name;
    this.description = description;
    this.location = location;
    this.category = category;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startTime = startTime;
    this.endTime = endTime;
    this.description = description;
    this.location = location;
    this.category = category;
  }

  public static SessionDAO createFrom(Session session){
    return new SessionDAO(session.getName(), session.getStartTime(), session.getEndTime(), session.getDescription(), session.getLocation(), session.getCategory());
  }

  public Session toSession() {
    return new Session(name, description, startTime, endTime, category, location);
  }

  public String getDescription() {
    return description;
  }

  public String getLocation() {
    return location;
  }

  public Category getCategory() {
    return category;
  }

  public Date getStartTime() {
    return startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public String getName(){
    return name;
  }
}
