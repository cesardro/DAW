<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  <html lang="en" dir="ltr">
    <head>
      <title></title>
    </head>
    <body>
      <b><xsl:value-of select="pelicula/@titulo" /></b>
      <p>
        <u>Director</u>: 
        <xsl:value-of select="pelicula/direccion/director/@nombre" />
        <xsl:value-of select="pelicula/direccion/director/@apellidos "/>
      </p>
      <p>
        <u>Interpretes</u>: 
        <br></br>
        <xsl:for-each select="pelicula/reparto/interprete" >
          <xsl:value-of select="./@nombre" />
          <xsl:value-of select="./@apellidos" />
          <br></br>
        </xsl:for-each>
      </p>
    </body>
  </html>
  </xsl:template>
</xsl:stylesheet>
