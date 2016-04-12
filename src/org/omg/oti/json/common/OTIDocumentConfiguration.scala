package org.omg.oti.json.common

import scala.collection.immutable._

import scala.Predef.String
import scalaz.@@

case class OTIDocumentConfiguration
( toolSpecific_packageLocation: ToolSpecificElementDocumentURL,
  otiCharacteristics: OTISpecificationRootCharacteristics,
  excludeSubPackages: SortedSet[String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID],
  overrideID: SortedMap[String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID, String @@ OTIPrimitiveTypes.OTI_ID],
  overrideUUID: SortedMap[String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID, String @@ OTIPrimitiveTypes.OTI_UUID] )
{}
