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