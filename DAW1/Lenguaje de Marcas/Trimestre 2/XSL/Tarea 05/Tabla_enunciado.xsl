<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  <html lang="en" dir="ltr">
    <head>
      <title></title>
      <style>
        th{
          background-color:#32cd32;
        }
      </style>
    </head>
    <body>
    <h1>Listado de notas</h1>
    <table border="1">
      <tr>
        <th>Nombre</th>
        <th>Asignatura</th>
      </tr>
      <xsl:for-each select="//alumno" >
        <tr>
          <td><xsl:value-of select="nombre/." /></td>
          <td><xsl:value-of select="asignatura/." /></td>
        </tr>
      </xsl:for-each>
    </table>
    </body>
  </html>
  </xsl:template>
</xsl:stylesheet>
