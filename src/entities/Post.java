package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
  private People user;
  private Date createdAt;
  private Date updatedAt;
  private String title;
  private String content;
  private List<Like> likes = new ArrayList<>();
  private List<Comment> comments = new ArrayList<>();

  public Post(People user, String title, String content) {
    Date date = new Date();
    this.user = user;
    this.createdAt = date;
    this.updatedAt = date;
    this.title = title;
    this.content = content;
  }

  public People getUser() {
    return user;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.updatedAt = new Date();
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.updatedAt = new Date();
    this.content = content;
  }

  public List<Like> getLikes() {
    return likes;
  }

  public void setLikes(Like like) {
    Integer liked = likes.indexOf(like);

    if (liked != -1) {
      likes.remove(like);
    } else {
      likes.add(like);
    }
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComment(Comment comment) {
    Integer commented = comments.indexOf(comment);

    if (commented != -1) {
      comments.get(commented).setText(comment.getText());
    } else {
      comments.add(comment);
    }
  }

  public boolean removeComment(Comment comment) {
    Integer commented = comments.indexOf(comment);

    if (commented != -1) {
      return comments.remove(comment);
    }

    return false;
  }

  public String toStringComment() {
    StringBuilder sb = new StringBuilder();
    sb.append("Comments quantity: ");
    sb.append(comments.size() + "\n");

    comments.forEach(comment -> {
      sb.append("Date: ");
      sb.append(comment.getDate() + "\n");

      sb.append("User: ");
      sb.append(comment.getUser().getName() + "\n");

      sb.append("Comment: ");
      sb.append(comment.getText() + "\n");
    });

    return sb.toString();
  }

  public String toStringLikes() {
    StringBuilder sb = new StringBuilder();
    sb.append("Likes quantity: ");
    sb.append(likes.size() + "\n");

    likes.forEach(like -> {
      sb.append("Date: ");
      sb.append(like.getDate() + "\n");

      sb.append("User: ");
      sb.append(like.getUser().getName() + "\n");
    });

    return sb.toString();
  }
}
