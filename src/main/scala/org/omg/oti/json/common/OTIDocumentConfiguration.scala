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
  * @param toolSpecificPackageURL a tool-specific URL for the external location of the OTI Document UML Package
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
  : String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_URL,

  overrideID
  : Vector[ToolSpecific2OTI_ID_Pair]
  = Vector.empty[ToolSpecific2OTI_ID_Pair],

  overrideUUID
  : Vector[ToolSpecific2OTI_ID_UUID_Pair]
  = Vector.empty[ToolSpecific2OTI_ID_UUID_Pair],

  excludeNestedElements
  : Vector[String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID]
  = Vector.empty[String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID] )

object OTIDocumentConfiguration {

  implicit val ordering
  : Ordering[OTIDocumentConfiguration]
  = new Ordering[OTIDocumentConfiguration] {

    def compare(x: OTIDocumentConfiguration, y: OTIDocumentConfiguration)
    : Int
    = Tag.unwrap(x.toolSpecificPackageURL).compareTo(Tag.unwrap(y.toolSpecificPackageURL)) match {
      case 0 =>
        Tag.unwrap(x.toolSpecificPackageID).compareTo(Tag.unwrap(x.toolSpecificPackageID)) match {
          case 0 =>
            OTISpecificationRootCharacteristics.ordering.compare(x.otiCharacteristics, y.otiCharacteristics)
          case c =>
            c
        }
      case c =>
        c
    }
  }

  implicit def formats
  : Format[OTIDocumentConfiguration]
  = Json.format[OTIDocumentConfiguration]

}