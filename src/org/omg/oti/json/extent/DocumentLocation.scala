/*
 *
 * License Terms
 *
 * Copyright (c) 2014-2016, California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * *   Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * *   Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the
 *    distribution.
 *
 * *   Neither the name of Caltech nor its operating division, the Jet
 *    Propulsion Laboratory, nor the names of its contributors may be
 *    used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.json.extent

import play.json.extra._
import play.api.libs.json._

import org.omg.oti.json.common._

import scala.Predef.String
import scala.{Option,None}
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