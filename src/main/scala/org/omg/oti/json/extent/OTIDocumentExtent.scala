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

import play.api.libs.json._

import org.omg.oti.json.uml._

import scala.collection.immutable._

case class OTIDocumentExtent
(documentLocation
 : DocumentLocation,

 elementExtent
 : Vector[OTIMOFElement]
 = Vector.empty[OTIMOFElement],

 compositeLinkExtent
 : Vector[OTIMOFCompositeLink]
 = Vector.empty[OTIMOFCompositeLink],

 compositeOrderedLinkExtent
 : Vector[OTIMOFCompositeOrderedLink]
 = Vector.empty[OTIMOFCompositeOrderedLink],

 referenceLinkExtent
 : Vector[OTIMOFReferenceLink]
 = Vector.empty[OTIMOFReferenceLink],

 referenceOrderedLinkExtent
 : Vector[OTIMOFReferenceOrderedLink]
 = Vector.empty[OTIMOFReferenceOrderedLink])
{}

object OTIDocumentExtent {

  def merge(d1: OTIDocumentExtent, d2: OTIDocumentExtent)
  : OTIDocumentExtent
  = d1.copy(
    elementExtent = d1.elementExtent ++ d2.elementExtent,
    compositeLinkExtent = d1.compositeLinkExtent ++ d2.compositeLinkExtent,
    compositeOrderedLinkExtent = d1.compositeOrderedLinkExtent ++ d2.compositeOrderedLinkExtent,
    referenceLinkExtent = d1.referenceLinkExtent ++ d2.referenceLinkExtent,
    referenceOrderedLinkExtent = d1.referenceOrderedLinkExtent ++ d2.referenceOrderedLinkExtent)

  implicit def reads
  : Reads[OTIDocumentExtent]
  = Json.reads[OTIDocumentExtent]

  implicit def writes
  : Writes[OTIDocumentExtent]
  = Json.writes[OTIDocumentExtent]

  implicit def formats
  : Format[OTIDocumentExtent]
  = Json.format[OTIDocumentExtent]

}