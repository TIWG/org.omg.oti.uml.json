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
package org.omg.oti.json.common

import play.api.libs.json._

import scala.collection.immutable._

import scala.{Int,Ordering}
import scala.Predef.String
import scalaz.{@@,Tag}

/**
  * Configuration for an OTI Document UML Package
  *
  * @param otiCharacteristics     the OTI characteristics for the OTI Document UML Package
  * @param toolSpecificPackageID  the tool-specific ID of the OTI Document UML Package
  * @param toolSpecificPackageURL optionally, a tool-specific URL for
  *                               the external location of the OTI Document UML Package
  * @param overrideID Each pair is used to override the generated OTI ID for a given UML Element
  *                   within the OTI DOcument UML Package according to its tool-specific ID
  * @param overrideUUID Each pair is used to override the generated OTI UUID for a given UML Element
  *                     within the OTI DOcument UML Package according to its tool-specific ID
  * @param excludeNestedElements  A set of tool-specific IDs for nested UML Elements to be excluded
  *                               along with their contents from the OTI extent of the OTI Document UML Package
  */
case class OTIDocumentConfiguration
( otiCharacteristics
  : OTISpecificationRootCharacteristics,

  toolSpecificPackageID
  : String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID,

  toolSpecificPackageURL
  : Option[String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_URL] = None,

  overrideID
  : SortedSet[ToolSpecific2OTI_ID_Pair]
  = SortedSet.empty[ToolSpecific2OTI_ID_Pair],

  overrideUUID
  : SortedSet[ToolSpecific2OTI_ID_UUID_Pair]
  = SortedSet.empty[ToolSpecific2OTI_ID_UUID_Pair],

  excludeNestedElements
  : SortedSet[String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID]
  = SortedSet.empty[String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID] )

object OTIDocumentConfiguration {

  implicit val ordering
  : Ordering[OTIDocumentConfiguration]
  = new Ordering[OTIDocumentConfiguration] {

    def compare1(x: OTIDocumentConfiguration, y: OTIDocumentConfiguration)
    : Int
    = Tag.unwrap(x.toolSpecificPackageID).compareTo(Tag.unwrap(x.toolSpecificPackageID)) match {
      case 0 =>
        OTISpecificationRootCharacteristics.ordering.compare(x.otiCharacteristics, y.otiCharacteristics)
      case c =>
        c
    }

    def compare(x: OTIDocumentConfiguration, y: OTIDocumentConfiguration)
    : Int
    = (x.toolSpecificPackageURL, y.toolSpecificPackageURL) match {
      case (None, None) =>
        compare1(x, y)
      case (Some(_), None) =>
        -1
      case (None, Some(_)) =>
        1
      case (Some(xURL), Some(yURL)) =>
        Tag.unwrap(xURL).compareTo(Tag.unwrap(yURL)) match {
          case 0 =>
            compare1(x, y)
          case c =>
            c
        }
    }
  }

  implicit def formats
  : Format[OTIDocumentConfiguration]
  = Json.format[OTIDocumentConfiguration]

  implicit def reads
  : Writes[OTIDocumentConfiguration]
  = Json.writes[OTIDocumentConfiguration]

  implicit def writes
  : Reads[OTIDocumentConfiguration]
  = Json.reads[OTIDocumentConfiguration]

}