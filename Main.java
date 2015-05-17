import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Container<First> list = new Container<First>(5);

		list.add(new Second("first name book", 10, 100, "font1"));
		list.add(new Second("second name book", 20, 200, "font2"));
		list.add(new Second("three name book", 30, 300, "font3"));
		list.add(new Second("four name book", 40, 400, "font4"));
		list.add(new Second("five name book", 50, 500, "font5"));

		System.out.println(list);
		list.sort();
		System.out.println(list);
		System.out.println("Ball-avg: " + Second.avgPrice());

	}
}

abstract class First implements Comparable<First> {
	protected String nameBook;
	protected double priceBook;

	First() {
		this("unknown", 0);
	}

	First(String nameBook, double priceBook) {
		setNameBook(nameBook);
		setPriceBook(priceBook);

	}

	public double getPriceBook() {
		return priceBook;
	}

	public void setPriceBook(double priceBook) {
		this.priceBook = priceBook;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Name: " + nameBook + " ").append(
				"Price: " + priceBook + " ");
		return str.toString();
	}

	public int compareTo(First o) {
		if (this.priceBook > o.priceBook)
			return -1;
		else if (this.priceBook < o.priceBook)
			return 1;
		else
			return 0;
	}
}

class Second extends First {
	private int numberPageBook;
	private String fontBook;
	private static int count = 0;
	private static double priceBook = 0;

	Second() {
		this("unknown", 0.0, 0, "unknown");
	}

	Second(String nameBook, double priceBook, int pageCount, String fontBook) {
		super(nameBook, priceBook);
		count++;
		this.priceBook += priceBook;
		setNumberPageBook(numberPageBook);
		setFontBook(fontBook);
	}

	public String getFontBook() {
		return fontBook;
	}

	public void setFontBook(String fontBook) {
		this.fontBook = fontBook;
	}

	public static int getCount() {
		return count;
	}

	public int getNumberPageBook() {
		return numberPageBook;
	}

	public void setNumberPageBook(int numberPageBook) {
		this.numberPageBook = numberPageBook;
	}

	public static double avgPrice() {
		return priceBook / count;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(nameBook + " ").append(priceBook + " ")
				.append(numberPageBook + " ").append(fontBook + " ");
		return str.toString().trim();
	}
}

class Container<T extends First> {
	private First[] array;
	private int pointer;

	Container(int count) {
		array = new First[count];
		pointer = 0;
	}

	public void add(T obj) {
		if (pointer < array.length) {
			array[pointer++] = obj;
		} else {
			First[] temp = new First[size() + 10];
			int i, j;
			for (i = 0, j = 0; i < array.length; i++, j++) {
				temp[i] = array[j];
			}
			temp[i] = obj;
			array = temp;
		}
	}

	public T get(int index) {
		int i = 0;
		while (++i != index)
			;
		return (T) array[i];
	}

	public int count() {
		return pointer;
	}

	public int size() {
		return array.length;
	}

	public void sort() {
		Arrays.sort(array, 0, pointer);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < pointer; i++) {
			str.append(array[i].toString() + "\n");
		}
		return str.toString();
	}
}