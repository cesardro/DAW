<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html lang="en" dir="ltr">
      <head>
       <title></title>
       <link rel="stylesheet" href="superman.css"/>
      </head>
      <body>
        <h1>Mis peliculas</h1>
        <h2 class="titulo"><xsl:value-of select="pelicula/titulo"/></h2>
        <xsl:element name="img">
          <xsl:attribute name="src">
            <xsl:value-of select="pelicula/imagen"/>
          </xsl:attribute>
          <xsl:attribute name="height">
            300px
          </xsl:attribute>
        </xsl:element>
        <p id="argumentos"><xsl:value-of select="pelicula/argumento"/></p>
        <p>
          Para más información
          <xsl:element name="a">
            <xsl:attribute name="href">
              <xsl:value-of select="pelicula/informacion"/>
            </xsl:attribute>
            click aquí.
          </xsl:element>
        </p>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
