package handler;

import dao.ClientDao;
import dao.HumanDao;
import di.Inject;
import model.Client;
import model.Human;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static ClientDao clientDao;

    @Inject
    private static HumanDao humanDao;

    static public void handle() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - если вносите клиента, 2 - если получаете клиентов, 3 - для выхода, " +
                    "4 - если вносите человек, 5 - если получаете человеков");
            int consoleChoice = scanner.nextInt();
            switch (consoleChoice) {
                case 1:
                    addClientInfo(scanner);
                    break;
                case 2:
                    System.out.println(clientDao.getAllClients());
                    break;
                case 3:
                    return;
                case 4:
                    addHumanInfo(scanner);
                    break;
                case 5:
                    System.out.println(humanDao.getAllHumans());
            }
        }
    }

    private static void addClientInfo(Scanner scanner) {
        System.out.println("Введите информацию о клиенте");
        System.out.println("Введите имя");
        String name = scanner.next();
        System.out.println("Введите телефон");
        String phone = scanner.next();
        Client client = new Client(name, phone);
        clientDao.saveClient(client);
    }
    private static void addHumanInfo(Scanner scanner) {
        System.out.println("Введите информацию о человеке");
        System.out.println("Введите имя");
        String name = scanner.next();
        System.out.println("Введите телефон");
        String phone = scanner.next();
        System.out.println("Введите сколько лет");
        int age = scanner.nextInt();
        Human human = new Human(name, phone,age);
        humanDao.saveHuman(human);
    }


}
