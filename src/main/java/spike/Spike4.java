package spike;

import Service.*;
import domain.Person;
import domain.Site;

import java.util.ArrayList;
import java.util.List;

public class Spike4 {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        List<Site> sites = new ArrayList<>();

        //Fyller listorna

        list.add(new Person("Test Ett", 2001,1));
        list.add(new Person("Test två", 2002,2));
        list.add(new Person("Test Tre", 2003,3));

        sites.add(new Site("Downingstreet", "London", "Birmingham", "England", 80267, 10));
        sites.add(new Site("Kungsbäcksvägen", "Gävle", "Gävle kommun", "Sverige", 80267, 12));
        sites.add(new Site("Stenhammarsvägen", "Gävle", "Gävle kommun", "Sverige", 80267, 34));


        //save site service
        SaveSiteService saveSiteService1 = new SaveSiteService(sites.get(0));
        SaveSiteService saveSiteService2 = new SaveSiteService(sites.get(1));
        SaveSiteService saveSiteService3 = new SaveSiteService(sites.get(2));

        saveSiteService1.execute();
        saveSiteService2.execute();
        saveSiteService3.execute();

        GetAllSiteService getAllSiteService = new GetAllSiteService();

        sites = getAllSiteService.execute();
        for (Site site : sites) {
            System.out.println(site);
        }

        System.out.println("-------------PersonService------------");
        PersonService personService = new PersonService();
        for (Person person : list) {
           personService.save(person);
        }
        list = personService.getAll();
        for (Person person : list) {
            System.out.println(person);
        }
        System.out.println("--------Get Site By ID Test--------------");
        for(int i = 1; i< 4; i++)
            System.out.println(new GetSiteByPersonIdService(i).execute());
//        System.out.println("--------Delete site service--------------");
//        System.out.println(new DeleteSiteService(sites.get(1)).execute());
//        System.out.println("--------Get Site By ID Test--------------");
//        System.out.println(new GetSiteBySiteIdService(2).execute());

        System.out.println(personService.getPersonById(1));
        //Funkar som förväntat



        //Update site Service
//        UpdateSiteService updateSiteService1 = new UpdateSiteService(sites.get(1));
//        UpdateSiteService updateSiteService2 = new UpdateSiteService(sites.get(2));
//        UpdateSiteService updateSiteService3 = new UpdateSiteService(sites.get(3));
//
//        updateSiteService1.execute();
//        updateSiteService2.execute();
//        updateSiteService3.execute();
    }
}
