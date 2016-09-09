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
  * ObjectNodeOrderingKind is an enumeration indicating queuing order for offering the tokens held by an ObjectNode.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
sealed trait UMLObjectNodeOrderingKind {}

object UMLObjectNodeOrderingKind {

  /**
    * Indicates that tokens are queued in a first in, first out manner.
    *
    * <!-- Start of user code doc for FIFO -->
    * <!-- End of user code doc for FIFO -->
    */
  case object FIFO extends UMLObjectNodeOrderingKind {}

  /**
    * Indicates that tokens are queued in a last in, first out manner.
    *
    * <!-- Start of user code doc for LIFO -->
    * <!-- End of user code doc for LIFO -->
    */
  case object LIFO extends UMLObjectNodeOrderingKind {}

  /**
    * Indicates that tokens are ordered.
    *
    * <!-- Start of user code doc for ordered -->
    * <!-- End of user code doc for ordered -->
    */
  case object ordered extends UMLObjectNodeOrderingKind {}

  /**
    * Indicates that tokens are unordered.
    *
    * <!-- Start of user code doc for unordered -->
    * <!-- End of user code doc for unordered -->
    */
  case object unordered extends UMLObjectNodeOrderingKind {}
 
  implicit val writesUMLObjectNodeOrderingKind
  : Writes[UMLObjectNodeOrderingKind]
  = Variants.writes[UMLObjectNodeOrderingKind]((__ \ "type").format[String])

  implicit val readsUMLObjectNodeOrderingKind
  : Reads[UMLObjectNodeOrderingKind]
  = Variants.reads[UMLObjectNodeOrderingKind]((__ \ "type").format[String])

  implicit val formatsUMLObjectNodeOrderingKind
  : Format[UMLObjectNodeOrderingKind]
  = Variants.format[UMLObjectNodeOrderingKind]((__ \ "type").format[String])
  
}
