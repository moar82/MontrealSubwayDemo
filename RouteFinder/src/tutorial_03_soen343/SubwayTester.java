package tutorial_03_soen343;

import java.io.*;
import java.util.*;

public class SubwayTester
{
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: SubwayTester \"StartStation\" \"endStation\" ");
            System.exit(-1);
        }
        try {
            SubwayLoader loader = new SubwayLoader();
            String subwayFilePath = "MontrealSubway.txt";
			Subway city = loader.loadFromFile(new File(subwayFilePath));
			
			String start = args[0];
			String end =  args[1];
            
            if (!city.hasStation(start)) {
                System.err.println(start + " is not a station in Montreal");
                System.exit(-1);
            } else if (!city.hasStation(end)) {
                System.err.println(end + " is not a station in Montreal");
                System.exit(-1);
            }
            
            List route = city.getDirections(start, end);
            SubwayPrinter printer = new SubwayPrinter(System.out);
            printer.printDirections(route);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
