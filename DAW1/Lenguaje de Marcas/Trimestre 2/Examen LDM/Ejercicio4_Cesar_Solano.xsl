<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html lang="en" dir="ltr">
      <head>
        <title></title>
        <style>
          body{
            background-color:#FFC500;
            font-size:24px;
          }
          table{
            width:100%;
          }
          .titulo{
            text-align:center;
          }
          .imagenes{
            text-align:center;
          }
          td{
            width:25%;
            text-align:left;
          }
          b{
            padding: 7px;
          }
          i{
            padding: 7px;
          }
          li{
            padding-top: 7px;
          }
        </style>
      </head>
      <body>
      <h5 class="titulo">
      <xsl:element name="a">
        <xsl:attribute name="href">
          <xsl:value-of select="hogwarts/@enlace"/>
        </xsl:attribute>
        HOGWARTS
      </xsl:element>
      </h5>
        <table border="1">
          <tr>
            <xsl:for-each select="hogwarts/casas/casa/@escudo">
            <xsl:sort select="." data-type="text"/>
              <th class="imagenes">
                <xsl:element name="img">
                  <xsl:attribute name="src">
                    <xsl:value-of select="."/>
                  </xsl:attribute>
                  <xsl:attribute name="height">100px</xsl:attribute>
                </xsl:element>
              </th>
            </xsl:for-each>
          </tr>
          <tr>
            <td>
              <xsl:for-each select="hogwarts/magos/mago">
                <xsl:if test="./@casa='1'">
                  <b><xsl:value-of select="nombre/."/></b>
                  <br></br>
                  <i><xsl:value-of select="@mote"/></i>
                  <br></br>
                  <li><xsl:value-of select="caracteristicasMagicas/patronus/."/></li>
                  <xsl:for-each select="caracteristicasMagicas/varita">
                    <li><xsl:value-of select="."/></li>
                  </xsl:for-each>
                  <br></br>
                </xsl:if>
              </xsl:for-each>
            </td>
            <td>
              <xsl:for-each select="hogwarts/magos/mago">
                <xsl:if test="./@casa='3'">
                  <b><xsl:value-of select="nombre/."/></b>
                  <br></br>
                  <i><xsl:value-of select="@mote"/></i>
                  <br></br>
                  <li><xsl:value-of select="caracteristicasMagicas/patronus/."/></li>
                  <xsl:for-each select="caracteristicasMagicas/varita">
                    <li><xsl:value-of select="."/></li>
                  </xsl:for-each>
                  <br></br>
                </xsl:if>
              </xsl:for-each>
            </td>
            <td>
              <xsl:for-each select="hogwarts/magos/mago">
                <xsl:if test="./@casa='2'">
                  <b><xsl:value-of select="nombre/."/></b>
                  <br></br>
                  <i><xsl:value-of select="@mote"/></i>
                  <br></br>
                  <li><xsl:value-of select="caracteristicasMagicas/patronus/."/></li>
                  <xsl:for-each select="caracteristicasMagicas/varita">
                    <li><xsl:value-of select="."/></li>
                  </xsl:for-each>
                  <br></br>
                </xsl:if>
              </xsl:for-each>
            </td>
            <td>
              <xsl:for-each select="hogwarts/magos/mago">
                <xsl:if test="./@casa='4'">
                  <b><xsl:value-of select="nombre/."/></b>
                  <br></br>
                  <i><xsl:value-of select="@mote"/></i>
                  <br></br>
                  <li><xsl:value-of select="caracteristicasMagicas/patronus/."/></li>
                  <xsl:for-each select="caracteristicasMagicas/varita">
                    <li><xsl:value-of select="."/></li>
                  </xsl:for-each>
                  <br></br>
                </xsl:if>
              </xsl:for-each>
            </td>
          </tr>
        </table>
        <i><h3>Realizado por <xsl:value-of select="hogwarts/@firma"/></h3></i>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
