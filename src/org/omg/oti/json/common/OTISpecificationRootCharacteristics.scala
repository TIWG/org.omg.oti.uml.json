package org.omg.oti.json.common

import org.omg.oti.json.common.OTIPrimitiveTypes._

import scala.Predef.String
import scalaz.@@

/**
  * The OTI characteristics for a UML Package specifying the root of an OTI document of some kind.
  *
  * @param packageURI the Package::URI characteristic
  * @param documentURL the URL where the OTI document is externally accessible as a resource
  * @param artifactKind the kind of the OTI document
  * @param nsPrefix the XML namespace prefix for the contents of the OTI document
  * @param uuidPrefix the XMI uuid prefix for all the contents of the OTI document
  */
case class OTISpecificationRootCharacteristics
(packageURI: String @@ OTI_URI,
 documentURL: String @@ OTI_URL,
 artifactKind: OTIArtifactKind,
 nsPrefix: String @@ OTI_NS_PREFIX,
 uuidPrefix: String @@ OTI_UUID_PREFIX)