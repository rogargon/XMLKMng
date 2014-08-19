<?xml version="1.0" encoding="UTF-8"?>
<!--xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl"-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="html" indent="yes"/>
	<xsl:template match="/">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="ADDRESSBOOK">
		<HTML>
			<HEAD>
				<TITLE>ADDRESSBOOK</TITLE>
			</HEAD>
			<BODY>
				<H1>ADDRESSBOOK</H1>
				<TABLE border="3" width="600" cellpadding="5">
					<TR>
						<td>Firstname</td>
						<td>Lastname</td>
						<td>Company</td>
						<td>E-mail</td>
					</TR>
					<xsl:for-each select="PERSON">
						<TR>
							<td>
								<xsl:value-of select="FIRSTNAME"/>
							</td>
							<td>
								<xsl:value-of select="LASTNAME"/>
							</td>
							<td>
								<xsl:value-of select="COMPANY"/>
							</td>
							<td>
								<A>
									<xsl:attribute name="HREF">mailto:<xsl:value-of select="EMAIL"/></xsl:attribute>
									<xsl:value-of select="EMAIL"/>
								</A>
							</td>
						</TR>
					</xsl:for-each>
				</TABLE>
			</BODY>
		</HTML>
	</xsl:template>
</xsl:stylesheet>
