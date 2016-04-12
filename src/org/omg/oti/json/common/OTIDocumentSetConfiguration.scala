package org.omg.oti.json.common

import scala.collection.immutable._

import scala.Predef.String
import scalaz.@@

/**
  * @param documents: A set of OTIDocumentConfigurations for a set of
  *                   packages and/or profiles characterized as OTI Documents.
  */
case class OTIDocumentSetConfiguration
( documents: SortedMap[String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID, OTIDocumentConfiguration] )
{}