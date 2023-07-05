package entities;

import java.util.Date;

public class Comment {
  private People user;
  private String text;
  private Date date;

  public Comment(People user, String text) {
    date = new Date();
    this.user = user;
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public People getUser() {
    return user;
  }

  public Date getDate() {
    return date;
  }

  public void setText(String text) {
    date = new Date();
    this.text = text;
  }
}