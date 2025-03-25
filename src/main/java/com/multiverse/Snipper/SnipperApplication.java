package com.multiverse.Snipper;

import com.multiverse.Snipper.model.Snippet;
import com.multiverse.Snipper.repository.SnippetRepository;
import com.multiverse.Snipper.service.SnippetService;
import com.multiverse.Snipper.service.SnippetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnipperApplication implements CommandLineRunner {

	@Autowired
	private SnippetServiceImpl snippetServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SnipperApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Snippet[] snippets = new Snippet[] {
			new Snippet("Python", "print('Hello, World!')"),
			new Snippet("Python", "def add(a, b):\\n    return a + b\""),
			new Snippet("Python", "class Circle:\\n    def __init__(self, radius):\\n        self.radius = radius\\n\\n    def area(self):\\n        return 3.14 * self.radius ** 2"),
			new Snippet("JavaScript", "console.log('Hello, World!');"),
			new Snippet("JavaScript", "function multiply(a, b) {\\n    return a * b;\\n}"),
			new Snippet("JavaScript", "const square = num => num * num;"),
			new Snippet("Java", "public class HelloWorld {\\n    public static void main(String[] args) {\\n        System.out.println(\\\"Hello, World!\\\");\\n    }\\n}"),
			new Snippet("Java", "public class Rectangle {\\n    private int width;\\n    private int height;\\n\\n    public Rectangle(int width, int height) {\\n        this.width = width;\\n        this.height = height;\\n    }\\n\\n    public int getArea() {\\n        return width * height;\\n    }\\n}"),
		};

		for (Snippet snippet : snippets) {
			snippetServiceImpl.createSnippet(snippet);
		}
	}
}
