let $movies:= (doc("movieList.xml")/movieCatalog/movie)
return 
    <movieCatalog>
    {
        for $x in $movies  
        where ($x/year<2003) and ($x/rating>8.7) and (fn:exists(fn:index-of($x/directors/name,"Peter Jackson")))
        return $x
    }
    </movieCatalog>