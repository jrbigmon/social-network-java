import java.util.List;

import entities.Comment;
import entities.Like;
import entities.People;
import entities.Post;

public class App {
    public static void main(String[] args) throws Exception {
        People peopleToPost = new People("Vagner", "vagner@example.com");

        People peopleToInteract1 = new People("interact_1", "interact_1@example.com");
        People peopleToInteract2 = new People("interact_2", "interact_2@example.com");

        Post post = new Post(peopleToPost, "My first post", "This post is my first post, please enter your like");

        Like likeFromInteract1 = new Like(peopleToInteract1);
        post.setLikes(likeFromInteract1);

        Comment commentFromInteract2 = new Comment(peopleToInteract2, "this post is a sheet");
        post.setComment(commentFromInteract2);

        List<Like> likes = post.getLikes();
        List<Comment> comments = post.getComments();

        System.out.println("Likes: " + likes.size());
        likes.forEach(like -> {
            System.out.println("Date: " + like.getDate());
            System.out.println("User: " + like.getUser().getName());
        });

        System.out.println("Comments: " + comments.size());
        comments.forEach(comment -> {
            System.out.println("Date: " + comment.getDate());
            System.out.println("User: " + comment.getUser().getName());
            System.out.println("Comment: " + comment.getText());
        });

        post.setLikes(likeFromInteract1);

        System.out.println("Likes: " + likes.size());
        likes.forEach(like -> {
            System.out.println("Date: " + like.getDate());
            System.out.println("User: " + like.getUser().getName());
        });

        post.removeComment(commentFromInteract2);

        System.out.println("Comments: " + comments.size());
        comments.forEach(comment -> {
            System.out.println("Date: " + comment.getDate());
            System.out.println("User: " + comment.getUser().getName());
            System.out.println("Comment: " + comment.getText());
        });
    }
}
