package petadoption;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        petService service = new petService();

        while (true) {
            System.out.println("\n1.Add  2.View(By ID)  3.View(By Species)  4.Update  5.Delete  6.Exit");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Pet ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Species: ");
                        String species = sc.nextLine();

                        System.out.print("Age: ");
                        String age = sc.nextLine();

                        service.addPet(id, name, species, age);
                        System.out.println("Pet added successfully");
                        break;

                    case 2:
                        service.viewPetsSortedById();
                        break;

                    case 3:
                        service.viewPetsSortedBySpecies();
                        break;

                    case 4:
                        System.out.print("Pet ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New Name: ");
                        String uname = sc.nextLine();

                        System.out.print("New Species: ");
                        String uspecies = sc.nextLine();

                        System.out.print("New Age: ");
                        String uage = sc.nextLine();

                        service.updatePet(uid, uname, uspecies, uage);
                        break;

                    case 5:
                        System.out.print("Pet ID to delete: ");
                        int did = sc.nextInt();
                        service.deletePet(did);
                        break;

                    case 6:
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
