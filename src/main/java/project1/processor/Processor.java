/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.processor;

import java.math.BigInteger;

import generated.DirectorList;
import generated.DirectorMovies;
import generated.MovieCatalog;
import project1.common.Common;

public class Processor {

    /**
     * @param amcs
     */
    public static void main(String[] amcs) {
        String outputFile = "xmlAfterProcessor.xml";
        MovieCatalog mc = Common.jaxbXMLFileToObject("xmlAfterSelector.xml", "movieList.xsd");

        DirectorList dl = new DirectorList();
        mc.getListDirectors().forEach(n -> {
            DirectorMovies dm = new DirectorMovies();
            dm.setName(n);
            dl.getDirectorMovies().add(dm);
        });

        System.out.println("****************Processor****************");
        System.out.println("Number of directors: ");
        int numDir = Common.lerInt(0, dl.getDirectorMovies().size());

        // sorts movies by popularity
        mc.getMovie().sort((m1, m2) -> m1.getPopularity().compareTo(m2.getPopularity()));
        System.out.println(mc);
        // adds ordered movies to each director
        dl.getDirectorMovies().forEach(dm -> {
            mc.getMovie().stream().filter(m -> m.getDirectors().getName().contains(dm.getName())).forEach(m -> {
                dm.getMovieCatalog().getMovie().add(m);
            });

        });

        dl.getStats().setNumberDirectors(BigInteger.valueOf(numDir));
        dl.getStats().getDirectors().getName().addAll(mc.getListDirectors().subList(0, numDir));

        Common.jaxbObjectToXML(dl, outputFile);
    }

}
