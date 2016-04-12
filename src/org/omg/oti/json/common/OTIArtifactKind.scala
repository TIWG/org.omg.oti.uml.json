package org.omg.oti.json.common

/**
  * A UML Package can be the root of an OTI artifact of some kind.
  * OTI artifact kinds impose well-formedness constraints on
  * UML Package inter-relationships.
  */
sealed trait OTIArtifactKind

/**
  * The kind for a UML Package that is processed as part of an importing/loading an OTI Document
  */
case object OTILoadingArtifactKind
  extends OTIArtifactKind

/**
  * The kind for a UML Package representing a metamodel (built-in or serializable)
  */
sealed trait OTIMetamodelArtifactKind

/**
  * The kind for a UML Package representing a profile (built-in or serializable)
  */
sealed trait OTIProfileArtifactKind

/**
  * The kind for a UML Package representing a model-library (built-in or serializable)
  */
sealed trait OTIModelLibraryArtifactKind


/**
  * A UML Package that is the root of an OTI artifact of some kind
  * that can be serialized to or deserialized from an external representation.
  */
sealed trait OTISerializableArtifactKind

/**
  * The kind for a UML Package representing a metamodel that can be serialized.
  * A metamodel package can acyclically import metamodel or model library packages
  */
case object OTISerializableMetamodelArtifactKind
  extends OTIArtifactKind
    with OTISerializableArtifactKind
    with OTIMetamodelArtifactKind

/**
  * The kind for a UML Package representing a profile that can be serialized.
  * A profile package must acyclically extend at least one metamodel package
  * and can acyclically import model library packages.
  */
case object OTISerializableProfileArtifactKind
  extends OTIArtifactKind
    with OTISerializableArtifactKind
    with OTIProfileArtifactKind

/**
  * The kind for a UML Package representing a model library that can be serialized.
  * A model library package can acyclically import model library packages
  * and can acyclically apply profile packages.
  */
case object OTISerializableModelLibraryArtifactKind
  extends OTIArtifactKind
    with OTISerializableArtifactKind
    with OTIModelLibraryArtifactKind

/**
  * A UML Package that is the root of an OTI artifact of some kind
  * that is built-in an OTI-compatible tool. Such an artifact is neither
  * serialized to nor deserialized from an external representation.
  */
sealed trait OTIBuiltInArtifactKind

/**
  * The kind for a UML Package representing a metamodel that is built-in an OTI compatible tool.
  * A built-in metamodel package can acyclically import built-in metamodel or built-in model library packages
  */
case object OTIBuiltInMetamodelArtifactKind
  extends OTIArtifactKind
    with OTIBuiltInArtifactKind
    with OTIMetamodelArtifactKind

/**
  * The kind for a UML Package representing a profile that is built-in an OTI compatible tool.
  * A built-in profile package must acyclically extend at least one built-in metamodel package
  * and can acyclically import built-in model library packages.
  */
case object OTIBuiltInProfileArtifactKind
  extends OTIArtifactKind
    with OTIBuiltInArtifactKind
    with OTIProfileArtifactKind

/**
  * The kind for a UML Package representing a model library that is built-in an OTI compatible tool.
  * A built-in model library package can acyclically import built-in model library packages
  * and can acyclically apply built-in profile packages.
  */
case object OTIBuiltInModelLibraryArtifactKind
  extends OTIArtifactKind
    with OTIBuiltInArtifactKind
    with OTIModelLibraryArtifactKind
    