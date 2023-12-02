import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int count = 0;
	
        SortedBinaryTree<SurveyStation> binaryTree = new SortedBinaryTree<>();

        SurveyStationAccess surveyAccess = new SurveyStationAccess("/Users/olepearse-danker/IdeaProjects/lab_vs_03_k/src/Messdaten.txt");
        ArrayList<SurveyStation> surveyStations = surveyAccess.getSurveyStations();

        // c) Die Klasse der 1. Aufgabe SurveyStation ist von der Node-Klasse
        // abzuleiten (siehe UML-Diagramm). Wählen Sie den stationName als Schlüssel.
        for (SurveyStation station : surveyStations) {
            binaryTree.insert(station);
        }

        // e) Nutzen Sie den Iterator des Binärbaums,
        // um inorder die ersten 10, jede 42: und die letzten 10 Messstationen auszugeben
        for (Node<SurveyStation> node : binaryTree) {
            if (count < 10 || count % 42 == 0 || count >= binaryTree.size() - 10) {
                System.out.println(node.getKey().getStationName() + ", ");
            }
            count++;
        }
		
		/* 
		int numberOfStations = surveyAccess.getNumberOfSurveyStations();  
		System.out.println("Anzahl der Messstationen: " + numberOfStations);

        SurveyStation lowestStation = surveyAccess.findLowestStation();
        System.out.println("Messstation mit niedrigster Höhe: " + lowestStation.getStationName() + " mit der Höhe " + lowestStation.getAltitude() );
 
        SurveyStation highestStation = surveyAccess.findHighestStation();
        System.out.println("Messstation mit höchster Höhe: " + highestStation.getStationName() + " mit der Höhe " + highestStation.getAltitude() );

        SurveyStation northernmostStation = surveyAccess.findNorthernmostStation();
        System.out.println("Nördlichste Messstation: " + northernmostStation.getStationName() + " " + northernmostStation.getLatitude() );
        
        SurveyStation southernmostStation = surveyAccess.findSouthernmostStation();
        System.out.println("Süderste Messstation: " + southernmostStation.getStationName() + " " + southernmostStation.getLatitude() );
        
        SurveyStation easternmostStation = surveyAccess.findEasternmostStation();
        System.out.println("Easterste Messstation: " + easternmostStation.getStationName() + " " + easternmostStation.getLongitude() );
        
        SurveyStation westernmostStation = surveyAccess.findWesternmostStation();
        System.out.println("Westlichste Messstation: " + westernmostStation.getStationName() + " " + westernmostStation.getLongitude() );
        */
 
	}
}
