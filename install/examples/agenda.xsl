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
				<xsl:for-each select="PERSON">
					<TABLE border="3" width="300" cellpadding="5">
						<TR>
							<td style="border: medium none">Name:</td>
							<td width="70%" style="border: medium none">
								<xsl:value-of select="FIRSTNAME"/>
								<xsl:text> </xsl:text>
								<xsl:value-of select="LASTNAME"/>
							</td>
						</TR>
						<TR>
							<td style="border: medium none">Company:</td>
							<td width="70%" style="border: medium none">
								<xsl:value-of select="COMPANY"/>
							</td>
						</TR>
						<TR>
							<td style="border: medium none">E-mail:</td>
							<td width="70%" style="border: medium none">
								<A>
									<xsl:attribute name="HREF">mailto:<xsl:value-of select="EMAIL"/></xsl:attribute>
									<xsl:value-of select="EMAIL"/>
								</A>
							</td>
						</TR>
					</TABLE>
					<BR/>
					<BR/>
				</xsl:for-each>
			</BODY>
		</HTML>
	</xsl:template>
</xsl:stylesheet>
