<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html lang="en" dir="ltr">
      <head>
        <title></title>
      </head>
      <body>
        <h1>Receta: <xsl:value-of select="//nombre" /> </h1>
        <table border="1">
          <tr>
            <th>Ingredientes</th>
            <th>Cantidad</th>
          </tr>
          <xsl:for-each select="//ingrediente">
          <xsl:sort select="@cantidad" data-type="number" />
            <tr>
              <td><xsl:value-of select="." /></td>
              <td><xsl:value-of select="@cantidad" /></td>
            </tr>
          </xsl:for-each>          
        </table>
        <ol>
          <xsl:for-each select="//paso">
            <li><xsl:value-of select="." /></li>
          </xsl:for-each>
        </ol>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
