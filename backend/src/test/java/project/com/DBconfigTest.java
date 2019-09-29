package project.com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBconfigTest 
{
	private static AnnotationConfigApplicationContext context;

	public static void main(String args[])
	{
	context = new AnnotationConfigApplicationContext();
	context.scan("project.com");
	System.out.println("Begin");
	context.refresh();
	System.out.println("End");
    }
}