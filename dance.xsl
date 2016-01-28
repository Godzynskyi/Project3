<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:def="http://godzynskyi.com/defaultNameSpaceDance"
    xmlns:my="http://godzynskyi.com/dancers"
    
    version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <tr>
                        <th>number</th>
                        <th>title</th>
                        <th>type</th>
                        <th>scene</th>
                        <th>numberOfDancers</th>
                        <th>music</th>
                        <th>dancers</th>
                    </tr>
                    <xsl:for-each select="def:dance/def:performance">
                        <tr>
                            <td>
                                <xsl:value-of select="@number"/>
                            </td>
                            <td>
                                <xsl:value-of select="@title"/>
                            </td>
                            <td><xsl:value-of select="def:type"/></td>
                            <td><xsl:value-of select="def:scene"/></td>
                            <td><xsl:value-of select="def:numberOfDancers"/></td>
                            <td><xsl:value-of select="def:music"/></td>
                            <td>
                                <table border="1">
                                <tr>
                                    <th>name</th>
                                    <th>age</th>
                                    <th>experience</th>
                                </tr>
                                <xsl:for-each select="def:dancers/my:person">
                                    <tr>
                                        <td><xsl:value-of select="my:name"/></td>
                                        <td><xsl:value-of select="my:age"/></td>
                                        <td><xsl:value-of select="my:experience"/></td>
                                    </tr>
                                </xsl:for-each>
                                    <xsl:for-each select="def:dancers/my:group">
                                        <tr>
                                            <td>Group <xsl:value-of select="@name"/></td>
                                        </tr>
                                        <xsl:for-each select="my:person">
                                        <tr>
                                            <td><xsl:value-of select="my:name"/></td>
                                            <td><xsl:value-of select="my:age"/></td>
                                            <td><xsl:value-of select="my:experience"/></td>
                                        </tr>
                                    </xsl:for-each>
                                    </xsl:for-each>
                                </table>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>