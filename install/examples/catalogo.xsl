<?xml version="1.0" encoding="UTF-8"?>
<!--xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl"-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="html" indent="yes"/>
	<xsl:template match="/">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="catalogo">
		<HTML>
			<HEAD>
				<TITLE>Catálogo</TITLE>
			</HEAD>
			<BODY>
				<xsl:for-each select="producto">
					<xsl:for-each select="precio">
						<xsl:if test="@tipo='mayor'">
							<h3>Precio venta al mayor: <xsl:value-of select="."/>
								<xsl:value-of select="@moneda"/>
							</h3>
						</xsl:if>
						<xsl:if test="@tipo='detalle'">
							<i>(Al detalle: <xsl:value-of select="."/>
								<xsl:value-of select="@moneda"/>)
							</i>
							<br/>
						</xsl:if>
					</xsl:for-each>
					<xsl:for-each select="entrega">
						<b>Coste entrega: <xsl:value-of select="."/>
							<xsl:value-of select="@moneda"/> (mediante <xsl:value-of select="@metodo"/>)
						</b>
					</xsl:for-each>
				</xsl:for-each>
			</BODY>
		</HTML>
	</xsl:template>
</xsl:stylesheet>
