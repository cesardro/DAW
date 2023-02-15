<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html lang="en" dir="ltr">
      <head>
        <title></title>
        <style>
          table{
          border-collapse: collapse;
          text-align:center;
          }
          th{
            text-align:left;
            margin:10px;
          }
          img{
            border-radius:30%;
          }
          .titulo{
            text-align:right;
            vertical-align:text-top;
            padding-top:10px;
            padding-right:20px;
            font-weight: bold;
            background-color:#180c2c;
            color: #ff9347;
            width: 150px;
          }
          .informacion{
            padding-left:30px;
            background-color: #301c4c;
            color: white;
            padding-bottom:40px;
          }
          .tituloInfo{
            font-weight: bold;
          }
          .nombreTitulo{
            font-size:60px;
            color:#ff9347;
            margin:0px;
          }
          .desarrollador{
          font-size:30px;
            color:#ff9347;
            margin:0px;
          }
          a{
            color:white;
            text-decoration: none;
            font-weight: normal;
          }
          .adicional{
            padding: 30px;
          }
        </style>
      </head>
      <body>
        <table>
        <tr>
          <th class="titulo">
            <xsl:element name="img">
              <xsl:attribute name="src">
                <xsl:value-of select="curriculum/foto"/>
              </xsl:attribute>
              <xsl:attribute name="height">100px</xsl:attribute>
            </xsl:element>
          </th>
          <th class="informacion">
            <p class="nombreTitulo"><xsl:value-of select="curriculum/nombre/."/></p>
            <p class="nombreTitulo"><xsl:value-of select="curriculum/apellido/."/></p>
            <p class="desarrollador"><xsl:value-of select="curriculum/profesion/."/></p>
            <p><xsl:value-of select="curriculum/redes/."/></p>
            <xsl:element name="a">
              <xsl:attribute name="href">
                <xsl:value-of select="curriculum/redes/@linkedin"/>
              </xsl:attribute>
              <xsl:value-of select="curriculum/redes/@linkedin"/>
            </xsl:element>
          </th>
        </tr>
        <tr>
          <td  class="titulo"><xsl:value-of select="curriculum/datos/formacion/@titulo"/></td>
          <td class="informacion">
          <xsl:for-each select="curriculum/datos/formacion/info">
            <p class="tituloInfo"><xsl:value-of select="@tituloInfo"/></p>
            <p><xsl:value-of select="."/></p>
            <p><xsl:value-of select="años/."/></p>
          </xsl:for-each>
          </td>
        </tr>
        <tr>
          <td  class="titulo"><xsl:value-of select="curriculum/datos/experiencia/@titulo"/></td>
          <td class="informacion">
          <p class="tituloInfo"><xsl:value-of select="curriculum/datos/experiencia/info/@tituloInfo"/></p>
          <xsl:for-each select="curriculum/datos/experiencia/info/punto">
            <p><xsl:value-of select="."/></p>
          </xsl:for-each>
          <p>
              <xsl:element name="a">
              <xsl:attribute name="href">
                <xsl:value-of select="curriculum/datos/experiencia/info/@link"/>
              </xsl:attribute>
              <xsl:value-of select="curriculum/datos/experiencia/info/@link"/>
            </xsl:element>
            </p>
            <p><xsl:value-of select="curriculum/datos/experiencia/info/años/."/></p>
          </td>
        </tr>
        <tr>
          <td  class="titulo"><xsl:value-of select="curriculum/datos/aptitudes/@titulo"/></td>
          <td class="informacion">
            <xsl:for-each select="curriculum/datos/aptitudes/info">
              <p class="tituloInfo"><xsl:value-of select="@tituloInfo"/></p>
              <xsl:for-each select="punto">
                <p><xsl:value-of select="."/></p>
              </xsl:for-each>
            </xsl:for-each>
          </td>
        </tr>
        <tr>
          <td class="titulo"><xsl:value-of select="curriculum/datos/adicional/@titulo"/></td>
          <td class="informacion">
            <p class="tituloInfo"><xsl:value-of select="curriculum/datos/adicional/info/@tituloInfo"/></p>
            <p><xsl:value-of select="curriculum/datos/adicional/info/punto/."/></p>
          </td>
        </tr>
        <tr>
          <td class="titulo"></td>
          <td class="informacion">
            <table>
              <tr class="informacion">
                <xsl:for-each select="curriculum/datos/extra/info">
                  <td >
                    <xsl:element name="img">
                      <xsl:attribute name="src">
                        <xsl:value-of select="@fotoAdicional"/>
                      </xsl:attribute>
                      <xsl:attribute name="height">70px</xsl:attribute>
                    </xsl:element>
                    <p class="adicional"><xsl:value-of select="."/></p>
                  </td>
                </xsl:for-each>
              </tr>
            </table>
          </td>
        </tr>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
