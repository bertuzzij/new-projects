package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class ProgramTweet {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comment cs1 = new Comment("Have a nice trip!");
		Comment cs2 = new Comment("Wow that's awesome!");
		
		//instanciando o post
		Post p1 = new Post(sdf.parse("21/06/2018 13:05:44")
				, "Traveling to New Zeland"
				, "I'm going to visit this wonderful country!",
				12);
		
		p1.addComment(cs1);
		p1.addComment(cs2);
		
		Comment c3 = new Comment("Good night!");
		Comment c4 = new Comment("May the Force be with you");
		Post p2 = new Post(
					sdf.parse("28/07/2018 23:14:19")
				,"Good nigth guys"
				, "See you tomorrow", 5);
		p2.addComment(c3);
		p2.addComment(c4);
		
		System.out.println(p1);
		System.out.println(p2);

	}

}
