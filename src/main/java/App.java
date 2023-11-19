import com.patika.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Author a1 = new Author();
        a1.setName("Victor Marie Hugo");
        a1.setBirthDate(LocalDate.of(1802, 2, 26));
        a1.setCountry("Fransa");

        entityManager.persist(a1);


        Category c1 = new Category();
        c1.setName("Macera");
        c1.setDescription("Macera");

        entityManager.persist(c1);

        Category c2 = new Category();
        c2.setName("Bilim Kurgu");
        c2.setDescription("Bilim Kurgu");

        entityManager.persist(c2);

        Publisher p1  = new Publisher();
        p1.setAddress("Ankara");
        p1.setName("BKM Kitap");
        p1.setEstablishmentYear(1986);

        entityManager.persist(p1);

        Publisher p2 = new Publisher();
        p2.setAddress("Mersin");
        p2.setName("Huzur Kitapevi");
        p2.setEstablishmentYear(1955);

        entityManager.persist(p2);

        Book b1 = new Book();
        b1.setAuthor(a1);
        b1.setPublisher(p1);
        b1.setStock(5);
        b1.setName("Sefiller");
        b1.setPublicationYear(1996);

        entityManager.persist(b1);

        Book b2 = new Book();
        b2.setAuthor(a1);
        b2.setPublisher(p2);
        b2.setStock(8);
        b2.setName("Notre-Dame'ın Kamburu");
        b2.setPublicationYear(1992);

        entityManager.persist(b2);

        BookBorrow brw1 = new BookBorrow();
        brw1.setBorrowerName("Mehmet");
        brw1.setBorrowingDate(LocalDate.of(2023 , 5 , 25));
        brw1.setBook(b1);
        brw1.setReturnDate(LocalDate.of(2023 , 8 , 12));

        entityManager.persist(brw1);


        BookBorrow brw2 = new BookBorrow();
        brw2.setBorrowerName("Recep");
        brw2.setBorrowingDate(LocalDate.of(2023 , 7 , 22));
        brw2.setBook(b2);
        brw2.setReturnDate(LocalDate.of(2023 , 9 , 16));

        entityManager.persist(brw2);

        List<Book> a1BookList = new ArrayList<>();
        a1BookList.add(b1);
        a1BookList.add(b2);
        a1.setBookList(a1BookList);

        List<Category> b1CategoryList = new ArrayList<>();
        b1CategoryList.add(c1);
        List<Category> b2CategoryList = new ArrayList<>();
        b2CategoryList.add(c2);

        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(b2);

        List<BookBorrow> listB1 = new ArrayList<>();
        listB1.add(brw1);

        List<Book> bookList1 = new ArrayList<>();
        bookList1.add(b1);

        c1.setBookList(bookList1);
        c2.setBookList(bookList2);

        List<BookBorrow> listB2 = new ArrayList<>();
        listB2.add(brw2);

        p1.setBookList(bookList1);
        p2.setBookList(bookList2);

        b2.setBorrowList(listB2);
        b1.setBorrowList(listB1);

        b1.setCategoryList(b1CategoryList);
        b2.setCategoryList(b2CategoryList);

        entityManager.persist(b1);
        entityManager.persist(b2);

        transaction.commit();

        /* transaction.begin();

        Author a1 = new Author();
        a1.setName("Victor Marie Hugo");
        a1.setBirthDate(LocalDate.of(1802, 2, 26));
        a1.setCountry("Fransa");


        Category c1 = new Category();
        c1.setName("Macera");
        c1.setDescription("Macera");

        Category c2 = new Category();
        c2.setName("Bilim Kurgu");
        c2.setDescription("Bilim Kurgu");

        Publisher p1  = new Publisher();
        p1.setAddress("Ankara");
        p1.setName("BKM Kitap");
        p1.setEstablishmentYear(1986);

        Publisher p2 = new Publisher();
        p2.setAddress("Mersin");
        p2.setName("Huzur Kitapevi");
        p2.setEstablishmentYear(1955);

        Book b1 = new Book();
        b1.setAuthor(a1);
        b1.setPublisher(p1);
        b1.setStock(5);
        b1.setName("Sefiller");
        b1.setPublicationYear(1996);

        List<Book> bookList1 = new ArrayList<>();
        bookList1.add(b1);

        Book b2 = new Book();
        b2.setAuthor(a1);
        b2.setPublisher(p2);
        b2.setStock(8);
        b2.setName("Notre-Dame'ın Kamburu");
        b2.setPublicationYear(1992);
        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(b2);


        BookBorrow brw1 = new BookBorrow();
        brw1.setBorrowerName("Mehmet");
        brw1.setBorrowingDate(LocalDate.of(2023 , 5 , 25));
        brw1.setBook(b1);
        brw1.setReturnDate(LocalDate.of(2023 , 8 , 12));
        List<BookBorrow> listB1 = new ArrayList<>();
        listB1.add(brw1);

        BookBorrow brw2 = new BookBorrow();
        brw2.setBorrowerName("Recep");
        brw2.setBorrowingDate(LocalDate.of(2023 , 7 , 22));
        brw2.setBook(b2);
        brw2.setReturnDate(LocalDate.of(2023 , 9 , 16));
        List<BookBorrow> listB2 = new ArrayList<>();
        listB2.add(brw2);

        p1.setBookList(bookList1);
        p2.setBookList(bookList2);

        List<Book> a1BookList = new ArrayList<>();
        a1BookList.add(b1);
        a1BookList.add(b2);
        a1.setBookList(a1BookList);

        List<Category> b1CategoryList = new ArrayList<>();
        b1CategoryList.add(c1);
        List<Category> b2CategoryList = new ArrayList<>();
        b2CategoryList.add(c2);
        c1.setBookList(bookList1);
        c2.setBookList(bookList2);

        b2.setBorrowList(listB2);
        b1.setBorrowList(listB1);

        b1.setCategoryList(b1CategoryList);
        b2.setCategoryList(b2CategoryList);

        entityManager.persist(b1);
        entityManager.persist(b2);

        transaction.commit();*/






    }

}
