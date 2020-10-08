package tutorial_03_soen343;

import java.io.File;

public class LoadTester
{
    public static void main(String[] args) {
        try {
            SubwayLoader loader = new SubwayLoader();
            String subwayFilePath = "MontrealSubway.txt";
			Subway city = loader.loadFromFile(new File(subwayFilePath));
            
            System.out.println("Testing stations");
            if (    city.hasStation("Guy Concordia") &&
                    city.hasStation("Snowdon") &&
                    city.hasStation("Berri UQAM")) {
                System.out.println("... station test passed successfully.");
            }
            else
            {
                System.out.println("...station test FAILED.");
                System.exit(-1);
            }
            
            System.out.println("\nTesting connections...");
            if (city.hasConnection("Atwater", "Guy Concordia", "Green Line") &&
                city.hasConnection("Cote Vertu", "Du College", "Orange Line") &&
                city.hasConnection("Snowdon", "Cote des Neiges", "Blue Line")) {
                System.out.println("...connections test passed succesfully.");
            }
            else
            {
                System.out.println("...connections test FAILED");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
