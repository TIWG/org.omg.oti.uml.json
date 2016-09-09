/*
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omg.oti.json.extent

import play.json.extra._
import play.api.libs.json._

import org.omg.oti.json.common._

import scala.Predef.String
import scalaz.@@

/**
  * Abstraction for the location of a Document container of OTI MOF Elements & Links.
  * There are two variants
  * - an OTI Document as the container of all UML Elements in scope of a UML Package/Profile
  * - a tool-specific document resource identified by a tool-specific URL
  */
sealed trait DocumentLocation

/**
  * The location of an OTI Document
  *
  * @param otiCharacteristics the characteristics of the OTI Document
  * @param toolSpecificPackageID the tool-specific ID of the OTI Document UML Package/profile scope
  * @param toolSpecificPackageURL the tool-specific URL of the OTI Document UML Package/profile scope
  */
case class OTIDocumentLocation
(otiCharacteristics
 : OTISpecificationRootCharacteristics,

 toolSpecificPackageID
 : String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID,

 toolSpecificPackageURL
 : String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_URL)
extends DocumentLocation
{}

object OTIDocumentLocation {

  implicit def reads
  : Reads[OTIDocumentLocation]
  = Json.reads[OTIDocumentLocation]

  implicit def writes
  : Writes[OTIDocumentLocation]
  = Json.writes[OTIDocumentLocation]

  implicit def formats
  : Format[OTIDocumentLocation]
  = Json.format[OTIDocumentLocation]

}

/**
  * A tool-specific document location
  *
  * @param toolSpecificDocumentLocation the tool-specific URL specifying the location of a document
  */
case class ToolSpecificDocumentLocation
(toolSpecificDocumentLocation: String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_URL)
extends DocumentLocation
{}

object ToolSpecificDocumentLocation {

  implicit def reads
  : Reads[ToolSpecificDocumentLocation]
  = Json.reads[ToolSpecificDocumentLocation]

  implicit def writes
  : Writes[ToolSpecificDocumentLocation]
  = Json.writes[ToolSpecificDocumentLocation]

  implicit def formats
  : Format[ToolSpecificDocumentLocation]
  = Json.format[ToolSpecificDocumentLocation]

}

object DocumentLocation {

  def toToolSpecificURL
  (dl: DocumentLocation)
  : String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_URL
  = dl match {
    case loc: OTIDocumentLocation =>
      loc.toolSpecificPackageURL
    case loc: ToolSpecificDocumentLocation =>
      loc.toolSpecificDocumentLocation
  }

  implicit val writes
  : Writes[DocumentLocation]
  = Variants.writes[DocumentLocation]((__ \ "type").write[String])

  implicit val reads
  : Reads[DocumentLocation]
  = Variants.reads[DocumentLocation]((__ \ "type").read[String])

  implicit val formats
  : Format[DocumentLocation]
  = Variants.format[DocumentLocation]((__ \ "type").format[String])

}