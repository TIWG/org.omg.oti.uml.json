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

## Example

### Defining Simple Data Structures for JSon serialization

The following shows some of the Scala data structures involved in the definition of
[OTIDocumentSetConfiguration](src/org/omg/oti/json/common/OTIDocumentSetConfiguration.scala).

```
case class OTIDocumentSetConfiguration
( documents: SortedSet[OTIDocumentConfiguration],
  overrideID: SortedSet[ToolSpecific2OTI_ID_Pair],
  overrideUUID: SortedSet[ToolSpecific2OTI_ID_UUID_Pair] )

case class OTIDocumentConfiguration
( toolSpecificPackageID: String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID,
  otiCharacteristics: OTISpecificationRootCharacteristics,
  excludeSubPackages: SortedSet[String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID])

case class OTISpecificationRootCharacteristics
(packageURI: String @@ OTI_URI,
 documentURL: String @@ OTI_URL,
 artifactKind: OTIArtifactKind,
 nsPrefix: String @@ OTI_NS_PREFIX,
 uuidPrefix: String @@ OTI_UUID_PREFIX)
```

The notation `String @@ T` refers to a compile-time technique for partitioning a type (e.g. `String`)
according to a tag `T` such that different tagged partitions are disjoint. For example,
 `String @@ OTI_URI` and `String @@ OTI_URL` are disjoint from each other in the sense that the
compiler prevents using a value from one partition as a value for another partition.

This is useful to make sure that strings that are intended to represent values of a particular kind
(i.e. a partition of all possible strings) are not accidentally used as strings intended to represent something else.

For example:

```
val u1: String @@ OTI_ID = OTI_URI.wrap("A1234")
val u2: String @@ OTI_URL = OTI_URI.wrap("http://example.org/A1234")

var x1: String = u1 // does not compile
var x2: String = u2 // does not compile
var x3: String @@ OTI_URL = u1 // does not compile
var x4: String @@ OTI_URL = u2 // OK
```

Without such partitioning, code that compiles correctly may have semantic errors.
For example:


```
val u1: String = "A1234"
val u2: String = "http://example.org/A1234"

var x1: String = u1 // OK
var x2: String = u2 // OK
var x3: String = u1 // OK
var x4: String = u2 // OK
```

This tagging technique is particularly attractive because it allows partitioning any kind of type without any runtime overhead.

### Json serialization example

```
{
  "documents" : [ {
    "toolSpecificPackageID" : "_project-bundle__0",
    "otiCharacteristics" : {
      "packageURI" : "http://imce.jpl.nasa.gov/foundation/project/project-bundle",
      "documentURL" : "http://imce.jpl.nasa.gov/foundation/project/project-bundle",
      "artifactKind" : {
        "type" : "OTISerializableProfileArtifactKind"
      },
      "nsPrefix" : "project-bundle",
      "uuidPrefix" : "IMCE"
    },
    "excludeSubPackages" : [ ]
  }, {
    "toolSpecificPackageID" : "_17_0_2_30cc04ae_1311049085228_39026_11607",
    "otiCharacteristics" : {
      "packageURI" : "http://imce.jpl.nasa.gov/projects/EuropaMSET/modelFramework",
      "documentURL" : "http://imce.jpl.nasa.gov/projects/EuropaMSET/modelFramework",
      "artifactKind" : {
        "type" : "OTISerializableProfileArtifactKind"
      },
      "nsPrefix" : "eModelFramework",
      "uuidPrefix" : "_europaMSET_modelFramework_"
    },
    "excludeSubPackages" : [ ]
  }, {
    "toolSpecificPackageID" : "_18_0_5_ff3038a_1460074977762_354899_68756",
    "otiCharacteristics" : {
      "packageURI" : "http://imce.jpl.nasa.gov/projects/EuropaMSET/modelFrameworkPackages",
      "documentURL" : "http://imce.jpl.nasa.gov/projects/EuropaMSET/modelFrameworkPackages",
      "artifactKind" : {
        "type" : "OTISerializableModelLibraryArtifactKind"
      },
      "nsPrefix" : "eModelFrameworkPackages",
      "uuidPrefix" : "_europaMSET_modelFrameworkPackages_"
    },
    "excludeSubPackages" : [ ]
  }, {
    "toolSpecificPackageID" : "_18_0_2_897027c_1440789904513_61611_38286",
    "otiCharacteristics" : {
      "packageURI" : "http://imce.jpl.nasa.gov/projects/EuropaMSET/projectFramework",
      "documentURL" : "http://imce.jpl.nasa.gov/projects/EuropaMSET/projectFramework",
      "artifactKind" : {
        "type" : "OTISerializableModelLibraryArtifactKind"
      },
      "nsPrefix" : "eProjectFramework",
      "uuidPrefix" : "_europaMSET_projectFramework_"
    },
    "excludeSubPackages" : [ ]
  } ],
  "overrideID" : [ ],
  "overrideUUID" : [ ]
}
```

## Dependencies.

- [OTI JSon Acceleo Generator](https://github.jpl.nasa.gov/imce/org.omg.oti.json.acceleo)

- [Scala 2.11.7](http://scala-lang.org)

- [Scala Play Framwork JSon support](https://www.playframework.com/documentation/2.4.x/ScalaJson)

- [Play JSon Extra module from Alberto Paro](https://github.com/aparo/play-json-extra)

  Note that this library is compiled for Java8.
  

