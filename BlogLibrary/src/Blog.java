import java.util.ArrayList;
import java.util.List;

/**
 * @author Revani Govender
 * This class will create the structure of a blog
 * A Blog has a title and a collection of posts
 * A Post has a title, author, body, collection of labels, and a collection of comments
 * A comment has an author and a body
 * 
 * The library will have CRUD functionality for Posts and Comments
 * Posts/Comments will be searchable by title, author, label, and body
 * 
 */
public class Blog {

	private String title;
	private List<Post> posts = new ArrayList<Post>();
	
	// Just need a title to get a blog, can add post later
	/**
	 * Base blog is just a title
	 * @param title
	 */
	public Blog(String title) {
		this.title = title;
	}
	
	public String getTitle () {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	// Create post/Post items
	
	/**
	 * New post
	 * @param postTitle
	 * @param postAuthor
	 * @param postBody
	 */
	public void addPost (String postTitle, String postAuthor, String postBody) {
		posts.add(new Post(postTitle, postAuthor, postBody));
	}
	/**
	 * Add label to a post
	 * @param labelBody
	 * @param postTitle
	 */
	public void addLabel (String labelBody, String postTitle) {
		int postIndex = findPostByTitle(postTitle);
		posts.get(postIndex).addLabel(labelBody);
	}
	
	/**
	 * Add comment to a post
	 * @param commentAuthor
	 * @param commentBody
	 * @param postTitle
	 */
	public void addComment (String commentAuthor, String commentBody, String postTitle) {
		int postIndex = findPostByTitle(postTitle);
		posts.get(postIndex).addComment(commentAuthor, commentBody);

	}
	
	//Update
	
	/**
	 * Edits comment in a post by the post title
	 * @param commentAuthor
	 * @param commentBody
	 * @param postTitle
	 */
	public void updateComment (String commentAuthor, String commentBody, String postTitle) {
		int postIndex = findPostByTitle(postTitle);
		posts.get(postIndex).editCommentByAuthor(commentAuthor, commentBody);

	}
	
	/**
	 * Edits post body from post title
	 * @param postBody
	 * @param postTitle
	 */
	public void updatePostBody (String postBody, String postTitle) {
		int postIndex = findPostByTitle(postTitle);
		posts.get(postIndex).setBody(postBody);

	}
	
	// Remove
	/**
	 * Remove a post by Title
	 * Assuming the post titles are unique
	 * @param postTitle
	 */
	public void removePostByTitle (String postTitle) {
		int postsLength = posts.size();
		for (int i = 0; i < postsLength; i++) {
			if (posts.get(i).getTitle().equals(postTitle)) {
				posts.remove(i);
				break;
			}
		}
	}
	
	//not the best way to remove posts - should probably have two identifiers to remove something
	/**
	 * Remove a post by Author
	 * Assuming the post authors are unique for now
	 * @param postAuthor
	 */
	public void removePostByAuthor (String postAuthor) {
		int postsLength = posts.size();
		for (int i = 0; i < postsLength; i++) {
			if (posts.get(i).getTitle().equals(postAuthor)) {
				posts.remove(i);
			}
		}
	}
	
	// Retrieve/Search
	/**
	 * Finds posts that contain string
	 * @param postTitle
	 */
	public void postByTitle(String postTitle) {
		int postsLength = posts.size();
		for (int i = 0; i < postsLength; i++) {
			if (posts.get(i).getTitle().contains(postTitle)) {
				posts.get(i).postToString();
		
			}
		}
		
	}
	
	/**
	 * Finds the index of a post by the title
	 * @param postTitle
	 * @return
	 */
	public int findPostByTitle (String postTitle) {
		int postsLength = posts.size();
		for (int i = 0; i < postsLength; i++) {
			if (posts.get(i).getTitle().equals(postTitle)) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * Finds posts by post author
	 * @param postAuthor
	 */
	public void postByAuthor(String postAuthor) {
		int postsLength = posts.size();
		for (int i = 0; i < postsLength; i++) {
			if (posts.get(i).getAuthor().contains(postAuthor)) {
				posts.get(i).postToString();
			}
		}
		
	}

	/**
	 * Finds posts with post body
	 * @param postBody
	 */
	public void postByBody(String postBody) {
		int postsLength = posts.size();
		for (int i = 0; i < postsLength; i++) {
			if (posts.get(i).getAuthor().contains(postBody)) {
				posts.get(i).postToString();
			}
		}
		
	}
	
	/**
	 * finds labels by body
	 * @param labelBody
	 * @param postTitle
	 */
	public void labelsByBody (String labelBody, String postTitle) {
		int postIndex = findPostByTitle(postTitle);
		posts.get(postIndex).labelsByBody(labelBody);

	}
	/**
	 * Finds comments by author
	 * @param commentAuthor
	 * @param postTitle
	 */
	public void commentsByAuthor (String commentAuthor, String postTitle) {
		int postIndex = findPostByTitle(postTitle);
		posts.get(postIndex).commentsByAuthor(commentAuthor);

	}
	
	/**
	 * Comments by body
	 * @param commentBody
	 * @param postTitle
	 */
	public void commentsByBody (String commentBody, String postTitle) {
		int postIndex = findPostByTitle(postTitle);
		posts.get(postIndex).commentsByAuthor(commentBody);

	}
	

	public void printAllPosts() {
		int postsLength = posts.size();
		for (int i = 0; i < postsLength; i++) {
			posts.get(i).postToString();
		}
	}
	

}

class Post {
	
	private String title;
	private String author;
	private String body;
	private List<Label> labels = new ArrayList<Label>();
	private List<Comment> comments = new ArrayList<Comment>();
	// Post has a title, author, body, Label, and Comment
	
	/**
	 * Base elements of a post is title, author, body
	 * @param title
	 * @param author
	 * @param body
	 */
	public Post(String title, String author, String body) {
		this.title = title;
		this.author = author;
		this.body = body;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle (String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor (String author) {
		this.author = author;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody (String body) {
		this.body = body;
	}
	
	/**
	 * Add labels to a post
	 * @param labelBody
	 */
	public void addLabel (String labelBody) {
		labels.add(new Label(labelBody));
	}
	
	/**
	 * Find labels in a post
	 * @param labelBody
	 */
	public void labelsByBody(String labelBody) {
		int labelsLength = labels.size();
		for (int i = 0; i < labelsLength; i++) {
			if (labels.get(i).getLabel().contains(labelBody)) {
				labels.get(i).labelToString();
			}
		}
		
	}
	
	/**
	 *  Add comments to a post
	 * @param commentAuthor
	 * @param commentBody
	 */
	public void addComment (String commentAuthor, String commentBody) {
		comments.add(new Comment(commentAuthor, commentBody));
	}
	
	// This probably isn't the best way to remove a comment
	// need to be able to specify the comment to delete if there is more than one comment per author
	/**
	 * Remove comments by author
	 * @param commentTitle
	 */
	public void removeCommentByAuthor (String commentAuthor) {
		int commentsLength = comments.size();
		for (int i = 0; i < commentsLength; i++) {
			if (comments.get(i).getAuthor().equals(commentAuthor)) {
				comments.remove(i);
				break;
			}
		}
	}
	
	/**
	 * Edit a comment by author
	 * @param commentAuthor
	 * @param commentBody
	 */
	public void editCommentByAuthor (String commentAuthor, String commentBody) {
		int commentsLength = comments.size();
		for (int i = 0; i < commentsLength; i++) {
			if (comments.get(i).getAuthor().equals(commentAuthor)) {
				comments.get(i).setBody(commentBody);
			}
		}
	}
		
	/**
	 * Find comments by author
	 * @param commentAuthor
	 */
	public Comment commentsByAuthor(String commentAuthor) {
		int commentsLength = comments.size();
		for (int i = 0; i < commentsLength; i++) {
			if (comments.get(i).getAuthor().contains(commentAuthor)) {
				comments.get(i).commentToString();
				return comments.get(i);
			}
		}
		return null;
		
	}

	/**
	 * Find comments by body
	 * @param commentBody
	 */
	public void commentsByBody(String commentBody) {
		int commentsLength = comments.size();

		for (int i = 0; i < commentsLength; i++) {
			if (comments.get(i).getAuthor().contains(commentBody)) {
				comments.get(i).commentToString();
			}
		}
	
	}

	
	// Print functions

	public void postToString() {
		System.out.print(getTitle() + " " + getAuthor() + " " + getBody() + "\n");
		printAllComments();
		printAllLabels();
	}
	
	public void printAllComments() {
		int postsLength = comments.size();
		for (int i = 0; i < postsLength; i++) {
			comments.get(i).commentToString();
		}
	}
	
	
	public void printAllLabels() {
		int labelsLength = labels.size();
		for (int i = 0; i < labelsLength; i++) {
			labels.get(i).labelToString();
		}
	}
	
}

class Label {
	
	private String label;
	/**
	 * Label is a string
	 * @param label
	 */
	public Label(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel (String label) {
		this.label = label;
	}
	
	public void labelToString() {
		System.out.print(getLabel() + "\n");
	}
	
}

class Comment {
	
	private String author;
	private String body;
	/**
	 * Comment is an author and body
	 * @param author
	 * @param body
	 */
	public Comment(String author, String body) {
		this.author = author;
		this.body = body;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public void commentToString() {
		System.out.print(getAuthor() + " " + getBody() + "\n");
	}
	
}
