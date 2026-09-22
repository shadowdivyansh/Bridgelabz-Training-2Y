import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    double price;
    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

public class LibraryManagementSystem {
    public static int removeDuplicates(Book[] b, int n) {
        if (n == 0) return 0;
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (b[i].bookId != b[j].bookId) { j++; b[j] = b[i]; }
        }
        return j + 1;
    }

    public static void searchByTitle(Book[] b, int cnt, String query) {
        String q = query.toLowerCase();
        System.out.println("Search Results for '" + query + "':");
        for (int i = 0; i < cnt; i++)
            if (b[i].title.toLowerCase().contains(q))
                System.out.println("- Found: [" + b[i].bookId + "] " + b[i].title + " (Rs. " + b[i].price + ")");
    }

    public static void sortByPrice(Book[] b, int cnt) {
        int swaps = 0;
        for (int i = 0; i < cnt - 1; i++) {
            int min = i;
            for (int j = i + 1; j < cnt; j++)
                if (b[j].price < b[min].price) min = j;
            if (min != i) { Book t = b[i]; b[i] = b[min]; b[min] = t; swaps++; }
        }
        System.out.println("Books Sorted by Price:");
        for (int i = 0; i < cnt; i++)
            System.out.println((i + 1) + ". [" + b[i].bookId + "] " + b[i].title + " - Rs. " + b[i].price);
        System.out.println("Total Swaps: " + swaps);
    }

    public static int searchByPrice(Book[] b, int cnt, double target) {
        int lo = 0, hi = cnt - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (b[mid].price == target) return mid;
            else if (b[mid].price < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static int minBooksForTargetCost(Book[] b, int cnt, double target) {
        int lt = 0, ans = Integer.MAX_VALUE;
        double sum = 0;
        for (int rt = 0; rt < cnt; rt++) {
            sum += b[rt].price;
            while (sum >= target) {
                ans = Math.min(ans, rt - lt + 1);
                sum -= b[lt].price;
                lt++;
            }
        }
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Book " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Title: ");
            String title = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            books[i] = new Book(id, title, author, price);
        }

        int count = removeDuplicates(books, n);
        System.out.println("Unique Books Count: " + count);
        for (int i = 0; i < count; i++)
            System.out.println("[" + books[i].bookId + "] " + books[i].title + " - Rs. " + books[i].price);

        sc.nextLine();
        System.out.print("Enter search word for title: ");
        String query = sc.nextLine();
        searchByTitle(books, count, query);

        sortByPrice(books, count);

        System.out.print("Enter price to search: ");
        double p = sc.nextDouble();
        int idx = searchByPrice(books, count, p);
        System.out.println("Searching for Price Rs. " + p + "...");
        if (idx != -1)
            System.out.println("Result: Book found at index " + idx + ": [" + books[idx].bookId + "] " + books[idx].title + " (Rs. " + books[idx].price + ")");
        else
            System.out.println("Result: Book not found");

        System.out.print("Enter target cost S: ");
        double s = sc.nextDouble();
        System.out.println("Finding minimum consecutive books whose total price >= Rs. " + s + "...");
        System.out.println("Minimum Consecutive Books Needed: " + minBooksForTargetCost(books, count, s));
    }
}