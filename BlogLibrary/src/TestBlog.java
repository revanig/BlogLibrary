
public class TestBlog {

	public TestBlog() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Blog blog = new Blog("hello");
		

		blog.addPost("hello", "Bob", "post Body");
		blog.addPost("hello1", "John", "post Body2");
		System.out.print("search\n");

		blog.postByTitle("hell");
		System.out.print("print\n");

		blog.printAllPosts();
		System.out.print("remove\n");
		blog.removePostByTitle("hello");
		
		blog.addComment("Jack", "much commenting", "hello1");
		blog.addLabel("Yay a label", "hello1");

		blog.printAllPosts();
		
		blog.updateComment("Jack", "updated Comment", "hello1");
		
		blog.printAllPosts();

	}

}
