package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mata
 */
public class PerzistencijaZadatak {

    public static void main(String[] args) throws SQLException {

        doTheThing();

    }

    public static void doTheThing() throws SQLException {
        Scanner unos = new Scanner(System.in);
        System.out.println("Pozdrav!\n Izberi opciju?");
        System.out.println("(L)ist zaposleni,(S)earch,(C)hange,(D)elete,(A)dd novog ili (E)xit");
        String opcija = unos.nextLine();

        if (opcija.equalsIgnoreCase("l")) {
            System.out.println("Izaberi (L)ist");
            List<Podaci> pod = Podaci.List();
            for (Podaci pod1 : pod) {
                System.out.println(pod1);

            }
            doTheThing();
        } else if (opcija.equalsIgnoreCase("s")) {
            System.out.println("Unesi (S)earch");
            System.out.println("Unesi ime koje te zanima: ");
            String name = unos.nextLine();
            List<Podaci> pod = Podaci.Search(name);
            if (pod.isEmpty()) {
                System.out.println("Ne postoji!");
                doTheThing();
            }
            for (Podaci pod1 : pod) {

                System.out.println(pod1);

            }
            doTheThing();
        } else if (opcija.equalsIgnoreCase("c")) {
            System.out.println("Izaberi (C)hange");
            List<Podaci> pod = Podaci.List();
            for (Podaci pod1 : pod) {
                System.out.println(pod1);

            }
            Podaci p = new Podaci();
            System.out.print("Unesi id zaposlenog koji zelis da izmenis: ");
            p.setId(unos.nextInt());
            unos.nextLine();
            System.out.println("Sta zelis da izmenis?Unesi vd za visinu dohotka ili a za adresu");
            String choice = unos.nextLine();
            if (choice.equalsIgnoreCase("vd")) {
                System.out.println("Unesi novu visinu dohotka:");
                p.setVisinaDohotka(unos.nextInt());
                p.UpdateVisinaDohotka();
            } else if (choice.equalsIgnoreCase("a")) {
                System.out.println("Unesi novu adresu: ");
                p.setAdresa(unos.nextLine());
                p.UpdateAdresa();
            }
            doTheThing();
        } else if (opcija.equalsIgnoreCase("d")) {
            System.out.println("Izaberi (D)elete");
            List<Podaci> pod = Podaci.List();
            for (Podaci pod1 : pod) {
                System.out.println(pod1);

            }
            Podaci p = new Podaci();
            System.out.print("Unesi id zaposlenog kojeg zelis da izbrises: ");
            p.setId(unos.nextInt());
            unos.nextLine();
            p.Delete();
            doTheThing();
        } else if (opcija.equalsIgnoreCase("a")) {
            System.out.println("Izaberi (A)dd novog zaposlenog");
            Podaci p = new Podaci();
            System.out.println("Unesi ime: ");
            p.setIme(unos.nextLine());
            System.out.println("Unesi broj godina: ");
            p.setBrojGodina(unos.nextInt());
            System.out.println("Unesi adresu: ");
            p.setAdresa(unos.next());
            System.out.println("Unesi visinu dohotka: ");
            p.setVisinaDohotka(unos.nextInt());
            p.Add();
            doTheThing();
        } else if (opcija.equalsIgnoreCase("e")) {
            System.out.println("Izaberi (E)xit");
            System.exit(0);
        } else {
            System.out.println("You chosee unknown option.Please try again");
            doTheThing();
        }
    }
}
