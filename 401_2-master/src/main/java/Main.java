import dao.BookDAO;
import models.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.print("Available models: ");
            System.out.println(Main.availableModels());
            System.out.println("Input model");
            String model = br.readLine();
            System.out.println("Available methods: ");
            System.out.println(Main.availableMethods(model));
            System.out.println("Input action");
            String action = br.readLine();
            doAction(model, action);
        }
    }


    public static String availableModels() {
        return "enterprise, service";
    }
    public static String availableMethods (String model) {
        switch (model) {
            case "enterprise" :
                return  "create, read, update, delete, findByAuthor, findAll";
            case "service" :
                return  "create, read, update, delete, findAll";
        }
        return "";
    }
    public static void doAction(String model, String action) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Book e = null;


        switch (model) {
            case "enterprise":
                switch (action) {
                    case "create":
                        e = new Book();
                        System.out.println("Input enterprise name:");
                        e.setName(br.readLine());
                        System.out.println("Input enterprise branch:");
                        e.setBranch(br.readLine());
                        System.out.println("Input enterprise employee count:");
                        e.setEmployeeCount(Integer.valueOf(br.readLine()));
                        e = BookDAO.create(e);
                        System.out.println("Model saved " + e);
                        return;

                    case "read":
                        System.out.println("Input enterprise model id:");
                        e = BookDAO.read(Integer.valueOf(br.readLine()));

                        if (e == null) {
                            System.out.println("Model didn't find");
                            return;
                        }

                        System.out.println(e);
                        return;

                    case "update":
                        System.out.println("Input enterprise model id witch you want update:");
                        e = BookDAO.read(Integer.valueOf(br.readLine()));

                        if (e == null) {
                            System.out.println("Model didn't find");
                            return;
                        }

                        System.out.println("Input enterprise name (old " + e.getName() + "):");
                        e.setName(br.readLine());
                        System.out.println("Input enterprise branch (old " + e.getBranch() + "):");
                        e.setBranch(br.readLine());
                        System.out.println("Input enterprise employee count (old " + e.getEmployeeCount() + "):");
                        e.setEmployeeCount(Integer.valueOf(br.readLine()));

                        BookDAO.update(e);
                        return;

                    case "delete":
                        System.out.println("Input enterprise model id:");
                        int id =Integer.valueOf(br.readLine());
                        e = BookDAO.read(id);

                        if (e == null) {
                            System.out.println("Model didn't find");
                            return;
                        }

                        BookDAO.delete(id);

                        System.out.println("Model was deleted");
                        return;

                    case "findByAuthor":
                        System.out.println("Input branch:");
                        List<Book> list = BookDAO.findByAuthor(br.readLine());

                        if (list.size() == 0) {
                            System.out.println("Models didn't find");
                            return;
                        }

                        System.out.println(list);
                        return;
                    case "findAll":
                        List<Book> allItemsList = BookDAO.findAll();

                        if (allItemsList.size() == 0) {
                            System.out.println("Models didn't find");
                            return;
                        }

                        System.out.println(allItemsList);
                        return;

                }

        }
    }
}
