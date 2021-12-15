package project1.selector;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import generated.MovieCatalog;
import project1.common.Common;

public class Selector {
	/**
	 * @param amcs
	 */
	public static void main(String[] amcs) {

		String outputFile = "xmlAfterSelector.xml";
		MovieCatalog mc = Common.jaxbXMLFileToObject("movieList.xml", "movieList.xsd");

		boolean done = false;
		while (!done) {
			System.out.println("****************Selector****************");
			System.out.println("Perform selection by: ");
			System.out.println("(1) Director");
			System.out.println("(2) Title");
			System.out.println("(3) Rating");
			System.out.println("(4) Number of ratings");
			System.out.println("(5) Popularity rank");
			System.out.println("(6) Publication date");
			System.out.println("\n(7) List Movies");
			System.out.println("\n(0) Exit");

			int option = Common.lerInt(0, 7);
			int option2 = 1;

			switch (option) {
				case 1:// Director
					List<String> directorNames = mc.getListDirectors();
					List<String> selectedDirectorNames = new ArrayList<>();

					for (int i = 0; i < directorNames.size(); i++) {
						System.out.println("(" + (i + 1) + ")" + directorNames.get(i));
					}
					System.out.println("\n(0) Done");

					System.out.println("Keep on selecting more directors until you're done.");

					while (option2 != 0) {
						option2 = Common.lerInt(0, directorNames.size());
						if (option2 != 0) {
							selectedDirectorNames.add(directorNames.get(option2 - 1));
						}
					}

					mc.getMovie().removeIf((movie) -> !Common.containsAtLeastOne(movie.getDirectors().getName(),
							selectedDirectorNames));
					Common.jaxbObjectToXML(mc, outputFile);
					break;

				case 2:// Title
					List<String> titles = mc.getListTitles();
					List<String> selectedTitles = new ArrayList<>();

					for (int i = 0; i < titles.size(); i++) {
						System.out.println("(" + (i + 1) + ")" + titles.get(i));
					}
					System.out.println("\n(0) Done");

					System.out.println("Keep on selecting more titles until you're done.");

					while (option2 != 0) {
						option2 = Common.lerInt(0, titles.size());
						if (option2 != 0) {
							selectedTitles.add(titles.get(option2 - 1));
						}
					}

					mc.getMovie().removeIf((movie) -> !selectedTitles.contains(movie.getTitle()));
					Common.jaxbObjectToXML(mc, outputFile);
					break;

				case 3:// Rating
					while (option2 != 0) {
						System.out.println(mc);
						System.out.println("(1) Higher or equal");
						System.out.println("(2) Equal");
						System.out.println("(3) Lower or equal");
						System.out.println("\n(0) Done");
						option2 = Common.lerInt(0, 3);
						BigDecimal optionBD;
						switch (option2) {
							case 1:
								System.out.println("Select movies rated higher or equal to: ");
								optionBD = Common.lerBigDecimal(BigDecimal.ZERO, BigDecimal.TEN);
								mc.getMovie().removeIf((movie) -> movie.getRating().compareTo(optionBD) < 0);
								break;
							case 2:
								System.out.println("Select movies rated equal to: ");
								optionBD = Common.lerBigDecimal(BigDecimal.ZERO, BigDecimal.TEN);
								mc.getMovie().removeIf((movie) -> movie.getRating().compareTo(optionBD) != 0);
								break;
							case 3:
								System.out.println("Select movies rated lower or equal to: ");
								optionBD = Common.lerBigDecimal(BigDecimal.ZERO, BigDecimal.TEN);
								mc.getMovie().removeIf((movie) -> movie.getRating().compareTo(optionBD) > 0);
								break;
							default:
								break;
						}
					}
					Common.jaxbObjectToXML(mc, outputFile);
					break;

				case 4:// Number of ratings
					while (option2 != 0) {
						System.out.println(mc);
						System.out.println("(1) Higher or equal");
						System.out.println("(2) Equal");
						System.out.println("(3) Lower or equal");
						System.out.println("\n(0) Done");
						option2 = Common.lerInt(0, 3);
						BigInteger optionBI;
						switch (option2) {
							case 1:
								System.out.println("Number of ratings higher or equal to: ");
								optionBI = Common.lerBigInt(BigInteger.ZERO);
								mc.getMovie().removeIf((movie) -> movie.getNumberRatings().compareTo(optionBI) < 0);
								break;
							case 2:
								System.out.println("Number of ratings equal to: ");
								optionBI = Common.lerBigInt(BigInteger.ZERO);
								mc.getMovie().removeIf((movie) -> movie.getNumberRatings().compareTo(optionBI) != 0);
								break;
							case 3:
								System.out.println("Number of ratings lower or equal to: ");
								optionBI = Common.lerBigInt(BigInteger.ZERO);
								mc.getMovie().removeIf((movie) -> movie.getNumberRatings().compareTo(optionBI) > 0);
								break;
							default:
								break;
						}
					}
					Common.jaxbObjectToXML(mc, outputFile);
					break;
				case 5:// Popularity rank
					while (option2 != 0) {
						System.out.println(mc);
						System.out.println("(1) Better or equal");
						System.out.println("(2) Equal");
						System.out.println("(3) Worse or equal");
						System.out.println("\n(0) Done");
						option2 = Common.lerInt(0, 3);
						BigInteger optionBI;
						switch (option2) {
							case 1:
								System.out.println("Select movies with popularity rank better or equal to: ");
								optionBI = Common.lerBigInt(BigInteger.ZERO);
								mc.getMovie().removeIf((movie) -> movie.getPopularity().compareTo(optionBI) > 0);
								break;
							case 2:
								System.out.println("Select movie with popularity rank equal to: ");
								optionBI = Common.lerBigInt(BigInteger.ZERO);
								mc.getMovie().removeIf((movie) -> movie.getPopularity().compareTo(optionBI) != 0);
								break;
							case 3:
								System.out.println("Select movies with popularity rank worse or equal to: ");
								optionBI = Common.lerBigInt(BigInteger.ZERO);
								mc.getMovie().removeIf((movie) -> movie.getPopularity().compareTo(optionBI) < 0);
								break;
							default:
								break;
						}
					}
					Common.jaxbObjectToXML(mc, outputFile);
					break;

				case 6:// Publication date
					while (option2 != 0) {
						System.out.println(mc);
						System.out.println("(1) Same year or later");
						System.out.println("(2) Same year");
						System.out.println("(3) Same year or before");
						System.out.println("\n(0) Done");
						option2 = Common.lerInt(0, 3);
						BigInteger optionBI;
						switch (option2) {
							case 1:
								System.out.println("On or after year: ");
								optionBI = Common.lerBigInt(BigInteger.ZERO);
								mc.getMovie().removeIf((movie) -> movie.getYear().compareTo(optionBI) < 0);
								break;
							case 2:
								System.out.println("On year: ");
								optionBI = Common.lerBigInt(BigInteger.ZERO);
								mc.getMovie().removeIf((movie) -> movie.getYear().compareTo(optionBI) != 0);
								break;
							case 3:
								System.out.println("On or before year: ");
								optionBI = Common.lerBigInt(BigInteger.ZERO);
								mc.getMovie().removeIf((movie) -> movie.getYear().compareTo(optionBI) > 0);
								break;
							default:
								break;
						}
					}
					Common.jaxbObjectToXML(mc, outputFile);
					break;
				case 7:
					System.out.println(mc);
					break;
				case 0:// Exit
					System.out.println("You have successfully exited the Selector.");
					done = true;
					break;
				default:
					break;
			}
		}
	}

}
