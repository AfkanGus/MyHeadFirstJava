package com.taly.TestTree;

import java.util.TreeSet;

/**
 * Created by Taly on 11.05.2018.
 */
public class TestTree{
	public static void main(String[] args) {
		new TestTree().go();
	}

	public void go(){
		Book b1 = new Book("Как устроены кошки");
		Book b2 = new Book("Постройте заново свое тело");
		Book b3 = new Book("В поисках Эмо");

		TreeSet<Book> tree = new TreeSet<Book>();
		tree.add(b1);
		tree.add(b2);
		tree.add(b3);
		System.out.println(tree);
		for (Book el: tree) {
			System.out.println(el.title);
		}
	}

	class Book implements Comparable{
		String title;
		public Book(String t){
			title = t;
		}

		@Override
		public int compareTo(Object o) {
			Book book = (Book) o;
			return title.compareTo(book.title);
		}
	}


}
