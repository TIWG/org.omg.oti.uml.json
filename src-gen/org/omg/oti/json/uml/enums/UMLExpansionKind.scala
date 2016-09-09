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

package org.omg.oti.json.uml.enums

import play.json.extra._
import play.api.libs.json._

import scala.Predef.String

/**
  * ExpansionKind is an enumeration type used to specify how an ExpansionRegion executes its contents.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
sealed trait UMLExpansionKind {}

object UMLExpansionKind {

  /**
    * The content of the ExpansionRegion is executed iteratively for the elements of the input collections, in the order of the input elements, if the collections are ordered.
    *
    * <!-- Start of user code doc for iterative -->
    * <!-- End of user code doc for iterative -->
    */
  case object iterative extends UMLExpansionKind {}

  /**
    * The content of the ExpansionRegion is executed concurrently for the elements of the input collections.
    *
    * <!-- Start of user code doc for parallel -->
    * <!-- End of user code doc for parallel -->
    */
  case object parallel extends UMLExpansionKind {}

  /**
    * A stream of input collection elements flows into a single execution of the content of the ExpansionRegion, in the order of the collection elements if the input collections are ordered.
    *
    * <!-- Start of user code doc for stream -->
    * <!-- End of user code doc for stream -->
    */
  case object stream extends UMLExpansionKind {}
 
  implicit val writesUMLExpansionKind
  : Writes[UMLExpansionKind]
  = Variants.writes[UMLExpansionKind]((__ \ "type").format[String])

  implicit val readsUMLExpansionKind
  : Reads[UMLExpansionKind]
  = Variants.reads[UMLExpansionKind]((__ \ "type").format[String])

  implicit val formatsUMLExpansionKind
  : Format[UMLExpansionKind]
  = Variants.format[UMLExpansionKind]((__ \ "type").format[String])
  
}
