# OMG Tool-Interchange JSon serialization support for OMG UML 2.5 compliant modeling tools

This library defines a collection of Algebraic Data Types (ADTs) -- data structures without any behavior -- corresponding
to the OMG UML 2.5 specification augmented with support for representing additional information for managing
UML models using the OMG Tool-Interchange API (OTI).

In particular, this library of ADTs is intended to support a JSon serialization with the following goals:

- reproducible serialization

For a given OMG UML 2.5-compliant modeling tool, a given UML model should always serialize 
to the same OTI JSon representation. Across different OMG UML 2.5-compliant modeling tools,
the serialization of the "same" model should be identical if the tools use the same tool-specific IDs & URLs.
If the tool-specific IDs and URLs are different but the logical content is the same, then the only
differences in the OTI JSon representations should be precisely the tool-specific IDs & URLs.

- serialization interchange

If the tool-specific URLs and IDs and used for identifying respectively OTI Document packages 
and UML elements within an OTI Document are interoperable across different OMG UML 2.5-compliant tools,
then the OTI JSon serialization of a given UML model should be interchangeable across such tools.
That is, OCL queries executed in each tool on tool-specific representations of the model
loaded from the same OTI JSon serialization should produce equivalent results.

- model comparison

A simple textual difference of the OTI JSon serialization should provide a minimal & complete account of 
the differences between UML models serialized using the same tool.

## Dependencies.

- [OTI JSon Acceleo Generator](https://github.jpl.nasa.gov/imce/org.omg.oti.json.acceleo)

- [Scala 2.11.7](http://scala-lang.org)

- [Scala Play Framwork JSon support](https://www.playframework.com/documentation/2.4.x/ScalaJson)

- [Play JSon Extra module from Alberto Paro](https://github.com/aparo/play-json-extra)

  Note that this library is compiled for Java8.
  

