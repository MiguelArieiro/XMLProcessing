<?xml version="1.0" encoding="UTF-8"?>
<html xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xsl:version="1.0">
	<head>
		<title>HTML Viewer</title>
	</head>
	<body>
		<h1 >Directors' list</h1>
			<xsl:for-each select="/directorList/directorMovies">
					<h2>Director: <xsl:value-of select="name"/></h2>
						<ul>
						<xsl:for-each select="movieCatalog/movie">
						<dl>
		  					<dt><h4><b>Movie: <xsl:value-of select="title"/></b> (<xsl:value-of select="year"/>)</h4></dt> 
							  	
							  	<ul style="list-style-type:square;">
									<dt>Description: <xsl:value-of select="description"/></dt>
									<dt>Duration: <xsl:value-of select="duration"/></dt>
									<dt>Rating: <xsl:value-of select="rating"/>/10 (<xsl:value-of select="numberRatings"/>)</dt>
									<dt>Popularity rank: #<xsl:value-of select="popularity"/></dt>
				 					<dt>Directors: </dt>
				 						<xsl:for-each select="directors/name">
				  							<ul style="list-style-type:square;">
				  								<li> <xsl:value-of select="."/></li>
				 							</ul>
				 						</xsl:for-each>

									<dt>Writers: </dt>
				 						<xsl:for-each select="writers/name">
				  							<ul style="list-style-type:square;">
				  								<li> <xsl:value-of select="."/></li>
				 							</ul>
				 						</xsl:for-each>
									
									<dt>Cast: </dt>
										<xsl:for-each select="cast/name">
											<ul style="list-style-type:square;">
												<li> <xsl:value-of select="."/></li>
											</ul>
										</xsl:for-each>
		 						</ul>
		 					</dl>
					</xsl:for-each>
				</ul>
			</xsl:for-each>

			<h1>Statistics</h1>
			<xsl:for-each select="/directorList/stats">
				<dt>Number of analised directors: <xsl:value-of select="numberDirectors"/></dt>
				<dt>Most popular directors: </dt>
					<ol>
					<xsl:for-each select="directors/name">
						<li> <xsl:value-of select="."/> </li>
					</xsl:for-each>
					</ol>
			</xsl:for-each>
	</body>
</html>