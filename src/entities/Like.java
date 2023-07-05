package entities;

import java.util.Date;

public class Like {
  private People user;
  private Date date;

  public Like(People user) {
    this.user = user;
    date = new Date();
  }

  public People getUser() {
    return user;
  }

  public Date getDate() {
    return date;
  }
}
