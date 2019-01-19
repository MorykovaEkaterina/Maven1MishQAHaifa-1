package util;

import org.testng.annotations.DataProvider;
import pages.PageBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Inka on 13-Jan-19.
 */
public class DataProviders {
    @DataProvider
    public static Iterator<Object[]> loginPositive() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(DataProviders.class.getResourceAsStream("/LoginPositive.data")));
        List<Object[]> userData = new ArrayList<>();

        for(String line = in.readLine(); line != null; line = in.readLine()) {
            userData.add(line.split(";"));
        }

        in.close();
        return userData.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> loginNegative() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(DataProviders.class.getResourceAsStream("/LoginNegative.data")));
        List<Object[]> userData = new ArrayList<>();

        for(String line = in.readLine(); line != null; line = in.readLine()) {
            userData.add(line.split(";"));
        }

        in.close();
        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> createNewAccountsWithDataProvider() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(DataProviders.class.getResourceAsStream("/NewAccounts.data")));
        List<Object[]> userData = new ArrayList<>();

        for(String line = in.readLine(); line != null; line = in.readLine()) {
            userData.add(line.split(";"));
        }

        in.close();
        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> anotherPositiveLogin() {
        List<Object[]> data = new ArrayList();
        data.add(new Object[]{"marinaLongLongLong@gmail.com", "marinaLongLongLong"});
        data.add(new Object[]{"MaRina@123", "MaRina"});

        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomUsers() {
        List<Object[]> data = new ArrayList();

        for(int i = 0; i < 3; ++i) {
            data.add(new Object[]{this.generateRandomName(), this.generateRandomPassword()});
        }

        return data.iterator();
    }

/*    //Test for generateRandomName
    public static void main(String[] args) {
        System.out.println(generateRandomName());
    }*/

    private Object generateRandomPassword() {
        return "pass" + (new Random()).nextInt();
    }

    private static Object generateRandomName() {
        return (PageBase.latinDigitString(25))+"@katy.com";
    }

}
