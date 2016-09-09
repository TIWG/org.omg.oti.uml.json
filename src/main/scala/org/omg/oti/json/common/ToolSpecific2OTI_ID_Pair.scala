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

import scala.{Int,Ordering}
import scala.Predef.String
import scalaz.{@@,Tag}

/**
  * For a given UML Element, the pair of its tool-specific ID and its OTI ID.
  *
  * @param toolSpecificID tool-specific ID
  * @param oti_id OTI ID
  */
case class ToolSpecific2OTI_ID_Pair
( toolSpecificID: String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID,
  oti_id: String @@ OTIPrimitiveTypes.OTI_ID )
{}

object ToolSpecific2OTI_ID_Pair {

  implicit val ordering
  : Ordering[ToolSpecific2OTI_ID_Pair]
  = new Ordering[ToolSpecific2OTI_ID_Pair] {

    def compare(x: ToolSpecific2OTI_ID_Pair, y: ToolSpecific2OTI_ID_Pair)
    : Int
    = Tag.unwrap(x.toolSpecificID).compareTo(Tag.unwrap(y.toolSpecificID)) match {
      case 0 =>
        Tag.unwrap(x.oti_id).compareTo(Tag.unwrap(y.oti_id))
      case c =>
        c
    }
  }

  implicit val formats
  : Format[ToolSpecific2OTI_ID_Pair]
  = Json.format[ToolSpecific2OTI_ID_Pair]

}