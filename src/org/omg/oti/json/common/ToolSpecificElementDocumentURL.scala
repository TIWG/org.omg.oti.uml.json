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

import scala.{Int,Ordering}
import scala.Predef.String
import scalaz.@@

/**
  * Tool-specific Element/Document Location
  *
  * @param element_id    The tool-specific ID of the UML Element contained in an OTI Document UML Package
  * @param document_url  The tool-specific URL of the external OTI Document UML Package resource
  *                      containing the identified element
  */
case class ToolSpecificElementDocumentURL
( element_id: String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_ID,
  document_url: String @@ OTIPrimitiveTypes.TOOL_SPECIFIC_URL ) 
{}

object ToolSpecificElementDocumentURL {

  implicit val ordering
  : Ordering[ToolSpecificElementDocumentURL]
  = new Ordering[ToolSpecificElementDocumentURL] {

    def compare(x: ToolSpecificElementDocumentURL, y: ToolSpecificElementDocumentURL)
    : Int
    = {
      taggedStringOrdering[OTIPrimitiveTypes.TOOL_SPECIFIC_URL].compare(x.document_url, y.document_url) match {
        case 0 =>
          taggedStringOrdering[OTIPrimitiveTypes.TOOL_SPECIFIC_ID].compare(x.element_id, y.element_id)
        case c =>
          c
      }
    }

  }

}