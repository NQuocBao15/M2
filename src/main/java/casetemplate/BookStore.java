package casetemplate;

import java.util.*;

public class BookStore {
//    private Book [] books;
    List<Book> books;

    private Scanner scanner = new Scanner(System.in);
    public BookStore() {
        // Ở đây áp dụng tính chất gì:
        books = new ArrayList<>();

//        long id, String name, String description, Date entryDate, double price)
        Book book = new Book(1L, "fChị Dậu", "chị dậu....", new Date(), 10000.0d);
        books.add(book);
        books.add(new Book(2L, "dChí Phèo", "chí phèo....", new Date(), 20000.0d));
        books.add(new Book(3L, "aChí Phèo3", "chí phèo3....", new Date(), 30000.0d));
        books.add(new Book(19L, "cChí Phèo4", "chí phèo4....", new Date(), 40000.0d));
        books.add(new Book(5L, "aaChí Phèo5", "chí phèo5....", new Date(), 50000.0d));
        books.add(new Book(6L, "Chí Phèo6", "chí phèo6....", new Date(), 60000.0d));
    }
    public void showBooks(){
        System.out.printf("%5s | %30s | %20s | %30s | %10s \n", "ID", "Name", "Description", "Date", "Price");
        for (int i = 0; i < books.size(); i++) {
            Book book  =  books.get(i);
            System.out.printf("%5s | %30s | %20s | %30s | %10s \n",
                    book.getId(),book.getName(),book.getDescription(),
                    book.getEntryDate(), book.getPrice());
        }
    }

    public void showBooks(List<Book> books) {
        System.out.printf("%5s | %30s | %20s | %30s | %10s \n", "ID", "Name", "Description", "Date", "Price");
        for (int i = 0; i < books.size(); i++) {
            Book book  =  books.get(i);
            System.out.printf("%5s | %30s | %20s | %30s | %10s \n",
                    book.getId(),book.getName(),book.getDescription(),
                    book.getEntryDate(), book.getPrice());
        }
    }

    public void addBook(){
        System.out.println("Nhập thông tin sách:");
        System.out.println("Nhập tên sách:");
        String name = scanner.nextLine();
        System.out.println("Nhập mo tả: ");
        String description = scanner.nextLine();

        System.out.println("Nhập giá");
        double price = Double.parseDouble(scanner.nextLine());

        Comparator<Book> comparator = new ComparatorById();
        books.sort(comparator);
        long maxId = books.get(books.size()-1).getId();

        Book book = new Book();
        book.setId(maxId + 1);
        book.setName(name);
        book.setDescription(description);
        book.setPrice(price);
        book.setEntryDate(new Date());

        books.add(book);

        showBooks();


    }

    public void editBook(){
        System.out.println("Nhập ID bạn muốn sửa: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Nhập tên mới: ");
        String nameNew = scanner.nextLine();
        System.out.println("Nhập mô tả mới: ");
        String descriptionNew = scanner.nextLine();
        System.out.println("Nhập giá mới: ");
        double priceNew = Double.parseDouble(scanner.nextLine());

        for (int i = 0; i < books.size(); i++) {
            if (id == books.get(i).getId()) {
                books.get(i).setName(nameNew);
                books.get(i).setDescription(descriptionNew);
                books.get(i).setPrice(priceNew);
            }
        }
        showBooks();
    }

    public void deleteBook() {
        System.out.println("Nhập sách bạn muốn xóa: ");
        long id = Long.parseLong(scanner.nextLine());

        for (int i = 0; i < books.size(); i++) {
            if (id == books.get(i).getId()) {
                books.remove(i);
            }
        }
        showBooks();
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BookStore bookStore = new BookStore();
        boolean checkActionMenu = true;
        do {
            System.out.println("Menu quản lý sách: ");
            System.out.println("Nhấn 1. Xem danh sách");
            System.out.println("Nhấn 2. Thêm sách");
            System.out.println("Nhấn 3. Sửa sách");
            System.out.println("Nhấn 4. Xóa sách");
            System.out.println("Nhấn 5. Sắp xếp sách theo giá ");
            System.out.println("Nhấn 6. Sắp xếp sách theo tên ");
            System.out.println("Nhấn 7. Tìm kiếm sách theo tên");
            System.out.println("Nhấn 8. Tìm kiếm sách theo tên hoặc mô tả");
            int actionMenu = Integer.parseInt(scan.nextLine());
            switch (actionMenu) {
                case 1:
                    bookStore.showBooks();
                    break;
                case 2:
                    bookStore.addBook();
                    break;
                case 3:
                    bookStore.editBook();
                    break;
                case 4:
                    bookStore.deleteBook();
                    break;
                case 5:
                    bookStore.sortByPrice();
                    break;
                case 6:
                    bookStore.sortByName();
                    break;
                case 7:
                    bookStore.searchByName();
                    break;
                default:
                    System.out.println("Nhập sai rồi bạn ơi! Vui lòng nhập lại");
            }
            boolean checkActionMenuContinue = true;
            do {
                System.out.println("Bạn có muốn tiếp tục hay không: Y/N");
                String actionMenuContinue = scan.nextLine();
                switch (actionMenuContinue) {
                    case "Y":
                        checkActionMenu = true;
                        checkActionMenuContinue = false;
                        break;
                    case "N":
                        checkActionMenu = false;
                        checkActionMenuContinue = false;
                        break;
                    default:
                        checkActionMenuContinue = true;
                }
            }while (checkActionMenuContinue) ;

            } while (checkActionMenu);

    }

    private void searchByName() {
        System.out.println("Nhập tên bạn muốn tìm kiếm: ");
        String kw = scanner.nextLine();
        List<Book> results = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getName().contains(kw)){
                results.add(books.get(i));
            }
        }
        showBooks(results);
    }

    private void sortByName() {
//        books.sort(new ComparatorByName());
        showBooks();
    }

    private void sortByPrice() {
//        Comparator comparator = new ComparatorByPrice();
        books.sort(new ComparatorByPrice());
        showBooks();
    }

}
