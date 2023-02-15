<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  <html lang="en" dir="ltr">
    <head>
      <title></title>
      <style>
        body{
          background-color:pink;
        }
        h1{
          background-color:purple;
          border-style:solid;
          border-color:red;
          font-size:25px;
          color:pink;
          text-align:center;
          padding:20px;
          text-decoration: underline;
        }
        .planta{
          color:blue;
        }
      </style>
    </head>
    <body>
      <h1>INVENTARIO DE EQUIPOS AÑO <xsl:value-of select="inventario/@año" /></h1>
      <b><p class="planta">Planta 1</p></b>
      <xsl:for-each select="inventario/producto" >
        <ul>
          <li>Elemento <xsl:value-of select="@codigo" /></li>
            <ul>
              <li>Nombre: <xsl:value-of select="nombre/." /></li>
              <li>Peso: <xsl:value-of select="peso/." /><xsl:value-of select="peso/@unidad" /></li>
            </ul>
        </ul>
      </xsl:for-each>
    </body>
  </html>
  </xsl:template>
</xsl:stylesheet>
