package createData;

import com.github.javafaker.*;

import java.util.Locale;

/**
 * Created by bigdata on 18-1-8.
 * faker 造数据
 */
public class createData {
    public static void main(String[] args) {

        Faker faker =new Faker(Locale.CHINA);

        Internet internet = faker.internet();

        for (int i = 0; i < 100; i++) {
            System.out.println(internet.url());
        }

        Book book = faker.book();
        System.out.println(book.author());

//        faker.s
        Name name = faker.name();
        System.out.println(name.name());
        Address address = faker.address();
        System.out.println(address.city());

    }
}
